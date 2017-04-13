package com.uncle2000.androidcommonutils.uitls.date;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by 2000 on 2017/4/10.
 */

@SuppressLint("SimpleDateFormat")
public class DateUtil {

    /**
     * 获得当前时间戳
     *
     * @return long
     */
    public static long getmillis() {
        return System.currentTimeMillis();
    }

    /**
     * get当前日期对象
     *
     * @return Date
     */
    static Date now() {
        return new Date();
    }

    /**
     * us的一周的第一天为星期天，这里更改为第一天为星期一
     *
     * @return Chinese's Calendar
     */
    static Calendar chineseCalendar() {
        Calendar cal = GregorianCalendar.getInstance(Locale.CHINESE);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        return cal;
    }

    /**
     * 通过传入的星期几 返回中国式的星期几的Date对象
     *
     * @param week 星期几
     * @return Chinese's  Date
     */
    static Date chineseWeekDay(int week) {
        Calendar cal = chineseCalendar();
        cal.set(Calendar.DAY_OF_WEEK, week);
        return cal.getTime();
    }

    /************************************计算&判断*****************************************/
    /**
     * 判断原日期是否在目标日期之前
     *
     * @param src
     * @param dst
     * @return
     */
    public static boolean isBefore(Date src, Date dst) {
        return src.before(dst);
    }

    /**
     * 判断原日期是否在目标日期之后
     *
     * @param src
     * @param dst
     * @return
     */
    public static boolean isAfter(Date src, Date dst) {
        return src.after(dst);
    }

    /**
     * 判断两日期是否相同
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isEqual(Date date1, Date date2) {
        return date1.compareTo(date2) == 0;
    }

    /**
     * 判断某个日期是否在某个日期范围
     *
     * @param beginDate 日期范围开始
     * @param endDate   日期范围结束
     * @param src       需要判断的日期
     * @return
     */
    public static boolean between(Date beginDate, Date endDate, Date src) {
        return beginDate.before(src) && endDate.after(src);
    }

    /**
     * 比较时间大小
     *
     * @param begin
     * @param end
     * @return 1：开始日期小于结束日期 -1：开始日期大于结束日期 0：相等
     */
    public static int compareDate(String begin, String end) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date beginDate = df.parse(begin);
            Date endDate = df.parse(end);
            if (beginDate.getTime() < endDate.getTime()) {
                return 1;
            } else if (beginDate.getTime() > endDate.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 获得天数差
     * <p>
     * 结束日期小于开始日期返回-1
     *
     * @param begin
     * @param end
     * @return
     */
    public static long getDayDiff(Date begin, Date end) {
        long day = 1;
        if (end.getTime() < begin.getTime()) {
            day = -1;
        } else if (end.getTime() == begin.getTime()) {
            day = 1;
        } else {
            day += (end.getTime() - begin.getTime()) / (24 * 60 * 60 * 1000);
        }
        return day;
    }

    /**
     * 判断long是不是时间戳
     */ {

    }

    /**
     * 秒->大概是多少个最少单位
     * 有瑕疵
     *
     * @param second
     * @return 分种小时
     */
    public static String parseSecond(long second) {
        if (second <= 60) {
            return second + "秒";
        } else if (second <= 60 * 60) {
            return second / 60 + "分";
        } else if (second <= 60 * 60 * 24) {
            return second / (60 * 60) + "时";
        } else if (second <= 60 * 60 * 24 * 30) {
            return second / (24 * 60 * 60) + "天";
        } else if (second <= 60 * 60 * 24 * 120) {
            return second / (30 * 24 * 60 * 60) + "月";
        } else if (second <= 60 * 60 * 24 * 365) {
            return second / (120 * 24 * 60 * 60) + "季";
        } else if (second <= 60 * 60 * 24 * 365*100) {//error
            return second / (365 * 24 * 60 * 60) + "年";
        } else {
            return second / (100 * 365 * 24 * 60 * 60) + "世纪";//error
        }
    }

}
