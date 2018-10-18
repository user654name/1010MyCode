package com.core.d_design_patterns.singleton.practice;

public class Singleton1018 {

    private Singleton1018() {
        System.out.println("你创建了我");
    }

    private static class SingletonHolder {

        private final static Singleton1018 INSTANCE = new Singleton1018();
    }

    public static Singleton1018 getSingleton1018() {
        return SingletonHolder.INSTANCE;
    }
}


class MyDemo {

    public static void main(String[] args) {
        Singleton1018 singleton1018 = Singleton1018.getSingleton1018();
        Singleton1018 singleton10182 = Singleton1018.getSingleton1018();
        Singleton1018 singleton10183 = Singleton1018.getSingleton1018();
        Singleton1018 singleton10184 = Singleton1018.getSingleton1018();

    }

}