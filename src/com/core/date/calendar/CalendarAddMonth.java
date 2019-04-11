package com.core.date.calendar;

import org.junit.Test;

import java.util.Calendar;

/**
 * @author Tianqi.Zhang
 * @date 2019/4/10
 * @time 15:05
 * @package com.core.date.calendar
 * @project 1008MyDemo
 * @description
 */
public class CalendarAddMonth {


    @Test
    public void addMonth(){
        Calendar instance = Calendar.getInstance();
        for (int i = 0; i <24 ; i++) {
            instance.add(Calendar.MONTH,1);
            System.out.println(instance.getTime()); //
        }
    }


    @Test
    public void namse() {

    }
}
