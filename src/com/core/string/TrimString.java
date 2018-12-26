package com.core.string;

/**
 * @author Tianqi.Zhang
 * @date 2018/12/25
 * @time 10:22
 * @package com.core.string
 * @project 1008MyDemo
 * @description
 */
public class TrimString {
    public static void main(String[] args) {
        // 【结论】trim可以取出空格！
        String s = "           ";
        String trim = s.trim();
        System.out.println("trim = " + trim);
        int length = trim.length();
        System.out.println("length = " + length);


        
    }
}
