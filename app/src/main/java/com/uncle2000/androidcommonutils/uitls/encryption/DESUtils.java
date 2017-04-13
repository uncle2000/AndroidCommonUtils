package com.uncle2000.androidcommonutils.uitls.encryption;


import com.uncle2000.androidcommonutils.uitls.compress.GZip2Utils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * Created by 2000 on 2017/3/29.
 */

@Deprecated
public class DESUtils {
    private final static String DES = "DES";
    public final static String PASSWORD_CRYPT_KEY = "_mapp_hz_server_";

    public DESUtils() {
//        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    /**
     * 加密
     *
     * @param src 数据源
     * @param key 密钥，长度必须是8的倍数
     * @return 返回加密后的数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] src, byte[] key) throws Exception {
        //产生一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成
        // 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS7Padding", "BC");
        // Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        // Cipher cipher = Cipher.getInstance("DES/CBC/NoPadding");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);//encrypt_mode
        // 现在，获取数据并加密
        // 正式执行加密操作
        return cipher.doFinal(src);
    }

    /**
     * 解密
     *
     * @param src 数据源
     * @param key 密钥，长度必须是8的倍数
     * @return 返回解密后的原始数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, byte[] key) throws Exception {
        //产生一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密匙数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成
        // 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS7Padding", "BC");
        // Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        // Cipher cipher = Cipher.getInstance("DES/CBC/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);//decrypt_mode
        // 现在，获取数据并解密
        // 正式执行解密操作
        return cipher.doFinal(src);
    }

    /**
     * 密码解密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public final static String decrypt(String hex, String pwd) {
        try {
            String data = new String(decrypt(
                    hex2byte(GZip2Utils.decompress(decryptBASE64(hex))),
                    pwd.getBytes()), "UTF-8");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 密码加密
     *
     * @param password
     * @return
     * @throws Exception
     */
    public final static String encrypt(String data, String pwd) {
        try {
            String hex = byte2hex(encrypt(data.getBytes("UTF-8"), pwd.getBytes()));
            hex = encryptBASE64(GZip2Utils.compress(hex.getBytes("UTF-8")));
            return hex;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Base64.encodeToString(m, Base64.NO_WRAP)

    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return android.util.Base64.decode(key, android.util.Base64.NO_WRAP);
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return android.util.Base64.encodeToString(key,
                android.util.Base64.NO_WRAP);
    }

    /**
     * 二行制转字符串
     *
     * @param b
     * @return
     */

    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));//变为十六进制的字符串
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;

        }
        return hs.toUpperCase();
    }

    // 将byte数组进行处理生产新的的byte数组
    public static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException("长度不是偶数");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);//将字符串变为十六进制数。
        }
        return b2;
    }

    public static void main(String[] args) throws Exception {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encryptNoDes(String jsonStr, String passwordCryptKey) {
        String str = "";
        try {
            str = encryptBASE64(GZip2Utils.compress(jsonStr.getBytes("UTF-8")));
        } catch (Exception e) {
        }
        return str;
    }

    public final static String decryptNoDes(String str, String pwd) {
        String data = "";
        try {
            data = new String(GZip2Utils.decompress(decryptBASE64(str)), "UTF-8");
        } catch (Exception e) {
        }
        return data;
    }
}
