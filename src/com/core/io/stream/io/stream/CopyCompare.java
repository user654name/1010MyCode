package com.core.io.stream.io.stream;

import java.io.*;

/*

        把d:\\**.mp4复制到当前项目目录下的copy.mp4中
        四种方式比较复制效率

        1. 普通一次读写一个字节
        2. 普通流一次读写一个字节数组
        3. 缓冲流一次读写一个字节
        4. 缓冲流一次读写一个字节数组


        copyFileByte duration: 117936
        copyBuffedByte duration: 556
        copyFileBytes duration: 284
        copyBufferedBytes duration: 145

 */
public class CopyCompare {

    public static void main(String[] args) throws IOException {

        copyFileByte();

        copyBuffedByte();

        copyFileBytes();


        copyBufferedBytes();


    }


    //普通一次读写一个字节
   public static void copyFileByte() throws IOException {
       FileInputStream fis = new FileInputStream("e:myshoe.mp4");

       FileOutputStream fos = new FileOutputStream("copy01.mp4");

       int read = -1;

       long start = System.currentTimeMillis();
       while((read = fis.read()) != -1) {
           fos.write(read);
       }

       long duration = System.currentTimeMillis() - start;
       System.out.println("copyFileByte duration: " + duration);

       fis.close();
       fos.close();

   }

   // 缓冲流一次读写一个字节
   public static void copyBuffedByte() throws IOException {
       FileInputStream fis = new FileInputStream("e:\\myshoe.mp4");
       BufferedInputStream bis = new BufferedInputStream(fis);

       FileOutputStream fos = new FileOutputStream("copy02.mp4");
       BufferedOutputStream bos = new BufferedOutputStream(fos);


       int read = -1;

       long start = System.currentTimeMillis();
       while((read = bis.read()) != -1) {
           bos.write(read);
       }
       long duration = System.currentTimeMillis() - start;
       System.out.println("copyBuffedByte duration: " + duration);
       bis.close();
       bos.close();
   }

   //普通流一次读写一个字节数组
   public static void copyFileBytes() throws IOException {
       FileInputStream fis = new FileInputStream("e:\\myshoe.mp4");

       FileOutputStream fos = new FileOutputStream("copy03.mp4");


       int len = -1;
       byte[] buffer = new byte[1024];
       long start = System.currentTimeMillis();
       while((len = fis.read(buffer)) != -1) {
           fos.write(buffer, 0, len);
       }
       long duration = System.currentTimeMillis() - start;
       System.out.println("copyFileBytes duration: " + duration);
       fis.close();
       fos.close();

   }

   //缓冲流一次读写一个字节数组
    public static void copyBufferedBytes() throws IOException {
        FileInputStream fis = new FileInputStream("e:\\myshoe.mp4");
        BufferedInputStream bis = new BufferedInputStream(fis);


        FileOutputStream fos = new FileOutputStream("copy04.mp4");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int len = -1;
        byte[] buffer = new byte[1024];
        long start = System.currentTimeMillis();
        while((len = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println("copyBufferedBytes duration: " + duration);
        bis.close();
        bos.close();
    }

}
