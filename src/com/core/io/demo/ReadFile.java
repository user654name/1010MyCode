package com.core.io.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Tianqi.Zhang
 * @date 2019/8/26
 * @time 16:59
 * @package com.core.io.demo.file
 * @project 1008MyDemo
 * @description
 */
public class ReadFile {
    public static void main(String[] args) throws IOException {
        File guan = CreateFile.getFile("关");
        FileInputStream fis = null;
        fis = new FileInputStream(guan);
        //初始化和迭代放在一起了
        int asciib;
        while ((asciib = fis.read()) != -1) {
            System.out.print(asciib);
        }

    }
}
