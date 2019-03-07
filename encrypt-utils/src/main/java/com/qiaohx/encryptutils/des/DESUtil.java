package com.qiaohx.encryptutils.des;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class DESUtil {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String content = "DESTest";
        // 密码长度必须是8的倍数
        String password = "1234567a";
        System.out.println("密　钥：" + password);
        System.out.println("加密前：" + content);
        byte[] result = encrypt(content, password);
        System.out.println("加密后：" + new String(Base64.getEncoder().encode(result)));
        String decryResult = decrypt(result, password);
        System.out.println("解密后：" + decryResult);
    }

    /**
     * 加密
     *
     * @param content 待加密内容
     * @param key     加密的密钥
     * @return
     */
    public static byte[] encrypt(String content, String key) {
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, getSecureKey(key),  new SecureRandom());
            byte[] result = cipher.doFinal(content.getBytes());
            return result;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     *
     * @param content 待解密内容
     * @param key     解密的密钥
     * @return
     */
    public static String decrypt(byte[] content, String key) {
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, getSecureKey(key), new SecureRandom());
            byte[] result = cipher.doFinal(content);
            return new String(result);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    private static SecretKey getSecureKey(String key){
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            return keyFactory.generateSecret(desKey);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

}
