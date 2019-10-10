package com;

import java.util.HashMap;

/**
 * @author Tianqi.Zhang
 * @date 2019/8/27
 * @time 15:16
 * @package com
 * @project 1008MyDemo
 * @description
 */
public class TTTestsetse {

    public static void main(String[] args) {

    }

    private static int cost(int i, HashMap<Integer, Integer> map) {
        i = i > 13 ? 13 : i;
        i = i < 9 ? 9 : i;
        int sum = 0;
        for (int j = 9; j <= i; j++) {
            sum += map.get(j);
        }
        return sum * 8;
    }
}
