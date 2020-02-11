package com.slabs.pushdata.entity;

import java.io.Serializable;

public class AssetInfoRecordEntity implements Serializable {
    /**
     * 业务单号
     */
    private String busiNo;

    /**
     * 资产包ID
     */
    private Integer projectId;

    /**
     * 资产包名称
     */
    private String projectName;

    /**
     * 资产包立项日期
     */
    private String projectInitDate;

    /**
     * 资产包到期日期
     */
    private String projectEndDate;

    /**
     * 资产标记日期（预标记就取预标记日期，正式标记就取正式标记日期  示例：20190404）
     */
    private String markDate;

    /**
     * 资产类型(01.未标记,02.预标记,03.正式标记')
     */
    private String assetType;

    /**
     * 资产处理类型（01.进包 02.退包）
     */
    private String assetDealType;
    /**
     * 处理状态（01 未同步, 02 已同步）
     */
    private String status;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 推送时间
     */
    private String pushTime;

    /**
     * 创建时间
     */
    private String createTime;

    public String getBusiNo() {
        return busiNo;
    }

    public void setBusiNo(String busiNo) {
        this.busiNo = busiNo;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectInitDate() {
        return projectInitDate;
    }

    public void setProjectInitDate(String projectInitDate) {
        this.projectInitDate = projectInitDate;
    }

    public String getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(String projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public String getMarkDate() {
        return markDate;
    }

    public void setMarkDate(String markDate) {
        this.markDate = markDate;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssetDealType() {
        return assetDealType;
    }

    public void setAssetDealType(String assetDealType) {
        this.assetDealType = assetDealType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getPushTime() {
        return pushTime;
    }

    public void setPushTime(String pushTime) {
        this.pushTime = pushTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}