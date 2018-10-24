package com.core.s_sort.mypractice;

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

        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {

            for (int j = 0; j < length - 1 - i; j++) {

                if (nums[j] > nums[j + 1]) {
                    swap(nums, j + 1, j);
                }

            }

        }
    }




}
