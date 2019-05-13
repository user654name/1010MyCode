package com.core.properties.atask;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/10
 * @time 10:40
 * @package com.core.properties.atask
 * @project 1008MyDemo
 * @description
 */
public class Obj {
    private String name;

    @Override
    public String toString() {
        return "Obj{" +
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
