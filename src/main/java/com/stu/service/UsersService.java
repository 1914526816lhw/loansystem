package com.stu.service;

import com.alibaba.fastjson.JSONObject;
import com.stu.entity.Guardian;
import com.stu.entity.Users;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletResponse;

/**
 * ClassName：UsersService
 * Description：用户业务类
 *
 * @author lihw
 * CreateTime: 2020/3/20 9:19
 * @version 1.0.0
 */
@Repository
public interface UsersService {
    JSONObject registerUsers(String userName, String userIdentity, String userSecurityQuestion, String userSecurityAnswer, String userPassword, String userPhone);
    JSONObject selectUserLoginByPhone(String userPhone, HttpServletResponse response);
    JSONObject selectUserByUserIdentity(String userIdentity);
    JSONObject selectPhoneByUserIdentity(String userIdentity);
    JSONObject selectSecurityByUserIdentity(String userIdentity);
    JSONObject updateSecurityQuestion(String userIdentity,String userSecurityQuestion,String userSecurityAnswer);
    JSONObject updateUserPhone(String userIdentity,String userPhone,String verifyCode);
    JSONObject isFirstLoan(String userIdentity);
    JSONObject getUserName(String userIdentity);
    JSONObject improveUserInfo(Guardian guardian, Users users);
    JSONObject getUserInfo(String userIdentity);
    JSONObject updateUser(Users users,String changeReason);
    JSONObject getUserInfoDetail(String userIdentity);
}
