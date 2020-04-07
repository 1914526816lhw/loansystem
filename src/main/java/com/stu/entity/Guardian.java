package com.stu.entity;

public class Guardian {
    private Integer guardianId;

    private String guardianName;

    private String guardianIdentity;

    private String guardianPostalCode;

    private String guardianHealth;

    private String guardianTel;

    private String areaId;

    private String guardianPermanentAddress;

    private String  userIdentity;

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