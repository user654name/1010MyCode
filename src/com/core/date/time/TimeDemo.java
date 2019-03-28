package com.core.date.time;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Tianqi.Zhang
 * @date 2019/3/25
 * @time 15:19
 * @package com.core.date.time
 * @project 1008MyDemo
 * @description
 */
public class TimeDemo {

    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        Date dateNow = new Date(l        );
        System.out.println("dateNow = " + dateNow);
        long time = dateNow.getTime();
        int hours = dateNow.getHours();
        System.out.println("hours = " + hours);


        Calendar instance = Calendar.getInstance();
        int i = instance.get(Calendar.HOUR_OF_DAY);
        System.out.println("i = " + i);
        int i1 = instance.get(Calendar.HOUR);
        System.out.println("i1 = " + i1);


    }

}
