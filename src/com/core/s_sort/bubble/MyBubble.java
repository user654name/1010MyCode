package com.core.s_sort.bubble;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.junit.Test;

import java.util.Arrays;

public class MyBubble {

    //看到冒泡好陌生啊2018年12月4日 16:10:17
    @Test
    public void testSort() {

        int[] array = {3, 5, 2, 8, 123};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    void sort(int[] nums) {


        int length = nums.length;


        for (int i = 0; i < length - 1; i++) {

            for (int j = 0; j < length - i -1; j++) {

                //改变这里符号可以变为顺序或者逆序
                if (nums[j] > nums[j + 1]) {

                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                }



            }


        }
    }

}
