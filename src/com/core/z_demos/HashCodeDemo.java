package com.core.z_demos;

import java.util.HashMap;
import java.util.Objects;

public class HashCodeDemo {

    public static void main(String[] args) {
//
//        String s = new String("s");
//        int i = s.hashCode();
//        System.out.println("i = " + i);
//
//        String t = new String("t");
//        int i1 = t.hashCode();
//        System.out.println("i1 = " + i1);
//
//        int hash = Objects.hash(1, 2, 4);
//        System.out.println("hash = " + hash);

        HashMap hashMap = new HashMap();
        hashMap.put(null, 1);
        Object o = hashMap.get(null);
        hashMap.clear();
        Object o1 = hashMap.get(null);
        System.out.println("o = " + o);
        System.out.println("o1 = " + o1);
    }
}
