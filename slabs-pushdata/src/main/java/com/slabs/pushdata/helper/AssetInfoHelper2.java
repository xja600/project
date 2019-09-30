package com.slabs.pushdata.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.slabs.pushdata.dao.AssetInfoMapper2;
import com.slabs.pushdata.dao.AssetInfoRecordMapper2;
import com.slabs.pushdata.entity.AssetInfoEntity;
import com.slabs.pushdata.entity.AssetInfoPushToBiDetailsReq;
import com.slabs.pushdata.entity.AssetInfoPushToBiReq;
import com.slabs.pushdata.entity.AssetInfoRecordEntity;
import com.slabs.pushdata.enums.SynDataStatus;
import com.slabs.pushdata.utils.BeanCopierUtils;
import com.slabs.pushdata.utils.DateUtil;
import com.slabs.pushdata.utils.HttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: XiongFeng
 * @Description:
 * @Date: Created in 15:06 2018/7/24
 */
@Component
@Configuration
public class AssetInfoHelper2 {

    private static final Logger logger = LoggerFactory.getLogger(AssetInfoHelper2.class);
    @Autowired
    AssetInfoMapper2 assetInfoMapper;
    @Autowired
    private AssetInfoRecordMapper2 assetInfoRecordMapper;

//    @Value("${Global.bi_server_sendData_ip}")
    private String host = "192.168.34.236";
//    private String host = "10.0.22.192";
//    @Value("${Global.bi_server_sendData_port}")
    private String port = "20970";
//    @Value("${Global.bi_sendData}")
    private String sendBiUrl="/ctsproperty/absPush/sendData";


    public void buildAssetInfoRecordEntity(AssetInfoEntity assetInfo, AssetInfoRecordEntity assetInfoRecordEntity, String batchNo){

        assetInfoRecordEntity.setBusiNo(assetInfo.getBusiNo());
        assetInfoRecordEntity.setProjectId(assetInfo.getProjectId());
        assetInfoRecordEntity.setProjectName(assetInfo.getProjectName());
        assetInfoRecordEntity.setProjectInitDate(assetInfo.getInitDate());
        assetInfoRecordEntity.setProjectEndDate(assetInfo.getExpireTime());
//        assetInfoRecordEntity.setMarkDate(assetInfo.getSignDate());
        assetInfoRecordEntity.setStatus(SynDataStatus.NO.getValue());//未同步
        assetInfoRecordEntity.setBatchNo(batchNo);
        assetInfoRecordEntity.setPushTime(DateUtil.getSysTime());
        assetInfoRecordEntity.setCreateTime(DateUtil.getSysTime());
    }

    public void sendAllAssetInfoToBi(List<AssetInfoPushToBiDetailsReq> assetInfoPushToBiDetailsReqList , String batchNo) throws Exception {

        logger.info("--------同步当前修改的数据到BI------assetInfoPushToBiDetailsReqList:【{}】",assetInfoPushToBiDetailsReqList.size());
        //同步当前修改的数据到BI
        sendAssetInfoToBI(assetInfoPushToBiDetailsReqList,batchNo);


        //处理未同步的历史数据,根据批次号来同步
        List<String> batchNoList = assetInfoRecordMapper.queryAssetInfoRecordBatchByStatus(SynDataStatus.NO.getValue());
        List<AssetInfoPushToBiDetailsReq> assetInfoPushToBiReqList = new ArrayList<>();
        logger.info("--------处理未同步的历史数据,根据批次号来同步-----batchNoList:【{}】-",batchNoList.size());
        for (int i = 0; i < batchNoList.size(); i++) {
            List<AssetInfoRecordEntity> assetInfoHisList = assetInfoRecordMapper.queryAssetInfoRecordByStatus(SynDataStatus.NO.getValue(),batchNoList.get(i));
            //转为AssetInfoPushToBiDetailsReq对象
            for (int j = 0; j <assetInfoHisList.size() ; j++) {
                assetInfoPushToBiReqList.add(BeanCopierUtils.copy(assetInfoHisList.get(j),AssetInfoPushToBiDetailsReq.class));
            }
            sendAssetInfoToBI(assetInfoPushToBiReqList,batchNoList.get(i));
        }
    }

    public void sendAssetInfoToBI(List<AssetInfoPushToBiDetailsReq> assetInfoPushToBiDetailsReqList ,String batchNo)throws Exception {
        List<AssetInfoPushToBiDetailsReq> assetInfoPushToBiReqList = new ArrayList<>();
        List<String> busiNoList = new ArrayList<>();

        StringBuffer urlBuf = new StringBuffer("http://").append(host).append(":").append(port).append(sendBiUrl);
        logger.info("url:",urlBuf);
        try {
            if(assetInfoPushToBiDetailsReqList.size()<0 || assetInfoPushToBiDetailsReqList == null){
                return;
            }
            logger.info("本次同步【{}】条",assetInfoPushToBiDetailsReqList.size());
            for(int i = 0;i<assetInfoPushToBiDetailsReqList.size();i++){

                assetInfoPushToBiReqList.add(assetInfoPushToBiDetailsReqList.get(i));
                busiNoList.add(assetInfoPushToBiDetailsReqList.get(i).getBusiNo());
                if(i != 0 && i%100 == 0){
                    logger.info("--------100条同步一次--------");
                    AssetInfoPushToBiReq assetInfoPushToBiReq = new AssetInfoPushToBiReq();
                    assetInfoPushToBiReq.setDetails(assetInfoPushToBiReqList);
                    String result =  HttpClient.sendBiHttpPost(JSON.toJSON(assetInfoPushToBiReq),urlBuf.toString());
                    if(StringUtils.equals("0000", JSONObject.parseObject(result).getJSONObject("head").getString("retcode"))){
                        //更新已发送的数据的状态为已处理
                        assetInfoRecordMapper.updateStatusByBusiNosAndBatchNo(busiNoList,SynDataStatus.YES.getValue(),batchNo);
                        //更改assetInfo表的状态
                        assetInfoMapper.updateAssetDealBossByBusiNo(busiNoList,assetInfoPushToBiDetailsReqList.get(i).getAssetDealType());
                        assetInfoPushToBiReqList = new ArrayList<>();
                        busiNoList = new ArrayList<>();
                    }
                }
            }
            logger.info("--------处理0<num<100的数据【{}】条--------",assetInfoPushToBiReqList.size());
            AssetInfoPushToBiReq assetInfoPushToBiReq = new AssetInfoPushToBiReq();
            assetInfoPushToBiReq.setDetails(assetInfoPushToBiReqList);


            String result = HttpClient.sendBiHttpPost(JSON.toJSON(assetInfoPushToBiReq),urlBuf.toString());
            //更新已发送的数据的状态为已处理
            if(busiNoList.size()>0&&busiNoList!=null&&  StringUtils.equals("0000",JSONObject.parseObject(result).getJSONObject("head").getString("retcode"))){
                assetInfoRecordMapper.updateStatusByBusiNosAndBatchNo(busiNoList,SynDataStatus.YES.getValue(),batchNo);
                //更改assetInfo表的状态
                assetInfoMapper.updateAssetDealBossByBusiNo(busiNoList,assetInfoPushToBiDetailsReqList.get(0).getAssetDealType());
            }

        }catch (Exception e){
            logger.error("-------attentionError---同步数据到BI失败！-----------------");
            e.printStackTrace();
            throw new Exception("同步数据到BI失败！");
        }
    }
}
