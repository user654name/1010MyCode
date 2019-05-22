package com.core.number.bigdecimal;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/22
 * @time 10:48
 * @package com.core.number.bigdecimal
 * @project 1008MyDemo
 * @description
 */
public class BigDecimalTest {


    private BigDecimal ten = new BigDecimal(10);
    private BigDecimal three = new BigDecimal(3);

    /**
     * 比较大小
     */
    @Test
    public void compare() {
        /**
         * BigDecimal用equals比较时候会比较精度 可能出现 1.00 不等于 1 的情形 但compare不会
         */
        System.out.println("————————compareTo————————");
        System.out.println("-5比较1        = " + new BigDecimal(-5).compareTo(new BigDecimal(1)));
        System.out.println("-1比较1        = " + new BigDecimal(-1).compareTo(new BigDecimal(1)));
        System.out.println("1比较1         = " + new BigDecimal(1).compareTo(new BigDecimal(1)));
        System.out.println("3比较1         = " + new BigDecimal(3).compareTo(new BigDecimal(1)));
        System.out.println("1.000比较1     = " + new BigDecimal(1.000).compareTo(new BigDecimal(1)));
        System.out.println("1.000D比较1.0F = " + new BigDecimal(1.000D).compareTo(new BigDecimal(1.0F)));

        System.out.println("————————equals————————");
        boolean equals = new BigDecimal(1).equals(new BigDecimal(1.00D));
        boolean equals1 = new BigDecimal(1.01F).equals(new BigDecimal(1.01D));
        boolean equals2 = new BigDecimal("1").equals(new BigDecimal("1.00"));
        System.out.println("1       equals 1.00D     ? " + equals);
        System.out.println("1.01F   equals 1.01D     ? " + equals1);
        System.out.println("\"1\"     equals \"1.00\"    ? " + equals2);

    }

    /**
     * 除法
     */
    @Test
    public void divide() {
        try {
            ten.divide(three);
        } catch (Exception e) {
            System.out.println("ten.result(three)方法会报错 除法需要指定多个参数");
        }
        System.out.println("ten.divide(three,5, RoundingMode.HALF_DOWN);");
        /**
         * 第一个参数 除数
         * 第二个参数 小数点后保留小数位数
         * 第三个参数 对截断位的处理方式
         */
        BigDecimal result = ten.divide(three, 5, RoundingMode.HALF_DOWN);
        System.out.println("result = " + result);
    }

    @Test
    public void add() {
        BigDecimal add = ten.add(three);
        System.out.println("add = " + add);
        BigDecimal add1 = add.add(new BigDecimal("1.1"));
        System.out.println("add1 = " + add1.toPlainString());

    }

    /**
     * 初始化方式必须用字符串方式，否则精度有问题
     *
     * (    不推荐 使用 Double 构造！！！     )
     * (    不推荐 使用 Double 构造！！！     )
     * (    不推荐 使用 Double 构造！！！     )
     *
     *  .abs()是获取绝对值
     */
    @Test
    public void arithmetic() {


        BigDecimal num1 = new BigDecimal(0.005);
        BigDecimal num2 = new BigDecimal(1000000);
        BigDecimal num3 = new BigDecimal(-1000000);
        //尽量用字符串的形式初始化
        BigDecimal num12 = new BigDecimal("0.005");
        BigDecimal num22 = new BigDecimal("1000000");
        BigDecimal num32 = new BigDecimal("-1000000");

        //加法
        BigDecimal result1 = num1.add(num2);
        BigDecimal result12 = num12.add(num22);
        //减法
        BigDecimal result2 = num1.subtract(num2);
        BigDecimal result22 = num12.subtract(num22);
        //乘法
        BigDecimal result3 = num1.multiply(num2);
        BigDecimal result32 = num12.multiply(num22);
        //绝对值
        BigDecimal result4 = num3.abs();
        BigDecimal result42 = num32.abs();
        //除法
        BigDecimal result5 = num2.divide(num1,20,BigDecimal.ROUND_HALF_UP);
        BigDecimal result52 = num22.divide(num12,20,BigDecimal.ROUND_HALF_UP);

        System.out.println("加法用value结果："+result1);
        System.out.println("加法用string结果："+result12);

        System.out.println("减法value结果："+result2);
        System.out.println("减法用string结果："+result22);

        System.out.println("乘法用value结果："+result3);
        System.out.println("乘法用string结果："+result32);

        System.out.println("绝对值用value结果："+result4);
        System.out.println("绝对值用string结果："+result42);

        System.out.println("除法用value结果："+result5);
        System.out.println("除法用string结果："+result52);

    }
}
