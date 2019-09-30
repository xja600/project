package com.slabs.pushdata.dao;

import com.slabs.pushdata.entity.AssetInfoRecordEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssetInfoRecordMapper2 {
    int insertAssetInfoRecord(List<AssetInfoRecordEntity> assetInfoRecordEntity);
//    int insertAssetInfoRecord(AssetInfoRecordEntity assetInfoRecordEntity);

    void updateStatusByBusiNosAndBatchNo(@Param("busiNos") List<String> busiNos, @Param("status") String status, @Param("batchNo") String batchNo);

    List<AssetInfoRecordEntity> queryAssetInfoRecordByStatus(@Param("status") String status, @Param("batchNo") String batchNo);

    /**
     * 获取未同步数据的批次号
     * @param status
     * @return
     */
    List<String> queryAssetInfoRecordBatchByStatus(@Param("status") String status);
}