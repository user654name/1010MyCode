package com.core.s_sort.mypractice;

import org.junit.Test;

import java.util.Arrays;

public class WriteBubble {

    @Test
    public void testSort() {
        Integer[] arr = {4, 8, 22, 1, 9, 312, 6};

        System.out.println(Arrays.toString(arr));

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(Integer[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {


            for (int j = 0; j < nums.length - 1 - i; j++) {


                if (nums[j] > nums[j + 1]) {
                    Integer temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                }

            }

        }

    }


}

