package com.uncle2000.androidcommonutils.uitls.equipment;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

import com.uncle2000.androidcommonutils.uitls._Constant;
import com.uncle2000.androidcommonutils.uitls.encryption.MD5Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * http://blog.csdn.net/ljz2009y/article/details/22895297
 * http://www.cnblogs.com/lvcha/p/3721091.html
 *
 * Created by 2000 on 2017/3/20.
 */

public class DevicesUtils {
    private static String DEVICEKEY = "";

    /**
     * 获取手机及SIM卡相关信息
     *
     * @param context
     * @return
     */
    public static Map getPhoneInfo(Context context) {
        Map map = new HashMap();
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String imei = tm.getDeviceId();
        String imsi = tm.getSubscriberId();
        String phoneMode = android.os.Build.MODEL;
        String phoneSDk = android.os.Build.VERSION.RELEASE;
        map.put("imei", imei);
        map.put("imsi", imsi);
        map.put("phoneMode", phoneMode + "##" + phoneSDk);
        map.put("model", phoneMode);
        map.put("sdk", phoneSDk);
        return map;
    }
}
