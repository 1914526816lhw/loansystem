package com.stu.service;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Map;

/**
 * ClassName：AlipayService
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/5 22:06
 * @version 1.0.0
 */
@Repository
public interface AlipayService {
    public String toAlipay(Map<String, String> sourceMap) throws IOException;
}