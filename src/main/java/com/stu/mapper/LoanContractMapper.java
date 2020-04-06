package com.stu.mapper;

import com.stu.entity.LoanContract;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanContractMapper {
    int insert(LoanContract loanContract) throws Exception;
    LoanContract selectLoanContractByUserIdentity(String contractId);
}