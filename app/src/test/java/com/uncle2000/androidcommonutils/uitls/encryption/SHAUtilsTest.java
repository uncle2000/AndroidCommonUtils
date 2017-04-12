package com.uncle2000.androidcommonutils.uitls.encryption;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 2000 on 2017/4/12.
 */
public class SHAUtilsTest {
    private String originalText = "1234567890";
    private String encryptingCode;

    @Test
    public void shaEncrypt() throws Exception {
        encryptingCode = SHAUtils.shaEncrypt(originalText);
        System.out.println(encryptingCode);
        Assert.assertNotNull(encryptingCode);
    }

}