package com.core.s_sort;

import static com.core.s_sort.BubbleSort.swap;

public class SelectSort {




    //选择排序，第i次比较，找到第i小的元素，把它放在第i个位置
    public static void selectSort(int[] target) {

        for (int i = 0; i < target.length - 1; i++) {
            //对n个元素的待排序序列，经过n-1次交换过程即可
            //通过getMin方法，找到无序序列中的最小值，和第i个位置的值进行交换
            int minIndex = getMin(target, i);
            swap(target, i, minIndex);
        }

    }

    private static int getMin(int[] target, int start) {

        int minIndex = start;
        int min = target[start];
        for(int i = start + 1; i < target.length; i++) {
            if(target[i] < min) {
                min = target[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

}
