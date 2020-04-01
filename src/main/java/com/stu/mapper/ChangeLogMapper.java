package com.stu.mapper;

import com.stu.entity.ChangeLog;

public interface ChangeLogMapper {
    int deleteByPrimaryKey(Integer changeReasonId);

    int insert(ChangeLog record);

    int insertSelective(ChangeLog record);

    ChangeLog selectByPrimaryKey(Integer changeReasonId);

    int updateByPrimaryKeySelective(ChangeLog record);

    int updateByPrimaryKey(ChangeLog record);
}