package com.core.i_io_file_stream.io.stream.output;

/*

         OutputStream的核心方法：

         void write(byte[] b)
          将 b.length 个字节从指定的 byte 数组写入此输出流。

        void write(byte[] b, int off, int len)
          将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。

        abstract  void write(int b)

          将指定的字节写入此输出流。
          将指定的字节写入此输出流。write 的常规协定是：向输出流写入一个字节。
          要写入的字节是参数 b 的八个低位。b 的 24 个高位将被忽略。

          public void close()
           throws IOException
           关闭此输出流并释放与此流有关的所有系统资源。close
           的常规协定是：该方法将关闭输出流。
           关闭的流不能执行输出操作，也不能重新打开。
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamDemo2 {

    public static void main(String[] args) throws IOException {

        //创建输出流对象

        //1.创建表示目标文件的File类对象
        File file = new File("b.txt");

        //1.创建FileOutputStream对象
        FileOutputStream fos = new FileOutputStream(file);

        //2.向目标文件中写入数据
        fos.write(97);
        fos.write('\n');

        //向目标文件中写入一个字节数组
        byte[] buffer = {98, 99, 100};
        fos.write(buffer);

        //向目标文件中写入一个字节数组的一部分
        //                   offset
        byte[] bytes = {105, 106, 107,108};

        fos.write(bytes, 1, 3);


        //释放系统资源
        fos.close();

    }
}
