package com.jlu.zhu.util;

/**
 * 字符串操作工具类
 *
 * @author <a href="mailto:zz_xiaozhu@163.com">风袭</a>
 * @version V1.0.0
 * @since 2015/6/8
 */
public class StringUtil {
    /**
     * 是否为空
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        return (s == null || "".equals(s.trim()));
    }

    /**
     * 是否不为空
     *
     * @param s
     * @return
     */
    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }
}
