package com.uncle2000.androidcommonutils.uitls.encryption;

/**
 * Created by 2000 on 2017/3/30.
 */

public class XORUtils {


    private XORUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }
    /**
     * 固定key的方式
     *
     * @param bytes
     * @return
     */
    public static byte[] encrypt1(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        int len = bytes.length;
        int key = 0x12;
        for (int i = 0; i < len; i++) {
            bytes[i] ^= key;
        }
        return bytes;
    }

    /**
     * 不固定key的方式
     *
     * @param bytes
     * @return
     */
    public static byte[] encrypt2(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        int len = bytes.length;
        int key = 0x12;
        for (int i = 0; i < len; i++) {
            bytes[i] = (byte) (bytes[i] ^ key);
            key = bytes[i];//这里key不断的被赋值，所以每次取反时key都不一样
        }
        return bytes;
    }

    /**
     * 解密
     *
     * @param bytes
     * @return
     */
    public static byte[] decrypt2(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        int len = bytes.length;
        int key = 0x12;
        for (int i = len - 1; i > 0; i--) {
            bytes[i] = (byte) (bytes[i] ^ bytes[i - 1]);
        }
        bytes[0] = (byte) (bytes[0] ^ key);
        return bytes;
    }

}
