package com.core.b_io_file_stream.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {

    public static void main(String[] args) {


        //源文件
        String parent = "D:\\MyJavaTest";
        String fileName="郭小萍 - 那年冬天.mp3";

        //目标文件
        String newName = "那年冬天-副本-ByZhang.rar";

        //源文件
        File fromFile = new File(parent, fileName);
        //目标文件
        File toFile = new File(parent, newName);
        try {
            /*
             * 执行复制操作！
             */
            doCopy(fromFile, toFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void doCopy(File fromFile, File toFile) throws IOException {
        //输入输出流
        FileInputStream fileInputStream = new FileInputStream(fromFile);
        FileOutputStream fileOutputStream = new FileOutputStream(toFile);


        byte[] bytes = new byte[1024];

        int len = 0;

        /**
         * fileInputStream.read(bytes)
         * 输入流 从文件中 读取 bytes（数组大小） 个字节
         * 参数bytes —— 存储读取数据的缓冲区 (向这里写入数据)
         * return 读入缓冲区的字节总数，如果因为已经到达文件末尾而没有更多的数据，则返回 -1
         */
        while ((len = fileInputStream.read(bytes)) != -1) {

            /**
             * fileOutputStream.write(bytes, 0, len)
             * 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
             * 覆盖：类 OutputStream 中的 write
             * 参数：
             *  @param bytes - 准备输出数据。
             *  @param off - 数据中的起始偏移量。
             *  @param len - 要写入的字节数。
             *
             */
            fileOutputStream.write(bytes, 0, len);

            /**
             * 刷新缓冲区里未写入的数据
             */
            fileOutputStream.flush();
        }

        /**
         * 关闭
         */
        fileInputStream.close();
        fileOutputStream.close();
    }

}
