package com.core.iostream.io.stream.output;

/*
        加入异常处理的IO流操作

        向c.txt写入hello,stream
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamDemo4 {

    public static void main(String[] args) {

        //1.创建文件输出流对象
        FileOutputStream fos = null;
        try {
             fos = new FileOutputStream("c.txt");

            //利用write方法，将数据写入
            fos.write("hello.stream".getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放流资源的代码，都写在finally代码块中
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
