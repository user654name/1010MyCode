package com.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tianqi.Zhang
 * @date 2020/5/30
 * @time 18:58
 * @package com.util
 * @project 1008MyDemo
 * @description
 */
public class Demo {
    public static void main(String[] args) {
        List<String> list = getList();
        for (String s : list) {
            System.out.println(s);
        }

        //        LocalTime localTime = LocalTime.parse("",new DateTimeFormatter());
    }

    private static List<String> getList() {
        String s = "6w 2h 35m ago\n" +
                "10m ago\n" +
                "17h 51m ago\n" +
                "22m ago\n" +
                "1h 44m ago\n" +
                "24m ago\n" +
                "1h 17m ago\n" +
                "3h 51m ago\n" +
                "26m ago\n" +
                "4m ago\n" +
                "2h 16m ago\n" +
                "1h 27m ago\n" +
                "9h 56m ago\n" +
                "8h 10m ago\n" +
                "11m ago\n" +
                "4h 48m ago\n" +
                "1h 53m ago\n" +
                "3d 5h 49m ago\n" +
                "2h 59m ago\n" +
                "1h 49m ago\n" +
                "2h 7m ago\n" +
                "1d 8h 9m ago\n" +
                "2h 26m ago\n" +
                "1h ago\n" +
                "3h 28m ago\n" +
                "3d 44m ago\n" +
                "4d 22h 53m ago\n" +
                "7h 19m ago\n" +
                "6h 26m ago\n" +
                "5h 49m ago\n" +
                "43m ago\n" +
                "4h 34m ago\n" +
                "1h 48m ago\n" +
                "4h 55m ago\n" +
                "1d 2h 23m ago\n" +
                "1d 2h 1m ago\n" +
                "7h 46m ago\n" +
                "7h 31m ago\n" +
                "5h 37m ago\n" +
                "12h 16m ago\n" +
                "12m ago\n" +
                "9h 35m ago\n" +
                "4h 58m ago\n" +
                "4d 10h 25m ago\n" +
                "3h 2m ago\n" +
                "5m ago\n" +
                "1h 8m ago\n" +
                "12h 30m ago\n" +
                "6h 12m ago\n" +
                "2h 5m ago";

        String[] split = s.split("\n");

        return new ArrayList(Arrays.asList(split));
    }
}
