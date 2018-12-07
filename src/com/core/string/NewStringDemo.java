package com.core.string;

import org.junit.Test;

public class NewStringDemo {


@Test
    public void stringTest(){

    /**
     * s所指的那个对象不会变
     * s指向了另一个Helloworld！的对象了
     * 
     */
    String s = "Hello";
        s = s + " world!";
        System.out.println(s);

    }

    @Test
    public void roundTest() {
        /**
         * Math.round(11.5) 四舍五入
         *
         *
         */
        long round = Math.round(11.4); //11
        long round2 = Math.round(11.5);//12
        long round3 = Math.round(-11.5);//-11
        long round4 = Math.round(-11.6);//-12
//        System.out.println("round = " + round3);
//        System.out.println("round2 = " + round4);
    }


    @Test
    public void demo() {

        String s1 = "aaa";
        String s2 = new String("aaa");

        boolean 是否相等 = s1 == s2;
        boolean 是否equ = s1.equals(s2);
        System.out.println("是否相等 = " + 是否相等);
        System.out.println("是否equ = " + 是否equ);


    }


}
