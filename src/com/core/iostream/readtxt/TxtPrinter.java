package com.core.iostream.readtxt;

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


    /**
     * 2018年12月2日 23:58:32
     * 用以下代码写入文件时，文件目录必须存在 否则报错
     */
    public static void main(String[] args) throws FileNotFoundException {

        /**
         * 这一步最重要
         *
         * 设置打印到TXT文件
         */
//        SetPrintToTxt();


        int lastNumber = 10000;
//        lastNumber
        long start = System.currentTimeMillis();
        System.out.print(SPACE);
        for (int num = 0; num <= lastNumber; num++) {

            SetPrintToTxt("txtFile" + num);

            // 每行10个元素 (每10个换行)
            if (num % ROW == 0 && num != 0) {
                System.out.println();
            }

            if (num < 10) {
                System.out.print(SPACE);
            }
            System.out.print(SPACE + num);

        }
        long end = System.currentTimeMillis();

        System.out.println("执行时间= " + (end - start) / 1000.0 + "秒");
    }


    /**
     * 这一步最重要
     *
     * 设置打印到TXT文件
     *
     */
    private static void SetPrintToTxt(String fileName) throws FileNotFoundException {
        //设置打印流指向的文件
        PrintStream ps = new PrintStream("d:/aaa/" + fileName + ".txt");
        //设置输出到打印流 而不是控制台
        System.setOut(ps);
    }
}
