package com.uncle2000.androidcommonutils.uitls;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 2000 on 2017/3/20.
 */

public class DevicesUtils {
//    private static String DEVICEKEY = "";
//    /**
//     * 根据mac地址+deviceid
//     * 获取设备唯一编码
//     * @return
//     */
//    public static String getDeviceKey(Application application)
//    {
//        if ("".equals(DEVICEKEY))
//        {
//            String macAddress = "";
//            WifiManager wifiMgr = (WifiManager)application.getIns().getSystemService(application.WIFI_SERVICE);
//            WifiInfo info = (null == wifiMgr ? null : wifiMgr.getConnectionInfo());
//            if (null != info)
//            {
//                macAddress = info.getMacAddress();
//            }
//            TelephonyManager telephonyManager =
//                    (TelephonyManager)application.getIns().getSystemService(MainApplication.TELEPHONY_SERVICE);
//            String deviceId = telephonyManager.getDeviceId();
//            DEVICEKEY = MD5Util.toMD5("android" + Constant.APPKEY + Constant.APPPWD + macAddress + deviceId);
//        }
//        return DEVICEKEY;
//    }

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
