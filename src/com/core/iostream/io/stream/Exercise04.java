package com.core.iostream.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise04 {

    public static void main(String[] args) {

        try {

            //先创建，文件输入流对象，指向要复制的源文件
            FileInputStream fis = new FileInputStream("e:\\myshoe.mp4");

            //创建，文件输出流对象，指向要复制的目标文件
            FileOutputStream fos = new FileOutputStream("copy.mp4");

            //一遍从源文件里读内容，一遍将读取到的源文件的内容，写到目标文件中
            byte[] buffer = new byte[1024];
            int len = -1;

            while ((len = fis.read(buffer))!= -1) {

                fos.write(buffer,0,len);
            }

            //我这种写法
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
