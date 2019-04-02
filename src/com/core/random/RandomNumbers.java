package com.core.random;

import java.util.Random;

/**
 * @author Tianqi.Zhang
 * @date 2019/4/2
 * @time 9:51
 * @package com.core.random
 * @project 1008MyDemo
 * @description
 */
public class RandomNumbers {
    public static void main(String[] args) {
        int[] ints = new Random().ints(20, 0, 30).toArray();
        for (int i = 0; i < ints.length; i++) {
            System.out.println( i+1+" "+ints[i]);
        }
    }
}
