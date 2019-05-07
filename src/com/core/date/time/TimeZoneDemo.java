package com.core.date.time;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/6
 * @time 14:10
 * @package com.core.date.time
 * @project 1008MyDemo
 * @description
 */
public class TimeZoneDemo {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance(TimeZone.getDefault());
//        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT+:08:00"));
//        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
        int mon = instance.get(Calendar.MONTH);
        int hour = instance.get(Calendar.HOUR_OF_DAY);
        int min = instance.get(Calendar.MINUTE);
        int date = instance.get(Calendar.DATE);
        System.out.println("date = " + date);
        System.out.print(hour + "h ");
        System.out.println(min + "m ");
        System.out.println("instance = " + instance);

        String[] availableIDs = TimeZone.getAvailableIDs();
//        for (String availableID : availableIDs) {
//            System.out.println("availableID = " + availableID);
//        }
    }
}
