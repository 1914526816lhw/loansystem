package com.stu.mapper;

import com.stu.entity.LoanContract;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanContractMapper {
    int insert(LoanContract loanContract) throws Exception;
    LoanContract selectByContractId(String contractId);
    LoanContract selectByLoanOrderId(String loanOrderId);
    LoanContract selectByUserIdentityAndContractId(String userIdentity,String contractId);
    int updateLoanConTractByLoanId(LoanContract loanContract);
    List<LoanContract> selectAllLoanContractByUserIdentity(String userIdentity);
    int updateLoanProgress(LoanContract loanContract) throws Exception;
}