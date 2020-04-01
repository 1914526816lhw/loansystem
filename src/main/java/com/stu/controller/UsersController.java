package com.stu.controller;

import com.alibaba.fastjson.JSONObject;
import com.stu.annotation.PassToken;
import com.stu.annotation.UserLoginToken;
import com.stu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * ClassName：UsersController
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/1/15 12:33
 * @version 1.0.0
 */

@RestController
@RequestMapping("/user")
public class UsersController {


    @Autowired
    UsersService usersService;


    /**
     * MethodName: register
     * Description:用户注册接口
     *
     * @param
     * @return jsonObject
     * @author lihw
     * CreateTime 2020/3/25 14:36
     */
    @PassToken
    @RequestMapping("/register")
    public JSONObject register(String userName, String userIdentity, String userSecurityQuestion, String userSecurityAnswer, String userPassword, String userPhone) {
        return usersService.registerUsers(userName, userIdentity, userSecurityQuestion, userSecurityAnswer, userPassword, userPhone);
    }

    /**
     * MethodName: verifyUser
     * Description:验证用户身份证号
     *
     * @param userIdentity
     * @return jsonObject
     * @author lihw
     * CreateTime 2020/3/25 14:35
     */
    @PassToken
    @RequestMapping("/verifyUser")
    public JSONObject verifyUser(String userIdentity) {
        return usersService.selectUserByUserIdentity(userIdentity);
    }


    /**
     * MethodName: selectPhoneByIdentity
     * Description: 通过用户身份证号查找手机号接口
     *
     * @param userIdentity
     * @return jsonObject
     * @author lihw
     * CreateTime 2020/3/25 14:43
     */
    @PassToken
    @RequestMapping("/selectPhoneByIdentity")
    public JSONObject selectPhoneByIdentity(String userIdentity) {
        return usersService.selectPhoneByUserIdentity(userIdentity);
    }

    /**
     * MethodName: selectSecurityByIdentity
     * Description: 通过用户身份证号查找密保问题
     * @author lihw
     * CreateTime 2020/3/25 16:13
     * @param userIdentity
     * @return jsonObject
     */
    @PassToken
    @RequestMapping("/selectSecurityByIdentity")
    public JSONObject selectSecurityByIdentity(String userIdentity) {
        return usersService.selectSecurityByUserIdentity(userIdentity);
    }

    @UserLoginToken
    @RequestMapping("/updateSecurityQuestion")
    public JSONObject updateSecurityQuestion(String userLoginAccount,String userSecurityQuestion,String userSecurityAnswer){
        return usersService.updateSecurityQuestion(userLoginAccount,userSecurityQuestion,userSecurityAnswer);
    }

    @UserLoginToken
    @RequestMapping("/updateUserPhone")
    public JSONObject updateUserPhone(String userLoginAccount,String newPhone,String verifyCode){
        return usersService.updateUserPhone(userLoginAccount,newPhone,verifyCode);
    }

    @UserLoginToken
    @RequestMapping("/isFirstLoan")
    public JSONObject isFirstLoan(String userLoginAccount){
        return usersService.isFirstLoan(userLoginAccount);
    }

}
