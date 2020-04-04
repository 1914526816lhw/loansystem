package com.stu.controller;

import com.alibaba.fastjson.JSONObject;
import com.stu.annotation.UserLoginToken;
import com.stu.service.ProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：ProvincesController
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/1 22:23
 * @version 1.0.0
 */

@RestController
@RequestMapping("/province")
public class ProvincesController {

    @Autowired
    private ProvincesService provincesService;


    /**
     * MethodName: getAllProvince
     * Description: 获取所有的省份信息
     * @author lihw
     * CreateTime 2020/4/1 22:25
     * @param
     * @return jsonObject
     */
    @UserLoginToken
    @RequestMapping("/getAllProvince")
    public JSONObject getAllProvince(){
        return provincesService.getAllProvince();
    }


}
