package com.uncle2000.androidcommonutils.uitls.file;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.uncle2000.androidcommonutils.uitls.output.Logger;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 2000 on 2017/4/14.
 */

public class GetFileUtil {

    /**
     * 从sd卡取文件 以字符串的形式返回
     *
     * @param filename
     * @return
     */
    public String getFileFromSdcard(String filename) {
        ByteArrayOutputStream outputStream = null;
        FileInputStream fis = null;
        try {
            outputStream = new ByteArrayOutputStream();
            File file = new File(filename);
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                fis = new FileInputStream(file);
                int len = 0;
                byte[] data = new byte[1024];
                while ((len = fis.read(data)) != -1) {
                    outputStream.write(data, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                fis.close();
            } catch (IOException e) {
            }
        }
        return new String(outputStream.toByteArray());
    }


    /**
     * 递归求取目录文件个数
     *
     * @param f
     * @return
     */
    public static long getlist(File f) {
        long size = 0;
        File flist[] = f.listFiles();
        size = flist.length;
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getlist(flist[i]);
                size--;
            }
        }
        return size;
    }

    /**
     * 递归取得文件夹大小
     *
     * @param dir
     * @return
     * @throws Exception
     */
    public static long getFileSize(File dir) throws Exception {
        long size = 0;
        File flist[] = dir.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getFileSize(flist[i]);
            } else {
                size = size + flist[i].length();
            }
        }
        return size;
    }


    /**
     * searchFile 查找文件并加入到ArrayList 当中去
     *
     * @param context
     * @param keyword
     * @param filepath
     * @return
     */
    public static List<Map<String, Object>> searchFile(Context context, String keyword, File filepath) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> rowItem = null;
        int index = 0;

        // 判断SD卡是否存在
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File[] files = filepath.listFiles();

            if (files.length > 0) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        if (file.getName().toLowerCase().lastIndexOf(keyword) > -1) {
                            rowItem = new HashMap<String, Object>();
                            rowItem.put("number", index); // 加入序列号
                            rowItem.put("fileName", file.getName());// 加入名称
                            rowItem.put("path", file.getPath()); // 加入路径
                            rowItem.put("size", file.length() + ""); // 加入文件大小
                            list.add(rowItem);
                        }
                        // 如果目录可读就执行（一定要加，不然会挂掉）
                        if (file.canRead()) {
                            list.addAll(searchFile(context, keyword, file)); // 如果是目录，递归查找
                        }
                    } else {
                        // 判断是文件，则进行文件名判断
                        try {
                            if (file.getName().indexOf(keyword) > -1 || file.getName().indexOf(keyword.toUpperCase()) > -1) {
                                rowItem = new HashMap<String, Object>();
                                rowItem.put("number", index); // 加入序列号
                                rowItem.put("fileName", file.getName());// 加入名称
                                rowItem.put("path", file.getPath()); // 加入路径
                                rowItem.put("size", file.length() + ""); // 加入文件大小
                                list.add(rowItem);
                                index++;
                            }
                        } catch (Exception e) {
                            Toast.makeText(context, "查找发生错误!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        }
        return list;
    }

    /**
     * 得到所有文件
     *
     * @param dir
     * @return
     */
    public static ArrayList<File> getAllFiles(File dir) {
        ArrayList<File> allFiles = new ArrayList<File>();
        // 递归取得目录下的所有文件及文件夹
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            allFiles.add(file);
            if (file.isDirectory()) {
                getAllFiles(file);
            }
        }
        return allFiles;
    }


    public String[] getFlieName(String rootpath) {
        File root = new File(rootpath);
        File[] filesOrDirs = root.listFiles();
        if (filesOrDirs != null) {
            String[] dir = new String[filesOrDirs.length];
            int num = 0;
            for (int i = 0; i < filesOrDirs.length; i++) {
                if (filesOrDirs[i].isDirectory()) {
                    dir[i] = filesOrDirs[i].getName();
                    num++;
                }
            }
            String[] dir_r = new String[num];
            num = 0;
            for (int i = 0; i < dir.length; i++) {
                if (dir[i] != null && !dir[i].equals("")) {
                    dir_r[num] = dir[i];
                    num++;
                }
            }
            return dir_r;
        } else
            return null;
    }

    /**
     * //获得流
     *
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public BufferedWriter getWriter(String path) throws FileNotFoundException,
            UnsupportedEncodingException {
        FileOutputStream fileout = null;
        fileout = new FileOutputStream(new File(path));
        OutputStreamWriter writer = null;
        writer = new OutputStreamWriter(fileout, "UTF-8");
        BufferedWriter w = new BufferedWriter(writer); // 缓冲区
        return w;
    }

//    public File getAlbumStorageDir(String albumName) {
//        // Get the directory for the user's public pictures directory.
//        File file = new File(Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES), albumName);
//        if (!file.mkdirs()) {
//            Log.e("(:з」∠)", "Directory not created");
//        }
//        return file;
//    }


    /**
     * 搜索sdcard文件
     *
     * @param file 需要进行文件搜索的目录
     * @param ext  过滤搜索文件类型
     * @return 以ext结尾的文件列表
     */
    public static List<String> search(File file, String[] ext) {
        List<String> list = new ArrayList<String>();
        if (file != null) {
            if (file.isDirectory()) {
                File[] listFile = file.listFiles();
                if (listFile != null) {
                    for (int i = 0; i < listFile.length; i++) {
                        search(listFile[i], ext);
                    }
                }
            } else {
                String filename = file.getAbsolutePath();
                for (int i = 0; i < ext.length; i++) {
                    if (filename.endsWith(ext[i])) {
                        list.add(filename);
                        break;
                    }
                }
            }
        }
        return list;
    }


    /**
     * 查询文件
     *
     * @param file    被搜索的文件或者文件夹
     * @param keyword 搜索关键字
     * @return 包含keyword的文件列表
     */
    public static List<File> FindFile(File file, String keyword) {
        List<File> list = new ArrayList<File>();
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File tempf : files) {
                    if (tempf.isDirectory()) {
                        if (tempf.getName().toLowerCase().lastIndexOf(keyword) > -1) {
                            list.add(tempf);
                        }
                        list.addAll(FindFile(tempf, keyword));
                    } else {
                        if (tempf.getName().toLowerCase().lastIndexOf(keyword) > -1) {
                            list.add(tempf);
                        }
                    }
                }
            }
        }
        return list;
    }


}
