package com.uncle2000.androidcommonutils.uitls.date;

import java.util.Calendar;
import java.util.Date;

import static com.uncle2000.androidcommonutils.uitls.date._DateConstant.dateSeparator;
import static com.uncle2000.androidcommonutils.uitls.date._DateConstant.datetimeFormat;
import static com.uncle2000.androidcommonutils.uitls.date._DateConstant.timeSeparator;
import static com.uncle2000.androidcommonutils.uitls.date.DateUtil.chineseCalendar;
import static com.uncle2000.androidcommonutils.uitls.date.DateUtil.now;
import static com.uncle2000.androidcommonutils.uitls.date.DateUtil.chineseWeekDay;

/**
 * 直接拿到某种形式的日期，或者日期中的某个值
 * Created by 2000 on 2017/4/13.
 */

public class GetDate {

    /**************************************获得当前日期********************************************/

    /**
     * 当前日期
     * 会自动省略0
     *
     * @return calendar2str yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentCalendarStr() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c.get(Calendar.YEAR) + dateSeparator
                + (c.get(Calendar.MONTH) + 1) + dateSeparator
                + c.get(Calendar.DAY_OF_MONTH) + " "
                + c.get(Calendar.HOUR_OF_DAY) + timeSeparator
                + c.get(Calendar.MINUTE) + timeSeparator
                + c.get(Calendar.SECOND);
    }

    /**
     * 当前日期
     * 不省略0
     *
     * @return date2Str datetimeFormat
     */
    public static String getCurrentDateStr() {
        return datetimeFormat.format(now());
    }

    /************************************获得日期中的某个值*****************************************/
    /**
     * 获得年份
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    /**
     * 获得月份
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 获得星期几
     *
     * @param date
     * @return
     */
    public static int getWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获得日期
     *
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_YEAR);
    }


    /********************************获得Chinese日期中的某个值**************************************/
    /**
     * get Chinese当年第几月
     *
     * @return
     */
    public static int monthOfYear() {
        return chineseCalendar().get(Calendar.MONTH) + 1;
    }

    /**
     * get Chinese当前月份中的第几天
     *
     * @return
     */
    public static int dayOfMonth() {
        return chineseCalendar().get(Calendar.DAY_OF_MONTH);
    }

    /**
     * get Chinese当前星期的第几天
     * chineseCalendar只对WEEK_OF_MONTH 与WEEK_OF_YEAR 有作用
     *
     * @return
     */
    public static int dayOfWeek() {
        int tmp = chineseCalendar().get(Calendar.DAY_OF_WEEK) - 1;
        if (0 == tmp) {
            tmp = 7;
        }
        return tmp;
    }

    /**
     * get Chinese当年中的第几天
     *
     * @return
     */
    public static int dayOfYear() {
        return chineseCalendar().get(Calendar.DAY_OF_YEAR);
    }

    /**
     * get Chinese当前月的第一天
     * <p>
     * HH:mm:ss SS为零
     *
     * @return
     */
    public static Date firstDayOfMonth() {
        Calendar cal = chineseCalendar();
        cal.set(Calendar.DAY_OF_MONTH, 1); // M月置1
        cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
        cal.set(Calendar.MINUTE, 0);// m置零
        cal.set(Calendar.SECOND, 0);// s置零
        cal.set(Calendar.MILLISECOND, 0);// S置零
        return cal.getTime();
    }

    /**
     * get Chinese当前月的最后一天
     * <p>
     * HH:mm:ss为0，毫秒为999
     *
     * @return
     */
    public static Date lastDayOfMonth() {
        Calendar cal = chineseCalendar();
        cal.set(Calendar.DAY_OF_MONTH, 0); // M月置零
        cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
        cal.set(Calendar.MINUTE, 0);// m置零
        cal.set(Calendar.SECOND, 0);// s置零
        cal.set(Calendar.MILLISECOND, 0);// S置零
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);// 月份+1
        cal.set(Calendar.MILLISECOND, -1);// 毫秒-1
        return cal.getTime();
    }

    /**
     * 获得Chinese周五日期
     *
     * @return Chinese's  Date
     */
    public static Date friday() {
        return chineseWeekDay(Calendar.FRIDAY);
    }

    /**
     * 获得Chinese周六日期
     *
     * @return Chinese's Date
     */
    public static Date saturday() {
        return chineseWeekDay(Calendar.SATURDAY);
    }

    /**
     * 获得Chinese周日日期
     *
     * @return Chinese's Date
     */
    public static Date sunday() {
        return chineseWeekDay(Calendar.SUNDAY);
    }
}
