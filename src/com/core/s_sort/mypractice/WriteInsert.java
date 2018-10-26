package com.core.s_sort.mypractice;

import org.junit.Test;

import java.util.Arrays;

public class WriteInsert {


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

    /*
    1 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
    2 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
     （如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
     */
    //在这里写排序代码
    public void sort(Integer[] nums) {
        int length = nums.length;


        for (int i = 1; i < length; i++) {


            for (int j = 0; j <i; j++) {
                if (nums[i]<nums[j]){
//                    insert();
                 }

            }

        }


    }

}
