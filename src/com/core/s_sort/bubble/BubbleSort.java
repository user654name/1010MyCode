package com.core.s_sort.bubble;

import org.junit.Test;

import java.util.Arrays;


public class BubbleSort {


    //冒泡排序
    public static void bubbleSort(int[] numbers) {

        boolean flag = true; //表示，在一趟排序过程中是否，发生了交换
        //当在没有玩成第n-1趟的比较之前，如果所有元素已经排好序，此时flag就会终止
        //接下来的比较

        //双重循环完成冒泡排序 o(n^2)
        for (int i = 0; i < numbers.length - 1 && flag; i++) {
            System.out.println("第" + (i + 1) + "次排序");

            flag = false;
            //外层循环控制，比较的趟数
            for (int j = numbers.length - 1; j > i; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    swap(numbers, j, j - 1);
                    flag = true;
                    System.out.println(Arrays.toString(numbers));
                }
            }

        }
    }


    //错误的排序
    //冒泡排序
//    public static void bubbleSortFromLeft(int[] numbers) {
//
//        boolean flag = true; //表示，在一趟排序过程中是否，发生了交换
//        //当在没有玩成第n-1趟的比较之前，如果所有元素已经排好序，此时flag就会终止
//        //接下来的比较
//
//        //外层 第i轮
//        for (int i = 0; i < numbers.length - 1 && flag; i++) {
//
//
//            System.out.println("第" + (i + 1) + "次排序");
//
//            flag = false;
//            //外层循环控制，比较的趟数
//            for (int j = i; j < numbers.length-1; j++) {
//                if (numbers[j] > numbers[j + 1]) {
//
//                    swap(numbers, j, j + 1);
//                    flag = true;
//                    System.out.println(Arrays.toString(numbers));
//
//                }
//            }
//            System.out.println(Arrays.toString(numbers));
//
//        }
//    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{5, 3, 4, 2, 1};
        bubbleSort(nums);



    }



    public static void swap(int[] target, int iIndex, int jIndex) {

        int temp = target[iIndex];

        target[iIndex] = target[jIndex];

        target[jIndex] = temp;
    }
}

