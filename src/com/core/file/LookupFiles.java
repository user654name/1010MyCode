package com.core.file;

import java.io.File;
import java.util.Objects;

/**
 * @author Tianqi.Zhang
 * @date 2019/4/2
 * @time 9:43
 * @package com.core.file
 * @project 1008MyDemo
 * @description 遍历文件
 */
public class LookupFiles {

    /**
     * 遍历文件 按格式（后缀）输出
     * @param args
     */
    public static void main(String[] args) {

//        File dir = new File("D:\\");

        lookupFileAndPrint(new File("C:\\"));
        lookupFileAndPrint(new File("D:\\"));
        lookupFileAndPrint(new File("X:\\"));
        lookupFileAndPrint(new File("Y:\\"));
        lookupFileAndPrint(new File("Z:\\"));

    }

    private static void lookupFileAndPrint(File file) {
        if (Objects.isNull(file) || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (Objects.isNull(files)) {
                return;
            } else {
                for (File currentFile : files) {
                    lookupFileAndPrint(currentFile);
                }
            }
        } else {
            suffix(file, ".rmvb");
            suffix(file, ".avi");
            suffix(file, ".mkv");
            suffix(file, ".torrent");
            suffix(file, ".mp3");
        }

    }

    private static void suffix(File file, String s) {
        if (file.getName().endsWith(s)) {
            System.out.println("[" + s + "]" + file.getAbsolutePath());
        }
    }
}
