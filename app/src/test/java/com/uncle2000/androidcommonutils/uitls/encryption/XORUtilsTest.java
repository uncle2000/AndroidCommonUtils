package com.uncle2000.androidcommonutils.uitls.encryption;

import junit.framework.Assert;

import org.hamcrest.core.StringContains;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 2000 on 2017/4/12.
 */
public class XORUtilsTest {
    private String sentence_0 = "\n密文：";
    private String sentence_1 = "\n解密后:";
    /*密文，解密文*/
    private byte[] encryptingCode, decryptingCode;

    @Test
    public void encrypt1() throws Exception {
        /*加密*/
        encryptingCode = XORUtils.encrypt1(Constant.originalText.getBytes());
        /*控制台打印*/
        System.out.println(sentence_0 + new String(encryptingCode));
        /*检测不为空*/
        Assert.assertNotNull(encryptingCode);
        /*检测密文与原文是否相等，true则未加密，false则已加密。期望false*/
        Assert.assertFalse(Constant.originalText.endsWith(new String(encryptingCode)));
        /*解密*/
        decryptingCode = XORUtils.encrypt1(encryptingCode);
        /*控制台打印*/
        System.out.println(sentence_1 + new String(decryptingCode));
        /*检测不为空*/
        Assert.assertNotNull(decryptingCode);
        /*检测解密文和原文是否相同，期望相同*/
        Assert.assertEquals(new String(decryptingCode), Constant.originalText);
    }

    @Test
    public void encrypt2() throws Exception {
        /*加密*/
        encryptingCode = XORUtils.encrypt2(Constant.originalText.getBytes());
        /*控制台打印*/
        System.out.println(sentence_0 + new String(encryptingCode));
        /*检测不为空*/
        Assert.assertNotNull(encryptingCode);
        /*检测密文与原文是否相等，true则未加密，false则已加密。期望false*/
        Assert.assertFalse(Constant.originalText.endsWith(new String(encryptingCode)));
    }

    @Test
    public void decrypt2() throws Exception {
        /*加密*/
        encryptingCode = XORUtils.encrypt2(Constant.originalText.getBytes());
        /*控制台打印*/
        System.out.println(sentence_0 + new String(encryptingCode));
        /*检测不为空*/
        Assert.assertNotNull(encryptingCode);
        /*检测密文与原文是否相等，true则未加密，false则已加密。*/
        Assert.assertFalse(Constant.originalText.endsWith(new String(encryptingCode)));
        /*解密*/
        decryptingCode = XORUtils.decrypt2(encryptingCode);
        /*控制台打印*/
        System.out.println(sentence_1 + new String(decryptingCode));
        /*检测不为空*/
        Assert.assertNotNull(decryptingCode);
        /*检测解密文和原文是否相同，期望相同*/
        Assert.assertEquals(new String(decryptingCode), Constant.originalText);
    }

}