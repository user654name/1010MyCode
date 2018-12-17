package com.core.io.stream.io.stream.input;

/*
           InputStream: 此抽象类是表示字节输入流的所有类的超类。

           核心方法：

           读方法
           abstract  int read()
          从输入流中读取数据的下一个字节。
           int read(byte[] b)
                  从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。

           int read(byte[] b, int off, int len)
                  将输入流中最多 len 个数据字节读入 byte 数组。

          关闭此输入流并释放与该流关联的所有系统资源

          FileInputStream(File file)
          通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的 File 对象 file 指定。

          FileInputStream(String name)
          通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的路径名 name 指定。

 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo1 {
    public static void main(String[] args) {


        InputStream is = null;
        try {
            //1.创建文件输入流对象

            //创建一个FileInputStream对象，也做了三件事情
            //1. 先在操作系统上，找是否存在该文件，如果存在啥也做做，
            //   不过不存在，直接抛出异常FileNotFoundException
            //2. 创建FileInputStream对象
            //3. 让FiltInputStream指向要读取的目标文件
             is = new FileInputStream("c.txt");

            //利用read方法从文件中读取内容

//            第一种方式：一次读取一个字节数据
//            int read = -1;
//            while((read = is.read()) != -1) {
//                System.out.print((char)read);
//            }


//            第二种方式：一次读取一个字节数组
//            字节数组的大小一般为1024的整数倍
              byte[] buffer = new byte[1024]; //x kb

              int length = -1;

              String s = null;
              while((length = is.read(buffer)) != -1) {
                  s = new String(buffer,0, length);
                  System.out.println("s = " + s + " -- " + ("abcdefg".equals(s)));
              }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
