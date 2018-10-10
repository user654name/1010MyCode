package com.ztq.b_io_file_stream.file;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {

        //原来的文件名
        String path = "D:\\ball.jpg";
        //新的文件名
        String newPath = "D:\\ball2.jpg";

        //读取原来文件
        File file = new File(path);
        //创建逻辑上的新文件
        File newFile = new File(newPath);


        //在原来文件上 调用API 进行重命名
        boolean rename = file.renameTo(newFile);

        System.out.println("rename = " + rename);

//        File fileCopy = new File(copyPath);
//        boolean mkdirs = fileCopy.mkdirs();
//        System.out.println("mkdir = " + mkdirs);

    }
}
