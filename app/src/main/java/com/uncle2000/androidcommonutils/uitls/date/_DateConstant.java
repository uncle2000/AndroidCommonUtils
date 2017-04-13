package com.uncle2000.androidcommonutils.uitls.date;

import java.text.SimpleDateFormat;

/**
 * 日期的常量类
 * Created by 2000 on 2017/4/13.
 */

class _DateConstant {
    /*基于毫秒*/
    static final long oneSMillis_SM = 1;
    static final long oneMillis_SM = 1000;
    static final long oneScond_SM = 60 * 1000;
    static final long oneHour_SM = 60 * 60 * 1000;
    static final long oneDay_SM = 24 * 60 * 60 * 1000;
    static final long oneWeek_SM = 7 * 24 * 60 * 60 * 1000;

    /*基于秒*/
    static final long oneSMillis_M = 1 / 1000;
    static final long oneMillis_M = 1;
    static final long oneScond_M = 60;
    static final long oneHour_M = 60 * 60;
    static final long oneDay_M = 24 * 60 * 60;
    static final long oneWeek_M = 7 * 24 * 60 * 60;

    static final String dateSeparator = "-";
    static final String timeSeparator = ":";

    static final String dateFormatStr = "yyyy" + dateSeparator + "MM" + dateSeparator + "dd";
    static final String timeFormatStr = "HH" + timeSeparator + "mm" + timeSeparator + "ss";
    static final String FORMAT = dateFormatStr + " " + timeFormatStr;

    static final SimpleDateFormat datetimeFormat = new SimpleDateFormat(FORMAT);
    static final SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
    static final SimpleDateFormat timeFormat = new SimpleDateFormat(timeFormatStr);
}
