package com.core.s_sort.mypractice;

import org.junit.Test;

import java.util.Arrays;

public class WriteBubble2 {

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

        //第i次 将倒数第i个位置元素排序
        for (int i = 1; i < nums.length; i++) {


            for (int j = 0; j < nums.length - i; j++) {

        //2018年11月3日 16:25:38
            }

        }


    }


}

