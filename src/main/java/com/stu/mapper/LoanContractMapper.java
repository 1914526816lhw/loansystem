package com.stu.mapper;

import com.stu.entity.LoanContract;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanContractMapper {
    int insert(LoanContract loanContract) throws Exception;
    LoanContract selectByContractId(String contractId);
    LoanContract selectByUserIdentity(String userIdentity);
    LoanContract selectByUserIdentityAndLoanId(String userIdentity,int loanId);
}