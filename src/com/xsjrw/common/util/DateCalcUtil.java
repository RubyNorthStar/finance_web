package com.xsjrw.common.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期Util
 *
 * @author hejianming
 * @date 2013-02-26
 */
public class DateCalcUtil {

    /**
     * 字符串日期转Date
     *
     * @param date yyyy-MM-dd
     * @return 日期
     * @throws ParseException
     * @author xuyl
     */
    public static Date dateParse(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(date);
    }

    /**
     * 格式化日期
     *
     * @param date yyyy-MM-dd
     * @return
     * @throws ParseException
     * @author xuyl
     */
    public static String dateFormat(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    public static Date dateFormatDate(Date date, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        String str = format.format(date);
        Date result = null;
        try {
            result = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 日期加减
     *
     * @param dateStr yyyy-MM-dd
     * @param amount  数值
     * @return dateStr+? yyyy-MM-dd
     * @throws ParseException
     * @author xuyl
     */
    public static String dateAdd(String dateStr, int amount) throws ParseException {
        return dateAdd(dateStr, Calendar.DATE, amount);
    }

    /**
     * 日期加减
     *
     * @param dateStr yyyy-MM-dd
     * @param field   Calendar.DATE...
     * @param amount  数值
     * @return dateStr+? yyyy-MM-dd
     * @throws ParseException
     * @author xuyl
     */
    public static String dateAdd(String dateStr, int field, int amount) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateParse(dateStr));
        cal.add(field, amount);
        return dateFormat(cal.getTime());
    }

    /**
     * 日期设置
     *
     * @param dateStr yyyy-MM-dd
     * @param field   Calendar.DAY_OF_WEEK...
     * @param value   Calendar.MONDAY...
     * @return dateStr+? yyyy-MM-dd
     * @throws ParseException
     * @author xuyl
     */
    public static String dateSet(String dateStr, int field, int value) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateParse(dateStr));
        cal.set(field, value);
        return dateFormat(cal.getTime());
    }

    /**
     * 今天的日期
     *
     * @return
     * @author xuyl
     */
    public static String getNow() {
        return dateFormat(Calendar.getInstance().getTime());
    }

    /**
     * 昨天的日期
     *
     * @return
     * @throws ParseException
     * @author xuyl
     */
    public static String getYesterday() throws ParseException {
        return dateAdd(getNow(), -1);
    }

    /**
     * 指定日期的周一
     *
     * @param date
     * @return
     * @throws ParseException
     * @author xuyl
     */
    public static String getMonday(String date) throws ParseException {
        return dateSet(date, Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    }

    /**
     * 指定日期的上周周一
     *
     * @param date
     * @return
     * @throws ParseException
     * @author xuyl
     */
    public static String getLastMonday(String date) throws ParseException {
        return dateSet(dateAdd(date, -7), Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    }

    /**
     * 指定日期的上周周日:老外的周日是一周的第一天哦
     *
     * @param date
     * @return
     * @throws ParseException
     * @author xuyl
     */
    public static String getSunday(String date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateParse(date));
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            return date; // 周日直接返回
        return dateSet(dateAdd(date, 7), Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    }

    /**
     * 指定日期的上周周日:老外的周日是一周的第一天哦
     *
     * @param date
     * @return
     * @throws ParseException
     * @author xuyl
     */
    public static String getLastSunday(String date) throws ParseException {
        return getSunday(dateAdd(date, -7));
    }

    /**
     * 指定日期的当前月1号
     *
     * @param date
     * @return
     * @throws ParseException
     * @author xuyl
     */
    public static String getFirstDayOfMonth(String date) throws ParseException {
        return dateSet(date, Calendar.DAY_OF_MONTH, 1);
    }

    /**
     * 获取本周是该年的第几周<br/>
     * 1号所在的周为第一周算起
     *
     * @return
     * @throws ParseException
     * @author xuyl
     */
    public static int getWeekOfYear(String date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setMinimalDaysInFirstWeek(7);
        cal.setTime(dateParse(date));
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取去年同自然周的周一
     *
     * @param date
     * @return
     * @throws ParseException
     * @author xuyl
     */
    public static String getLastYearByWeekMonday(String date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setMinimalDaysInFirstWeek(7);
        cal.setTime(dateParse(date));
        cal.set(cal.get(Calendar.YEAR) - 1, Calendar.JANUARY, 1);
        cal.add(Calendar.WEEK_OF_YEAR, getWeekOfYear(date));
        return getMonday(dateFormat(cal.getTime()));
    }

    /**
     * 两个日期的时间差，以小时显示
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long dateDiff(Date startTime, Date endTime) {
        long nd = 1000 * 24 * 60 * 60;//一天的毫秒数
        long nh = 1000 * 60 * 60;//一小时的毫秒数
        long diff = endTime.getTime() - startTime.getTime();
        return diff % nd / nh;
    }

    /**
     * 两个日期的时间差，以秒显示
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static long dateDiffSecond(Date startTime, Date endTime) {
        return (endTime.getTime() - startTime.getTime()) / 1000;
    }

    /**
     * 把毫秒转化成中文天数
     * 0天6时20分 3秒
     *
     * @param ms
     * @return
     */
    public static String formatTimeToZhDay(long ms) {
        //将毫秒数换算成x天x时x分x秒x毫秒
        int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;

        long day = ms / dd;
        long hour = (ms - day * dd) / hh;
        long minute = (ms - day * dd - hour * hh) / mi;
        long second = (ms - day * dd - hour * hh - minute * mi) / ss;

        String strDay = day < 10 ? "0" + day : "" + day;
        String strHour = hour < 10 ? "0" + hour : "" + hour;
        String strMinute = minute < 10 ? "0" + minute : "" + minute;
        String strSecond = second < 10 ? "0" + second : "" + second;
        return strDay + " 天 " + strHour + " 小时 " + strMinute + " 分 " + strSecond + " 秒";
    }

    /**
     * 把秒转化成中文天数
     * 0天6时20分 3秒
     *
     * @param second
     * @return
     */
    public static String formatSecondTimeToZhDay(long second) {
        return formatTimeToZhDay(second * 1000);
    }

    /**
     * 时间参数与秒相减
     *
     * @param date
     * @param second
     * @return
     */
    public static Date diffDateToSecond(Date date, Integer second) {
        Long dateMilisecond = date.getTime();
        return new Date(dateMilisecond - second * 1000);
    }

    public static Double getMinuteBySecond(Integer second) {
        double minuteDouble = second.doubleValue() / 60;
        BigDecimal bg = new BigDecimal(minuteDouble);
        return bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(DateCalcUtil.dateFormatDate(new Date(),"yyyy-MM-dd"));
    }
}
