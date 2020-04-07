package com.stu.mapper;

import com.stu.entity.PayLog;
import org.springframework.stereotype.Repository;

@Repository
public interface PayLogMapper {

    int insert(PayLog record);

}