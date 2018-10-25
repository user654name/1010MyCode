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
 /*
    1 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
    2 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
    3 重复第二步，直到所有元素均排序完毕。*/

    //在这里写排序代码
    public void sort(Integer[] nums) {

        int length = nums.length;

        for (int i = 0; i < length - 1; i++) {

            int min = i;
            //得未排序序列里到最小的数字 的位置
            for (int j = i; j < length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }

    }



}
