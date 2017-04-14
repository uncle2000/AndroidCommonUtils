package com.uncle2000.androidcommonutils.uitls.file;

import android.content.Context;
import android.os.Environment;

import java.io.File;

public class PathManager {

    /*
     * 获取Android的数据目录。
     * > /data
     */
    public static final String SYSTEM＿DATA_DIR = Environment.getDataDirectory().getPath();
    /*
     * 获取 Android 下载/缓存内容目录。
     * > /cache
     */
    public static final String SYSTEM＿CACHE_DIR = Environment.getDownloadCacheDirectory().getPath();
    /*
     * 获取外部存储目录即 SDCard
     * > /mnt/sdcard
     */
    public static final String SYSTEM＿SDCARD_DIR = Environment.getExternalStorageDirectory().getPath();
    /*
     * 获取 Android 的根目录
     * > /system
     */
    public static final String SYSTEM＿ROOT_DIR = Environment.getRootDirectory().getPath();
    /*
     * 获取外部存储设备的当前状态    注意！这是获取状态！！！不是获取路径
     * http://www.eoeandroid.com/forum.php?mod=viewthread&tid=233569
     */
    public static final String SYSTEM_DIR_STATE = Environment.getExternalStorageState();
    public static String mFolderName = "xxx";//下载升级包的命名><
    public final String APP_CACHE_DIR_PRIVATE;
    public final String APP_FILES_DIR_PRIVATE;
    public final String APP_CACHE_DIR;
    public final String APP_FILES_DIR;
    final String folderName = "/" + mFolderName;
    Context context;

    public PathManager(Context context) {
        /*初始化*/
        this.context = context;
        APP_CACHE_DIR_PRIVATE = context.getCacheDir().getPath();
        APP_FILES_DIR_PRIVATE = context.getFilesDir().getPath();
        APP_CACHE_DIR = getPathCache();
        APP_FILES_DIR = getPathFiles();
        /*若不存在则创建 适用于老版本*/
        buildPath();
    }

    public static boolean isEffective(String path) {
        File file = new File(path);
        return false;
    }

    public static boolean isSdCardExitOrCouldWrite() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public String getmFolderName() {
        return mFolderName;
    }

    public void setmFolderName(String mFolderName) {
        this.mFolderName = mFolderName;
    }

    public String getPathCache() {
        if (isSdCardExitOrCouldWrite()) {
            return SYSTEM＿CACHE_DIR + folderName;
        } else {
            return APP_CACHE_DIR_PRIVATE;
        }
    }

    public String getPathFiles() {
        if (isSdCardExitOrCouldWrite()) {
            return SYSTEM＿SDCARD_DIR + folderName;
        } else {
            return APP_FILES_DIR_PRIVATE;
        }
    }

    public void buildPath() {
        File dir = new File(APP_CACHE_DIR_PRIVATE);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        dir = new File(APP_FILES_DIR_PRIVATE);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        dir = new File(APP_CACHE_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        dir = new File(APP_FILES_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

}
