package com.uncle2000.androidcommonutils.uitls.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA1(Secure Hash Algorithm，译作安全散列算法)是Hash算法中的一种，适合用于数字签名数据认证，加密过程不可逆不能进行解密。
 * <p>
 * MD5与SHA1都是Hash算法，MD5输出是128位的，SHA1输出是160位的，SHA256输出是256位，MD5比SHA1快，SHA1比MD5强度高。
 * Created by 2000 on 2017/3/29.
 */

public class SHAUtils {
    /**
     * SHA加密
     *
     * @param strSrc 明文
     * @return 加密之后的密文
     */
    public static String shaEncrypt(String strSrc) {
        MessageDigest md = null;
        String strDes = null;
        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance("SHA-256");// 将此换成SHA-1、SHA-512、SHA-384等参数
            md.update(bt);
            strDes = bytes2Hex(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }

    /**
     * byte数组转换为16进制字符串
     *
     * @param bts 数据源
     * @return 16进制字符串
     */
    private static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
}
