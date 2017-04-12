package com.uncle2000.androidcommonutils.uitls.encryption;

import org.junit.Test;

import static com.uncle2000.androidcommonutils.uitls.encryption.Constant.*;
import static org.junit.Assert.*;

/**
 * Created by 2000 on 2017/4/11.
 */
public class MD5UtilsTest {
    /*密文*/
    private String encryptingCode;
    /*循环md5的次数 可以为任意次数*/
    private int times = 5;
    /*加盐 可以为任意值*/
    private String salt = "salt";

    @Test
    public void md5() throws Exception {
        /*加密*/
        encryptingCode = MD5Utils.md5(originalText);
        /*控制台打印*/
        System.out.println(sentence_0 + encryptingCode);
        /*检测不为空*/
        assertNotNull(encryptingCode);
    }

    @Test
    public void md51() throws Exception {
        /*加密*/
        encryptingCode = MD5Utils.md5(originalText, times);
        /*控制台打印*/
        System.out.println(sentence_0 + encryptingCode);
        /*检测不为空*/
        assertNotNull(encryptingCode);
    }

    @Test
    public void md52() throws Exception {
        /*加密*/
        encryptingCode = MD5Utils.md5(originalText, salt);
        /*控制台打印*/
        System.out.println(sentence_0 + encryptingCode);
        /*检测不为空*/
        assertNotNull(encryptingCode);
    }

}