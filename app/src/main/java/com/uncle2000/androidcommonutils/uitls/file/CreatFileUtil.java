package com.uncle2000.androidcommonutils.uitls.file;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.File;
import java.io.IOException;

/**
 * Created by 2000 on 2017/4/14.
 */

public class CreatFileUtil {

    /**
     * 创建文件
     * 缺少判断“缺失路径”是否是在app下创建的路径
     *
     * @param context app内创建文件时候才用
     * @param str     文件名 不可以为空
     * @param del     是否删了重建
     * @return 返回创建成功的文件 如果为null则创建失败
     */
    public static File createFile(Context context, @NonNull String str, boolean del) {
        File file = null;
        /*1 建立索引*/
        if (!str.contains("/")) {
            if (context == null) {
                /*在app内创建文件时 context不可以为null*/
                return null;
            }
            /*如果是文件名而不是路径，则默认创建文件到app自己的根目录下*/
            file = context.getFileStreamPath(str);
        } else {
            file = new File(str);
        }
        /*2 如果是文件而不是路径*/
        if (file.isFile()) {
            /*3 是否删掉重建*/
            if (del && file.exists()) {
                synchronized (file) {//???这里是否适合加同步锁？
                    if (!file.delete()) {
                        /*删除失败就写入空*/
                        //TODO
                    }
                }
            }
            /*4 不存在则重建*/
            if (!file.exists()) {
                try {
                    if (new File(str.substring(0, str.lastIndexOf(File.separator))).mkdirs()) {
                        if (file.createNewFile()) {
                            return file;
                        } else {
                            /*创建失败*/
                            return null;
                        }
                    } else {
                        /*路径创建失败，有些手机必须要创建路径才能创建文件*/
                        return null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    /*创建失败*/
                    return null;
                }
            }
        } else {
            if (file.exists() || file.mkdirs()) {
                return file;
            } else {
                /*路径创建失败*/
                return null;
            }
        }
        return file;
    }


}
