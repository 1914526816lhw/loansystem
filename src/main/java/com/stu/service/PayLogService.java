package com.stu.service;

import com.stu.entity.PayLog;
import org.springframework.stereotype.Repository;

/**
 * ClassName：PayLogService
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/7 18:23
 * @version 1.0.0
 */
@Repository
public interface PayLogService {
    int addPayLog(PayLog payLog);
}
