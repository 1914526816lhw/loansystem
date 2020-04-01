package com.stu.service;

import com.alibaba.fastjson.JSONObject;
import com.stu.config.RedisConfig;
import com.stu.entity.UserLogin;
import com.stu.entity.Users;
import com.stu.mapper.UserLoginMapper;
import com.stu.mapper.UsersMapper;
import com.stu.util.enAndDeCription.Md5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName：UserLoginServiceImpl
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/3/20 10:13
 * @version 1.0.0
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    Logger logger = Logger.getLogger(UserLoginServiceImpl.class);

    @Autowired
    private UserLoginMapper userLoginMapper;
    @Autowired
    TokenService tokenService;
    @Autowired
    private RedisConfig redisConfig;
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int insertUserLogin(String userLoginAccount, String userLoginPassword, int userId) {
        try {
            int result = userLoginMapper.insertUserLogin(userLoginAccount, userLoginPassword, userId);
            if (result == 1) {
                return 0;
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return 1;
    }

    @Override
    public JSONObject userLogin(String userLoginAccount, String userLoginPassword, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        UserLogin userLogin = userLoginMapper.selectUserLoginByAccount(userLoginAccount);
        if (userLogin != null) {
            try {

                if (Md5Util.md5(userLoginPassword).equals(userLogin.getUserLoginPassword())) {

                    String token = tokenService.getToken(userLogin);
                    data.put("token", token);
                    data.put("userLoginAccount", userLoginAccount);
                    jsonObject.put("status", 200);//表示登录成功;
                    Cookie cookie = new Cookie("token", token);
                    cookie.setPath("/");
                    response.addCookie(cookie);

                } else {
                    jsonObject.put("status", 1000);//表示密码错误
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            jsonObject.put("status", 401);//表示没有该用户
        }
        jsonObject.put("data", data);
        return jsonObject;
    }

    @Override
    public UserLogin selectByUserLoginAccount(String userLoginAccount) {
        return userLoginMapper.selectUserLoginByAccount(userLoginAccount);
    }

    @Override
    public JSONObject resetPwdByUserPhone(String userIdentity, String verifyCode, String newPwd) {
        JSONObject jsonObject = new JSONObject();
        if (redisConfig.hasKey("autoCode")) {
            if (verifyCode.equals(redisConfig.get("autoCode"))) {
                int result = userLoginMapper.resetPwd(userIdentity, Md5Util.md5(newPwd));
                if (result == 1) {
                    jsonObject.put("status", 200);
                    redisConfig.delete("autoCode");
                } else {
                    jsonObject.put("status", 500);
                }
            } else {
                jsonObject.put("status", 401);
            }
        } else {
            jsonObject.put("status", 402);
        }
        return jsonObject;
    }

    @Override
    public JSONObject resetPwdByUserSecurity(String userIdentity, String securityQuestion, String newPwd) {
        JSONObject jsonObject = new JSONObject();
        Users users = usersMapper.selectUserByIdentity(userIdentity);
        if(users!=null){
            if(Md5Util.md5(securityQuestion).equals(users.getUserSecurityAnswer())){
                if(userLoginMapper.resetPwd(userIdentity,Md5Util.md5(newPwd))==1){
                    jsonObject.put("status",200);
                }else{
                    jsonObject.put("status",500);
                }
            }else {
                jsonObject.put("status",401);
            }
        }

        return jsonObject;
    }

    @Override
            public JSONObject updatePwdByUserLoginAccount(String userLoginAccount, String oldPwd, String newPwd) {
        JSONObject jsonObject = new JSONObject();
        UserLogin userLogin = userLoginMapper.selectUserLoginByAccount(userLoginAccount);
        if(userLogin!=null){
            if(Md5Util.md5(oldPwd).equals(userLogin.getUserLoginPassword())){
                if(userLoginMapper.resetPwd(userLoginAccount,Md5Util.md5(newPwd))==1){
                    jsonObject.put("status",200);
                }else {
                    jsonObject.put("status",500);
                }
            }else {
                jsonObject.put("status",401);
            }
        }
        return jsonObject;
    }
}
