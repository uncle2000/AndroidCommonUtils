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
        if (!folder.exists())
            return;
        String paths[] = folder.list(); // 声明目录下所有的文件 files[];
        File tmpFile = null;
        for (int i = 0; i < paths.length; i++) { // 遍历目录下所有的文件
            if (paths[i].endsWith(File.separator)) {
                tmpFile = new File(folder + paths[i]);
            } else {
                tmpFile = new File(folder + File.separator + paths[i]);
            }
            if (tmpFile.isFile()) {
                delFile(tmpFile);
            }
            if (tmpFile.isDirectory()) {
                delFolder(tmpFile);
            }
        }
    }
}
