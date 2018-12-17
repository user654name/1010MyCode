package com.core.base_api;

import java.util.ArrayList;
import java.util.List;

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
}
