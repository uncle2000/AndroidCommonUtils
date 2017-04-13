package com.uncle2000.androidcommonutils.uitls.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.uncle2000.androidcommonutils.uitls.date._DateConstant.FORMAT;
import static com.uncle2000.androidcommonutils.uitls.date._DateConstant.oneDay_SM;
import static com.uncle2000.androidcommonutils.uitls.date._DateConstant.oneHour_SM;
import static com.uncle2000.androidcommonutils.uitls.date._DateConstant.oneScond_SM;
import static com.uncle2000.androidcommonutils.uitls.date._DateConstant.oneWeek_SM;

/**
 * 日期转换类
 * Created by 2000 on 2017/4/13.
 */

public class ConverDate {

    /**
     * 任意字符串转换成任意格式
     *
     * @param dateStr   需要转换的字符串
     * @param formatStr 需要格式的目标字符串 举例 yyyy-MM-dd
     * @return Date 返回转换后的时间
     * @throws ParseException 转换异常
     */
    public static Date StringToDate(String dateStr, String formatStr) {
        DateFormat sdf = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /*********************************Date&Calender&String 互转************************************/
    /**
     * String->Date
     *
     * @param str
     * @return
     */
    public static Date str2Date(String str) {
        return str2Date(str, null);
    }

    public static Date str2Date(String str, String format) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = FORMAT;
        }
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;

    }

    /**
     * String->Calendar
     *
     * @param str
     * @return
     */
    public static Calendar str2Calendar(String str) {
        return str2Calendar(str, null);

    }

    public static Calendar str2Calendar(String str, String format) {
        Date date = str2Date(str, format);
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c;
    }

    /**
     * Calendar->String
     *
     * @param c
     * @return
     */
    public static String calendar2Str(Calendar c) {// yyyy-MM-dd HH:mm:ss
        return calendar2Str(c, null);
    }

    public static String calendar2Str(Calendar c, String format) {
        if (c == null) {
            return null;
        }
        return date2Str(c.getTime(), format);
    }

    /**
     * Date->String
     *
     * @param d
     * @return
     */
    public static String date2Str(Date d) {// yyyy-MM-dd HH:mm:ss
        return date2Str(d, null);
    }

    public static String date2Str(Date d, String format) {// yyyy-MM-dd HH:mm:ss
        if (d == null) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = FORMAT;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String s = sdf.format(d);
        return s;
    }

    /**
     * date->long
     *
     * @param s
     * @return 时间戳
     */
    @Deprecated
    public static long str2Long(String s) {
        Date d = str2Date(s);
        return date2Long(d);
    }

    /**
     * date->long
     *
     * @param d
     * @return 时间戳
     */
    public static long date2Long(Date d) {
        if (d == null) {
            return 0;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return calendar2Long(c);
    }

    /**
     * date->long
     *
     * @param c
     * @return 时间戳
     */
    public static long calendar2Long(Calendar c) {
        return c.getTimeInMillis();
    }

    /***********************************时间戳->格式化的字符串**************************************/
    /**
     * long->
     *
     * @param time
     * @return 年月日时分秒毫秒
     */
    public static String getSMillon(long time) {
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS").format(time);
    }

    /**
     * long->
     *
     * @param time
     * @return 年月天 时分秒
     */
    public static String getMillon(long time) {
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(time);
    }

    /**
     * long->
     *
     * @param time
     * @return 年月天
     */
    public static String getDay(long time) {
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }


//    /**
//     * 根据自定义pattern将字符串日期转换成java.util.Date类型
//     *
//     * @param datetime
//     * @param pattern
//     * @return
//     * @throws ParseException
//     */
//    public static Date parseDatetime(String datetime, String pattern) throws ParseException {
//        SimpleDateFormat format = (SimpleDateFormat) datetimeFormat.clone();
//        format.applyPattern(pattern);
//        return format.parse(datetime);
//    }

    /************************************已过去时间***********************************************/

    /**
     * 已过去时间距现在多久
     * 有瑕疵 月和季度还没有实现
     *
     * @param timestamp 过去的时间戳
     * @return
     */
    public static String converTime(long timestamp) {
        long currentSeconds = System.currentTimeMillis();
        long timeGap = currentSeconds - timestamp;// 与现在时间相差秒数
        System.out.println("==>" + timeGap);
        String timeStr = null;
        if (timeGap > oneWeek_SM) {// 7天以上
            timeStr = timeGap / (oneWeek_SM) + "周前";
        } else if (timeGap > oneDay_SM) {// 1天以上
            timeStr = timeGap / (oneDay_SM) + "天前";
        } else if (timeGap > oneHour_SM) {// 1小时-24小时
            timeStr = timeGap / (oneHour_SM) + "小时前";
        } else if (timeGap > oneScond_SM) {// 1分钟-59分钟
            timeStr = timeGap / oneScond_SM + "分钟前";
        } else {// 1秒钟-59秒钟
            timeStr = "刚刚";
        }
        return timeStr;
    }
}
