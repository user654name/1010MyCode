package com.test.extend;

/**
 * @author Tianqi.Zhang
 * @date 2018/12/11
 * @time 9:24
 * @package com.test.extend
 * @project 1008MyDemo
 * @description
 */
public class Son extends Father {
    @Override
    public String toString() {
        return "Son{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
            Son son = new Son();
            son.setName("2");
        System.out.println("son = " + son);
    }
}

