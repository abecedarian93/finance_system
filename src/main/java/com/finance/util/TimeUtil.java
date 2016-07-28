package com.finance.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by tianle.li on 2016/7/28.
 */
public class TimeUtil {

    /**
     * 获得今天日期
     *
     * @return
     */
    public static String getTodayStr(String format) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = cal.getTime();
        String curDate = sdf.format(d);
        return curDate;
    }

    /**
     * 得到 N天前的日期
     *
     * @return
     */
    public static String getDaysBefore(int num, String format) {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) - num);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = cal.getTime();
        String curDate = sdf.format(d);
        return curDate;
    }

    /**
     * 得到  去年的现在
     *
     * @param format
     * @return
     */
    public static String getNowOfLastYear(String format) {
        SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat(format);
        GregorianCalendar aGregorianCalendar = new GregorianCalendar();
        aGregorianCalendar.set(Calendar.YEAR, aGregorianCalendar.get(Calendar.YEAR) - 1);
        String currentYearAndMonth = aSimpleDateFormat.format(aGregorianCalendar.getTime());
        return currentYearAndMonth;
    }

    public static String getNowOfLastYear(int year, int month, int date, String format) {
        SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat(format);
        GregorianCalendar aGregorianCalendar = new GregorianCalendar(year, month, date);
        aGregorianCalendar.set(Calendar.YEAR, aGregorianCalendar.get(Calendar.YEAR) - 1);
        String currentYearAndMonth = aSimpleDateFormat.format(aGregorianCalendar.getTime());
        return currentYearAndMonth;
    }

    /**
     * 得到 上月的现在
     *
     * @param format
     * @return
     */
    public static String getNowOfLastMonth(String format) {
        SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat(format);
        GregorianCalendar aGregorianCalendar = new GregorianCalendar();
        aGregorianCalendar.set(Calendar.MONTH, aGregorianCalendar.get(Calendar.MONTH) - 1);
        String nowOfLastMonth = aSimpleDateFormat.format(aGregorianCalendar.getTime());
        return nowOfLastMonth;
    }

    public static String getNowOfLastMonth(int year, int month, int date, String format) {
        SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat(format);
        GregorianCalendar aGregorianCalendar = new GregorianCalendar(year, month, date);
        aGregorianCalendar.set(Calendar.MONTH, aGregorianCalendar.get(Calendar.MONTH) - 1);
        String nowOfLastMonth = aSimpleDateFormat.format(aGregorianCalendar.getTime());
        return nowOfLastMonth;
    }

}
