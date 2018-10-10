package com.ztq.io_file_stream.io.stream.output;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
       ”helloworld”
        分析发现其实更适合用字往一个文本文件中写一句话符流，
        但是由于字节流先出现，
        所以，我们考虑先使用字节流后面再讲会什么出现字符流。


        FileOutputStream的构造方法
        FileOutputStream(File file)   创建一个向指定 File 对象表示的文件中写入数据的文件输出流
        FileOutputStream(String name) 创建一个向具有指定名称的文件中写入数据的输出文件流
 */
public class OutputStreamDemo1 {

    public static void main(String[] args) throws IOException {

        //创建输出流对象，在创建输出流对象的时候，通过改造方法，告诉输出流把数据输出到那个文件中

        //创建一个输出流对象，其实做了三件事情

        //1. 输出流会在操作系统上找，文件是否针对存在，如果不存在会创建这个文件，如果存在就啥也不做。
        //2. 创建OutputStream子类对象
        //3. 让OutputStream堆向，指向目标文件
        OutputStream os = new FileOutputStream("a.txt");

        //向目标文件中写入数据
        os.write("helloworld".getBytes());

        //关闭此输出流并释放与此流有关的所有系统资源。
        //close 的常规协定是：该方法将关闭输出流。
        // 关闭的流不能执行输出操作，也不能重新打开。
        //释放资源
        os.close();


    }
}
