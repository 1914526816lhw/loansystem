package com.stu.controller;


//import com.aliyuncs.CommonResponse;
import com.alibaba.fastjson.JSONObject;
import com.stu.config.RedisConfig;
//import com.stu.util.SmsServiceUtil;

import com.stu.util.sms.SmsUtil;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * ClassName：TestSendMsg
 * Description：测试发送短信
 *
 * @author lihw
 * CreateTime: 2019/12/12
 * @version 1.0.0
 */
@RestController
public class TestSendMsg {
    @Autowired
    private RedisConfig redisConfig;

    /**
     * MethodName: getCode
     * Description:
     *
     * @param
     * @return
     * @author lhw
     * CreateTime 2019/12/12 14:56
     */
    @RequestMapping("/getCode")
    public JSONObject getCode(String phone) {
        int flag = 0;
        JSONObject jsonObject=new JSONObject();
        String code = getRandomCode();

        System.out.println(code);
        redisConfig.set("autoCode", code);
        redisConfig.expire("autoCode", 600);//设置验证码10分钟之后失效
        //成功返回0，失败返回1
        if ((!"".equals(phone)) && phone.length() > 0) {
            //把后台生成的code和所发送的手机号传进发送消息类，调用执行。
            HttpResponse response = SmsUtil.sendMsg(phone, code);
            /*判断response*/
//            System.out.println(response.getStatusLine().getStatusCode());
            flag = response.getStatusLine().getStatusCode();
//            if ("".equals(response.getData())&&response.getData().length()>0)
        }
        jsonObject.put("flag",flag);
        return jsonObject;
    }

    @RequestMapping("/verifyCode")
    public int verifyResult(String preCode) {
        redisConfig.hasKey("autoCode");
        String autoCode = redisConfig.get("autoCode");
        //验证码不为空时，到后台进行比较，返回响应码，为1，提示请先获得验证码
        //为2，提示验证码错误
        //为3，验证码正确，无提示
        if (autoCode == null) {
            return 1;
        } else if (autoCode.equals(preCode)) {
            redisConfig.delete("autoCode");
            return 3;
        } else {
            return 2;
        }
    }

    /**
     * MethodName:
     * Description:
     *
     * @param
     * @return
     * @author lhw
     * CreateTime 2019/12/12 21:43
     */
    public static String getRandomCode() {
        String code = "";
        for (int i = 0; i < 6; i++) {
            code = code + (int) (Math.random() * 9);
        }
        return code;
    }
}
