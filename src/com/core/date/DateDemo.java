package com.core.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Tianqi.Zhang
 * @date 2019/2/20
 * @time 19:42
 * @package com.core.date
 * @project 1008MyDemo
 * @description
 */
public class DateDemo {
    public static void main(String[] args) throws ParseException {

        long l = System.currentTimeMillis();
        Date dateSql = new java.sql.Date(l);
        System.out.println("dateSql = " + dateSql);
        Date date = new Date(l);
        System.out.println("date = " + date);


    }
}
