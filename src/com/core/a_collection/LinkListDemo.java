package com.core.a_collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkListDemo {
    public static void main(String[] args) {
        List<String> linkedList = new LinkedList<>();

        linkedList.add("张三");
        linkedList.add("李四");
        linkedList.add("王五");


        Iterator iterator = linkedList.iterator();
        System.out.println(iterator);

        String first = (String) iterator.next();
        System.out.println("first = " + first);


    }
}
