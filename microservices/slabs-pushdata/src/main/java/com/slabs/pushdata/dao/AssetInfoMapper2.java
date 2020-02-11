package com.slabs.pushdata.dao;

import com.slabs.pushdata.entity.AssetInfoEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetInfoMapper2 {

    List<AssetInfoEntity> selectAssetInfoByStatus(@Param("status") String status);

    int updateAssetDealBossByBusiNo(@Param("busiNos") List<String> busiNos, @Param("assetDealBoss")String assetDealBoss);
}