package com.uncle2000.androidcommonutils.uitls;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;

import java.util.List;

/**
 * Created by 2000 on 2017/4/10.
 */

public class AdobeUtil {
    /**
     * 安装flash插件
     */
    public static void installAdobe(final Context context) {
        new AlertDialog.Builder(context).setTitle("安装flash插件").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("market://details?id=com.adobe.flashplayer"));
                context.startActivity(intent);
                ((Activity) context).finish();
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        }).show();
    }

    /**
     * 是否安装了flash插件
     *
     * @return
     */
    public static boolean checkAdaboe(Context context) {
        PackageManager pm = context.getPackageManager();
        List<PackageInfo> packages = pm.getInstalledPackages(PackageManager.GET_SERVICES);
        for (PackageInfo pi : packages) {
            if ("com.adobe.flashplayer".equals(pi.packageName)) {
                return true;
            }
        }
        return false;
    }
}