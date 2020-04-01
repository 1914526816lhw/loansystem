package com.stu.controller;

import com.alibaba.fastjson.JSONObject;
import com.stu.annotation.PassToken;
import com.stu.annotation.UserLoginToken;
import com.stu.config.RedisConfig;
import com.stu.entity.UserLogin;
import com.stu.entity.Users;
import com.stu.service.UserLoginService;
import com.stu.service.UsersService;
import com.stu.util.Interceptor.TokenUtil;
import com.stu.util.enAndDeCription.Md5Util;
import com.stu.util.sms.SmsUtil;
import org.apache.catalina.User;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ClassName：UserLoginController
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/3/20 12:06
 * @version 1.0.0
 */

@RestController
@RequestMapping("/userLogin")
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private RedisConfig redisConfig;
    @Autowired
    private UsersService usersService;

    /**
     * MethodName: 用户登录
     * Description:
     *
     * @param userLoginAccount,userLoginPassword
     * @return status
     * @author lihw
     * CreateTime 2020/3/20 13:05
     */
    @PassToken
    @RequestMapping("/byAccount")
    public JSONObject loginCheck(@RequestParam("userLoginAccount") String userLoginAccount, @RequestParam("userLoginPassword") String userLoginPassword, HttpServletResponse response) {

        return userLoginService.userLogin(userLoginAccount, userLoginPassword, response);
    }


    /**
     * MethodName: 验证结果
     * Description:成功则登录系统
     *
     * @param
     * @return
     * @author lhw
     * CreateTime 2020/3/21 16:14
     */
    @PassToken
    @RequestMapping("/loginCheck")
    public JSONObject verifyResult(String userPhone, String verifyCode, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        if (redisConfig.hasKey("autoCode")) {
            String autoCode = redisConfig.get("autoCode");
            //验证码不为空时，到后台进行比较，返回响应码，为1，提示请先获得验证码
            //为2，提示验证码错误
            //为3，验证码正确，无提示
            if (autoCode.equals(verifyCode)) {

                //当验证码核对成功后，清除redis中保存的验证码。
                redisConfig.delete("autoCode");
                //比对验证码正确，方可登录系统
                JSONObject data = usersService.selectUserLoginByPhone(userPhone, response);
                if (data != null) {
                    jsonObject.put("status", 200);
                    jsonObject.put("data", data);
                }
            } else {
                jsonObject.put("status", 401);//验证码错误
            }
        } else {
            jsonObject.put("status", 402);//验证码过期
        }
        return jsonObject;
    }

    /**
     * MethodName: resetPwdByUserPhone
     * Description: 通过手机验证重置登录密码
     *
     * @param userIdentity,verifyCode,newPwd
     * @return jsonObject
     * @author lihw
     * CreateTime 2020/3/25 16:58
     */
    @PassToken
    @RequestMapping("/resetPwdByUserPhone")
    public JSONObject resetPwdByUserPhone(String userIdentity, String verifyCode, String newPwd) {
        return userLoginService.resetPwdByUserPhone(userIdentity, verifyCode, newPwd);
    }

    /**
     * MethodName: resetPwdByUserSecurity
     * Description: 通过密保验证重置密码
     *
     * @param userIdentity,securityAnswer,newPwd
     * @return jsonObject
     * @author lihw
     * CreateTime 2020/3/25 17:00
     */
    @PassToken
    @RequestMapping("/resetPwdByUserSecurity")
    public JSONObject resetPwdByUserSecurity(String userIdentity, String securityAnswer, String newPwd) {
        return userLoginService.resetPwdByUserSecurity(userIdentity, securityAnswer, newPwd);
    }


    /**
     * MethodName: updateLoginPassword
     * Description: 账户管理，通过账号旧密码修改密码验证修改密码
     *
     * @param userLoginAccount,oldPwd,newPwd
     * @return jsonObject
     * @author lihw
     * CreateTime 2020/3/25 17:13
     */
    @UserLoginToken
    @RequestMapping("/updateLoginPassword")
    public JSONObject updateLoginPassword(String userLoginAccount, String oldPwd, String newPwd) {
        return userLoginService.updatePwdByUserLoginAccount(userLoginAccount, oldPwd, newPwd);
    }

    /**
     * MethodName: verifyPassword
     * Description: 修改手机号时，验证密码
     * @author lihw
     * CreateTime 2020/3/25 18:09
     * @param
     * @return
     */
    @UserLoginToken
    @RequestMapping("/verifyPassword")
    public JSONObject verifyPassword(String userLoginAccount,String verifyPassword){
        JSONObject jsonObject = new JSONObject();
        UserLogin userLogin = userLoginService.selectByUserLoginAccount(userLoginAccount);
        if(userLogin!=null){
            if(Md5Util.md5(verifyPassword).equals(userLogin.getUserLoginPassword())){
                jsonObject.put("status",200);
            }else {
                jsonObject.put("status",401);
            }
        }
        return jsonObject;
    }
}
