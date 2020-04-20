package com.stu.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * ClassName：FetchDateUtil
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/6 14:13
 * @version 1.0.0
 */
public class DateUtilCurrent {

    private static Calendar calendar = Calendar.getInstance();

    /**
     * MethodName: getCurrentYear
     * Description: 获取当前年份
     *
     * @param
     * @return year
     * @author lihw
     * CreateTime 2020/4/6 20:35
     */
    public static int getCurrentYear() {
        return calendar.get(Calendar.YEAR);
    }

    /**
     * MethodName: getDate
     * Description: 将字符串的日期你按照 yyyy-MM-dd 格式转换成Date数据类型
     *
     * @param
     * @return
     * @author lihw
     * CreateTime 2020/4/6 20:36
     */
    public static String getDate(Date strDate) {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = null;
        try {
            newDate = simpleDateFormat.format(strDate);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return newDate;
    }

    public static Date addDate(Date date) {

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1); //把日期往后增加一天,整数  往后推,负数往前移动
        date = calendar.getTime(); //这个时间就是日期往后推一天的结果
        return date;
    }
}
