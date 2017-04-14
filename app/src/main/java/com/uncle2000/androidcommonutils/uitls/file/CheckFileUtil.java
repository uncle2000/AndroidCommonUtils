package com.uncle2000.androidcommonutils.uitls.file;

import android.annotation.SuppressLint;

import com.uncle2000.androidcommonutils.uitls.output.Logger;

import java.io.File;

/**
 * Created by 2000 on 2017/4/14.
 */

public class CheckFileUtil {

    /**
     * 判断uri
     */
    /**
     * 判断File
     */
    /**
     * 判断url
     */
    /**
     * 判断SD卡上的文件是否存在
     */
    public static boolean isFileExist(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    /**
     * 检查文件的常用信息 一般突然出现了问题用得到
     *
     * @param it
     */
    @SuppressLint("NewApi")
    public void checkFile(File it) {
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
