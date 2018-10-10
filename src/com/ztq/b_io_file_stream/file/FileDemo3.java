package com.ztq.b_io_file_stream.file;

/*
    创建功能：
    //在操作系统上创建文件
    public boolean createNewFile()

    //创建目录
    public boolean mkdir()
    public boolean mkdirs()


    public boolean delete()
    删除此抽象路径名表示的文件或目录。
    如果此路径名表示一个目录，则该目录必须为空才能删除。

    重命名功能
        public boolean renameTo(File dest)

 */

import java.io.File;
import java.io.IOException;

public class FileDemo3 {

    public static void main(String[] args) throws IOException {
        File file = new File("f:\\b.txt");
        System.out.println(file.exists());

        // public boolean createNewFile() 创建文件
        boolean newFile = file.createNewFile();
        System.out.println(newFile);

        //public boolean mkdir()
        File file1 = new File("f:\\show\\go");

        //创建目录  对于mkdir来讲，如果父目录目录路径中，至少有一个目录并不真实存在，目录创建失败
        //file1.mkdir();

        //当父目录路径中有不存在的目录时，会自动创建不存在父目录路径的目录，在父目录路径下创建目标目录
        file1.mkdirs();

        //删除f:\\b.txt
        //file.delete();

        //删除一个不存在与操作系统上的文件
        File file2 = new File("f:\\d.txt");
        System.out.println(file2.delete());


        //重命名功能 重新命名此抽象路径名表示的文件
        file.renameTo(new File("f:\\c.txt"));

    }
}
