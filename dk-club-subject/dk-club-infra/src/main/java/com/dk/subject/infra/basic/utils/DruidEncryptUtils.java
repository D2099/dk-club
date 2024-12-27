package com.dk.subject.infra.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * druid加密工具类
 * @author 23247
 */
public class DruidEncryptUtils {

    private static String privateKey;

    private static String publicKey;

    /**
     * 初始化生成公钥和私钥
     */
    static {
        try {
            String[] genKeyPair = ConfigTools.genKeyPair(512);
            privateKey = genKeyPair[0];
            System.out.println("privateKey:" + privateKey);
            publicKey = genKeyPair[1];
            System.out.println("publicKey:" + publicKey);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 加密
     * @param plainText 加密文本
     * @return
     */
    public static String encrypt(String plainText) throws Exception {
        String encrypt = ConfigTools.encrypt(privateKey, plainText);
        return encrypt;
    }

    /**
     * 解密
     * @param plainText 解密文本
     * @return
     */
    public static String decrypt(String plainText) throws Exception {
        String decrypt = ConfigTools.decrypt(publicKey, plainText);
        return decrypt;
    }

    public static void main(String[] args) throws Exception {
        String encrypt = encrypt("P$gJX&FU8kBDT%ux6Ucw");
        System.out.println("encrypt:" + encrypt);
        String decrypt = decrypt(encrypt);
        System.out.println("decrypt:" + decrypt);
    }
}
