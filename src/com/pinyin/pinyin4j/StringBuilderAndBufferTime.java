package com.pinyin.pinyin4j;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/28
 * @time 15:50
 * @package com.pinyin.pinyin4j
 * @project 1008MyDemo
 * @description
 */
public class StringBuilderAndBufferTime {
    public static void main(String[] args) {
        int times = 10;
        int outTime = 1000000;
        long start1 = System.currentTimeMillis();
        builder(times,outTime);
        System.out.println("time builder " + (System.currentTimeMillis() - start1));


        long start2 = System.currentTimeMillis();
        buffer(times,outTime);
        System.out.println("time buffer " + (System.currentTimeMillis() - start2));
    }

    public static void builder(int times, int outTime) {
        for (int j = 0; j < outTime; j++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("test").append(1).deleteCharAt(1);
            for (int i = 0; i < times; i++) {
                stringBuilder.append("test").append(1).deleteCharAt(1);
            }
        }

    }

    public static void buffer(int times, int outTime) {
        for (int j = 0; j < outTime; j++) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < times; i++) {
                stringBuffer.append("test").append(1).deleteCharAt(1);
            }
        }
    }
}
