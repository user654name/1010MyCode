package com.core.sort.tradition.bubble;

import com.core.sort.ArraySort;
import org.junit.Test;

import java.util.Arrays;

import static com.core.sort.tradition.bubble.BubbleSort.swap;

public class MyBubble implements ArraySort {

    /**
     * 看到冒泡好陌生啊2018年12月4日 16:10:17
     */
    @Test
    public void testSort() throws Exception {

        int[] array = {3, 5, 2, 8, 123, -4, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int length = sourceArray.length;

        // 1 对相邻的两个数比大小，若左大于右则交换
        // 2 一趟下来 使得右面的数字最大
        // 3 下一趟不用比较右数第一个

        // 第i趟比较 排好右数第i号元素
        for (int i = 1; i <= length-1; i++) {
            System.out.println(Arrays.toString(sourceArray));

            for (int j = 0; j < length - i; j++) {

                if (sourceArray[j] > sourceArray[j + 1]) {
                    swap(sourceArray, j, j + 1);
                }

            }
        }


        return new int[0];
    }



}
