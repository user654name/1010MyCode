package com.core.reflect;

public class Cat {

    String name;
    Integer age;

    void shout() {

        System.out.println("miao miao");
    }

    void eat() {
        System.out.println("eating");

    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

