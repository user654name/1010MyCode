package com.core.sort;

/**
 * @author Tianqi.Zhang
 * @date 2018/12/29
 * @time 15:41
 * @package com.core.sort
 * @project 1008MyDemo
 * @description
 */
public class SortUtil {

    public static int[] generateArray() {
        return new int[]{3, 7, 1, 6, 5, 4, 8, 0, 4};
    }


    /**
     *
     * @param oldArr      插入的数组
     * @param insertValue 插入的值
     * @param insertIndex 插入的位置
     * @return 插入好的数组
     */
    public static int[] insert(int[] oldArr,int insertValue, int insertIndex) {
        int oldLength = oldArr.length;
        int newLength = oldLength + 1;
        if (oldLength <= insertIndex) {
            return null;
        }
        int[] newArr = new int[newLength];
        for (int i = 0; i < newLength; i++) {
            if (i < insertIndex) {
                // 插入位置之前的——原位放入
                newArr[i] = oldArr[i];
            } else if (i == insertIndex) {
                // 插入的位置——将插入值放入
                newArr[i] = insertValue;
            } else {
                // 插入位置之后的——错位放入
                newArr[i] = oldArr[i-1];
            }
        }


        return null;
    }

    /**
     * 交换
     */
    public static void swap(int[] target, int iIndex, int jIndex) {
        int temp = target[iIndex];

        target[iIndex] = target[jIndex];

        target[jIndex] = temp;
    }

    /**
     * 交换
     */
    public static void swap(int[] target, int iIndex) {
        int temp = target[iIndex];
        int jIndex = iIndex + 1;

        target[iIndex] = target[jIndex];

        target[jIndex] = temp;
    }
}
