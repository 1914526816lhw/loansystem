package com.stu.mapper;

import com.stu.entity.LoanLog;

public interface LoanLogMapper {
    int deleteByPrimaryKey(Integer loanLogId);

    int insert(LoanLog record);

    int insertSelective(LoanLog record);

    LoanLog selectByPrimaryKey(Integer loanLogId);

    int updateByPrimaryKeySelective(LoanLog record);

    int updateByPrimaryKey(LoanLog record);
}