package com.core.base_api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Tianqi.Zhang
 * @date 2018/12/17
 * @time 13:18
 * @package com.core.base_api
 * @project 1008MyDemo
 * @description
 */
public class ForLoop {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList();

        for (int i = 0; i <15 ; i++) {
            list.add(i);
        }


        for (Integer integer : list) {
            System.out.println("当前是 = " + integer);
            if (integer==7){
                System.out.println("找到了7");
                continue;

            }
            System.out.println(324);

        }



    }

    @Test
    public void randomNumber(){
        Random random = new Random();
        int[] ints = random.ints(200, 0, 30).toArray();
        for (int anInt : ints) {
            System.out.print(" | " + anInt);
        }


    }
}
