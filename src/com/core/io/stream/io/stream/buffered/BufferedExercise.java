package com.core.io.stream.io.stream.buffered;

/*
        BufferedOutputStream和BufferedInputStream

        //构造一个BufferedInputStream
        BufferedInputStream(InputStream in)
          创建一个 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。

        //构造一个BufferdOutputStream对象
        BufferedOutputStream(OutputStream out)
          创建一个新的缓冲输出流，以将数据写入指定的底层输出流。

        e:\\myshoe.mp4 复制到当前项目路径下的copy.mp4

        BufferedInputStream或者BufferedOutputStream也被成为包装流：依赖于底层普通流对象
        对于包装流而言，close包装流，包装流自己会正确释放，它所依赖的底层普通流


 */

import java.io.*;

public class BufferedExercise {

    public static void main(String[] args) throws IOException {

        //创建字节缓冲输入流对象，让它指向源文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("e:\\myshoe.mp4"));

        //创建字节缓冲输出流对象，让它指向复制的目标文件
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.mp4"));


        //一边读，一边写（一次读写一个字节数组）
        byte[] buffer = new byte[2048];

        int len = -1;
        while((len = bis.read(buffer)) != -1) {

            bos.write(buffer, 0, len);

        }

        //释放上层包装流资源（包装流会自己去释放底层依赖的普通流）
        bis.close();
        bos.close();

    }
}
