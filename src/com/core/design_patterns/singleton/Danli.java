package com.core.design_patterns.singleton;

public class Danli {

    private Danli() {

    }

    private static class DanliHolder {

        private static final Danli INSTANCE = new Danli();
    }

    public static Danli getInstance() {
        return DanliHolder.INSTANCE;
    }

}
