package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

/**
 * @author Tianqi.Zhang
 * @date 2019/10/10
 * @time 22:33
 * @package com.util
 * @project 1008MyDemo
 * @description
 */
public class DateUtil {

    private final static long SECOND = 1000;
    private final static long MINUTE = SECOND * 60;
    private final static long HOUR = MINUTE * 60;
    private final static long DAY = HOUR * 24;
    private final static long WEEK = DAY * 7;
    static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date toDate(String yyyyMMdd) {
        Date parse = null;
        try {
            parse = formatDate.parse(yyyyMMdd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    public static String toStr(Date yyyyMMdd) {
        return formatDate.format(yyyyMMdd);
    }


    public static int getGap(Date date1, Date date2) {
        long mSeconds = date1.getTime() - date2.getTime();
        long DAYS = mSeconds / (1000 * 60 * 60 * 24);
        DAYS = DAYS < 0 ? (0 - DAYS) : DAYS;
        return (int) DAYS;
    }


    public static long formatCrTime(String timeAgo) {
        long time = 0;
        String[] split = timeAgo.split(" ");
        for (String ts : split) {
            if (ts.contains("w")) {
                time +=Long.valueOf(ts.substring(0, ts.length() - 1))*WEEK;
            } else if (ts.contains("d")) {
                time +=Long.valueOf(ts.substring(0, ts.length() - 1))*DAY;
            } else if (ts.contains("h")) {
                time +=Long.valueOf(ts.substring(0, ts.length() - 1))*HOUR;
            } else if (ts.contains("m")) {
                time +=Long.valueOf(ts.substring(0, ts.length() - 1))*MINUTE;
            } else if (ts.contains("s")) {
                time +=Long.valueOf(ts.substring(0, ts.length() - 1))*SECOND;
            }
        }
        return time;
    }

    public static Duration formatCrDurationTime(String timeAgo) {
        long timeMills = formatCrTime(timeAgo);
        return Duration.ofMillis(timeMills);
    }


    public static String getNowCn() {
        return formatDateTime.format(new Date());
    }

    public static String getSeasonStartDate() {
//        Calendar ins
        return formatDateTime.format(new Date());
    }


}

