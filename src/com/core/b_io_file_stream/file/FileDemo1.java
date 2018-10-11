package com.core.b_io_file_stream.file;

/*
     在操作系统上，所有的数据，只有一种存在形式，
     数据在硬盘上就是以文件的形式存储的

     File：
     文件和目录路径名的抽象表示形式

        File(String pathname)   pathName：是指用字符串表示的，文件在操作系统上的路径

 */

import java.io.File;

public class FileDemo1 {

    public static void main(String[] args) {
        //这个文件对象，就是表示操作系统上路径为 f:\\a.txt
        //f:\\a.txt就是字符串表示的路径名

        File file = new File("f:\\a.txt");

        //File类对象，只是路径名的抽象表示形式
        // 即使该文件在操作系统上并不物理存在，也可以创建这个路径所表示的File对象
        File file1 = new File("f:\\b.txt");

        //file类对象中有个方法 exists方法，它可以判断，file所表示的文件在操作系统
        //上是否真的存在

        System.out.println(file.exists() +  "---" + file1.exists());



    }
}
