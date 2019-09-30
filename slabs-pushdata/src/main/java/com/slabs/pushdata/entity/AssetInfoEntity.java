package com.slabs.pushdata.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class AssetInfoEntity implements Serializable {
    private String busiNo;

    private Integer projectId;

    private String projectName;

    private String packId;

    private String status;

    private String discountFlag;

    private String productType;

    private String productName;

    private String mainLoanerName;

    private String mainLoanerMaritalStatus;

    private Integer mainLoanerAge;

    private String coLoanerNameOne;

    private String coLoanerNameTwo;

    private Integer coLoanerAgeOne;

    private Integer coLoanerAgeTwo;

    private String loanUses;

    private String estateProvince;

    private String estateCity;

    private String estateAddr;

    private String estateCertNo;

    private BigDecimal proportion;

    private String repaymentType;

    private BigDecimal rate;

    private Integer loanPeriod;

    private String loanDate;

    private BigDecimal actualLoanAmt;

    private String fiveCategroy;

    private String extensionFlag;

    private String newOldFlag;

    private String preSignDate;

    private String signDate;

    private String productCode;

    private String productLevelName;

    private String projectExpireTime;

    private String createTime;

    private String updateTime;

    private String preSelected;

    private BigDecimal loanBalance;

    private String isowner;

    private String guarantycount;

    private String mainbondWorkCity;

    private BigDecimal prepaymentAmount;

    private String prepaymentDate;

    private String initDate;

    private String expireTime;

    /**
     * 资产由谁处理（01.ABS   02.BI）
     */
    private String assetDealBoss;

    private static final long serialVersionUID = 1L;

    public String getAssetDealBoss() {
        return assetDealBoss;
    }

    public void setAssetDealBoss(String assetDealBoss) {
        this.assetDealBoss = assetDealBoss;
    }

    public BigDecimal getPrepaymentAmount() {
        return prepaymentAmount;
    }

    public void setPrepaymentAmount(BigDecimal prepaymentAmount) {
        this.prepaymentAmount = prepaymentAmount;
    }

    public String getPrepaymentDate() {
        return prepaymentDate;
    }

    public void setPrepaymentDate(String prepaymentDate) {
        this.prepaymentDate = prepaymentDate;
    }

    public String getIsowner() {
        return isowner;
    }

    public void setIsowner(String isowner) {
        this.isowner = isowner;
    }

    public String getGuarantycount() {
        return guarantycount;
    }

    public void setGuarantycount(String guarantycount) {
        this.guarantycount = guarantycount;
    }

    public String getMainbondWorkCity() {
        return mainbondWorkCity;
    }

    public void setMainbondWorkCity(String mainbondWorkCity) {
        this.mainbondWorkCity = mainbondWorkCity;
    }

    public String getBusiNo() {
        return busiNo;
    }

    public void setBusiNo(String busiNo) {
        this.busiNo = busiNo == null ? null : busiNo.trim();
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
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getPackId() {
        return packId;
    }

    public void setPackId(String packId) {
        this.packId = packId == null ? null : packId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDiscountFlag() {
        return discountFlag;
    }

    public void setDiscountFlag(String discountFlag) {
        this.discountFlag = discountFlag == null ? null : discountFlag.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getMainLoanerName() {
        return mainLoanerName;
    }

    public void setMainLoanerName(String mainLoanerName) {
        this.mainLoanerName = mainLoanerName == null ? null : mainLoanerName.trim();
    }

    public String getMainLoanerMaritalStatus() {
        return mainLoanerMaritalStatus;
    }

    public void setMainLoanerMaritalStatus(String mainLoanerMaritalStatus) {
        this.mainLoanerMaritalStatus = mainLoanerMaritalStatus == null ? null : mainLoanerMaritalStatus.trim();
    }

    public Integer getMainLoanerAge() {
        return mainLoanerAge;
    }

    public void setMainLoanerAge(Integer mainLoanerAge) {
        this.mainLoanerAge = mainLoanerAge;
    }

    public String getCoLoanerNameOne() {
        return coLoanerNameOne;
    }

    public void setCoLoanerNameOne(String coLoanerNameOne) {
        this.coLoanerNameOne = coLoanerNameOne == null ? null : coLoanerNameOne.trim();
    }

    public String getCoLoanerNameTwo() {
        return coLoanerNameTwo;
    }

    public void setCoLoanerNameTwo(String coLoanerNameTwo) {
        this.coLoanerNameTwo = coLoanerNameTwo == null ? null : coLoanerNameTwo.trim();
    }

    public Integer getCoLoanerAgeOne() {
        return coLoanerAgeOne;
    }

    public void setCoLoanerAgeOne(Integer coLoanerAgeOne) {
        this.coLoanerAgeOne = coLoanerAgeOne;
    }

    public Integer getCoLoanerAgeTwo() {
        return coLoanerAgeTwo;
    }

    public void setCoLoanerAgeTwo(Integer coLoanerAgeTwo) {
        this.coLoanerAgeTwo = coLoanerAgeTwo;
    }

    public String getLoanUses() {
        return loanUses;
    }

    public void setLoanUses(String loanUses) {
        this.loanUses = loanUses == null ? null : loanUses.trim();
    }

    public String getEstateProvince() {
        return estateProvince;
    }

    public void setEstateProvince(String estateProvince) {
        this.estateProvince = estateProvince == null ? null : estateProvince.trim();
    }

    public String getEstateCity() {
        return estateCity;
    }

    public void setEstateCity(String estateCity) {
        this.estateCity = estateCity == null ? null : estateCity.trim();
    }

    public String getEstateAddr() {
        return estateAddr;
    }

    public void setEstateAddr(String estateAddr) {
        this.estateAddr = estateAddr == null ? null : estateAddr.trim();
    }

    public String getEstateCertNo() {
        return estateCertNo;
    }

    public void setEstateCertNo(String estateCertNo) {
        this.estateCertNo = estateCertNo == null ? null : estateCertNo.trim();
    }

    public BigDecimal getProportion() {
        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    public String getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType == null ? null : repaymentType.trim();
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(Integer loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate == null ? null : loanDate.trim();
    }

    public BigDecimal getActualLoanAmt() {
        return actualLoanAmt;
    }

    public void setActualLoanAmt(BigDecimal actualLoanAmt) {
        this.actualLoanAmt = actualLoanAmt;
    }

    public String getFiveCategroy() {
        return fiveCategroy;
    }

    public void setFiveCategroy(String fiveCategroy) {
        this.fiveCategroy = fiveCategroy == null ? null : fiveCategroy.trim();
    }

    public String getExtensionFlag() {
        return extensionFlag;
    }

    public void setExtensionFlag(String extensionFlag) {
        this.extensionFlag = extensionFlag == null ? null : extensionFlag.trim();
    }

    public String getNewOldFlag() {
        return newOldFlag;
    }

    public void setNewOldFlag(String newOldFlag) {
        this.newOldFlag = newOldFlag == null ? null : newOldFlag.trim();
    }

    public String getPreSignDate() {
        return preSignDate;
    }

    public void setPreSignDate(String preSignDate) {
        this.preSignDate = preSignDate == null ? null : preSignDate.trim();
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate == null ? null : signDate.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductLevelName() {
        return productLevelName;
    }

    public void setProductLevelName(String productLevelName) {
        this.productLevelName = productLevelName == null ? null : productLevelName.trim();
    }

    public String getProjectExpireTime() {
        return projectExpireTime;
    }

    public void setProjectExpireTime(String projectExpireTime) {
        this.projectExpireTime = projectExpireTime == null ? null : projectExpireTime.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getPreSelected() {
        return preSelected;
    }

    public void setPreSelected(String preSelected) {
        this.preSelected = preSelected == null ? null : preSelected.trim();
    }

    public String getInitDate() {
        return initDate;
    }

    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public BigDecimal getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(BigDecimal loanBalance) {
        this.loanBalance = loanBalance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBusiNo() == null) ? 0 : getBusiNo().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getPackId() == null) ? 0 : getPackId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDiscountFlag() == null) ? 0 : getDiscountFlag().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getMainLoanerName() == null) ? 0 : getMainLoanerName().hashCode());
        result = prime * result + ((getMainLoanerMaritalStatus() == null) ? 0 : getMainLoanerMaritalStatus().hashCode());
        result = prime * result + ((getMainLoanerAge() == null) ? 0 : getMainLoanerAge().hashCode());
        result = prime * result + ((getCoLoanerNameOne() == null) ? 0 : getCoLoanerNameOne().hashCode());
        result = prime * result + ((getCoLoanerNameTwo() == null) ? 0 : getCoLoanerNameTwo().hashCode());
        result = prime * result + ((getCoLoanerAgeOne() == null) ? 0 : getCoLoanerAgeOne().hashCode());
        result = prime * result + ((getCoLoanerAgeTwo() == null) ? 0 : getCoLoanerAgeTwo().hashCode());
        result = prime * result + ((getLoanUses() == null) ? 0 : getLoanUses().hashCode());
        result = prime * result + ((getEstateProvince() == null) ? 0 : getEstateProvince().hashCode());
        result = prime * result + ((getEstateCity() == null) ? 0 : getEstateCity().hashCode());
        result = prime * result + ((getEstateAddr() == null) ? 0 : getEstateAddr().hashCode());
        result = prime * result + ((getEstateCertNo() == null) ? 0 : getEstateCertNo().hashCode());
        result = prime * result + ((getProportion() == null) ? 0 : getProportion().hashCode());
        result = prime * result + ((getRepaymentType() == null) ? 0 : getRepaymentType().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getLoanPeriod() == null) ? 0 : getLoanPeriod().hashCode());
        result = prime * result + ((getLoanDate() == null) ? 0 : getLoanDate().hashCode());
        result = prime * result + ((getActualLoanAmt() == null) ? 0 : getActualLoanAmt().hashCode());
        result = prime * result + ((getFiveCategroy() == null) ? 0 : getFiveCategroy().hashCode());
        result = prime * result + ((getExtensionFlag() == null) ? 0 : getExtensionFlag().hashCode());
        result = prime * result + ((getNewOldFlag() == null) ? 0 : getNewOldFlag().hashCode());
        result = prime * result + ((getPreSignDate() == null) ? 0 : getPreSignDate().hashCode());
        result = prime * result + ((getSignDate() == null) ? 0 : getSignDate().hashCode());
        result = prime * result + ((getProductCode() == null) ? 0 : getProductCode().hashCode());
        result = prime * result + ((getProductLevelName() == null) ? 0 : getProductLevelName().hashCode());
        result = prime * result + ((getProjectExpireTime() == null) ? 0 : getProjectExpireTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getPreSelected() == null) ? 0 : getPreSelected().hashCode());
        result = prime * result + ((getLoanBalance() == null) ? 0 : getLoanBalance().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", busiNo=").append(busiNo);
        sb.append(", projectId=").append(projectId);
        sb.append(", projectName=").append(projectName);
        sb.append(", packId=").append(packId);
        sb.append(", status=").append(status);
        sb.append(", discountFlag=").append(discountFlag);
        sb.append(", productType=").append(productType);
        sb.append(", productName=").append(productName);
        sb.append(", mainLoanerName=").append(mainLoanerName);
        sb.append(", mainLoanerMaritalStatus=").append(mainLoanerMaritalStatus);
        sb.append(", mainLoanerAge=").append(mainLoanerAge);
        sb.append(", coLoanerNameOne=").append(coLoanerNameOne);
        sb.append(", coLoanerNameTwo=").append(coLoanerNameTwo);
        sb.append(", coLoanerAgeOne=").append(coLoanerAgeOne);
        sb.append(", coLoanerAgeTwo=").append(coLoanerAgeTwo);
        sb.append(", loanUses=").append(loanUses);
        sb.append(", estateProvince=").append(estateProvince);
        sb.append(", estateCity=").append(estateCity);
        sb.append(", estateAddr=").append(estateAddr);
        sb.append(", estateCertNo=").append(estateCertNo);
        sb.append(", proportion=").append(proportion);
        sb.append(", repaymentType=").append(repaymentType);
        sb.append(", rate=").append(rate);
        sb.append(", loanPeriod=").append(loanPeriod);
        sb.append(", loanDate=").append(loanDate);
        sb.append(", actualLoanAmt=").append(actualLoanAmt);
        sb.append(", fiveCategroy=").append(fiveCategroy);
        sb.append(", extensionFlag=").append(extensionFlag);
        sb.append(", newOldFlag=").append(newOldFlag);
        sb.append(", preSignDate=").append(preSignDate);
        sb.append(", signDate=").append(signDate);
        sb.append(", productCode=").append(productCode);
        sb.append(", productLevelName=").append(productLevelName);
        sb.append(", projectExpireTime=").append(projectExpireTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", preSelected=").append(preSelected);
        sb.append(", loanBalance=").append(loanBalance);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}