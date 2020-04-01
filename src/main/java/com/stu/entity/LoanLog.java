package com.stu.entity;

import java.util.Date;

public class LoanLog {
    private Integer loanLogId;

    private String loanContactId;

    private Integer loanUserId;

    private Double loanMoney;

    private String loanType;

    private Date loanLogDate;

    public Integer getLoanLogId() {
        return loanLogId;
    }

    public void setLoanLogId(Integer loanLogId) {
        this.loanLogId = loanLogId;
    }

    public String getLoanContactId() {
        return loanContactId;
    }

    public void setLoanContactId(String loanContactId) {
        this.loanContactId = loanContactId == null ? null : loanContactId.trim();
    }

    public Integer getLoanUserId() {
        return loanUserId;
    }

    public void setLoanUserId(Integer loanUserId) {
        this.loanUserId = loanUserId;
    }

    public Double getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(Double loanMoney) {
        this.loanMoney = loanMoney;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType == null ? null : loanType.trim();
    }

    public Date getLoanLogDate() {
        return loanLogDate;
    }

    public void setLoanLogDate(Date loanLogDate) {
        this.loanLogDate = loanLogDate;
    }
}