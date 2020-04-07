package com.stu.entity;

import java.util.Date;

public class PayLog {
    private Integer payId;

    private String userIdentity;

    private String loanContract;

    private Double payMoney;

    private Date payDatetime;

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity == null ? null : userIdentity.trim();
    }

    public String getLoanContract() {
        return loanContract;
    }

    public void setLoanContract(String loanContract) {
        this.loanContract = loanContract == null ? null : loanContract.trim();
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public Date getPayDatetime() {
        return payDatetime;
    }

    public void setPayDatetime(Date payDatetime) {
        this.payDatetime = payDatetime;
    }
}