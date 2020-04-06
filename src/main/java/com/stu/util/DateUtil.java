package com.stu.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ClassName：FetchDateUtil
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/6 14:13
 * @version 1.0.0
 */
public class DateUtil {

    private static Calendar calendar = Calendar.getInstance();

    /**
     * MethodName: getCurrentYear
     * Description: 获取当前年份
     * @author lihw
     * CreateTime 2020/4/6 20:35
     * @param
     * @return year
     */
    public static int getCurrentYear() {
        return calendar.get(Calendar.YEAR);
    }

    /**
     * MethodName: getDate
     * Description: 将字符串的日期你按照 yyyy-MM-dd 格式转换成Date数据类型
     * @author lihw
     * CreateTime 2020/4/6 20:36
     * @param
     * @return
     */
//    public static Date getDate(Date strDate) {
//        DateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
//        Date newDate
//        try {
//          newDate =  simpleDateFormat.parse(strDate);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return newDate;
//    }

}
