package com.stu.controller;

import com.alibaba.fastjson.JSONObject;
import com.stu.annotation.UserLoginToken;
import com.stu.service.AccountCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName：AccountCharacterController
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/1 12:02
 * @version 1.0.0
 */
@RestController
@RequestMapping("/accountCharacter")
public class AccountCharacterController {
    @Autowired
    private AccountCharacterService accountCharacterService;


    @UserLoginToken
    @RequestMapping("/getAllAccountCharacter")
    public JSONObject getAllAccountCharacter(){
        return accountCharacterService.getAllAccountCharacter();
    }

}
