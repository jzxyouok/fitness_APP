package com.jlu.zhu.util;

import java.util.Random;

/**
 * 随机值工具类
 *
 * @author <a href="mailto:zz_xiaozhu@163.com">风袭</a>
 * @version V1.0.0
 * @since 2015/6/8
 */
public class RandomUtil {
    private static final Random RANDOM = new Random();
    private static final char[] NUMBERS = "0123456789".toCharArray();
    private static final char[] LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] NUMBERS_AND_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] DELIMITER = ",.!?:;、。，！·：\n\t\r".toCharArray();

    /**
     * 产生length位的随机字符串 仅有数字和大小写字母
     *
     * @param length 字符长度
     * @return
     */
    public static String randomStr(int length) {
        if (length < 1) {
            return null;
        }

        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = NUMBERS_AND_LETTERS[RANDOM.nextInt(72)];
        }

        return new String(randBuffer);
    }

    /**
     * 产生length长度的字母字符，仅大小写字母
     *
     * @param length 字符长度
     * @return
     */
    public static String randomLetter(int length) {
        if (length < 1) {
            return null;
        }

        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = LETTERS[RANDOM.nextInt(51)];
        }

        return new String(randBuffer);
    }

    /**
     * 产生length位的随机数字，仅数字
     *
     * @param length
     * @return
     */
    public static String randomNum(int length) {
        if (length < 1) {
            return null;
        }

        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = NUMBERS[RANDOM.nextInt(10)];
            if (i == 0) {
                if (randBuffer[i] == '0') {
                    i--;
                }
            }
        }

        return new String(randBuffer);
    }

    /**
     * 随即产生min到max之间的随机数,包含max和min，但是int型的
     *
     * @param min 最小值
     * @param max 最大值
     * @return
     */
    public static int randomInt(int min, int max) {
        if (min == max) {
            return min;
        }
        return RANDOM.nextInt(max + 1) % (max - min + 1) + min;
    }

    /**
     * 随机产生min到max之间的long值
     *
     * @param min 最小值
     * @param max 最大值
     * @return
     */
    public static long randomLong(long min, long max) {
        if(min == max){
            return min;
        }
        return Math.abs(RANDOM.nextLong() % (max - min + 1)) + min;
    }

    /**
     * 随机产生true或false
     *
     * @return
     */
    public static boolean randomBoolean() {
        return RANDOM.nextInt(2) % 2 == 0;
    }

    /**
     * 随机产生标点符号
     *
     * @return
     */
    public static char randomDelimiter() {
        return DELIMITER[randomInt(0, DELIMITER.length - 1)];
    }

    /**
     * 随机产生ip
     *
     * @return
     */
    public static String randomIp() {
        return randomInt(1, 254) + "." + randomInt(1, 254) + "." + randomInt(1, 254) + "." + randomInt(1, 254);
    }

    /**
     * 随机选择数组中的值 ？？？
     *
     * @return
     */
    public static <T> T randomChose(T... arr) {
        return arr[randomInt(0, arr.length - 1)];
    }
}
