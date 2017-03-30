package com.uncle2000.androidcommonutils.encryption;

import com.uncle2000.androidcommonutils.uitls.encryption.DESUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by 2000 on 2017/3/29.
 */
public class DESUtilsTest {
    private String masterPassword = "a";
    private String originalText = "0123456789";
    private String encryptingCode, decryptingCode;

    @Test
    public void decrypt() throws Exception {
        encryptingCode = DESUtils.encrypt(masterPassword, originalText);
        assertNotNull("加密后", encryptingCode);
    }

    @Test
    public void encrypt() throws Exception {
        encryptingCode = DESUtils.encrypt(masterPassword, originalText);
        decryptingCode = DESUtils.decrypt(masterPassword, encryptingCode);
        assertEquals("加密再解密", originalText, decryptingCode);
    }
}