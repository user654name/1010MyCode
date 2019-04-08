package com.core;

/**
 * @author Tianqi.Zhang
 * @date 2019/4/8
 * @time 9:27
 * @package com.core
 * @project 1008MyDemo
 * @description
 */
public class Demo {

    public static void main(String[] args) {

        double tou_zi_e = 1.0;
        int nian_xian = 1;
        double nian_li_lv = 3.25;

        conut(tou_zi_e, nian_xian);


    }

    private static void conut(double tou_zi_e, int nian_xian) {
        double zong_qian_shu = tou_zi_e * Math.pow((1 + nian_xian / 100.0), nian_xian);
    }
}
