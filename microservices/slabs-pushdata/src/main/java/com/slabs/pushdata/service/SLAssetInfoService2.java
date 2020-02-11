package com.slabs.pushdata.service;

import org.springframework.stereotype.Service;

/**
  *  推送数据到bi
  *  @author MG01972
  * @date 2019-09-26 14:19:23
  *
  */
 @Service
public interface SLAssetInfoService2 {


    /**
     * 功能描述: <br>根据资产状态推送历史数据的数据到bi
     * @Param:
     * @Return:
     * @Author: MG01972
     * @Date: 2019-09-26 14:19:50
     */
    int pushDataToBIByStatus(String status) throws Exception;

}
