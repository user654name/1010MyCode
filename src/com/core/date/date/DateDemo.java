package com.core.date.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Tianqi.Zhang
 * @date 2019/4/28
 * @time 15:20
 * @package com.core.date.date
 * @project 1008MyDemo
 * @description
 */
public class DateDemo {
    public static void main(String[] args) throws ParseException {
        String dateS="70-03-22";
        Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(dateS);
        Calendar instance = Calendar.getInstance();
        instance.setTime(parse);
        System.out.print("parse = " + parse+"$$##"+ instance.get(Calendar.YEAR));

    }
}
