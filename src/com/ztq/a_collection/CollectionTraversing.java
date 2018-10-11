package com.ztq.a_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionTraversing {


    static void traversingIterator(List list) {


        long l1 = System.currentTimeMillis();

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(" e = " + iterator.next());
        }


        long l2 = System.currentTimeMillis();
        long time = l2 - l1;
        System.out.println();

        System.out.println("traversingIterator遍历耗时=" + time);


    }

    static void traversingForEach(List list) {

        long l1 = System.currentTimeMillis();
        for (Object o : list) {
            System.out.print("o = " + o);
        }
        long l2 = System.currentTimeMillis();
        long time = l2 - l1;

        System.out.println();
        System.out.println("traversingForEach方法遍历耗时=" + time);

    }


    static void addToList(List list) {

        for (int i = 0; i < 999999; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {

        List list = new ArrayList();

        //构造List
        addToList(list);

        //遍历  foreach
        traversingForEach(list);


        //遍历 迭代器
        traversingIterator(list);

    }


}
