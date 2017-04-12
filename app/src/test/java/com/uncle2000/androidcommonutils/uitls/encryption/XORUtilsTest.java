package com.uncle2000.androidcommonutils.uitls.encryption;

import junit.framework.Assert;

import org.hamcrest.core.StringContains;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 2000 on 2017/4/12.
 */
public class XORUtilsTest {
    private String originalText = "1234567890";
    private byte[] encryptingCode, decryptingCode;

    @Test
    public void encrypt1() throws Exception {
        encryptingCode = XORUtils.encrypt1(originalText.getBytes());
        System.out.println(new String(encryptingCode));
        Assert.assertNotNull(encryptingCode);
        decryptingCode = XORUtils.encrypt1(encryptingCode);
        System.out.println(new String(decryptingCode));
        Assert.assertNotNull(decryptingCode);
        Assert.assertEquals(new String(decryptingCode), originalText);
    }

//    @Test
//    public void encrypt2() throws Exception {
//        encryptingCode = XORUtils.encrypt2(originalText.getBytes());
//        System.out.println(new String(encryptingCode));
//        Assert.assertNotNull(encryptingCode);
//    }

//    @Test
//    public void decrypt2() throws Exception {
//        encryptingCode = XORUtils.encrypt2(originalText.getBytes());
//        System.out.println(new String(encryptingCode));
//        Assert.assertNotNull(encryptingCode);
//        decryptingCode = XORUtils.decrypt2(encryptingCode);
//        System.out.println(new String(decryptingCode));
//        Assert.assertNotNull(decryptingCode);
//        Assert.assertEquals(new String(decryptingCode), originalText);
//    }

}