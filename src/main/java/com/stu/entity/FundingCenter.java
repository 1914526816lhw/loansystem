package com.stu.entity;

public class FundingCenter {
    private Integer fundingCenterId;

    private String fundingCenterName;

    private String fundingCenterAddress;

    private String fundingCenterPhone;

    public Integer getFundingCenterId() {
        return fundingCenterId;
    }

    public void setFundingCenterId(Integer fundingCenterId) {
        this.fundingCenterId = fundingCenterId;
    }

    public String getFundingCenterName() {
        return fundingCenterName;
    }

    public void setFundingCenterName(String fundingCenterName) {
        this.fundingCenterName = fundingCenterName == null ? null : fundingCenterName.trim();
    }

    public String getFundingCenterAddress() {
        return fundingCenterAddress;
    }

    public void setFundingCenterAddress(String fundingCenterAddress) {
        this.fundingCenterAddress = fundingCenterAddress == null ? null : fundingCenterAddress.trim();
    }

    public String getFundingCenterPhone() {
        return fundingCenterPhone;
    }

    public void setFundingCenterPhone(String fundingCenterPhone) {
        this.fundingCenterPhone = fundingCenterPhone == null ? null : fundingCenterPhone.trim();
    }
}