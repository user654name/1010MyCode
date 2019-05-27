package com.pinyin.pinyin4j;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/24
 * @time 9:35
 * @package com.pinyin.pinyin4j
 * @project 1008MyDemo
 * @description
 */
public class PinYinDemo {
    public static void main(String[] args) {

        char c = '大';
        String[] strings = PinyinHelper.toHanyuPinyinStringArray(c);
        print(strings);
        System.out.println();

        String[] strings1 = PinyinHelper.toGwoyeuRomatzyhStringArray(c);
        print(strings1);
        System.out.println();

        String[] strings2 = PinyinHelper.toMPS2PinyinStringArray(c);
        print(strings2);
        System.out.println();

        String[] strings3 = PinyinHelper.toHanyuPinyinStringArray(c);
        print(strings3);
        System.out.println();


    }

    private static void print(String[] strings) {
        for (String string : strings) {
            System.out.print(string);
        }
    }

}
