package com.core.iostream.file;

/*
    1.判断目录下是否有以后缀名为.jpg结尾的文件，如果有就输出此文件的文件名

 */

import java.io.File;

public class Excersise {

    public static void main(String[] args) {

        File show = new File("y:\\");
        String houzhui = ".doc";


        searcFileName(show, houzhui);

    }

    //抽出方法，包装一下
    private static void searcFileName(File show, String houzhui) {
        long l1 = System.currentTimeMillis();
        System.out.println("正在查找");


        //递归查找，当前下满足条件的文件或者目录
        findRecursively(show, houzhui);


        long l2 = System.currentTimeMillis();

        long time = l2 - l1;
        System.out.println("此次遍历用时 " + time + "毫秒");
    }

    //递归查找，指定目录下满足条件的文件或者目录
    public static void findRecursively(File dir, String houzhui) {
        //递归查找
        File[] childs = dir.listFiles();


        if (childs == null) {
            //当前的dir实际上代表的是一个文件
            return;//返回，如果是递归调用的话，返回调用的那个位置继续执行（嘿嘿）
        }

        for (File child : childs) {
            if (child.isFile()) {
                //该file对象是一个文件
                if (child.getName().endsWith(houzhui)) {
                    System.out.println(child.getName());
                }
            } else {
                //当前的file对象是个目录，递归
                findRecursively(child,houzhui);
            }
        }


    }
}