package com.core.iostream.readtxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author Tianqi.Zhang
 * @date 2018/11/30
 * @time 16:38
 * @package com.core.i_io_file_stream.readtxt
 * @project 1008MyDemo
 * @description
 */
public class TxtReader {
    public static String txt2String(File file) {
        StringBuilder result = new StringBuilder();
        try {
            //构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            //使用readLine方法，一次读一行
            while ((s = br.readLine()) != null) {
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        File file = new File("d:/loog.txt");

        String string = txt2String(file);
        String[] split = string.split(" ");

        int i = 1;
        for (String s : split) {

            System.out.println("字串" + i++ + ":  " + s);
        }
    }

}
