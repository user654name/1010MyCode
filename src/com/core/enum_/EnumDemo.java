package com.core.enum_;

import java.util.EnumSet;

/**
 * @author Tianqi.Zhang
 * @date 2019/3/26
 * @time 16:16
 * @package com.core.enum_
 * @project 1008MyDemo
 * @description
 */
public enum EnumDemo {

    word1,word2,橘子3,句子4;

    public static void main(String[] args) {
        EnumSet<EnumDemo> enumDemos = EnumSet.allOf(EnumDemo.class);
        for (EnumDemo enumDemo : enumDemos) {
            System.out.println(enumDemo);
        }
    }
}

