package com.core.regex;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.regex.Pattern;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/27
 * @time 15:06
 * @package com.core.regex
 * @project 1008MyDemo
 * @description
 */
public class RegexDemo {
    public static void main(String[] args) {
        String content = "是";

        String pattern = "[\\u4e00-\\u9fa5]";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 汉字 字符串? " + isMatch);
    }
}
