package com.core.design_patterns.singleton;

public class Boy {


    private Boy() {
    }

    private static class BoyHolder {
        private final static Boy INSTANCE = new Boy();

    }

    public static Boy getInstance() {
        return BoyHolder.INSTANCE;
    }

}


class TestBoy {

    public static void main(String[] args) {
        Boy boy = Boy.getInstance();
    }

}