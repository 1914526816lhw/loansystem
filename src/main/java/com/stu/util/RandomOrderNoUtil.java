package com.stu.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * ClassName：RandomOrderNoUtil
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/6 11:33
 * @version 1.0.0
 */
public class RandomOrderNoUtil {

    /**
     * 订单流水号模拟
     * @return
     */
    public static String getRandomFileName() {
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String str = simpleDateFormat.format(date);  //当前时间字符串
        String val = ""; //自定义一个随机字符串
        Random random = new Random();
        // 10位含数字字母的随机字符串
        for (int i = 0; i < 10; i++) {
            // 在[0,2)值域随机生成一个数除2，得到以下要判断的格式
            String ranstr = random.nextInt(2) % 2 == 0 ? "num" : "char";
            if ("char".equalsIgnoreCase(ranstr)) {
                // 产生字母（大小写判断）
                int nextInt = random.nextInt(2) % 2 == 0 ? 65 : 97;
                // 字符串拼接
                val += (char) (nextInt + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(ranstr)) { // 产生随机数字并转成字符串
                val += String.valueOf(random.nextInt(10));
            }
        }

        return "D"+str+val;// 当前时间

    }
}
