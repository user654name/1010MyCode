package com.core.c_collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class CollectionTest {
    public static void main(String[] args) {
        Collection treeSet = new TreeSet();

        treeSet.add(1);
        treeSet.add(1);

        treeSet.add(222);
        treeSet.add(222);
        treeSet.add(22);
        treeSet.add(2);


        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println("treeSet= " + next);
        }

        Collection hashSet = new HashSet();
        hashSet.add(1);
        hashSet.add(13213);
        hashSet.add(123);

        Iterator iterator1 = hashSet.iterator();
        while(iterator1.hasNext()) {
            Object next1 = iterator1.next();
            System.out.println("hashSet = " + next1);
        }

    }
}
