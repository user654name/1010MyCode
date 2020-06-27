package com.util;

import java.util.List;

/**
 * @author Tianqi.Zhang
 * @date 2020/5/30
 * @time 21:28
 * @package com.util
 * @project 1008MyDemo
 * @description
 */
public class NumberUtil {
    public static boolean between(Long number, Long small, Long big) {
        return number >= small && number < big;
    }

    public static int avg(List<Integer> numbers) {
        int sum = 0;
        int avg = 0;
        int size = numbers.size();
        if (size > 0) {
            for (Integer number : numbers) {
                sum += number;
            }
            avg = sum / size;
        }
        return avg;
    }
}
