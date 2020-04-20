package com.stu.controller;

import com.alibaba.fastjson.JSONObject;
import com.stu.annotation.UserLoginToken;
import com.stu.service.FundingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：FundingCenterController
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/5 10:24
 * @version 1.0.0
 */

@RestController
@RequestMapping("/fundingCenter")
public class FundingCenterController {

    @Autowired
    private FundingCenterService fundingCenterService;

    @UserLoginToken
    @RequestMapping("/getFundingCenterList")
    public JSONObject getFundingCenterList(){
        return fundingCenterService.getAllFundingCenter();
    }

    @UserLoginToken
    @RequestMapping("/getFundingCenter")
    public JSONObject getFundingCenter(String userLoginAccount){
        return fundingCenterService.getFundingCenter(userLoginAccount);
    }
}
