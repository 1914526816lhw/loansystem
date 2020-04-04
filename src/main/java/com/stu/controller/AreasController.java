package com.stu.controller;

import com.alibaba.fastjson.JSONObject;
import com.stu.annotation.UserLoginToken;
import com.stu.service.AreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：AreasController
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/1 23:01
 * @version 1.0.0
 */
@RestController
@RequestMapping("/area")
public class AreasController {

    @Autowired
    private AreasService areasService;


    /**
     * MethodName: getAllAreaByCityId
     * Description: 通过cityId获取当前城市的所有区域
     * @author lihw
     * CreateTime 2020/4/1 23:03
     * @param cityId
     * @return jsonObject
     */
    @UserLoginToken
    @RequestMapping("/getAllAreaByCityId")
    public JSONObject getAllAreaByCityId(String cityId){
        return areasService.getAllAreaByCityId(cityId);
    }

}
