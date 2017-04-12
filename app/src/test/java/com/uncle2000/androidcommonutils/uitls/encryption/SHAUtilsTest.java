package com.uncle2000.androidcommonutils.uitls.encryption;

import junit.framework.Assert;

import org.junit.Test;

import static com.uncle2000.androidcommonutils.uitls.encryption.Constant.originalText;
import static com.uncle2000.androidcommonutils.uitls.encryption.Constant.sentence_0;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

/**
 * SHA的单元测试
 * Created by 2000 on 2017/4/12.
 */
public class SHAUtilsTest
{
    /*密文*/
    private String encryptingCode;

    @Test
    public void shaEncrypt() throws Exception {
        /*加密*/
        encryptingCode = SHAUtils.encrypt(originalText);
        /*控制台打印*/
        System.out.println(sentence_0 + encryptingCode);
        /*检测不为空*/
        assertNotNull(encryptingCode);
        /*检测密文与原文是否相等，true则未加密，false则已加密。期望false*/
        assertFalse(originalText.endsWith(encryptingCode));
    }

}