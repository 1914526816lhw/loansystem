package com.stu.mapper;

import com.stu.entity.ChangeLog;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeLogMapper {
    int insertUserChangeReason(ChangeLog changeLog) throws Exception;
}