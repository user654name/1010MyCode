package com.java8.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.MinguoDate;
import java.time.chrono.ThaiBuddhistDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Date;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/21
 * @time 15:01
 * @package com.java8.date
 * @project 1008MyDemo
 * @description
 */
public class Java8DateDemo {
    public static void main(String[] args) {
    }

    @Test
    public void showNewClassOfJavaTime() {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime = " + localTime);
        Year year = Year.now();
        System.out.println("year = " + year);
        YearMonth yearMonth = YearMonth.now();
        System.out.println("yearMonth = " + yearMonth);
        DayOfWeek friday = DayOfWeek.FRIDAY;
        System.out.println("friday = " + friday);

    }

    @Test
    public void classDurationTest() {
        Temporal start = LocalDateTime.of(2019, 1, 1, 1, 1, 1);
        Temporal end = LocalDateTime.of(2019, 1, 2, 1, 1, 1);
        Duration duration = Duration.between(start, end);
        long toDays = duration.toDays();
        System.out.println("toDays = " + toDays);
        long toHours = duration.toHours();
        System.out.println("toHours = " + toHours);
        long toMinutes = duration.toMinutes();
        System.out.println("toMinutes = " + toMinutes);

        //        String toString = duration.toString();
        //        System.out.println("toString = " + toString);
        ThaiBuddhistDate now = ThaiBuddhistDate.now();
        System.out.println("now = " + now);
    }

    /**
     * 测试日期转化
     */
    @Test
    public void dateString() {
        String pattern = "G yyyy年MM月dd号 E a hh时mm分ss秒";
        // 旧方法
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String format = sdf.format(new Date());
        System.out.println("format = " + format);
        Date parse = null;
        try {
            parse = sdf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("parse = " + parse);
        // JAVA8
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        String format8 = now.format(dtf);
        System.out.println("format8 = " + format8);
    }

    @Test
    public void minguoDate() {
        MinguoDate minguoDate = MinguoDate.now();
        System.out.println("minguoDate = " + minguoDate);
    }
}
