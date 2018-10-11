package com.core.b_io_file_stream.file;

/*
        基本获取功能：
        public File getAbsolutePath()
        public String getPath()
        public String getName()
        public long length()
        public long lastModified()

        高级获取功能
        public String[] list()
        如果此抽象路径名不表示一个目录，那么此方法将返回 null
        返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。
        不会递归的获取，子目录中的信息（文件，或者目录的名称）

        public File[] listFiles()

        //更高级的用法
        File[] listFiles(FileFilter filter)

        FileFileter是接口：功能指明，文件过滤的过滤条件
        用于抽象路径名的过滤器

        boolean accept(File pathname)  返回true满足条件
                                       返回false不满足过滤条件

 */

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileDemo4 {

    public static void main(String[] args) {

        File go = new File("f:\\show", "go");
        //getPath() 和 getAbsolutePath()效果相同
//        System.out.println(go.getPath());
//        System.out.println(go.getAbsolutePath());

        //对于默认的相对路径，所表示的文件：
        // getPath() 获取的只是文件名
        // getAbsolutePath() 仍旧可以获取到绝对路径名
        File c = new File("c.txt");
//        System.out.println(c.getPath());
//        System.out.println(c.getAbsolutePath());


        //获取目录的名称
//        System.out.println(go.getName());
//        //获取文件的名称
//        System.out.println(c.getName());


        //获取文件的大小 此抽象路径名表示的文件的长度，以字节为单位
//        System.out.println(c.length());

        //高级获取功能
        File file = new File("f:\\show");

//        String[] list = file.list();
//        System.out.println(Arrays.toString(list));

        File[] files = file.listFiles();

        //System.out.println(Arrays.toString(findTxt(files)));


        //利用文件过滤器，来筛选目标文件

        File[] txts = file.listFiles(new FileFilter() {

            //指明了过滤条件
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() && pathname.getName().endsWith("txt");
            }
        });

        System.out.println(Arrays.toString(txts));

    }

    /*
            对于一个目录下，文件或文件目录的筛选工作代码：
            1. 不变 筛选的过程是不变
            2. 变化 筛选条件
     */
    private static File[] findTxt(File[] files) {

        List<File> resultSet = new ArrayList<>();
        for (File file : files) {

            if(file.isDirectory() && file.getName().endsWith("txt")) {
                resultSet.add(file);
            }
        }
        File[] files1 = resultSet.toArray(new File[resultSet.size()]);
        return files1;
    }
}
