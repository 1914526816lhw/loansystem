package com.stu.util.sms;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * ClassName：SmsServiceUtil
 * Description：发送短信的类
 *
 * @author lihw
 * CreateTime: 2019/12/12
 * @version 1.0.0
 */
public class SmsServiceUtil {

    /**
     * MethodName:sendMsg
     * Description:
     *
     * @param phone
     * @param key
     * @return
     * @author lhw
     * CreateTime 2019/12/12 12:01
     */
    public static CommonResponse sendMsg(String phone, String key) {
        CommonResponse response=null;
        /*第二个参数为自己独有的accessKeyid，第三个参数为自己独有的accessKeySecret*/
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FnQQsDVHcXVPtj1EKD3", "d6SUt06Cvr27oao5IrpTmXkhWY0vNr");
        IAcsClient client = new DefaultAcsClient(profile);
        /*组装请求对象*/
        CommonRequest request = new CommonRequest();
        /*request.setProtocol(ProtocolType.HTTPS)*/
        request.setMethod(MethodType.POST);//设置post提交
        request.setDomain("dysmsapi.aliyuncs.com");//短信API产品域名（接口地址固定，无需修改）
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "ITMo");//短信签名
        request.putQueryParameter("TemplateCode", "SMS_180048471");
        request.putQueryParameter("TemplateParam", "{code:" + key + "}");
        try {
            response = client.getCommonResponse(request);
//            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return response;
    }
}
