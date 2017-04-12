package com.uncle2000.androidcommonutils.uitls.encryption;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 2000 on 2017/4/11.
 */
public class MD5UtilsTest {
    private String sentence_0 = "\n加密后：";
    private String sentence_1 = "\n原文:";
    private String sentence_2 = "\n解密后:";
    private String originalText = "0123456789";
    private String encryptingCode;

    @Test
    public void md5() throws Exception {
        /*加密*/
        encryptingCode = MD5Utils.md5(originalText);
        /*测试*/
        assertNull(sentence_0 + encryptingCode, encryptingCode);
    }

    @Test
    public void md51() throws Exception {
        /*加密*/
        encryptingCode = MD5Utils.md5(originalText, 5);
        /*测试*/
        assertNull(sentence_0 + encryptingCode, encryptingCode);
    }

    @Test
    public void md52() throws Exception {
        /*加密*/
        encryptingCode = MD5Utils.md5(originalText,"salt");
        /*测试*/
        assertNull(sentence_0 + encryptingCode, encryptingCode);
    }

}