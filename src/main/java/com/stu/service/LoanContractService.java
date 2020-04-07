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
    LoanContract selectByUserIdentityAndLoanId(String userIdentity,int loanId);
    LoanContract selectByContractId(String contractId);
}
