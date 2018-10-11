package com.core.b_io_file_stream.io.stream.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
        在不同的操作系统上，操作系统上是不一样的：
        1. windows 操作系统上 \r\n
        2. linux,mac上 \n

        在高级记事本中，都是可以识别的

        关于数据的追加写入：
        1.默认情况下，当一个文件输出流对象，指向一个文件的时候，会清空文件内容
        2.必须使用特殊的构造方法实现文件的追加写入
          public FileOutputStream(File file,
                        boolean append)

 */

public class OutputStreamDemo3 {

    public static void main(String[] args) throws IOException {
        //1.创建表示目标文件的File类对象
        File file = new File("b.txt");

        //1.创建FileOutputStream对象
       //FileOutputStream fos = new FileOutputStream(file);
        //实现追加写入：
        FileOutputStream fos = new FileOutputStream(file, true);

        //2.向目标文件中写入数据
        fos.write(97);
        fos.write('\r');
        fos.write('\n');

        //向目标文件中写入一个字节数组
        byte[] buffer = {98, 99, 100};
        fos.write(buffer);

        //向目标文件中写入一个字节数组的一部分
        //                   offset
        byte[] bytes = {105, 106, 107, 108};

        fos.write(bytes, 1, 3);


        //释放系统资源
        fos.close();


    }
}
