package com.stu.entity;

public class ChangeLog {
    private Integer changeReasonId;

    private String userIdentity;

    private String guardianIdentity;

    private String changeReasonContent;

    public Integer getChangeReasonId() {
        return changeReasonId;
    }

    public void setChangeReasonId(Integer changeReasonId) {
        this.changeReasonId = changeReasonId;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity == null ? null : userIdentity.trim();
    }

    public String getGuardianIdentity() {
        return guardianIdentity;
    }

    public void setGuardianIdentity(String guardianIdentity) {
        this.guardianIdentity = guardianIdentity == null ? null : guardianIdentity.trim();
    }

    public String getChangeReasonContent() {
        return changeReasonContent;
    }

    public void setChangeReasonContent(String changeReasonContent) {
        this.changeReasonContent = changeReasonContent == null ? null : changeReasonContent.trim();
    }
}