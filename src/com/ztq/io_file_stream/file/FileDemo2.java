package com.ztq.io_file_stream.file;

/*
        File的构造方法：

        File(String pathname)
        File(String parent, String child)
        File(File parent, String child)

        无论是抽象路径名还是路径名字符串，都可以是绝对 路径名或相对 路径名。
        绝对路径名是完整的路径名，不需要任何其他信息就可以定位它所表示的文件

        绝对路径：
        对于 Microsoft Windows 平台，包含盘符的路径名前缀由驱动器号和一个 ":" 组成。
        如果路径名是绝对路径名，还可能后跟 "\\"

        相对路径：在windows上没有盘符前缀
 */

import java.io.File;

public class FileDemo2 {

    public static void main(String[] args) {
        // File(String pathname)
        File fileAbs = new File("d:\\a.txt");
        System.out.println(fileAbs.getAbsolutePath());

        //默认情况下，java.io 包中的类都相对于系统属性 user.dir
        File fileRelative = new File("a.txt");
        System.out.println(fileRelative.getAbsolutePath());

        //获取java虚拟机的系统属性"user.dir"
        System.out.println(System.getProperty("user.dir"));


        //File(String parent, String child)
        //parent: 文件相对的父路径的路径名
        //chile:  相对于符目录路径下的文件名
        File file = new File("d:\\", "a.txt");
        System.out.println(file.exists());

        //File(File parent, String child)
        //表示父目录路径File实例
        File parent = new File("f:");
        File child = new File(parent, "a.txt");
        System.out.println(child.exists());


    }
}
