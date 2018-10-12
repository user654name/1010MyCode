package com.core.z_demos;

import java.util.Date;

public class JiSuanDemo {

    public static void main(String[] args) {


        Date date = new Date();
        date.setMinutes(29);
        date.setSeconds(30);

        String string = date.toString();
        System.out.println("string = " + string);
//        long i =  / 5;
    }
}
