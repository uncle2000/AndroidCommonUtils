package com.uncle2000.androidcommonutils.uitls.encryption;


import org.junit.Test;

import static com.uncle2000.androidcommonutils.uitls.encryption.Constant.originalText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by 2000 on 2017/3/29.
 */
public class DESUtilsTest {
    private String sentence_0 = "加密后";
    private String sentence_1 = "\n原文:";
    private String sentence_2 = "\n解密后:";
    private String masterPassword = "a";
    private String encryptingCode, decryptingCode;

    /**
     * 测试加密
     * 不为空则成功
     *
     * @throws Exception
     */
    @Test
    public void decrypt() throws Exception {
        /*加密*/
        encryptingCode = DESUtils.encrypt(masterPassword, originalText);
        /*测试*/
        assertNotNull(sentence_0, encryptingCode);
    }

    /**
     * 先加密再测试解密
     * 相等则成功
     *
     * @throws Exception
     */
    @Test
    public void encrypt() throws Exception {
        /*加密*/
        encryptingCode = DESUtils.encrypt(masterPassword, originalText);
        /*再解密*/
        decryptingCode = DESUtils.decrypt(masterPassword, encryptingCode);
        /*测试*/
        assertEquals(sentence_1 + originalText + sentence_2 + decryptingCode,
                originalText, decryptingCode);
    }
}