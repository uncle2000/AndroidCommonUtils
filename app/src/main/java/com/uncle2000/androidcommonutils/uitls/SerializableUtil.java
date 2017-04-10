package com.uncle2000.androidcommonutils.uitls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by 2000 on 2017/4/10.
 */

public class SerializableUtil {

    //把序列化的类写到sdcard文件里
    public static <T extends Serializable> void write(T t, String outPath) throws Exception {
        ObjectOutputStream oos = null;
        try {
            File file = new File(outPath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(t);
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }

    /**
     * 把文件转化成序列化的类
     *
     * @param path
     * @return
     * @throws Exception
     */
    public static Serializable read(String path) throws Exception {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            Object object = ois.readObject();

            if (object != null) {
                return (Serializable) object;
            }
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
        return null;
    }
}
