package com.uncle2000.androidcommonutils.uitls.date;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 2000 on 2017/4/13.
 */
public class ConvertDateTest {
    @Test
    public void converTime() throws Exception {
        long curTime = DateUtil.getmillis();
        System.out.println(ConvertDate.converTime(curTime));
        System.out.println(ConvertDate.converTime(curTime - 1000 * 60));
        System.out.println(ConvertDate.converTime(curTime - 1000 * 60 * 60));
        System.out.println(ConvertDate.converTime(curTime - 1000 * 60 * 60 * 25));
        System.out.println(ConvertDate.converTime(curTime - 1000 * 60 * 60 * 24 * 8));
    }

}