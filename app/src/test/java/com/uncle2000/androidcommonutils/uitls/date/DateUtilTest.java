package com.uncle2000.androidcommonutils.uitls.date;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 2000 on 2017/4/13.
 */
public class DateUtilTest {
    private static final long oldTime = 1492070956055l;
    private static final long time = 1492070956555l;

    @Test
    public void getmillis() throws Exception {
        System.out.println("当前时间戳          " + DateUtil.getmillis());
    }

    @Test
    public void now() throws Exception {
        System.out.println("当前时间戳date->long" + ConvertDate.date2Long(DateUtil.now()));
    }

    @Test
    public void compareDate() throws Exception {
        System.out.println(DateUtil.compareDate("2017-4-13 16:19", "2017-4-13 16:19"));
    }

    @Test
    public void getDayDiff() throws Exception {

    }

    @Test
    public void parseSecond() throws Exception {
        System.out.println(DateUtil.parseSecond(24000076));
    }

}