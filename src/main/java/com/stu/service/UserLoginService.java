package com.stu.service;

import com.alibaba.fastjson.JSONObject;
import com.stu.entity.UserLogin;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletResponse;


/**
 * ClassName：UserLoginService
 * Description：用户登录类
 *
 * @author lihw
 * CreateTime: 2020/3/20 10:11
 * @version 1.0.0
 */
@Repository
public interface UserLoginService {
    int insertUserLogin(String userLoginAccount,String userLoginPassword,int userId);
    JSONObject userLogin(String userLoginAccount, String userLoginPassword, HttpServletResponse response);
    UserLogin selectByUserLoginAccount(String userLoginAccount);
    JSONObject resetPwdByUserPhone(String userIdentity,String verifyCode,String newPwd);
    JSONObject resetPwdByUserSecurity(String userIdentity,String securityQuestion,String newPwd);
    JSONObject updatePwdByUserLoginAccount(String userLoginAccount,String oldPwd,String newPwd);
}
