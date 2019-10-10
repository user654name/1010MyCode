package com.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时任务
 *
 * @author Tianqi.Zhang
 * @date 2019/8/22
 * @time 9:13
 * @package com.timer
 * @project 1008MyDemo
 * @description
 */
public class TimeeTaskDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 0, 5000);
    }
}

class MyTask extends TimerTask {
    static private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public void run() {
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR);
        int min = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        String secondWord = second % 2 == 0 ? "A" : "B";

        String format1 = format.format(new Date());
        String info1 = "  INFO 10464 --- [       Thread-3] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...";
        String info2 = "  INFO 10464 --- [       Thread-3] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.";
        System.out.println(format1+info1);
        System.out.println(format1+info2);
    }
}