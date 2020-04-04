package com.stu.controller;

import com.alibaba.fastjson.JSONObject;
import com.stu.annotation.UserLoginToken;
import com.stu.service.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：CitiesController
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/1 22:45
 * @version 1.0.0
 */
@RestController
@RequestMapping("/city")
public class CitiesController {
    @Autowired
    private CitiesService citiesService;


    @UserLoginToken
    @RequestMapping("/getAllCityByProvinceId")
    public JSONObject getAllCityByProvinceId(String provinceId){
        return citiesService.getAllCityByProvinceId(provinceId);
    }

}
