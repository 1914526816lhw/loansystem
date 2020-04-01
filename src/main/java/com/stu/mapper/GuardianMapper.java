package com.stu.mapper;

import com.stu.entity.Guardian;

public interface GuardianMapper {
    int deleteByPrimaryKey(Integer guardianId);

    int insert(Guardian record);

    int insertSelective(Guardian record);

    Guardian selectByPrimaryKey(Integer guardianId);

    int updateByPrimaryKeySelective(Guardian record);

    int updateByPrimaryKey(Guardian record);
}