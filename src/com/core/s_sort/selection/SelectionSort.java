package com.core.s_sort.selection;

public class SelectionSort {

    //选择排序，第i次比较，找到第i小的元素，把它放在第i个位置
    public static int[] selectionSort(int[] arr) {

        //对n个元素的待排序序列，经过n-1次比较过程即可
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }

        }
        return arr;
    }
}