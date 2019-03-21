package com.qiaohx.encryptutils.md5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5摘要算法
 */
public class MD5Util {

    private final static Logger logger = LoggerFactory.getLogger(MD5Util.class);

    private final static String MD5 = "MD5";

    /**
     * 获取32位大写MD5
     * @param content 待摘要字符串
     * @return MD5大写
     */
    public static String getMD5Upper(String content){
        return getMD5(content).toUpperCase();
    }

    /**
     * 获取32位MD5
     * @param content 待摘要字符串
     * @return MD5小写
     */
    public static String getMD5(String content){
        try {
            MessageDigest md = MessageDigest.getInstance(MD5);
            //对字符串进行加密
            md.update(content.getBytes());
            //获得加密后的数据
            byte[] secretBytes = md.digest();
            StringBuilder md5 = new StringBuilder(new BigInteger(1, secretBytes).toString(16));
            for (int i = 0; i < 32 - md5.length(); i++) {
                md5.insert(0, "0");
            }
            logger.info("MD5：" + md5);
            return md5.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("没有找到MD5摘要算法", e);
        }
        return "";
    }
}
