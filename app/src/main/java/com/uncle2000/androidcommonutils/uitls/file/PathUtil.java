package com.uncle2000.androidcommonutils.uitls.file;

import android.os.Environment;

import java.io.File;

/**
 * Created by 2000 on 2017/4/10.
 */

public class PathUtil {
    private static final String CACHE = "cache/";
    private static final String ICON = "icon/";
    private static final String ROOT = "kooshop/";

    /**
     * 获得文件目录
     *
     * @param str
     * @return
     */
    public static File getDir(String str) {
        StringBuilder sb = new StringBuilder();
        if (isSDCardAvailable()) {
            sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
            sb.append(File.separator);
            sb.append(ROOT);
            sb.append(str);
        } else {
            File cache = new File("");//Util.getContext().getCacheDir();//><
            sb.append(cache.getAbsolutePath());
            sb.append(File.separator);
            sb.append(str);
        }

        File dir = new File(sb.toString());
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdirs();
        }
        return dir;
    }

    /**
     * 获得缓存目录
     *
     * @return
     */
    public static File getCacheDir() {
        return getDir(CACHE);
    }

    /**
     * 获得实际图片位置
     *
     * @return
     */
    public static File getIconDir() {
        return getDir(ICON);
    }

    /**
     * 判断sd卡是否可用
     *
     * @return
     */
    private static boolean isSDCardAvailable() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return true;
        }
        return false;
    }
}
