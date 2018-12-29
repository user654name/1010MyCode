package com.core.sort.tradition.bubble;

import org.junit.Test;

import java.util.Arrays;

public class WriteBubble {

    @Test
    public void testSort() {
        Integer[] arr = {4, 8, 22, 1, 736, 9, 312, 6};

        System.out.println(Arrays.toString(arr));

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void swap(Integer[] arr, int a, int b) {
        Integer temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    public void sort(Integer[] nums) {

        //第i次比较，使得倒数第i位有序
        for (int i = 1; i < nums.length; i++) {

            //从位置j开始，比较至未排序列的末尾
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j+1])
                    swap(nums, j, j+1);
            }


        }

    }




}

