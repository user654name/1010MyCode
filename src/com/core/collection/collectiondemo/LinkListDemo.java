package com.core.collection.collectiondemo;

import java.util.LinkedList;
import java.util.List;

public class LinkListDemo {
    public static void main(String[] args) {
        List<String> linkedList = new LinkedList<>();

        linkedList.add("张三");
        linkedList.add("李四");
        linkedList.add("王五");


//        Iterator iterator = linkedList.iterator();
//        System.out.println(iterator);

//        String first = (String) iterator.next();
//        System.out.println("first = " + first);

        //不熟悉的构造方法
        List list = new LinkedList(linkedList);


        LinkedList linkedList1 = new LinkedList();

        for (Object o : list) {
            System.out.println("o = " + o);
        }
    }
}
