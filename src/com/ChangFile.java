package com;

import java.io.File;

/**
 * @author Tianqi.Zhang
 * @date 2019/7/17
 * @time 20:07
 * @package com
 * @project 1008MyDemo
 * @description
 */
public class ChangFile {
    public static void main(String[] args) {
        File f = new File("Z:\\movie\\3");


        for (File file : f.listFiles()) {
            String name = file.getName();
            System.out.println();
            File absoluteFile = file.getAbsoluteFile();



        }
    }

}
