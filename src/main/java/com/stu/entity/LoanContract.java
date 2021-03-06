package com.stu.entity;

import java.util.Date;

public class LoanContract {

    private Integer loanId;

    private String contractId;

    private String loanName;

    private Double loanMoney;

    private Double loanBalance;

    private Date loanDate;

    private int loanTerm;

    private String loanReason;

    private String loanStatement;

    private String userIdentity;

    private String guardianIdentity;

    private String loanProgress;

    private String loanOrderId;

    public String getLoanProgress() {
        return loanProgress;
    }

    public void setLoanProgress(String loanProgress) {
        this.loanProgress = loanProgress;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName == null ? null : loanName.trim();
    }

    public Double getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(Double loanMoney) {
        this.loanMoney = loanMoney;
    }

    public Date getLoanDate() {
        return loanDate;
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
        this.guardianIdentity = guardianIdentity;
    }

    public String getLoanReason() {
        return loanReason;
    }

    public void setLoanReason(String loanReason) {
        this.loanReason = loanReason;
    }

    public String getLoanStatement() {
        return loanStatement;
    }

    public void setLoanStatement(String loanStatement) {
        this.loanStatement = loanStatement;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public Double getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(Double loanBalance) {
        this.loanBalance = loanBalance;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public String getLoanOrderId() {
        return loanOrderId;
    }

    public void setLoanOrderId(String loanOrderId) {
        this.loanOrderId = loanOrderId;
    }
}