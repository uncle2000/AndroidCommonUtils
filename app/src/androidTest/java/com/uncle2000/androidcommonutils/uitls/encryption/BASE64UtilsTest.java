package com.uncle2000.androidcommonutils.uitls.encryption;

import org.junit.Test;

import static com.uncle2000.androidcommonutils.uitls.encryption.AndroidTestConstant.originalText;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

/**
 * Created by 2000 on 2017/4/12.
 */
public class BASE64UtilsTest {
    private String encryptingCode, decryptingCode;

    @Test
    public void encrypt() throws Exception {
        /*加密*/
        encryptingCode = BASE64Utils.encrypt(originalText);
        /*控制台打印 注意：输出在Android Monitor内*/
        System.out.println(encryptingCode);
        /*测试*/
        assertNotNull(encryptingCode);
    }

    @Test
    public void decrypt() throws Exception {
        /*加密*/
        encryptingCode = BASE64Utils.encrypt(originalText);
        /*控制台打印 注意：输出在Android Monitor内*/
        System.out.println(encryptingCode);
        /*测试*/
        assertNotNull(encryptingCode);
        /*解密*/
        decryptingCode = BASE64Utils.decrypt(encryptingCode);
        /*控制台打印 注意：输出在Android Monitor内*/
        System.out.println(decryptingCode);
        /*测试*/
        assertNotNull(decryptingCode);
        /*测试解密是否与原文相同，期望相同*/
        assertEquals(decryptingCode, originalText);
    }

}