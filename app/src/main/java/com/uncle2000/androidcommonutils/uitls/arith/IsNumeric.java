package com.uncle2000.androidcommonutils.uitls.arith;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 2000 on 2017/3/29.
 */

public class IsNumeric {

    /**
     * 判断str是否是正整数
     *
     * @param str
     * @return true 是正整数 false 不是正整数
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 判断str是否是整数
     *
     * @param str
     * @return true 是整数 false 不是整数
     */
    public static boolean isNegativeNumeric(String str) {
        Pattern pattern = Pattern.compile("^-?[0-9]+");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 判断str是否是数字
     *
     * @param str
     * @return true 是数字 false 不是数字
     */
    public static boolean isDecimalNumeric(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]+");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
