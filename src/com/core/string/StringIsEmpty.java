package com.core.string;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @author Tianqi.Zhang
 * @date 2018/12/19
 * @time 18:54
 * @package com.core.string
 * @project 1008MyDemo
 * @description
 */
public class StringIsEmpty {
    public static void main(String[] args) {
        String e = "";
        String e1 = " ";
        String e2 = "         ";

        doTest(e);
        doTest(e1);
        doTest(e2);

    }


    public static void doTest(String s) {
        boolean b = s == null;
        System.out.println("s = " + s + "是否为null" + b);
        int length = s.length();
        System.out.println("length = " + length);
    }
}
