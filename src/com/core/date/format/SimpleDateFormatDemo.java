package com.core.date.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/8
 * @time 14:05
 * @package com.core.date.format
 * @project 1008MyDemo
 * @description
 */
public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyy-MM-dd");


        for (int m = 1; m < 13; m++) {
            for (int d = 1; d < 28; d++) {

                String dates =2019+"-"+m+"-"+d;
                Date parse = simpleDateFormat.parse(dates.toString());
                System.out.print("dates = " + dates);
                System.out.println(" parse = " + parse);
            }
        }


    }
}
