package com.stu.controller;

import com.alibaba.fastjson.JSONObject;
import com.stu.service.PhoneVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：PhoneVerifyController
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/3/25 2:30
 * @version 1.0.0
 */

@RestController
public class PhoneVerifyController {

    @Autowired
    private PhoneVerifyService phoneVerifyService;


    @RequestMapping("/getCode")
    public JSONObject getCode(String userPhone) {
       return  phoneVerifyService.getCode(userPhone);
    }
}
