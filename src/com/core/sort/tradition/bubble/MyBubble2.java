package com.core.sort.tradition.bubble;

import com.core.sort.SortUtil;

import java.util.Arrays;

/**
 * @author Tianqi.Zhang
 * @date 2018/12/29
 * @time 15:47
 * @package com.core.sort.tradition.bubble
 * @project 1008MyDemo
 * @description
 */
public class MyBubble2 {

    public static void main(String[] args) {
        int[] arr = SortUtil.generateArray();
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void sort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (arr[j]>arr[j+1]){
                    SortUtil.swap(arr, j);
                }
            }
        }

    }
}
