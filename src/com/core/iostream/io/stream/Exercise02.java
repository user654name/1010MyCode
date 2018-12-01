package com.core.iostream.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/*
*
*       try-with-resource 语句
*
*              try(放申请资源的语句){

        }catch() {
        }

        一旦资源的申请放在try-with-resource语句的（）中，那么资源会保证一定自动被释放
*
*
* */

public class Exercise02 {


    public static void exercise01() {

        try (
                //申请资源的语句
                FileInputStream fis = new FileInputStream("c:\\a.txt");
                FileOutputStream fos = new FileOutputStream("d:\\b.txt");
                //int i = 100; 普通的不是申请资源的语句，不能写在（）里面
        ) {

            //从源文件中读取要复制的内容
            byte[] buffer = new byte[2048];
            int length = -1;
            while ((length = fis.read(buffer)) != -1) {

                //因为利用fis.read(buffer)，流中的一部分数据已经读取到了buffer数组中

                //所以我们只需要再将，buffer中的复制内容，写入目标文件就可以完成一次复制过程
                //一定要使用write(byte[] b, int off, int len)写入
                fos.write(buffer, 0, length);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
