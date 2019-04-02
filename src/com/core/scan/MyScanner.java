package com.core.scan;

import java.io.Serializable;
import java.util.Scanner;

/**
 * @author Tianqi.Zhang
 * @date 2019/1/11
 * @time 16:19
 * @package com.core.scan
 * @project 1008MyDemo
 * @description
 */
public class MyScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入数字");
            String next = scanner.next();

            int num = 0;
            try {
                num = Integer.parseInt(next);
            } catch (NumberFormatException e) {
                System.out.println("转换异常");
            }
            int rst = num * 10;
            System.out.println("rst = " + rst);

        }

    }
}
