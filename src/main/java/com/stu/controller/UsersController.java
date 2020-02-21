package com.stu.controller;

import com.stu.annotation.UserLoginToken;
import com.stu.util.enAndDeCription.Base64Util;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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


    @RequestMapping("/register")
    public boolean register(String userAccount, String userPassword) {
        System.out.println(userAccount + " and " + userPassword);
        System.out.println(Base64Util.decode(userAccount.getBytes()) + "," + Base64Util.decode(userPassword.getBytes()));
        return true;
    }


    @RequestMapping("/login")
    public boolean loginCheck(@RequestParam("userAccount") String userAccount, @RequestParam("userPassword") String userPassword, HttpSession session) {

        System.out.println(userAccount + " and " + userPassword);
        System.out.println(Base64Util.decode(userAccount.getBytes()) + "," + Base64Util.decode(userPassword.getBytes()));

        if (!StringUtils.isEmpty(userAccount) && "123456".equals(userPassword)) {
            session.setAttribute("userAccount", userAccount);
            return true;
        } else {
            return false;
        }
    }

    @UserLoginToken
    @RequestMapping("/userDetails")
    public Object userDetails() {
        return "拦截器";
    }
}
