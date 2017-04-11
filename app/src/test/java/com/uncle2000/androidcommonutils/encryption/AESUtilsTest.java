package com.uncle2000.androidcommonutils.encryption;

import com.uncle2000.androidcommonutils.uitls.encryption.AESUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by 2000 on 2017/3/29.
 */
public class AESUtilsTest {
    private String Sentence_0="";
    private String Sentence_1 ="";
    private String masterPassword = "a";
    private String originalText = "0123456789";
    private String encryptingCode, decryptingCode;

    @Test
    public void encrypt() throws Exception {
        encryptingCode = AESUtils.encrypt(masterPassword, originalText);
        assertNotNull("加密后全部为16进制", encryptingCode);
    }

    @Test
    public void decrypt() throws Exception {
        encryptingCode = AESUtils.encrypt(masterPassword, originalText);
        decryptingCode = AESUtils.decrypt(masterPassword, encryptingCode);
        assertEquals("加密再解密之后的结果", originalText, decryptingCode);
    }
}