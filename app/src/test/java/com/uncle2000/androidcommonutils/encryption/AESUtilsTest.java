package com.uncle2000.androidcommonutils.encryption;

import com.uncle2000.androidcommonutils.uitls.encryption.AESUtils;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by 2000 on 2017/3/29.
 */
public class AESUtilsTest {
    private String sentence_0 = "\n加密后为16进制：";
    private String sentence_1 = "\n原文:";
    private String sentence_2 = "\n解密后:";
    private String masterPassword = "a";
    private String originalText = "0123456789";
    private String encryptingCode, decryptingCode;

    @Test
    public void encrypt() throws Exception {
        /*加密*/
        encryptingCode = AESUtils.encrypt(masterPassword, originalText);
        /*测试*/
        assertTrue(sentence_0 + encryptingCode, checkNum(encryptingCode));
    }

    @Test
    public void decrypt() throws Exception {
        /*加密*/
        encryptingCode = AESUtils.encrypt(masterPassword, originalText);
        /*再解密*/
        decryptingCode = AESUtils.decrypt(masterPassword, encryptingCode);
        /*测试*/
        assertEquals(sentence_1 + originalText + sentence_2 + decryptingCode,
                originalText, decryptingCode);
    }

    public static boolean checkNum(String aNumber) {
        String regString = "[a-f0-9A-F]{32}";
        if (Pattern.matches(regString, aNumber)) {
            //匹配成功
            return true;
        }
        return false;
    }
}