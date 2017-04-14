package com.uncle2000.androidcommonutils.uitls.file;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.uncle2000.androidcommonutils.uitls.output.Logger;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 2000 on 2017/3/20.
 */
public class FileUtil {
    private static FileUtil util;

    public static FileUtil init() { // 单例，个人习惯用Init,标准是getInstance
        if (util == null)
            util = new FileUtil();
        return util;
    }

    //?????
    public boolean StateXmlControl(String path) {
        File f = new File(path);
        if (!f.exists())
            return false;
        if (f.length() == 0)
            return false;
        return true;
    }


//    // 把字加长，使其可以滚动，在音乐界面
//    public String dealString(String st, int size) {
//        if (st.length() >= size)
//            return "  " + st + "  ";
//        else {
//            int t = (size - st.length()) / 2;
//            for (int i = 0; i < t; i++) {
//                st = " " + st + "  ";
//            }
//            return st;
//        }
//    }
//
//    // 取前面的名字　"."
//    public String getNameByFlag(String source, String flag) {
//        // String[] source_spli = source.split(flag);
//        String s = source.toLowerCase().replace(flag, "");
//        return s.trim();
//    }

    /**
     * 取Asset文件夹下文件
     *
     * @param paramContext
     * @param paramString
     * @return
     * @throws IOException
     */
    public InputStream getAssetsInputStream(Context paramContext,
                                            String paramString) throws IOException {
        return paramContext.getResources().getAssets().open(paramString);
    }

    //以省内存的方式读取图片
    public Bitmap getBitmap(InputStream is) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        opt.inSampleSize = 4;
        //获取资源图片
        //InputStream is = mContext.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }

    /**
     * 根据后缀得到文件类型
     *
     * @param fileName
     * @param pointIndex
     * @return
     */
    public static String getFileType(String fileName, int pointIndex) {
        String type = fileName.substring(pointIndex + 1).toLowerCase();
        if ("m4a".equalsIgnoreCase(type) || "xmf".equalsIgnoreCase(type) || "ogg".equalsIgnoreCase(type) || "wav".equalsIgnoreCase(type)
                || "m4a".equalsIgnoreCase(type) || "aiff".equalsIgnoreCase(type) || "midi".equalsIgnoreCase(type)
                || "vqf".equalsIgnoreCase(type) || "aac".equalsIgnoreCase(type) || "flac".equalsIgnoreCase(type)
                || "tak".equalsIgnoreCase(type) || "wv".equalsIgnoreCase(type)) {
            type = "ic_file_audio";
        } else if ("mp3".equalsIgnoreCase(type) || "mid".equalsIgnoreCase(type)) {
            type = "ic_file_mp3";
        } else if ("avi".equalsIgnoreCase(type) || "mp4".equalsIgnoreCase(type) || "dvd".equalsIgnoreCase(type)
                || "mid".equalsIgnoreCase(type) || "mov".equalsIgnoreCase(type) || "mkv".equalsIgnoreCase(type)
                || "mp2v".equalsIgnoreCase(type) || "mpe".equalsIgnoreCase(type) || "mpeg".equalsIgnoreCase(type)
                || "mpg".equalsIgnoreCase(type) || "asx".equalsIgnoreCase(type) || "asf".equalsIgnoreCase(type)
                || "flv".equalsIgnoreCase(type) || "navi".equalsIgnoreCase(type) || "divx".equalsIgnoreCase(type)
                || "rm".equalsIgnoreCase(type) || "rmvb".equalsIgnoreCase(type) || "dat".equalsIgnoreCase(type)
                || "mpa".equalsIgnoreCase(type) || "vob".equalsIgnoreCase(type) || "3gp".equalsIgnoreCase(type)
                || "swf".equalsIgnoreCase(type) || "wmv".equalsIgnoreCase(type)) {
            type = "ic_file_video";
        } else if ("bmp".equalsIgnoreCase(type) || "pcx".equalsIgnoreCase(type) || "tiff".equalsIgnoreCase(type)
                || "gif".equalsIgnoreCase(type) || "jpeg".equalsIgnoreCase(type) || "tga".equalsIgnoreCase(type)
                || "exif".equalsIgnoreCase(type) || "fpx".equalsIgnoreCase(type) || "psd".equalsIgnoreCase(type)
                || "cdr".equalsIgnoreCase(type) || "raw".equalsIgnoreCase(type) || "eps".equalsIgnoreCase(type)
                || "gif".equalsIgnoreCase(type) || "jpg".equalsIgnoreCase(type) || "jpeg".equalsIgnoreCase(type)
                || "png".equalsIgnoreCase(type) || "hdri".equalsIgnoreCase(type) || "ai".equalsIgnoreCase(type)) {
            type = "ic_file_image";
        } else if ("ppt".equalsIgnoreCase(type) || "doc".equalsIgnoreCase(type) || "xls".equalsIgnoreCase(type)
                || "pps".equalsIgnoreCase(type) || "xlsx".equalsIgnoreCase(type) || "xlsm".equalsIgnoreCase(type)
                || "pptx".equalsIgnoreCase(type) || "pptm".equalsIgnoreCase(type) || "ppsx".equalsIgnoreCase(type)
                || "maw".equalsIgnoreCase(type) || "mdb".equalsIgnoreCase(type) || "pot".equalsIgnoreCase(type)
                || "msg".equalsIgnoreCase(type) || "oft".equalsIgnoreCase(type) || "xlw".equalsIgnoreCase(type)
                || "wps".equalsIgnoreCase(type) || "rtf".equalsIgnoreCase(type) || "ppsm".equalsIgnoreCase(type)
                || "potx".equalsIgnoreCase(type) || "potm".equalsIgnoreCase(type) || "ppam".equalsIgnoreCase(type)) {
            type = "ic_file_office";
        } else if ("txt".equalsIgnoreCase(type) || "text".equalsIgnoreCase(type) || "chm".equalsIgnoreCase(type)
                || "hlp".equalsIgnoreCase(type) || "pdf".equalsIgnoreCase(type) || "doc".equalsIgnoreCase(type)
                || "docx".equalsIgnoreCase(type) || "docm".equalsIgnoreCase(type) || "dotx".equalsIgnoreCase(type)) {
            type = "ic_file_text";
        } else if ("ini".equalsIgnoreCase(type) || "sys".equalsIgnoreCase(type) || "dll".equalsIgnoreCase(type)
                || "adt".equalsIgnoreCase(type)) {
            type = "ic_file_system";
        } else if ("rar".equalsIgnoreCase(type) || "zip".equalsIgnoreCase(type) || "arj".equalsIgnoreCase(type)
                || "gz".equalsIgnoreCase(type) || "z".equalsIgnoreCase(type) || "7Z".equalsIgnoreCase(type) || "GZ".equalsIgnoreCase(type)
                || "BZ".equalsIgnoreCase(type) || "ZPAQ".equalsIgnoreCase(type)) {
            type = "ic_file_rar";
        } else if ("html".equalsIgnoreCase(type) || "htm".equalsIgnoreCase(type) || "java".equalsIgnoreCase(type)
                || "php".equalsIgnoreCase(type) || "asp".equalsIgnoreCase(type) || "aspx".equalsIgnoreCase(type)
                || "jsp".equalsIgnoreCase(type) || "shtml".equalsIgnoreCase(type) || "xml".equalsIgnoreCase(type)) {
            type = "ic_file_web";
        } else if ("exe".equalsIgnoreCase(type) || "com".equalsIgnoreCase(type) || "bat".equalsIgnoreCase(type)
                || "iso".equalsIgnoreCase(type) || "msi".equalsIgnoreCase(type)) {
            type = "ic_file_exe";
        } else if ("apk".equalsIgnoreCase(type)) {
            type = "ic_file_apk";
        } else {
            type = "ic_file_normal";
        }
        return type;
    }

    /**
     * 转换文件大小
     *
     * @param fileS
     * @return
     */
    public static String FormetFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }

    /**
     * 保存文件到sd
     *
     * @param filename
     * @param content
     * @return
     */
    public static boolean saveContentToSdcard(String filename, String content) {
        boolean flag = false;
        FileOutputStream fos = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory(), filename);
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                fos = new FileOutputStream(file);
                fos.write(content.getBytes());
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
            }
        }
        return flag;
    }

    /**
     * 打开文件的权限
     *
     * @param file
     */
    public void openLimits(File file) {
        synchronized (file) {
            if (!file.exists()) {
                Logger.e("file does not exists");
            }
            String command = "chmod 777 " + file.getAbsolutePath();
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec(command);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }


    @SuppressLint("NewApi")
    public void excuteFile(File file) {
        synchronized (file) {
            if (!file.exists()) {
                Logger.e("file does not exists");
            }
            if (!file.isFile()) {
                Logger.e("file is not a file");
            }
            if (!file.canExecute()) {
                Logger.e("file can not execute");
            }
            //><
        }
    }


    /**
     * 使用文件通道的方式复制文件
     *
     * @param s 源文件
     * @param t 复制到的新文件
     */

    public void fileChannelCopy(File s, File t) {
        synchronized (s) {
            FileInputStream fi = null;
            FileOutputStream fo = null;
            FileChannel in = null;
            FileChannel out = null;
            try {
                fi = new FileInputStream(s);
                fo = new FileOutputStream(t);
                in = fi.getChannel();//得到对应的文件通道
                out = fo.getChannel();//得到对应的文件通道
                in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fi.close();
                    in.close();
                    fo.close();
                    out.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 拷贝文件
     *
     * @param fromFile
     * @param toFile
     * @throws IOException
     */
    public static void copyFile(File fromFile, String toFile) throws IOException {

        FileInputStream from = null;
        FileOutputStream to = null;
        try {
            from = new FileInputStream(fromFile);
            to = new FileOutputStream(toFile);
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = from.read(buffer)) != -1)
                to.write(buffer, 0, bytesRead); // write
        } finally {
            if (from != null)
                try {
                    from.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (to != null)
                try {
                    to.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}