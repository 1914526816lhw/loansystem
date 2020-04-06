package com.stu.config;

import org.springframework.context.annotation.Configuration;

import java.io.FileWriter;
import java.io.IOException;

/**
 * ClassName：AlipayConfig
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/1/7 12:04
 * @version 1.0.0
 */

@Configuration
public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

//    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
//    public static String app_id = "2016102100731812";
//
//    // 商户私钥，您的PKCS8格式RSA2私钥
//    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCaTDBNzK2IH1zo4MmcUIJ744s3YM+zBOJoeMyxVctdvjJWG6+r6ubI6o8o0lMHUJ2glROsMI68Gr564dSwaWN1afuJ2vU5aENznRb/Wov02+mOh6l2K71FDfmmZTtW3g4RzX6N9MBYbmNrmc2HZwqApIYYcfcTk3mvUcWLxbzAY6Lk24++sPAfaSB8ew0j02JH1x4ilUvGCJ/pm0VzjyHektPIFbaboAIcdE35WB+DZFAnv6aqqLzySugVOjlmDq0GJ7ldub3CEGlmOhwnSOEyVsQdCbFz/VZDp4KE1EGzJtfOaWCho/OjK8j/gMGlaV34p8iRRgSZZuB944Pd6P0rAgMBAAECggEATbLUGDlboVJ5zON1Yvu/2XcqIcbkkHeDM6yxFxPnBtvCKU5j1iTB9qb3VE0ldmeIGNc5Qtpo5hxpkyOpoPRRG001V6QlHLV+UffnHsuP8svS/u0dzt4Tv3RcJQiRKxtC5oAenImFWoKsGgEnWGnxBfrTc/ffvcHj4v9AhTQb6pz34BBhhIqGEHhLSZq8Wveih0Tq7oTNnjykf74Q2FyFev/07R3M4I+WQwCCGUHyzNTQmU0dXshLd/9V9mc5T5muAwR8FGlWZT3Sbs7ecEIzNu0/ATN23uSQ1kvjZKJC3zXQL40TbZFynXF37k7LbxcBjqkj7AFflqjq2Nq8ONQa0QKBgQDjzhv+iG0FP/Xyg7ga47C9pUMi4gFRsaToMoRIWcUXGTrfu/OL8Llz4rgAVHjhWyoA0LVcn2UaadwYD+OlbnT7eNR7Xy2j0YilJ6ndJmEeblkNgcAe518EWknM6hT8xqJOigDDsKrm9rI97z7icUi3VXMu/bI1FYKhmGFLzTRcdwKBgQCtZQfxu/dphe4dtq+xhw0FLElXTW0FBkzz3F22ocK8cX5d+FjipdbhPM0ooQI2HV7tiZptMzNL5jm9IGa7ApOlYi0heOWYt5tlA2XOGQ5VTdjGRcEAE6yMcKTz+6rHXxmxy5b2QGoRsYQo6CW/Ivsd9bxUR/dyLnNuH6DN/3t17QKBgHIFwSdW29Kr4AwB+A2ld9qEtKTqIKTmWNdMKcAZBrh4DWrdJZse44Ror5aisVqDCfQcgxqYQb/Fyr9UfKpaLj2MjjYuPqbngxC/WJtz0Vqs+u/yyNnvDzUbiCMD63tWZPkQxC8u52vxgOfVL1GiSDZTk/KqUx+U46zEm7aYQKQjAoGAex4Po/85T73/My3yVnV0M0Yc1VZuoHC21ziTegglw7Q6a/LY+iWTC98mNUEN1urH6pYYBo2iULQqLzYAe6z6tSWesfOr4uIL/o+JC+wSl1NtJmuE/M77Z8Tb+zmpK2NFVU8f474dEm8fTgR4ON1XvRAtJxLqijKdV4YxodNUEIkCgYByeaomc+X3yNDIuj3uVweT9zKXpWGfnpFtnsTQK33uScpH38D+kZVQ/2fqDl8SO6OMCZQ06Ps3jZchEzD4Szn7Xg3eyUKyEflUbVaZnpkH0l7ZNkVLHSk9L6dvfliJUwg+Jl4K74AO97KAtFFxn5/NLvndk7VFrPs0AgsQcpi7Rw==";
//
//    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
//    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqyH0a0Ih8eYoKpZcx7LlzaNJWAhfzgH1bc+F60dmoH4yIn3uDqdabJBjQsXCMbUPuyj1PJb9KDzI8XKciynC3igfuJZUwoA19P2kkIzg7c8z8jriiNQzRGgStG7IRbVou4j0UAts9JLYpPHvVrIG3dI7yGx7zDpmVxf/zu0K1GyJIoDaeDf+kK0yffNsLQj/ofhd8mOtAN56ATuB9JuJ6tBk9ct1sXzdz7qeanP2B66zcOHgVp9fSK7dEfZC7bLiLogFgwnVcxnkv5BHyouE2iw+sztLIDlBh0En+drjxQkuaZoNYAkRXpW8B5oz5BxVoKKb61Nc604QwA9cTyPAZwIDAQAB";
//
//    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String notify_url = "http://www.baidu.com/";
//
//    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String return_url = "http://www.baidu.com/";
//
//    // 签名方式
//    public static String sign_type = "RSA2";
//
//    // 字符编码格式
//    public static String charset = "utf-8";
//
//    // 支付宝网关
//    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
//
//    // 支付宝网关
//    public static String log_path = "D:\\java";

    //支付宝商户号的APPID
    public static String APPID = "2016102100731812";

    //用支付宝密钥生成工具生成的私钥
    public static String RSA_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCaTDBNzK2IH1zo4MmcUIJ744s3YM+zBOJoeMyxVctdvjJWG6+r6ubI6o8o0lMHUJ2glROsMI68Gr564dSwaWN1afuJ2vU5aENznRb/Wov02+mOh6l2K71FDfmmZTtW3g4RzX6N9MBYbmNrmc2HZwqApIYYcfcTk3mvUcWLxbzAY6Lk24++sPAfaSB8ew0j02JH1x4ilUvGCJ/pm0VzjyHektPIFbaboAIcdE35WB+DZFAnv6aqqLzySugVOjlmDq0GJ7ldub3CEGlmOhwnSOEyVsQdCbFz/VZDp4KE1EGzJtfOaWCho/OjK8j/gMGlaV34p8iRRgSZZuB944Pd6P0rAgMBAAECggEATbLUGDlboVJ5zON1Yvu/2XcqIcbkkHeDM6yxFxPnBtvCKU5j1iTB9qb3VE0ldmeIGNc5Qtpo5hxpkyOpoPRRG001V6QlHLV+UffnHsuP8svS/u0dzt4Tv3RcJQiRKxtC5oAenImFWoKsGgEnWGnxBfrTc/ffvcHj4v9AhTQb6pz34BBhhIqGEHhLSZq8Wveih0Tq7oTNnjykf74Q2FyFev/07R3M4I+WQwCCGUHyzNTQmU0dXshLd/9V9mc5T5muAwR8FGlWZT3Sbs7ecEIzNu0/ATN23uSQ1kvjZKJC3zXQL40TbZFynXF37k7LbxcBjqkj7AFflqjq2Nq8ONQa0QKBgQDjzhv+iG0FP/Xyg7ga47C9pUMi4gFRsaToMoRIWcUXGTrfu/OL8Llz4rgAVHjhWyoA0LVcn2UaadwYD+OlbnT7eNR7Xy2j0YilJ6ndJmEeblkNgcAe518EWknM6hT8xqJOigDDsKrm9rI97z7icUi3VXMu/bI1FYKhmGFLzTRcdwKBgQCtZQfxu/dphe4dtq+xhw0FLElXTW0FBkzz3F22ocK8cX5d+FjipdbhPM0ooQI2HV7tiZptMzNL5jm9IGa7ApOlYi0heOWYt5tlA2XOGQ5VTdjGRcEAE6yMcKTz+6rHXxmxy5b2QGoRsYQo6CW/Ivsd9bxUR/dyLnNuH6DN/3t17QKBgHIFwSdW29Kr4AwB+A2ld9qEtKTqIKTmWNdMKcAZBrh4DWrdJZse44Ror5aisVqDCfQcgxqYQb/Fyr9UfKpaLj2MjjYuPqbngxC/WJtz0Vqs+u/yyNnvDzUbiCMD63tWZPkQxC8u52vxgOfVL1GiSDZTk/KqUx+U46zEm7aYQKQjAoGAex4Po/85T73/My3yVnV0M0Yc1VZuoHC21ziTegglw7Q6a/LY+iWTC98mNUEN1urH6pYYBo2iULQqLzYAe6z6tSWesfOr4uIL/o+JC+wSl1NtJmuE/M77Z8Tb+zmpK2NFVU8f474dEm8fTgR4ON1XvRAtJxLqijKdV4YxodNUEIkCgYByeaomc+X3yNDIuj3uVweT9zKXpWGfnpFtnsTQK33uScpH38D+kZVQ/2fqDl8SO6OMCZQ06Ps3jZchEzD4Szn7Xg3eyUKyEflUbVaZnpkH0l7ZNkVLHSk9L6dvfliJUwg+Jl4K74AO97KAtFFxn5/NLvndk7VFrPs0AgsQcpi7Rw==";

    //电脑网站支付结果异步通知，可以参考异步文档，一定要是外网能访问的
    public static String notify_url = "http://www.baidu.com/";

    //电脑网站支付结果同步通知，用于转跳到用户自己的页面，一定要是外网能访问的
    public static String return_url = "http://www.baidu.com/";

    //沙箱接口，正式上线时请改用正式支付接口
    public static String URL = "https://openapi.alipaydev.com/gateway.do";

    //固定的参数
    public static String CHARSET = "UTF-8";

    //固定的参数
    public static String FORMAT = "json";

    //用支付宝密钥生成工具生成的公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqyH0a0Ih8eYoKpZcx7LlzaNJWAhfzgH1bc+F60dmoH4yIn3uDqdabJBjQsXCMbUPuyj1PJb9KDzI8XKciynC3igfuJZUwoA19P2kkIzg7c8z8jriiNQzRGgStG7IRbVou4j0UAts9JLYpPHvVrIG3dI7yGx7zDpmVxf/zu0K1GyJIoDaeDf+kK0yffNsLQj/ofhd8mOtAN56ATuB9JuJ6tBk9ct1sXzdz7qeanP2B66zcOHgVp9fSK7dEfZC7bLiLogFgwnVcxnkv5BHyouE2iw+sztLIDlBh0En+drjxQkuaZoNYAkRXpW8B5oz5BxVoKKb61Nc604QwA9cTyPAZwIDAQAB";

    //固定的参数
    public static String log_path = "/log";

    //固定的参数
    public static String SIGNTYPE = "RSA2";

    public AlipayConfig() {
    }

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}