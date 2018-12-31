package com.core.sort.tradition.selection;

import com.core.sort.SortUtil;

import java.util.Arrays;

/**
 * @author Tianqi.Zhang
 * @date 2018/12/29
 * @time 16:11
 * @package com.core.sort.tradition.selection
 * @project 1008MyDemo
 * @description
 */
public class MySelection {


    public static void main(String[] args) {
        int[] array = SortUtil.generateArray();
        System.out.println(Arrays.toString(array)+"新年快乐");
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectionSort(int[] array) {
        // 每一轮选出最大的放在最后
        // length个数据 一共length-1 轮 （如2个元素 需要排序1次）
        int length = array.length;

        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(array));
            // 第i轮 此轮会将第length-i位置的元素排好
            // 最大值和下标
            int bigValue = array[0];
            int bigIndex = 0;
            for (int j = 0; j < length - i; j++) {
            /*
                应该通过这层循环 找出这轮最大值
             */
                if (array[j] > bigValue) {
                    bigValue = array[j];
                    bigIndex = j;
                }
                System.out.println("j = " + j + " length - i -1 = " + (length - i - 1));
                if (j == length - i - 1) {
                    System.out.println();
                    SortUtil.swap(array, bigIndex, j);
                }
            }
        }
    }
}
