package com.core.z_demos;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashDemo {
    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }



    @Test
    public void  demooo(){
        HashSet hashSet = new HashSet();
        boolean add = hashSet.add(1);
        System.out.println("add = " + add);
        boolean add2 = hashSet.add(1);
        System.out.println("add2 = " + add2);


    }



    @Test
    public void demo() {

//        for (int cap = 0; cap < 16; cap++) {
//            System.out.println("CAP="+cap+"      tableSizeFor="+tableSizeFor(cap));
//
//        }

        int cap = 0;
        System.out.println("CAP=" + cap + "      tableSizeFor=" + tableSizeFor(cap));


    }

    public static void main(String[] args) {

        Map map = new ConcurrentHashMap();


        Map hashMap = new HashMap(1, 0.75f);

        hashMap.put(1, 2);
        hashMap.put(1, 3);
        hashMap.get(1);


        int a = 3;

        System.out.println("a = " + a);


        int i = tableSizeFor(1);
        System.out.println("i = " + i);


    }

}
