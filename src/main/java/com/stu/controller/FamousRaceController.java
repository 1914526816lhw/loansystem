package com.stu.controller;

import com.alibaba.fastjson.JSONObject;
import com.stu.annotation.UserLoginToken;
import com.stu.service.FamousRaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：FamousRaceController
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/1 11:24
 * @version 1.0.0
 */
@RestController
@RequestMapping("/famousRace")
public class FamousRaceController {
    @Autowired
    private FamousRaceService famousRaceService;


    @UserLoginToken
    @RequestMapping("/getAllFamousRace")
    public JSONObject getAllFamousRace(){
        return famousRaceService.getAllFamousRace();
    }
}
