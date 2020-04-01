package com.stu.mapper;

import com.stu.entity.FundingCenter;

public interface FundingCenterMapper {
    int deleteByPrimaryKey(Integer fundingCenterId);

    int insert(FundingCenter record);

    int insertSelective(FundingCenter record);

    FundingCenter selectByPrimaryKey(Integer fundingCenterId);

    int updateByPrimaryKeySelective(FundingCenter record);

    int updateByPrimaryKey(FundingCenter record);
}