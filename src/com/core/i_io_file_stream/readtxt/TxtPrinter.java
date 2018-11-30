package com.core.i_io_file_stream.readtxt;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author Tianqi.Zhang
 * @date 2018/11/30
 * @time 14:56
 * @package com.core.i_io_file_stream.readtxt
 * @project 1008MyDemo
 * @description
 */
public class TxtPrinter {


    final static String SPACE = " ";
    final static int ROW = 10;


    public static void main(String[] args) throws FileNotFoundException {

        /**
         * 这一步最重要
         *
         * 设置打印到TXT文件
         */
        SetPrintToTxt();


        int lastNumber = 99;
//        lastNumber
        System.out.print(SPACE);
        for (int num = 0; num <= lastNumber; num++) {

            // 每行10个元素 (每10个换行)
            if (num % ROW == 0 && num != 0) {
                System.out.println();
            }

            if (num < 10) {
                System.out.print(SPACE);
            }
            System.out.print(SPACE + num);

        }
    }


    /**
     * 这一步最重要
     *
     * 设置打印到TXT文件
     *
     */
    private static void SetPrintToTxt() throws FileNotFoundException {
        //设置打印流指向的文件
        PrintStream ps = new PrintStream("d:/loooooooog.txt");
        //设置输出到打印流 而不是控制台
        System.setOut(ps);
    }
}
