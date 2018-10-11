package com.core.d_design_patterns.singleton;

public class Dog {

    //【私有的】构造方法
    private Dog() {
        System.out.println("正在执行-Dog.Dog");
        System.out.println("我构造了Dog");
    }

    //【私有的】【静态的】能得到Dog的内部类
    private static class DogHolder {
        //它有一个【静态的】【常量】
        //自己构建的一个Dog实例，供别人通过【方法】获取
        private static final Dog INSTANCE = new Dog();
    }

    //就是通过这个【公共的】【静态】【方法】获取Dog
    public static final Dog getInstance() {
        System.out.println("正在执行-Dog.getInstance");
        System.out.println("即将返回这条指定生成的Dog");
        return DogHolder.INSTANCE;
    }

    //公共的方法 外界可调用！
    public void wang() {
        System.out.println("正在执行-Dog.wang");
        System.out.println("WANG!");
    }
    //所以这个类只开放了一个getInstance()给外界用来获取Dog对象常量


}

class MainDog {


    public static void main(String[] args) {

        //获取狗
        Dog dog = Dog.getInstance();
        //执行他的公共方法
        dog.wang();

    }
}



