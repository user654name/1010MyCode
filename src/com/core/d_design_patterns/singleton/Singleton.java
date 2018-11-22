package com.core.d_design_patterns.singleton;

public class Singleton {

    private Singleton() {
    }

    private static class SingletonHolder {
        private final static Singleton INSTANCE = new Singleton();
    }

    public static Singleton getSingleton() {
        return SingletonHolder.INSTANCE;
    }

}
