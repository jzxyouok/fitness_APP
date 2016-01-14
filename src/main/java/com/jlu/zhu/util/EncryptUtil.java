package com.jlu.zhu.util;

import java.security.MessageDigest;

/**
 * EncryptUtil md5加密工具
 *
 * @author <a href="mailto:zz_xiaozhu@163.com">风袭</a>
 * @version V1.0.0
 * @since 2015-06-10
 */
public class EncryptUtil {

    public static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();

    /**
     * md5加密
     *
     * @param s
     * @return
     */
    public static String md5(String s) {
        //16进制字符
        try {
            byte[] bytes = s.getBytes("UTF-8");
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            int j = digest.length;
            char[] md5 = new char[j * 2];
            int k = 0;
            //移位 输出字符串
            for (int i = 0; i < j; i++) {
                byte byte0 = digest[i];
                md5[k++] = HEX_DIGITS[byte0 >>> 4 & 0xf];
                md5[k++] = HEX_DIGITS[byte0 & 0xf];
            }
            return new String(md5);
        } catch (Exception e) {
            return null;
        }
    }
}
