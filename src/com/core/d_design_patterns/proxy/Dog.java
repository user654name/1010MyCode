package com.core.d_design_patterns.proxy;

public class Dog implements SoundMaker {

    //【私有的】构造方法
    private Dog() {
    }

    @Override
    //实现接口的方法 外界可调用！
    public void wang(int times) {
        for (int i = 0; i <= times; i++) {
            System.out.print(" WANG!" + i);
            if (i==times){
                System.out.println("  Ohhh!------!");
            }

        }
    }

    //【私有的】【静态的】能得到Dog的内部类
    private static class DogHolder {
        //它有一个【静态的】【常量】
        //自己构建的一个Dog实例，供别人通过【方法】获取
        private static final Dog INSTANCE = new Dog();
    }

    //就是通过这个【公共的】【静态】【方法】获取Dog
    public static final Dog getInstance() {
        System.out.println("即将用单例模式返回狗对象");
        return DogHolder.INSTANCE;
    }
}




