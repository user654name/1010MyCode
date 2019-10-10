package com.core.io.demo;

import java.io.File;
import java.io.IOException;

/**
 * 用于创建新文件
 *
 * @author Tianqi.Zhang
 * @date 2019/8/26
 * @time 16:52
 * @package com.core.io.demo
 * @project 1008MyDemo
 * @description
 */
public class CreateFile {

    static String dir = "D:\\Users\\Administrator\\1008MyDemo\\src\\com\\core\\io\\demo\\file";

    public static void main(String[] args) throws IOException {
        getFile("123");
    }

    public static File getFile(String fileName) throws IOException {
        File file = new File(dir, fileName + ".txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
}
