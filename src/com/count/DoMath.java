package com.count;

/**
 * @author Tianqi.Zhang
 * @date 2019/10/12
 * @time 14:58
 * @package com.count
 * @project 1008MyDemo
 * @description
 */
public class DoMath {


    /**
     * A 命中率 30%
     * B 命中率 50%
     * A先向B射击
     * B再向A射击
     * 直到一方倒下
     * A的胜率是多少
     *
     * @param args
     */
    public static void main(String[] args) {
        double aT = 0.3;
        double aF = 1 - aT;
        double bT = 0.5;
        double bF = 1 - bT;
        double draw = aF * bF;
        System.out.println(aT);
        System.out.println(aF);
        System.out.println(bT);
        System.out.println(bF);
        System.out.println(draw);
        System.out.println("sssstart");

        System.out.println();
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " =》" + p(aT, draw, i));
        }
    }

    private static double p(double aT, double draw, int times) {

        if (times == 0) {
            return aT;
        }
        return p(aT, draw, times - 1) + Math.pow(draw, times) * aT;
    }
}
