package com.qiaohx.encryptutils.aes;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AESUtil {

    //初始向量（偏移）
    public static final String DEFAULT_IV = "0000000000000000";   //AES 为16bytes. DES 为8bytes

    /**
     * 密钥算法
     */
    private static final String KEY_ALGORITHM = "AES";

    /**
     * 填充方式
     */
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

    //编码方式
    private static final String CHARSET = "UTF-8";

    //私钥  （密钥）
//    private static final String ASE_KEY="aabbccddeeffgghh";   //AES固定格式为128/192/256 bits.即：16/24/32bytes。DES固定格式为128bits，即8bytes。


    /**
     * 加密
     * @param cleartext
     * @param key
     * @return
     */
    public static String encrypt(String cleartext, String key) throws IllegalBlockSizeException{
        return encrypt(cleartext, key, DEFAULT_IV);
    }

    /**
     * 加密
     * @param cleartext
     * @param key
     * @param iv
     * @return
     */
    public static String encrypt(String cleartext, String key, String iv) throws IllegalBlockSizeException{
        //------------------------------------------AES加密-------------------------------------
        //加密方式： AES128(CBC/PKCS5Padding) + Base64, 私钥：aabbccddeeffgghh
        try {
            iv = iv == null ? DEFAULT_IV : iv;
            IvParameterSpec zeroIv = new IvParameterSpec(iv.getBytes());
            //两个参数，第一个为私钥字节数组， 第二个为加密方式 AES或者DES
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), KEY_ALGORITHM);
            //实例化加密类，参数为加密方式，要写全
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM); //PKCS5Padding比PKCS7Padding效率高，PKCS7Padding可支持IOS加解密
            //初始化，此方法可以采用三种方式，按加密算法要求来添加。（1）无第三个参数（2）第三个参数为SecureRandom random = new SecureRandom();中random对象，随机数。(AES不可采用这种方法)（3）采用此代码中的IVParameterSpec
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, zeroIv);
            //------------------------------------------base64编码-------------------------------------

            //加密操作,返回加密后的字节数组，然后需要编码。主要编解码方式有Base64, HEX, UUE,7bit等等。此处看服务器需要什么编码方式
            //加密后的字节数组
            byte[] encryptedData = cipher.doFinal(cleartext.getBytes(CHARSET));
            //对加密后的字节数组进行base64编码
            byte[] base64Data = Base64.getEncoder().encode(encryptedData);
            //将base64编码后的字节数组转化为字符串并返回
            return new String(base64Data);

            //------------------------------------------/base64编码-------------------------------------

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
        //------------------------------------------/AES加密-------------------------------------
    }

    /**
     * 解密
     * @param encrypted
     * @param key
     * @return
     */
    public static String decrypt(String encrypted, String key) throws IllegalBlockSizeException{
        return decrypt(encrypted, key, DEFAULT_IV);
    }
    /**
     * 解密
     *
     * @param encrypted 解密前的字符串（也就是加密后的字符串）
     * @return 解密后的字符串（也就是加密前的字符串）
     */
    public static String decrypt(String encrypted, String key, String iv) throws IllegalBlockSizeException{
        //---------------------------------------AES解密----------------------------------------
        try {
            iv = iv == null ? DEFAULT_IV : iv;
            //将字符串转化为base64编码的字节数组
            byte[] encryptedBase64Bytes = encrypted.getBytes();
            //将base64编码的字节数组转化为在加密之后的字节数组
            byte[] byteMi = Base64.getDecoder().decode(encryptedBase64Bytes);

            IvParameterSpec zeroIv = new IvParameterSpec(iv.getBytes());
            SecretKeySpec secretKeySpec = new SecretKeySpec(
                    key.getBytes(), KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            //与加密时不同MODE:Cipher.DECRYPT_MODE
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, zeroIv);
            byte[] decryptedData = cipher.doFinal(byteMi);
            return new String(decryptedData, CHARSET);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
        //---------------------------------------/AES解密----------------------------------------
    }

    /**
     * 测试
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {


        String content = "98.5674";
        String iv = "0000000000000000";
        // 加密
        System.out.println("加密前：" + content);
        String encryptResult = encrypt(content, "1234567812345678", iv);

        System.out.println("加密后：" + new String(encryptResult));
        // 解密
        String decryptResult = decrypt(encryptResult, "1234567812345678", iv);
        System.out.println("解密后：" + new String(decryptResult));


    }
}
