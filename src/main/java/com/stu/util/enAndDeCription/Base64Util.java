package com.stu.util.enAndDeCription;


import org.apache.commons.codec.binary.Base64;

/**
 * ClassName：Base64Util
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/1/16 13:53
 * @version 1.0.0
 */
public class Base64Util {

    public static String encode(byte[] bytes){
        return new String(Base64.encodeBase64(bytes));
    }

    public static String decode(byte[] bytes){
        return new String(Base64.decodeBase64(bytes));
    }

    public static void main(String[] args) {

        String str = "123456";
        String password = Base64Util.encode(str.getBytes());
        System.out.println(password);

        System.out.println(Base64Util.decode(password.getBytes()));
    }
}