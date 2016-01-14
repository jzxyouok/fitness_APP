package com.jlu.zhu.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author <a href="mailto:zz_xiaozhu@163.com">风袭</a>
 * @version V1.0.0
 * @since 2015/6/8
 */
public class DateUtil {
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期字符串转日期对象
     *
     * @param dateStr 日期字符串"yyyy-MM-dd"和"yyyy-MM-dd HH:mm:ss"
     * @return 返回日期对象
     */
    public static Date getDate(String dateStr) {
        if (StringUtil.isNotEmpty(dateStr)) {
            return (dateStr.length() > 10) ? getDate(dateStr, DATE_TIME_FORMAT) : getDate(dateStr, DATE_FORMAT);
        }
        return null;
    }

    public static Date getDate(String dateStr, String format) {
        try {
            return new SimpleDateFormat(format).parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将日期对象转日期字符串(yyyy-MM-dd)
     *
     * @param date 日期对象
     * @return 返回日期字符串
     */
    public static String getDateString(Date date) {
        return getDateString(date, DATE_FORMAT);
    }

    /**
     * 将日期对象转日期字符串(yyyy-MM-dd HH:mm:ss)
     *
     * @param date 日期对象
     * @return 返回日期字符串
     */
    public static String getDateTimeString(Date date) {
        return getDateString(date, DATE_TIME_FORMAT);
    }

    /**
     * 将日期对象转日期字符串，格式自定义
     *
     * @param date 日期对象
     * @param format 日期格式
     * @return 返回日期字符串
     */
    public static String getDateString(Date date, String format) {
        return date == null ? null : new SimpleDateFormat(format).format(date);
    }

    /**
     *假设long型time是1452737423613 代表(2016-01-14 10:10:23)则
     getHourBeginTime 返回1452736800000 代表(2016-01-14 10:00:00) //time所在小时的起始时间
     getHourEndTime   返回1452740399999 代表(2016-01-14 10:59:59) //time所在小时的结束时间
     getDayBeginTime  返回1452700800000 代表(2016-01-14 00:00:00) //time所在日期的起始时间
     getDayEndTime    返回1452787199999 代表(2016-01-14 23:59:59) //time所在日期的结束时间
     getMonthBeginTime返回1451577600000 代表(2016-01-01 00:00:00) //time所在月份的起始时间
     getMonthEndTime  返回1454255999999 代表(2016-01-31 23:59:59) //time所在月份的结束时间
     getYearBeginTime 返回1451577600000 代表(2016-01-01 00:00:00) //time所在年份的起始时间
     getYearEndTime   返回1483199999999 代表(2016-12-31 23:59:59) //time所在年份的结束时间
     */

    /**
     * time所在小时的起始时间
     *
     * @param time 日期long型
     * @return 返回time所在小时的起始时间，但也是long型
     */
    public static long getHourBeginTime(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }


    /**
     * time所在小时的结束时间
     *
     * @param time 日期long型
     * @return 返回time所在小时的结束时间，但也是long型
     */
    public static long getHourEndTime(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
        return calendar.getTime().getTime();
    }

    public static long getDayBeginTime(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    public static long getDayEndTime(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
        return calendar.getTime().getTime();
    }

    public static long getMonthBeginTime(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    public static long getMonthEndTime(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
        return calendar.getTime().getTime();
    }

    public static long getYearBeginTime(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.MONTH, 0);//注意：月份从0开始。
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    public static long getYearEndTime(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.MONTH, calendar.getActualMaximum(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
        return calendar.getTime().getTime();
    }

    /**
     *以下函数是在time时间的基础上加上年、月、日、时、分、秒的增量。返回long型时间。
     * @param time 日期long型
     * @param year 增加的量
     * @return 返回增加后的时间，但也是long型
     */
    public static long addYear(long time, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.add(Calendar.YEAR, year);
        return calendar.getTimeInMillis();
    }

    public static long addMonth(long time, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTimeInMillis();
    }

    public static long addDay(long time, int day) {
        return addHour(time, 24L * day);
    }

    public static long addHour(long time, long hour) {
        return addMinute(time, 60L * hour);
    }

    public static long addMinute(long time, long min) {
        return addSecond(time, 60L * min);
    }

    public static long addSecond(long time, long sec) {
        return time + sec * 1000L;
    }
}
