package com.uncle2000.androidcommonutils.uitls.encryption;

import android.util.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by 2000 on 2017/3/30.
 */

public class BASE64Utils {

    private BASE64Utils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 字符串进行Base64编码
     *
     * @param key
     * @return
     */
    public static String encrypt(String key) {
        return Base64.encodeToString(key.getBytes(), Base64.DEFAULT);
    }

    /**
     * 字符串进行Base64解码
     *
     * @param encodedString
     * @return
     */
    public static String decrypt(String encodedString) {
        return new String(Base64.decode(encodedString, Base64.DEFAULT));
    }

    /**
     * 对文件进行Base64编码
     *
     * @param path
     * @return
     */
    public static String encryptFile(String path) {
        String encodedString = null;
        File file = new File(path);
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            inputFile.read(buffer);
            inputFile.close();
            encodedString = Base64.encodeToString(buffer, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encodedString;
    }


    /**
     * 对文件进行Base64解码
     *
     * @param encodedString
     * @return
     */
    public static File decryptFile(String path, String encodedString) {
        File desFile = new File(path);
        FileOutputStream fos = null;
        try {
            byte[] decodeBytes = Base64.decode(encodedString.getBytes(), Base64.DEFAULT);
            fos = new FileOutputStream(desFile);
            fos.write(decodeBytes);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return desFile;
    }
}
