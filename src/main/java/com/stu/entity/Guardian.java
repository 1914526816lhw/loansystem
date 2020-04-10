package com.stu.entity;

public class Guardian {
    //共同贷款人id
    private Integer guardianId;
    //共同贷款人姓名
    private String guardianName;
    //身份证号
    private String guardianIdentity;
    //y邮政编码
    private String guardianPostalCode;
    //健康状况
    private String guardianHealth;
    //手机号码
    private String guardianTel;
    //户籍地址
    private String guardianPermanentAddress;
    //外键，用户身份证号
    private String userIdentity;
    //省市区
    private String provinceId;
    private String provinceName;
    private String cityId;
    private String cityName;
    private String areaId;
    private String areaName;

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public Integer getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(Integer guardianId) {
        this.guardianId = guardianId;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName == null ? null : guardianName.trim();
    }

    public String getGuardianIdentity() {
        return guardianIdentity;
    }

    public void setGuardianIdentity(String guardianIdentity) {
        this.guardianIdentity = guardianIdentity == null ? null : guardianIdentity.trim();
    }

    public String getGuardianPostalCode() {
        return guardianPostalCode;
    }

    public void setGuardianPostalCode(String guardianPostalCode) {
        this.guardianPostalCode = guardianPostalCode == null ? null : guardianPostalCode.trim();
    }

    public String getGuardianHealth() {
        return guardianHealth;
    }

    public void setGuardianHealth(String guardianHealth) {
        this.guardianHealth = guardianHealth == null ? null : guardianHealth.trim();
    }

    public String getGuardianTel() {
        return guardianTel;
    }

    public void setGuardianTel(String guardianTel) {
        this.guardianTel = guardianTel == null ? null : guardianTel.trim();
    }


    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public String getGuardianPermanentAddress() {
        return guardianPermanentAddress;
    }

    public void setGuardianPermanentAddress(String guardianPermanentAddress) {
        this.guardianPermanentAddress = guardianPermanentAddress == null ? null : guardianPermanentAddress.trim();
    }


}