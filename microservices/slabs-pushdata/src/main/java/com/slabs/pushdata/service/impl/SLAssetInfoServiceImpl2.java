package com.slabs.pushdata.service.impl;


import com.alibaba.fastjson.JSON;
import com.slabs.pushdata.dao.AssetInfoMapper2;
import com.slabs.pushdata.dao.AssetInfoRecordMapper2;
import com.slabs.pushdata.entity.AssetInfoEntity;
import com.slabs.pushdata.entity.AssetInfoPushToBiDetailsReq;
import com.slabs.pushdata.entity.AssetInfoRecordEntity;
import com.slabs.pushdata.enums.AssetDealType;
import com.slabs.pushdata.enums.AssetStatus;
import com.slabs.pushdata.helper.AssetInfoHelper2;
import com.slabs.pushdata.service.SLAssetInfoService2;
import com.slabs.pushdata.utils.BeanCopierUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SLAssetInfoServiceImpl2 implements SLAssetInfoService2 {

    private static final Logger logger = LoggerFactory.getLogger(SLAssetInfoServiceImpl2.class);

    @Autowired
    private AssetInfoMapper2 assetInfoMapper;
    @Autowired
    private AssetInfoHelper2 assetInfoHelper;
    @Autowired
    private AssetInfoRecordMapper2 assetInfoRecordMapper;


    /**
     * 功能描述: 根据资产状态推送历史数据的数据到bi
     * @Author: MG01972
     * @Date: 2019-09-26 11:49:13
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int pushDataToBIByStatus(String status) throws Exception {


        List<AssetInfoRecordEntity> assetInfoRecordEntityList = new ArrayList<>();
        List<AssetInfoPushToBiDetailsReq> assetInfoPushToBiReqList = new ArrayList<>();
        String batchNo = getBatchNoByDate(6);
        int successTotal = 0;
//        int insertNum = 0;

        List<AssetInfoEntity> assetInfoEntities = assetInfoMapper.selectAssetInfoByStatus(status);
        logger.info("status:{},assetInfoEntities:【{}】条",status, assetInfoEntities.size());
        for (AssetInfoEntity assetInfo: assetInfoEntities) {

            //保存数据到记录表
            AssetInfoRecordEntity assetInfoRecordEntity = new  AssetInfoRecordEntity();
            assetInfoHelper.buildAssetInfoRecordEntity(assetInfo,assetInfoRecordEntity, batchNo);

            if(StringUtils.equals(AssetStatus.PRE.getValue(),status)){//预标记
                assetInfoRecordEntity.setMarkDate(assetInfo.getPreSignDate());
                assetInfoRecordEntity.setAssetType(AssetStatus.PRE.getValue());
                assetInfoRecordEntity.setAssetDealType(AssetDealType.IN.getValue());//进包

            }else if(StringUtils.equals(AssetStatus.MARK.getValue(),status)){//正式标记
                assetInfoRecordEntity.setMarkDate(assetInfo.getSignDate());
                assetInfoRecordEntity.setAssetType(AssetStatus.MARK.getValue());
                assetInfoRecordEntity.setAssetDealType(AssetDealType.IN.getValue());//进包
            }
            assetInfoRecordEntityList.add(assetInfoRecordEntity);
            if(successTotal != 0 && successTotal%100 == 0){
                logger.info("--------100条插入一次--------【{}】条",assetInfoRecordEntityList.size());
                assetInfoRecordMapper.insertAssetInfoRecord(assetInfoRecordEntityList);
                assetInfoRecordEntityList = new ArrayList<>();

            }
//            int insertNum = assetInfoRecordMapper.insertAssetInfoRecord(assetInfoRecordEntity);

//            if (insertNum < 1) {
//                throw new Exception(String.format("备份到记录表失败！业务单号：【%s】",  assetInfo.getBusiNo()));
//            }

            assetInfoPushToBiReqList.add(BeanCopierUtils.copy(assetInfoRecordEntity,AssetInfoPushToBiDetailsReq.class));
//            successTotal += insertNum++;
            successTotal ++;
        }
        logger.info("--------插入0<num<100的数据【{}】条--------",assetInfoRecordEntityList.size());
        assetInfoRecordMapper.insertAssetInfoRecord(assetInfoRecordEntityList);
        logger.info("successTotal【{}】,assetInfoPushToBiReqList=【{}】条",successTotal,assetInfoPushToBiReqList.size());
        //同步本次修改的数据到BI
        assetInfoHelper.sendAllAssetInfoToBi(assetInfoPushToBiReqList,batchNo);
        return successTotal;
    }

    /**
     * 日期+随机数拼成批次号
     * @param n
     * @return
     */
    public static String getBatchNoByDate(int n){
        String batchNo = DateUtils.formatDate(new Date(), "yyyyMMddHHmmss");
        int j = 1;
        for (int i = 1; i < n; i++) {
            j = j*10;
        }
        if(n==0){
            return batchNo;
        }
        return batchNo+((int)((Math.random()*9+1)*j));
    }
}
