package com.ztq.a_hash;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {


    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add("1");
        list.add(1);
        list.add("2");


        List sonList = new ArrayList();
        sonList.add(1);

//        boolean contains1 = list.contains(1);
//        boolean contains2 = list.contains(2);
//        System.out.println("contains1 = " + contains1);
//        System.out.println("contains2 = " + contains2);

        boolean b = list.containsAll(sonList);
        sonList.add(312);

        System.out.println("b = " + b);
        boolean b2 = list.containsAll(sonList);
        System.out.println("b2 = " + b2);





//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println("元素" + iterator.next());
//        }
    }
}
