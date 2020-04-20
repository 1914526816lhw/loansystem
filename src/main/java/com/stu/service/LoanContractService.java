package com.stu.service;

import com.alibaba.fastjson.JSONObject;
import com.stu.entity.LoanContract;
import org.springframework.stereotype.Repository;

/**
 * ClassName：LoanContractService
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/6 14:01
 * @version 1.0.0
 */
@Repository
public interface LoanContractService {
    JSONObject getUserInfoByLoanInfo(String userIdentity);
    JSONObject fillLoanAppForm(LoanContract loanContract);
    void createAppForm(String userIdentity,String loanContractId);
    LoanContract selectByUserIdentityAndContractId(String userIdentity,String contractId);
    LoanContract selectByLoanOrderId(String contractId);
    int updateLoanConTractByLoanId(LoanContract loanContract);
    JSONObject getAllLoanContractByUserIdentity(String userIdentity);
    JSONObject getLoanContractInfo(String userIdentity,String contractId);
    JSONObject getLoanSchedule(String userIdentity);
    JSONObject updateProgressByContractId(String userIdentity,LoanContract loanContract);
    JSONObject currentIsLoan(String userIdentity);
    void createContract(String userIdentity,String contractId);
}
