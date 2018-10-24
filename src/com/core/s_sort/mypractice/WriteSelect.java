package com.core.s_sort.mypractice;

import org.junit.Test;

import java.util.Arrays;

public class WriteSelect {


    @Test
    public void testSort() {
        Integer[] arr = {4, 8, 22, 1, 9, 312, 6};

        System.out.println(Arrays.toString(arr));

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    private void swap(Integer[] arr, int a, int b) {
        Integer temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }


    //在这里写排序代码
    public void sort(Integer[] nums) {


    }



}
