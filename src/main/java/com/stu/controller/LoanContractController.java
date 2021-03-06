package com.stu.controller;

import com.alibaba.fastjson.JSONObject;
import com.stu.annotation.UserLoginToken;
import com.stu.entity.LoanContract;
import com.stu.service.LoanContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：LoanContractController
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/6 14:04
 * @version 1.0.0
 */
@RestController
@RequestMapping("/loan")
public class LoanContractController {
    @Autowired
    private LoanContractService loanContractService;


    /**
     * MethodName: getStudentInfo
     * Description: 申请贷款前获取学生信息
     * @author lihw
     * CreateTime 2020/4/6 14:07
     * @param userLoginAccount
     * @return jsonObject
     */
    @UserLoginToken
    @RequestMapping("/getStudentInfo")
    public JSONObject getStudentInfo(String userLoginAccount){
        return loanContractService.getUserInfoByLoanInfo(userLoginAccount);
    }

    /**
     * MethodName: fillLoanAppForm
     * Description: 贷款申请
     * @author lihw
     * CreateTime 2020/4/6 14:55
     * @param
     * @return
     */
    @UserLoginToken
    @RequestMapping("/fillLoanAppForm")
    public JSONObject jsonObject(String userLoginAccount,double loanMoney,int loanTerm,String loanReason,String loanStatement){
        LoanContract loanContract = new LoanContract();

        loanContract.setUserIdentity(userLoginAccount);
        loanContract.setLoanMoney(loanMoney);
        loanContract.setLoanBalance(loanMoney);
        loanContract.setLoanTerm(loanTerm);
        loanContract.setLoanReason(loanReason);
        loanContract.setLoanStatement(loanStatement);
        return loanContractService.fillLoanAppForm(loanContract);
    }

    @UserLoginToken
    @RequestMapping("/loanContractInfo")
    public JSONObject loanContractInfo(String userLoginAccount,String contractId){
        return loanContractService.getLoanContractInfo(userLoginAccount, contractId);
    }

    @UserLoginToken
    @RequestMapping("/getLoanSchedule")
    public JSONObject getLoanSchedule(String userLoginAccount){
        return loanContractService.getLoanSchedule(userLoginAccount);
    }

    @UserLoginToken
    @RequestMapping("/updateLoanProgress")
    public JSONObject updateLoanProgress(String userLoginAccount,String contractId){
        LoanContract loanContract = new LoanContract();
        loanContract.setContractId(contractId);
        loanContract.setLoanProgress("已完成");
        return loanContractService.updateProgressByContractId(userLoginAccount,loanContract);
    }


    @UserLoginToken
    @RequestMapping("/currentIsLoan")
    public JSONObject currentIsLoan(String userLoginAccount){
        return loanContractService.currentIsLoan(userLoginAccount);
    }
}
