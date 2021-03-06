package com.uncle2000.androidcommonutils.uitls.system;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * Created by 2000 on 2017/4/10.
 */

public class ServiceUtils {

    /**
     * 用来判断服务是否运行.
     *
     * @param context
     * @param className
     *            判断的服务名字
     * @return true 在运行 false 不在运行
     */
    public static boolean isServiceRunning(Context mContext, String className) {
        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(30);
        if (!(serviceList.size() > 0)) {
            return false;
        }
        for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).service.getClassName().equals(className)) {
                isRunning = true;
                break;
            }
        }
        return isRunning;
    }
}