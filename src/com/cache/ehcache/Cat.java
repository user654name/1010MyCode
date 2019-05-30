package com.cache.ehcache;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/29
 * @time 14:10
 * @package com.cache.ehcache
 * @project 1008MyDemo
 * @description
 */
public class Cat {
    private String id;
    private String name;
    private String color;

    public Cat(String id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
