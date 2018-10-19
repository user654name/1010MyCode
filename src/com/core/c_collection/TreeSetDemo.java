package com.core.c_collection;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();

        boolean add = treeSet.add(1);
        System.out.println("add = " + add);
        boolean add1 = treeSet.add(1);
        System.out.println("add1 = " + add1);

        HashMap hashMap = new HashMap();
        hashMap.put(1,1);
        hashMap.put(2,1);

        TreeMap treeMap = new TreeMap();
        treeMap.putAll(hashMap);
        

    }
}
