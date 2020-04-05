package com.stu.mapper;

import com.stu.entity.FundingCenter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundingCenterMapper {
   List<FundingCenter> selectAllFundingCenter();
}