package com.uncle2000.androidcommonutils.uitls.encryption;

import org.junit.Test;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import static org.junit.Assert.*;

/**
 * http://www.cnblogs.com/AloneSword/p/3326750.html
 * Created by 2000 on 2017/4/12.
 */
public class RSAUtilsTest {

//    Modulus.length=512
//    Modulus=9584625951826002969061958059847230147495127638156749018285078609508898781632350046419965878918316341657762710171213449476803817539130905377786124498742329
//    PublicExponent.length=17
//    PublicExponent=65537
//            ----------RSAPrivateKey ----------
//    Modulus.length=512
//    Modulus=9584625951826002969061958059847230147495127638156749018285078609508898781632350046419965878918316341657762710171213449476803817539130905377786124498742329
//    PrivateExponent.length=507
//    PrivatecExponent=316918449694171970550334362508032832287439791139137817150979833480412342032697226757353057290078869359640403220231863830726675618325344312612625859901117

    private String sentence_0 = "\n密钥对不该为null";
    private String sentence_1 = "\n密文：";
    private String sentence_2 = "\n原文:";
    private String originalText = "1234567890";
    private String encryptingCode, decryptingCode;
    private String N = "9584625951826002969061958059847230147495127638156749018285078609508898781632350046419965878918316341657762710171213449476803817539130905377786124498742329";
    private String e = "65537";
    private String d = "316918449694171970550334362508032832287439791139137817150979833480412342032697226757353057290078869359640403220231863830726675618325344312612625859901117";

    @Test
    public void generateRSAKeyPair() throws Exception {
        /*获得密钥对*/
        KeyPair testKeyPair = RSAUtils.generateRSAKeyPair();
        RSAUtils.printPublicKeyInfo(testKeyPair.getPublic());
        RSAUtils.printPrivateKeyInfo(testKeyPair.getPrivate());
        /*测试*/
        assertNotNull(sentence_0, testKeyPair);
    }

    @Test
    public void generateRSAKeyPair1() throws Exception {
        /*获得密钥对*/
        KeyPair testKeyPair = RSAUtils.generateRSAKeyPair(512);
        RSAUtils.printPublicKeyInfo(testKeyPair.getPublic());
        RSAUtils.printPrivateKeyInfo(testKeyPair.getPrivate());
        /*测试*/
        assertNotNull(sentence_0, testKeyPair);
    }

    /***************************************
     * 上面是生成keyPair
     * 下面是加密解密
     ***************************************/

    @Test
    public void encryptData() throws Exception {
        /*通过N，e得到公钥*/
        PublicKey publicKey = RSAUtils.getPublicKey(N, e);
        /*通过公钥加密*/
        byte[] b = RSAUtils.encryptData(originalText.getBytes(), publicKey);
        /*控制台打印*/
        System.out.print(sentence_1);
        /*控制台打印密文*/
        for (byte b1 : b) {
            System.out.print(b1);
        }
    }


    @Test
    public void decryptData() throws Exception {
        /*通过N，e得到公钥*/
        PublicKey publicKey = RSAUtils.getPublicKey(N, e);
        /*通过公钥加密*/
        byte[] b = RSAUtils.encryptData(originalText.getBytes(), publicKey);
        /*控制台打印*/
        System.out.print(sentence_1);
        /*控制台打印密文*/
        for (byte b1 : b) {
            System.out.print(b1);
        }
        /*控制台打印*/
        System.out.print("\n");
        /*通过N，d得到私钥*/
        PrivateKey privateKey = RSAUtils.getPrivateKey(N, d);
        /*通过私钥解密*/
        byte[] a = RSAUtils.decryptData(b, privateKey);
        /*控制台打印*/
        System.out.print(sentence_2);
        /*控制台打印解密文*/
        for (byte a1 : a) {
            System.out.print(a1);
        }

        System.out.print("\n" + new String(a));
    }

}