package com.stu.service;

import cn.hutool.core.date.DateUtil;
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
import java.util.Calendar;
import java.util.Date;

/**
 * ClassName：UsersServiceImpl
 * Description：User业务逻辑实现类
 *
 * @author lihw
 * CreateTime: 2020/3/20 9:22
 * @version 1.0.0
 */

@Service
public class UsersServiceImpl implements UsersService {
    Logger logger = Logger.getLogger(UsersServiceImpl.class);

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UserLoginMapper userLoginMapper;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private RedisConfig redisConfig;

    /**
     * MethodName: 用户注册
     * Description:新用户的注册
     *
     * @param userName,userIdentity,userSecurityQuestion,userSecurityAnswer,userPassword,userPhone
     * @return status 0或1表示成功和失败
     * @author lhw
     * CreateTime 2020/3/20 11:23
     */
    @Override
    public JSONObject registerUsers(String userName, String userIdentity, String userSecurityQuestion, String userSecurityAnswer, String userPassword, String userPhone) {
        JSONObject jsonObject = new JSONObject();

        try {
            Users users = new Users();
            users.setUserName(userName);
            users.setUserIdentity(userIdentity);
            users.setUserSecurityQuestion(userSecurityQuestion);
            users.setUserSecurityAnswer(Md5Util.md5(userSecurityAnswer));
            users.setUserPhone(userPhone);
            int insertUserResult = usersMapper.registerUsers(users);


            if (insertUserResult == 1) {
                //使用md5单向加密对用户的密码加密
                //因为是单向加密，在密码比对的时候，使用同样的方式处理
                String userLoginPassword = Md5Util.md5(userPassword);

                int insertUserLoginResult = userLoginMapper.insertUserLogin(userIdentity, userLoginPassword, users.getUserId());
                if (insertUserLoginResult == 1) {
                    jsonObject.put("status", 200);//注册成功
                } else {
                    jsonObject.put("status", 401);//注册失败
                }
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return jsonObject;
    }

    @Override
    public JSONObject selectUserLoginByPhone(String userPhone, HttpServletResponse response) {
        JSONObject data = new JSONObject();
        UserLogin userLogin = usersMapper.selectUserLoginByPhone(userPhone);
        if (userLogin != null) {
            String token = tokenService.getToken(userLogin);
            data.put("token", token);
            data.put("userLoginAccount", userLogin.getUserLoginAccount());
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
        } else {
            data = null;
        }
        return data;
    }

    @Override
    public JSONObject selectUserByUserIdentity(String userIdentity) {
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        Users users = usersMapper.selectUserByIdentity(userIdentity);
        if (users != null) {
            jsonObject.put("status", 200);
            data.put("userIdentity", userIdentity);
            jsonObject.put("data", data);
        } else {
            jsonObject.put("status", 401);
        }
        return jsonObject;
    }

    @Override
    public JSONObject selectPhoneByUserIdentity(String userIdentity) {
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        Users users = usersMapper.selectUserByIdentity(userIdentity);
        if (users != null) {
            jsonObject.put("status", 200);
            data.put("userPhone", users.getUserPhone());
            jsonObject.put("data", data);
        } else {
            jsonObject.put("status", 401);
        }
        return jsonObject;
    }

    @Override
    public JSONObject selectSecurityByUserIdentity(String userIdentity) {
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        Users users = usersMapper.selectUserByIdentity(userIdentity);
        if (users != null) {
            jsonObject.put("status", 200);
            data.put("userSecurityQuestion", users.getUserSecurityQuestion());
            jsonObject.put("data", data);
        } else {
            jsonObject.put("status", 401);
        }
        return jsonObject;
    }

    @Override
    public JSONObject updateSecurityQuestion(String userIdentity, String userSecurityQuestion, String userSecurityAnswer) {
        JSONObject jsonObject = new JSONObject();
        Users users = usersMapper.selectUserByIdentity(userIdentity);
        if (users != null) {
            if (usersMapper.updateSecurityQuestion(userIdentity, userSecurityQuestion, Md5Util.md5(userSecurityAnswer)) == 1) {
                jsonObject.put("status", 200);
            } else {
                jsonObject.put("status", 500);
            }
        } else {
            jsonObject.put("status", 401);
        }
        return jsonObject;
    }

    @Override
    public JSONObject updateUserPhone(String userIdentity, String userPhone, String verifyCode) {
        JSONObject jsonObject = new JSONObject();
        Users users = usersMapper.selectUserByIdentity(userIdentity);
        if (users != null) {
            if (verifyCode.equals(redisConfig.get("autoCode"))) {
                redisConfig.delete("autoCode");
                try {
                    if (usersMapper.updateUserPhone(userIdentity, userPhone) == 1) {
                        jsonObject.put("status", 200);
                    }
                } catch (Exception e) {
                    jsonObject.put("status", 500);
                }
            } else {
                jsonObject.put("status", 401);//验证码错误
            }
        }
        return jsonObject;
    }

    @Override
    public JSONObject isFirstLoan(String userIdentity) {
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        Users users = usersMapper.selectUserByIdentity(userIdentity);
        String userLoanType = users.getUserLoanType();
        if (users != null) {
            if ("首贷".equals(userLoanType)) {
                jsonObject.put("status", 200);
                data.put("userLoanType", userLoanType);
            } else if ("续贷".equals(userLoanType)) {
                //毕业年份
                Date date = users.getUserGraduationTime();
                Calendar calendar = Calendar.getInstance();
//                System.out.println("当前年份" + calendar.get(Calendar.YEAR));
//                System.out.println("毕业年份" + DateUtil.year(date));
                if (calendar.get(Calendar.YEAR) < DateUtil.year(date)) {
                    jsonObject.put("status", 200);
                    data.put("data", userLoanType);
                } else {
                    jsonObject.put("status", 401);
                }
            }
        } else {
            jsonObject.put("status", 500);
        }
        jsonObject.put("data", data);
        return jsonObject;
    }
}