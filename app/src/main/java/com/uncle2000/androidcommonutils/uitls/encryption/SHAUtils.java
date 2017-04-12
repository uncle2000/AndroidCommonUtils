package com.uncle2000.androidcommonutils.uitls.encryption;

import com.uncle2000.androidcommonutils.uitls.unit.GetHex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA1(Secure Hash Algorithm，译作安全散列算法)是Hash算法中的一种，适合用于数字签名数据认证，加密过程不可逆不能进行解密。
 * MD5与SHA1都是Hash算法，MD5输出是128位的，SHA1输出是160位的，SHA256输出是256位，MD5比SHA1快，SHA1比MD5强度高。
 * Created by 2000 on 2017/3/29.
 */

public class SHAUtils {
    /* 将此换成SHA-1、SHA-512、SHA-384等参数*/
    private static final String SHA = "SHA-256";

    private SHAUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }
    /**
     * SHA加密
     *
     * @param strSrc 明文
     * @return 加密之后的密文
     */
    public static String encrypt(String strSrc) {
        MessageDigest md = null;
        String strDes = null;
        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance(SHA);
            md.update(bt);
            strDes = GetHex.bytes2Hex(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }

}
