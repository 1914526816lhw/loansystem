package com.stu.entity;

public class ChangeLog {
    private Integer changeReasonId;

    private String changeReasonContent;

    public Integer getChangeReasonId() {
        return changeReasonId;
    }

    public void setChangeReasonId(Integer changeReasonId) {
        this.changeReasonId = changeReasonId;
    }

    public String getChangeReasonContent() {
        return changeReasonContent;
    }

    public void setChangeReasonContent(String changeReasonContent) {
        this.changeReasonContent = changeReasonContent == null ? null : changeReasonContent.trim();
    }
}