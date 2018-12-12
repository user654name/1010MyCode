package com.test.extend;

/**
 * @author Tianqi.Zhang
 * @date 2018/12/11
 * @time 9:24
 * @package com.test.extend
 * @project 1008MyDemo
 * @description
 */
public class Father {
    String name;

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
