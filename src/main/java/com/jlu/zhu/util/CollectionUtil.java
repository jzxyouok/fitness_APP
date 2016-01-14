package com.jlu.zhu.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 集合工具类
 *
 * @author <a href="mailto:zz_xiaozhu@163.com">风袭</a>
 * @version V1.0.0
 * @since 2015-06-05
 */
public class CollectionUtil {

    /**
     * 列表是否为空
     *
     * @param list
     * @return
     */
    public static boolean isEmpty(Collection<?> list) {
        return list == null || list.isEmpty();
    }

    /**
     * 列表是否不为空
     *
     * @param list
     * @return
     */
    public static boolean isNotEmpty(Collection<?> list) {
        return !isEmpty(list);
    }

    /**
     * 输入流转码
     *
     * @param in
     * @param encoding
     * @return
     */
    public static String in2Str(InputStream in, String encoding) {
        if (in == null) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        try {
            InputStreamReader reader = new InputStreamReader(in, encoding);
            int tmp = -1;
            char temp;
            while ((tmp = reader.read()) != -1) {
                temp = (char) tmp;
                sb.append(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    /**
     * list过滤空
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> filterEmpty(Collection<T> list) {
        if (list == null) {
            return null;
        }

        List<T> newList = new ArrayList<T>();
        for (T t : list) {
            if (t != null && t.toString().length() > 0) {
                newList.add(t);
            }
        }
        return newList;
    }

    /**
     * 过滤重复项
     * @param c
     * @param <T>
     * @return
     */
    public static <T> Collection<T> unique(Collection<T> c) {
        if (c != null && c.size() > 0) {
            Map<T, Integer> map = new LinkedHashMap<T, Integer>();
            for (T o : c) {
                map.put(o, 0);
            }
            if (c instanceof Set) {
                return map.keySet();
            } else {
                return new ArrayList<T>(map.keySet());
            }
        }
        return c;
    }

    /**
     * 将list对象用separator连接起来 join函数
     * 1，将list对象用separator连接起来，并过滤空
     * 2，将数组对象用separator连接起来，并过滤空
     * 3，将数组对象用separator连接起来
     * 4，将数组对象用separator连接起来，并指定开始处和结尾处
     *
     * @param list
     * @param separator
     * @param <T>
     * @return
     */
    public static <T> String join(Collection<T> list, String separator) {
        return join(list, separator, false);
    }

    public static <T> String join(Collection<T> list, String separator, boolean filterEmpty) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            int i = 0;
            List<T> newList = filterEmpty ? filterEmpty(list) : new ArrayList<T>(list);
            for (T t : newList) {
                sb.append(t.toString());
                if (i < list.size() - 1) {
                    sb.append(separator);
                }
                i++;
            }
        }
        return sb.toString();
    }

    public static <T> String join(T[] arr, String separator, boolean filterEmpty) {
        return join(asList(arr), separator, filterEmpty);
    }

    public static <T> String join(T[] arr, String separator) {
        return join(arr, separator, false);
    }

    public static <T> String join(T[] arr, String separator, int start, int end) {
        List<T> newList = new ArrayList<T>();
        for (int i = 0; i < arr.length; i++) {
            if (i >= start && i < end) {
                newList.add(arr[i]);
            }
        }
        return join(newList, separator);
    }

    /**
     * 数组转List对象
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T> List<T> asList(T... array) {
        if (array == null) {
            return null;
        }

        List<T> list = new ArrayList<T>();
        for (T t : array) {
            if (t != null) {
                list.add(t);
            }
        }
        return list;
    }

    /**
     * list对象转为Array对象
     *
     * @param list
     * @return
     */
    public static String[] toArray(Collection<String> list) {
        if (list == null) {
            return null;
        }

        String[] ts = new String[list.size()];
        list.toArray(ts);
        return ts;
    }

    /**
     * 交集
     * @param l1
     * @param l2
     * @param <T>
     * @return
     */
    public static <T> List<T> intersect(List<T> l1, List<T> l2) {
        List<T> list = new ArrayList<T>();
        list.addAll(l1);
        list.retainAll(l2);
        return list;
    }

    /**
     * 并集
     * @param l1
     * @param l2
     * @param <T>
     * @return
     */
    public static <T> List<T> union(List<T> l1, List<T> l2) {
        Map<T, T> map = new LinkedHashMap<T, T>();
        for (T t : l1) {
            map.put(t, t);
        }
        for (T t : l2) {
            map.put(t, t);
        }
        return new ArrayList<T>(map.keySet());
    }

    /**
     * 差集
     * @param l1
     * @param l2
     * @param <T>
     * @return
     */
    public static <T> List<T> diff(List<T> l1, List<T> l2) {
        List<T> list = new ArrayList<T>();
        list.addAll(l1);
        list.removeAll(l2);
        return list;
    }
}
