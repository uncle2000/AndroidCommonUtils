package com.uncle2000.androidcommonutils.uitls.file;

import android.content.Context;
import android.os.Environment;

import java.io.File;

public class PathUtil {

    /*
     * 获取Android的数据目录。
     * > /data
     */
    public static final String SYSTEM_DATA_DIR = Environment.getDataDirectory().getPath();
    /*
     * 获取 Android 下载/缓存内容目录。
     * > /cache
     */
    public static final String SYSTEM_CACHE_DIR = Environment.getDownloadCacheDirectory().getPath();
    /*
     * 获取外部存储目录即 SDCard
     * > /mnt/sdcard
     */
    public static final String SYSTEM_SDCARD_DIR = Environment.getExternalStorageDirectory().getPath();

    public static String appFolderName = "ACutil";//

    /*************************************
     * 初始化常用路径
     *************************************/

    private final String CACHE = "/cache/";
    private final String FILES = "/files/";
    private final String LOG = "/log/";
    private final String APP_ROOT;

    public final String APP_LOG_DIR_PRIVATE;
    public final String APP_CACHE_DIR_PRIVATE;
    public final String APP_FILES_DIR_PRIVATE;
    public final String APP_LOG_DIR;
    public final String APP_CACHE_DIR;
    public final String APP_FILES_DIR;

    private Context context;

    public PathUtil(Context context) {
        if (context == null) throw new NullPointerException("context can not be null");
        this.context = context;
        /*初始化*/
        if (null == appFolderName || appFolderName.length() == 0)
            appFolderName = "/" + context.getPackageName();
        else
            appFolderName = "/" + appFolderName;

        APP_ROOT = SYSTEM_SDCARD_DIR + appFolderName;

        APP_LOG_DIR_PRIVATE = context.getDir("log", Context.MODE_PRIVATE).getPath();
        APP_CACHE_DIR_PRIVATE = context.getCacheDir().getPath();
        APP_FILES_DIR_PRIVATE = context.getFilesDir().getPath();

        APP_LOG_DIR = getLogPath();
        APP_CACHE_DIR = getCachePath();
        APP_FILES_DIR = getFilesPath();

        /*若不存在则创建 适用于老版本*/
        buildPath();
    }

    public String getLogPath() {
        if (isSdCardExitOrCouldWrite()) {
            return APP_ROOT + LOG;
        } else {
            return APP_LOG_DIR_PRIVATE;
        }
    }

    public String getCachePath() {
        if (isSdCardExitOrCouldWrite()) {
            return APP_ROOT + CACHE;
        } else {
            return APP_CACHE_DIR_PRIVATE;
        }
    }

    public String getFilesPath() {
        if (isSdCardExitOrCouldWrite()) {
            return APP_ROOT + FILES;
        } else {
            return APP_FILES_DIR_PRIVATE;
        }
    }

    /*************************************
     * 一些工具类
     *************************************/
    public static boolean isSdCardExitOrCouldWrite() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }


    private void buildPath() {
        /*app私有目录*/
        makeDirs(APP_CACHE_DIR_PRIVATE);
        makeDirs(APP_FILES_DIR_PRIVATE);
        makeDirs(APP_LOG_DIR_PRIVATE);
        /*在外部创建文件夹需要确认是否有权限
        * 6.0以上需要动态权限
        * 否则创建不了*/
        makeDirs(APP_CACHE_DIR);
        makeDirs(APP_FILES_DIR);
        makeDirs(APP_LOG_DIR);
    }

    public void makeDirs(String path) {
        File dir = new File(path);

        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                System.out.println("==>" + "文件夹创建失败原因可能有：" +
                        "1文件夹已存在。2没有权限（动态权限）。3系统定制导致");
            }
        }
    }

}
