package com.stu.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.stu.config.AlipayConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * ClassName：AlipayServiceImpl
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/5 22:07
 * @version 1.0.0
 */
@Service
public class AlipayServiceImpl implements AlipayService {

    @Override
    public String toAlipay(Map<String, String> sourceMap) throws IOException {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL,AlipayConfig.APPID,AlipayConfig.RSA_PRIVATE_KEY,AlipayConfig.FORMAT,AlipayConfig.CHARSET,AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
//        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        AlipayTradeWapPayModel alipayTradeWapPayModel = new AlipayTradeWapPayModel();
        alipayTradeWapPayModel.setOutTradeNo(sourceMap.get("out_trade_no"));
        alipayTradeWapPayModel.setProductCode("FAST_INSTANT_TRADE_PAY");
        alipayTradeWapPayModel.setTotalAmount(sourceMap.get("total_amount"));
        alipayTradeWapPayModel.setSubject(sourceMap.get("product_name"));
        alipayTradeWapPayModel.setBody(sourceMap.get("body"));
        alipayRequest.setBizModel(alipayTradeWapPayModel);
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }
}