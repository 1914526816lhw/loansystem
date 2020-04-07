package com.stu.service;

import com.stu.entity.PayLog;
import com.stu.mapper.PayLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName：PayLogServiceImpl
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/7 18:24
 * @version 1.0.0
 */
@Service
public class PayLogServiceImpl  implements PayLogService{

    @Autowired
    private PayLogMapper payLogMapper;

    @Override
    public int addPayLog(PayLog payLog) {
        return payLogMapper.insert(payLog);
    }
}
