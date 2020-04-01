package com.stu.mapper;

import com.stu.entity.LoanContract;

public interface LoanContractMapper {
    int deleteByPrimaryKey(Integer loanId);

    int insert(LoanContract record);

    int insertSelective(LoanContract record);

    LoanContract selectByPrimaryKey(Integer loanId);

    int updateByPrimaryKeySelective(LoanContract record);

    int updateByPrimaryKey(LoanContract record);
}