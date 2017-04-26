package com.uncle2000.androidcommonutils.uitls.date;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by 2000 on 2017/4/13.
 */
public class GetDateTest {
    @Test
    public void getCurrentCalendarStr() throws Exception {
        System.out.println("当前calendar时间" + GetDate.getCurrentCalendarStr());
    }

    @Test
    public void getCurrentDateStr() throws Exception {
        System.out.println("当前date时间" + GetDate.getCurrentDateStr());
    }

    @Test
    public void getYear() throws Exception {
        System.out.println("当前第几年" + GetDate.getYear(DateUtil.now()));
    }

    @Test
    public void getMonth() throws Exception {
        System.out.println("当年第几月" + GetDate.getMonth(DateUtil.now()));
    }

    @Test
    public void getWeek() throws Exception {
        System.out.println("当年第几周" + GetDate.getWeek(DateUtil.now()));
    }

    @Test
    public void getDay() throws Exception {
        System.out.println("当月第几天" + GetDate.getDay(DateUtil.now()));
    }

    @Test
    public void monthOfYear() throws Exception {
        System.out.println("中国当年第几月" + GetDate.monthOfYear());
    }

    @Test
    public void dayOfMonth() throws Exception {
        System.out.println("中国当月第几天" + GetDate.dayOfMonth());
    }

    @Test
    public void dayOfWeek() throws Exception {
        System.out.println("中国当周第几天" + GetDate.dayOfWeek());
    }

    @Test
    public void dayOfYear() throws Exception {
        System.out.println("中国当年第几天" + GetDate.dayOfYear());
    }

    @Test
    public void firstDayOfMonth() throws Exception {
        System.out.println("当月第一天的日期" + ConvertDate.date2Str(GetDate.firstDayOfMonth()));
    }

    @Test
    public void lastDayOfMonth() throws Exception {
        System.out.println("当月最后一天的日期" + ConvertDate.date2Str(GetDate.lastDayOfMonth()));
    }

    @Test
    public void friday() throws Exception {
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

        System.out.println("本周五的日期" + ConvertDate.date2Str(GetDate.friday()));
    }

    @Test
    public void saturday() throws Exception {
        System.out.println("本周六的日期" + ConvertDate.date2Str(GetDate.saturday()));
    }

    @Test
    public void sunday() throws Exception {
        System.out.println("本周天的日期" + ConvertDate.date2Str(GetDate.sunday()));
    }

}