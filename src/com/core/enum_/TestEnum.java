package com.core.enum_;

import java.util.Random;

/**
 * @author Tianqi.Zhang
 * @date 2019/3/26
 * @time 16:18
 * @package com.core.enum_
 * @project 1008MyDemo
 * @description
 */
//枚举类
enum WeekEnum {
    星期一, 星期二, 星期三, 星期四, 星期五, 星期六, 星期日
}

public class TestEnum {

    private static int random = (int) (Math.random() * 10);// 生成种子

    private static Random rand = new Random(random);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        T[] enumConstants = ec.getEnumConstants();
        return random(enumConstants);
    }


    /**
     * 泛型
     */
    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }

    public static void main(String[] args) {

        System.out.println(random(WeekEnum.class));
        System.out.println(random(WeekEnum.class));
        System.out.println(random(WeekEnum.class));
        System.out.println(random(WeekEnum.class));
        System.out.println(random(WeekEnum.class));
        System.out.println(random(WeekEnum.class));
        System.out.println(random(WeekEnum.class));
        System.out.println(random(WeekEnum.class));
        System.out.println(random(WeekEnum.class));

        String abc = random(WeekEnum.class).toString();

        random(WeekEnum.class);
        random(WeekEnum.class.getEnumConstants());

        Class<WeekEnum> weekEnumClass = WeekEnum.class;
        WeekEnum[] enumConstants = weekEnumClass.getEnumConstants();
        int length = enumConstants.length;
        int randomNumber = rand.nextInt(length);
        WeekEnum enumConstant = enumConstants[randomNumber];
        String string = enumConstant.toString();
        System.out.println("string = " + string);


    }
}


