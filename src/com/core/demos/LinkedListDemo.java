package com.core.demos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo {

    static LinkedList linkedList;

    static {
        linkedList = new LinkedList();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");
        linkedList.add("F");
        linkedList.add("C");

    }

    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        ListIterator listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            Object next = listIterator.next();

            boolean add = hashSet.add(next);

           if (add==false){
               System.out.println("huan zai "+next);
           }
            System.out.println("next = " + next);

        }

    }
}
