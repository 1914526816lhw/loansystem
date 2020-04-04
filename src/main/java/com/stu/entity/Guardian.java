package com.stu.entity;

public class Guardian {
    private Integer guardianId;

    private String guardianName;

    private String guardianIdentity;

    private String guardianAddress;

    private String guardianFamilyAddress;

    private String guardianPostalCode;

    private String guardianFamilyPhone;

    private String guardianHealth;

    private String guardianTel;

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

    public String getGuardianAddress() {
        return guardianAddress;
    }

    public void setGuardianAddress(String guardianAddress) {
        this.guardianAddress = guardianAddress == null ? null : guardianAddress.trim();
    }

    public String getGuardianFamilyAddress() {
        return guardianFamilyAddress;
    }

    public void setGuardianFamilyAddress(String guardianFamilyAddress) {
        this.guardianFamilyAddress = guardianFamilyAddress == null ? null : guardianFamilyAddress.trim();
    }

    public String getGuardianPostalCode() {
        return guardianPostalCode;
    }

    public void setGuardianPostalCode(String guardianPostalCode) {
        this.guardianPostalCode = guardianPostalCode == null ? null : guardianPostalCode.trim();
    }

    public String getGuardianFamilyPhone() {
        return guardianFamilyPhone;
    }

    public void setGuardianFamilyPhone(String guardianFamilyPhone) {
        this.guardianFamilyPhone = guardianFamilyPhone == null ? null : guardianFamilyPhone.trim();
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
}