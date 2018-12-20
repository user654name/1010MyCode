package com.core.collection.collectiondemo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tianqi.Zhang
 * @date 2018/12/19
 * @time 14:24
 * @package com.core.collection.collectiondemo
 * @project 1008MyDemo
 * @description
 */
public class HashMapInit {
    public static void main(String[] args) {
        Map map = new HashMap(16);
        for (int i = 0; i <20 ; i++) {
            map.put(i,i);
            System.out.println("size = " + map.size());
        }


    }


}
