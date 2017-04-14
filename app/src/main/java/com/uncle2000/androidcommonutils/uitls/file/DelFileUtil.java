package com.uncle2000.androidcommonutils.uitls.file;

import com.uncle2000.androidcommonutils.uitls.output.Logger;

import java.io.File;

/**
 * 缺少：删除文件夹下的同级文件，不删除子文件夹的文件 也不删除文件夹
 * Created by 2000 on 2017/4/14.
 */

public class DelFileUtil {

    /**
     * @param str 文件或者文件夹的路径
     * @return
     */
    public void delPath(String str) {
        File file = new File(str);
        synchronized (file) {
            if (file.exists()) {
                if (file.isFile()) {
                    delFile(file);
                } else {
                    delFolder(file);
                }
            }
        }
    }

    public void delFile(File file) {
        synchronized (file) {
            file.delete();
        }
    }

    public void delFolder(File folder) {
        File files[] = folder.listFiles(); // 声明目录下所有的文件 files[];
        for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
            synchronized (files[i]) {
                this.delFile(files[i]); // 把每个文件 用这个方法进行迭代
            }
        }
    }
//
//    // 删除一个目录
//    public boolean deleteFileDir(String path) {
//        boolean flag = false;
//        File file = new File(path);
//        if (!IsExist(path)) {
//            return flag;
//        }
//        if (!file.isDirectory()) {
//
//            file.delete();
//            return true;
//        }
//        String[] filelist = file.list();
//        File temp = null;
//        for (int i = 0; i < filelist.length; i++) {
//            if (path.endsWith(File.separator)) {
//                temp = new File(path + filelist[i]);
//            } else {
//                temp = new File(path + File.separator + filelist[i]);
//            }
//            if (temp.isFile()) {
//
//                temp.delete();
//            }
//            if (temp.isDirectory()) {
//                deleteFileDir(path + "/" + filelist[i]);// 先删除文件夹里面的文件
//            }
//        }
//        file.delete();
//
//        flag = true;
//        return flag;
//    }
//
//    // 删除指定文件夹下所有文件
//    // param path 文件夹完整绝对路径
//    public boolean delAllFile(String path) {
//        boolean flag = false;
//        File file = new File(path);
//        if (!file.exists()) {
//            return flag;
//        }
//        if (!file.isDirectory()) {
//            return flag;
//        }
//        String[] tempList = file.list();
//        File temp = null;
//        for (int i = 0; i < tempList.length; i++) {
//            if (path.endsWith(File.separator)) {
//                temp = new File(path + tempList[i]);
//            } else {
//                temp = new File(path + File.separator + tempList[i]);
//            }
//            if (temp.isFile()) {
//                temp.delete();
//            }
//            if (temp.isDirectory()) {
//                delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
//                delFolder(path + "/" + tempList[i]);// 再删除空文件夹
//                flag = true;
//            }
//        }
//        return flag;
//    }
}
