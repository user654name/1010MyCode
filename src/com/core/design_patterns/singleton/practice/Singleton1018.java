package com.core.design_patterns.singleton.practice;

public class Singleton1018 {

    private  Singleton1018() {
    }

    private static class SingletonHolder {

        private final static Singleton1018 INSTANCE = new Singleton1018();
    }

    public static Singleton1018 getSingleton1018() {
        return SingletonHolder.INSTANCE;
    }
}
