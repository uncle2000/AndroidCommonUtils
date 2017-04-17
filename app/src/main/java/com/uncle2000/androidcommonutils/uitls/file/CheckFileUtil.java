package com.uncle2000.androidcommonutils.uitls.file;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Environment;

import com.uncle2000.androidcommonutils.uitls.output.Logger;

import java.io.File;

/**
 * Created by 2000 on 2017/4/14.
 */

public class CheckFileUtil {

    /**
     * 判断str是不是一个有效的文件路径 文件（或者文件夹）可以不存在
     *
     * @param str
     * @return
     */
    @Deprecated
    public boolean ifStrIsPath(String str) {
//        if (str == null) {
//            return false;
//        }
//        String tempStr = str.trim();
//        tempStr = tempStr.replace("//", "/");
//        tempStr = tempStr.replace("\\\\", "/");
//        tempStr = tempStr.replace("\\", "/");
//        String[] prefixs = new String[]{
//                Environment.getExternalStorageDirectory().getPath(),
//                Environment.getDownloadCacheDirectory().getPath(),
//                Environment.getDataDirectory().getPath(),
//                Environment.getRootDirectory().getPath()};
//        /*完整路径*/
//        boolean isPrefix = false;
//        for (String prefix : prefixs) {
//            if (tempStr.startsWith(prefix)) {
//                isPrefix = true;
//            }
//        }
//        /*路径的一部分*/
//        if (str.indexOf('\u0000') < 0)
//            return true;

        return false;
    }


    /**
     * 判断path的路径下的文件或者文件夹是否存在
     *
     * @param path
     * @return
     */
    public boolean checkPathExists(String path) {
        if (path == null || path.length() <= 0) {
            return false;
        }
        File file = new File(path);
        return checkFile(file);
    }

    /**
     * 判断uri对应的文件是否存在
     *
     * @param uri
     * @return
     */
    public boolean checkUri(Uri uri) {
        if (null != uri) {
            return checkPathExists(uri.getPath());
        }
        return false;
    }

    /**
     * 判断File 是否存在
     */
    public boolean checkFile(File file) {
        if (null != file && file.exists()) {
            return true;
        }
        return false;
    }

    /**
     * 检查文件的常用信息 一般突然出现了问题用得到，尤其是在某个系统下可以，某个系统下不行的时候
     *
     * @param it
     */
    @SuppressLint("NewApi")
    public void printFileLog(File it) {
        synchronized (it) {
            if (it.exists())
                Logger.v("it exists");
            else
                Logger.e("it does not exists");
            if (it.isFile())
                Logger.v("it is a file");
            else
                Logger.e("it is not a file");
            if (it.isDirectory())
                Logger.v("it is a directory");
            else
                Logger.e("it is not a directory");
            if (it.canExecute())
                Logger.v("it can execute");
            else
                Logger.e("it can not execute");
            if (it.canRead())
                Logger.v("it can read");
            else
                Logger.e("it can not read");
            if (it.canWrite())
                Logger.v("it can write");
            else
                Logger.e("it can not write");
            Logger.v("path:" + it.getAbsolutePath());
            Logger.v("name:" + it.getName());
            Logger.v("length:" + it.length());
        }
    }

}
