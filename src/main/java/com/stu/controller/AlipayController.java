package com.stu.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.stu.config.AlipayConfig;
import com.stu.service.AlipayService;
import com.stu.util.RandomOrderNoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.*;
import java.util.Set;

/**
 * ClassName：AlipayController
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/1/7 12:42
 * @version 1.0.0
 */

@Controller
public class AlipayController {

    @Autowired
    public AlipayService alipayService;


    @RequestMapping("/pay")
    public void toAlipay(HttpServletRequest httpRequest , HttpServletResponse httpResponse) throws IOException {

        //生成一笔支付记录，支付完成时将支付状态改为成功


        Map<String, String> sourceMap = new HashMap<>();
        sourceMap.put("out_trade_no", RandomOrderNoUtil.getRandomFileName());
        sourceMap.put("total_amount","10000");
        sourceMap.put("body","李宏伟的支付测试。");


        String form = alipayService.toAlipay(sourceMap);
        httpResponse.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
        httpResponse.getWriter().write(form);
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }


    //注意异步返回结果通知是以post请求形式返回的
    @RequestMapping("/notifyUrl")
    public String notify_url(HttpServletRequest request){
        Map<String, String> paramsMap = convertRequestParamsToMap(request);
        String out_trade_no= paramsMap.get("out_trade_no");
        String trade_status= paramsMap.get("trade_status");
        try {
            boolean signVerified = AlipaySignature.rsaCheckV1(paramsMap, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGNTYPE);
            //无论同步异步都要验证签名
            if(signVerified){
                if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
                    //处理自己系统的业务逻辑，如：将支付记录状态改为成功，需要返回一个字符串success告知支付宝服务器

                    return "success";
                } else {
                    //支付失败不处理业务逻辑
                    return "failure";
                }
            }else {
                //签名验证失败不处理业务逻辑
                return "failure";
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return "failure";
        }
    }

    //注意同步返回结果是以get请求形式返回的
    @RequestMapping("/returnUrl")
    public String return_url(HttpServletRequest request){
        Map<String, String> paramsMap = convertRequestParamsToMap(request);
        try {
            boolean signVerified = AlipaySignature.rsaCheckV1(paramsMap, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGNTYPE);
            if(signVerified){
                //跳转支付成功界面
                return "success";

            }else {
                //跳转支付失败界面
                return "failure";
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return "success";
    }


    //将请求中的参数转换为Map
    public static Map<String, String> convertRequestParamsToMap(HttpServletRequest request) {
        Map<String, String> retMap = new HashMap();
        Set<Entry<String, String[]>> entrySet = request.getParameterMap().entrySet();
        Iterator var3 = entrySet.iterator();

        while(true) {
            while(var3.hasNext()) {
                Entry<String, String[]> entry = (Entry)var3.next();
                String name = (String)entry.getKey();
                String[] values = (String[])entry.getValue();
                int valLen = values.length;
                if(valLen == 1) {
                    retMap.put(name, values[0]);
                } else if(valLen <= 1) {
                    retMap.put(name, "");
                } else {
                    StringBuilder sb = new StringBuilder();
                    String[] var9 = values;
                    int var10 = values.length;

                    for(int var11 = 0; var11 < var10; ++var11) {
                        String val = var9[var11];
                        sb.append(",").append(val);
                    }

                    retMap.put(name, sb.toString().substring(1));
                }
            }

            return retMap;
        }
    }


    //将字符串转换为UTF-8编码以防出现乱码错误（出现中文乱码时使用）
    public static String getUTF8XMLString(String xml) {
        StringBuffer sb = new StringBuffer();
        sb.append(xml);
        String xmString = "";
        String xmlUTF8="";
        try {
            xmString = new String(sb.toString().getBytes("UTF-8"));
            xmlUTF8 = URLEncoder.encode(xmString, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return xmlUTF8;
    }
}