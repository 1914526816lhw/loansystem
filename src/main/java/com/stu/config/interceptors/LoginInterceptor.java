package com.stu.config.interceptors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.stu.annotation.PassToken;
import com.stu.annotation.UserLoginToken;
import com.stu.entity.UserLogin;
import com.stu.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * ClassName：LoginInterceptor
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/1/15 12:07
 * @version 1.0.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    //这个方法是在访问接口前执行的，我们只需要在这里写验证登录状态的业务逻辑，就可以在用户指定接口之前验证登录状态了
    @Autowired
    private UserLoginService userLoginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        //如果不是映射到方法直接通过

        if (!(handler instanceof HandlerMethod)) {
            //这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
            //当然你可以利用response给用户返回一些提示信息，告诉他没登陆
//            System.out.println("preHandle");
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检测 是否有passtoken注释,有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        //如果有UserLoginToken，检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                if (token == null) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("status", 501);
                    jsonObject.put("message", "无会话，请先登录！");
                    printJson(response, jsonObject);
//                    throw new RuntimeException("无 token, 请重新登录!");
                    return false;
                }
                //获取token中的userId
                String userLoginAccount;
                try {
                    userLoginAccount = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException e) {
//                    throw new RuntimeException("401");
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("status", 502);
                    jsonObject.put("message", "会话已过期，请重新登录！");
                    printJson(response, jsonObject);
                    return false;
                }
                UserLogin userLogin = userLoginService.selectByUserLoginAccount(userLoginAccount);//通过 userId 来查询用户的，判断用户数是否存在
                if (userLogin != null) {


                    //验证 token
                    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(userLogin.getUserLoginAccount())).build();
                    try {
                        jwtVerifier.verify(token);
                    } catch (JWTDecodeException e) {
                        throw new RuntimeException("401");
                    }
                    return true;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


    private static void printJson(HttpServletResponse response, JSONObject jsonObject) {

        printContent(response, JSON.toJSONString(jsonObject));
    }


    private static void printContent(HttpServletResponse response, String content) {
        try {
            response.reset();
            response.setContentType("application/json");
            response.setHeader("Cache-Control", "no-store");
            response.setCharacterEncoding("UTF-8");
            PrintWriter pw = response.getWriter();
            pw.write(content);
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
