package com.core.design_patterns.singleton;


/**
 * 单例模式！！！
 * 不能被别人new
 * 自己只new一个 给别人用
 */

public class Cat {
    /**
     * 私有的静态内部类
     * <p>
     * 【好处】线程安全————放在静态里和类一起加载只加载一次！！！！
     * 【好处】懒加载————不用不加载，用才加载————节约宝贵的内存资源！！！
     * <p>
     * 这种方式同样利用了 classloader 机制来保证初始化 instance 时只有一个线程，
     * 它跟第 3 种方式（不是内部类而是成员）不同的是：第 3 种方式只要 Cat 类被装载了，
     * 那么 instance 就会被实例化（没有达到 lazy loading 效果），
     * 而这种方式是 Cat 类被装载了，instance 不一定被初始化。
     * 因为 CatHolder 类没有被主动使用，
     * 只有通过显式调用 getInstance 方法时，才会显式装载 CatHolder 类，
     * 从而实例化 instance。想象一下，如果实例化 instance 很消耗资源，所以想让它延迟加载，
     * 另外一方面，又不希望在 Cat 类加载时就实例化，
     * 因为不能确保 Cat 类还可能在其他的地方被主动使用从而被加载，
     * 那么这个时候实例化 instance 显然是不合适的。这个时候，这种方式相比第 3 种方式就显得很合理。
     */

    private static class CatHolder {
        private static final Cat INSTANCE = new Cat();
    }

    //构造方法私有！
    private Cat() {
    }

    //外部只能通过这种方式获取Cat的唯一实例
    public static final Cat getInstance() {
        return CatHolder.INSTANCE;
    }


    public void eat() {
        System.out.println("eating");
    }

}


//这里是主方法
class MainCat {

    public static void main(String[] args) {
        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //Cat object = new Cat();

        //获取唯一可用的对象
        Cat cat = Cat.getInstance();

        //用唯一的对象执行个方法试试
        cat.eat();


    }
}