package com.slabs.pushdata.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AssetInfoPushToBiReq implements Serializable {
    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 推送时间
     */
    private Date pushTime;

    /**
     * 资产推送明细
     */
    private List<AssetInfoPushToBiDetailsReq> details;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public List<AssetInfoPushToBiDetailsReq> getDetails() {
        return details;
    }

    public void setDetails(List<AssetInfoPushToBiDetailsReq> details) {
        this.details = details;
    }
}