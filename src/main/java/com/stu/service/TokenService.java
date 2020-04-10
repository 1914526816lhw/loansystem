package com.stu.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.stu.entity.UserLogin;
import org.springframework.stereotype.Service;

import java.util.Date;



@Service
public class TokenService {

    public String getToken(UserLogin userLogin) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 60*1000*24;//有效求一天
        Date end = new Date(currentTime);
        String token;
        token = JWT.create().withAudience(userLogin.getUserLoginAccount()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(userLogin.getUserLoginAccount()));
        return token;
    }
}
