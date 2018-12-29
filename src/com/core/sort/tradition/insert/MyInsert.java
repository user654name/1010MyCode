package com.core.sort.tradition.insert;

import com.core.sort.SortUtil;

import java.util.Arrays;

/**
 * @author Tianqi.Zhang
 * @description 插入排序
 * 1    将待排序序列第一个元素看做一个有序序列，
 * 把第二个元素到最后一个元素当成是未排序序列。
 * 2    从头到尾依次扫描未排序序列，
 * 将扫描到的每个元素插入有序序列的适当位置。
 * （如果待插入的元素与有序序列中的某个元素相等，
 * 则将待插入元素插入到相等元素的后面。）
 * @date 2018/12/29
 * @time 16:46
 * @package com.core.sort.tradition.insert
 * @project 1008MyDemo
 */
public class MyInsert {
    public static void main(String[] args) {
        int[] array = SortUtil.generateArray();
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertSort(int[] array) {
        // 有序
        int[] ordered = new int[]{array[0]};
        // 无序
        int[] unordered = new int[array.length - 1];

        for (int i = 0; i < unordered.length; i++) {
            unordered[i]  = array[i + 1];
        }


        // 遍历无序的 讲每个元素插入到适当位置
        for (int i = 0; i < unordered.length; i++) {
            System.out.println("ordered = " + Arrays.toString(ordered));
            System.out.println("unordered = " + Arrays.toString(unordered));

            for (int index = 0; index < ordered.length; index++) {
                if (unordered[i] < ordered[index]) {
                    // 插入到数组
                    ordered = SortUtil.insert(ordered, unordered[i], i);
                }
            }
        }

    }
}
