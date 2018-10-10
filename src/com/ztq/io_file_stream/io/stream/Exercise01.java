package com.ztq.io_file_stream.io.stream;

/*

        1.把c:\\a.txt内容复制到d:\\b.txt中
        2.把e:\\**.jpg内容复制到当前项目目录下的mn.jpg中
        3.把e:\\***.mp4复制到当前项目目录下的copy.mp4中


        1.第一种释放资源的方式  closeQuietly
        2.jdk7 中引入的 try-with-resource语句





 */

import java.io.*;

public class Exercise01 {

    public static void main(String[] args) {

        exercise01();
    }


    //把c:\\a.txt内容复制到d:\\b.txt中
    public static void exercise01() {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //创建文件输入流对象，指向要复制的源文件
            fileInputStream = new FileInputStream("c:\\a.txt");

            //创建输出流对象，指向复制的目标文件
            fileOutputStream = new FileOutputStream("d:\\b.txt");

            //从源文件中读取要复制的内容
            byte[] buffer = new byte[2048];
            int length = -1;
            while((length = fileInputStream.read(buffer)) != -1) {

                //因为利用fileInputStream.read(buffer)，流中的一部分数据已经读取到了buffer数组中

                //所以我们只需要再将，buffer中的复制内容，写入目标文件就可以完成一次复制过程
                //一定要使用write(byte[] b, int off, int len)写入
                fileOutputStream.write(buffer, 0, length);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//
//            //释放输入流资源
//            closeQuietly(fileInputStream);
//
//            //释放输出流对象
//            closeQuietly(fileOutputStream);
//
//        }
    }

    private static void closeQuietly(Closeable close) {
        if(close != null) {
            try {
                close.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
