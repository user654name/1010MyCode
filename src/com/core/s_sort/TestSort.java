package com.core.s_sort;

import com.core.s_sort.bubble.BubbleSort;
import com.core.s_sort.mypractice.WriteSingleton;
import com.core.s_sort.selection.SelectionSort;
import org.junit.Test;

import java.util.Arrays;

public class TestSort {

    @Test
    //冒泡排序测试
    public void testBubble() {
        int[] nums = new int[]{3, 7, 1, 6, 5, 4, 8, 0, 4};

        BubbleSort.bubbleSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    @Test
    //选择排序测试
    public void testSelect() {
        int[] nums = new int[]{3, 7, 1, 6, 5, 4, 8, 0, 4};

        SelectionSort.selectionSort(nums);

        System.out.println(Arrays.toString(nums));

    }

    @Test
    public void demo99(){

        WriteSingleton writeSingleton = WriteSingleton.getInstance();

        System.out.println(writeSingleton);
    }
}
