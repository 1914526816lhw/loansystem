package com.stu.config.interceptors;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.stu.annotation.PassToken;
import com.stu.annotation.UserLoginToken;
import com.stu.domain.User;
import com.stu.domain.UserLogin;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        //如果不是映射到方法直接通过

        if (!(handler instanceof HandlerMethod)) {
            //这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
            //当然你可以利用response给用户返回一些提示信息，告诉他没登陆
            System.out.println("preHandle");
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

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                if (token == null) {
                    throw new RuntimeException("无 token, 请重新登录!");
                }
                //获取token中的userid
                String userId;
                try {
                    userId = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException e) {
                    throw new RuntimeException("401");
                }
                UserLogin user = null;//通过 userId 来查询用户的，判断用户数是否存在
                if (user == null) {
                    throw new RuntimeException("用户不存在，请重新登录！");
                }
                //验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getUserLoginPassword())).build();
                try {
                    jwtVerifier.verify(token);
                }catch (JWTDecodeException e){
                    throw new RuntimeException("401");
                }
                return true;
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
}
