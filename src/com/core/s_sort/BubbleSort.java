package com.core.s_sort;

import org.junit.Test;

import java.util.Arrays;


public class BubbleSort {




    //冒泡排序
    public static void bubbleSort(int[] target) {

        boolean flag = true; //表示，在一趟排序过程中是否，发生了交换
        //当在没有玩成第n-1趟的比较之前，如果所有元素已经排好序，此时flag就会终止
        //接下来的比较

        //双重循环完成冒泡排序 o(n^2)
        for (int i = 0; i < target.length - 1 && flag; i++) {

            flag = false;
            //外层循环控制，比较的趟数
            for (int j = target.length - 1; j > i; j--) {
                if (target[j] < target[j - 1]) {
                    swap(target, j, j - 1);
                    flag = true;

                }
            }
            System.out.println(Arrays.toString(target));

        }
    }


    public static void swap(int[] target, int iIndex, int jIndex) {

        int temp = target[iIndex];

        target[iIndex] = target[jIndex];

        target[jIndex] = temp;
    }
}

