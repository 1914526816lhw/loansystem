package com.stu.service;

import com.alibaba.fastjson.JSONObject;
import com.stu.config.RedisConfig;
import com.stu.util.sms.SmsUtil;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName：PhoneVerifyService
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/3/25 2:28
 * @version 1.0.0
 */
@Service
public class PhoneVerifyService {
    @Autowired
    private RedisConfig redisConfig;

    public JSONObject getCode(String userPhone) {
        int flag = 0;
        JSONObject jsonObject = new JSONObject();
        String code = getRandomCode();

        System.out.println(code);
        redisConfig.set("autoCode", code);
        redisConfig.expire("autoCode", 600);//设置验证码10分钟之后失效
        //成功返回0，失败返回1
        if ((!"".equals(userPhone)) && userPhone.length() > 0) {
            //把后台生成的code和所发送的手机号传进发送消息类，调用执行。
            HttpResponse response = SmsUtil.sendMsg(userPhone, code);
            /*判断response*/
//            System.out.println(response.getStatusLine().getStatusCode());
            flag = response.getStatusLine().getStatusCode();

            jsonObject.put("status", flag);


//            if ("".equals(response.getData())&&response.getData().length()>0)
        }
        return jsonObject;
    }

    /**
     * MethodName:
     * Description:
     *
     * @param
     * @return
     * @author lihw
     * CreateTime 2020/3/21 21:12
     */
    public String getRandomCode() {
        String code = "";
        for (int i = 0; i < 6; i++) {
            code = code + (int) (Math.random() * 9);
        }
        return code;
    }
}
