package com.core.design_patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {




        //被代理对象
        Dog dog = Dog.getInstance();

        //参数1：ClassLoader loader,要求与被代理对象一致
        //参数2：Class[] interfaces 代理类要实现的接口列表
        //参数3：InvocationHandler new出来了一个接口的实现 （实际上在传递一个回调方法）
        //回调方法：什么时候回调呢？ 当代理对象的方法被调用的时候，回调函数就会调用
        //有啥用呢？

        //返回值：返回指定接口的代理类的实例


        /**
         *
         * Proxy.newProxyInstance(
         * @param1 dog.getClass().getClassLoader()
         * @param2 dog.getClass().getInterfaces()
         * @param3 new InvocationHandler(){  @Override public Object invoke(Object proxy, Method method, Object[] args) }
         *
         *
         *
         */
        SoundMaker proxy = (SoundMaker) Proxy.newProxyInstance(dog.getClass().getClassLoader(),
                dog.getClass().getInterfaces(), new InvocationHandler() {

                    /**
                     * 返回由该对象表示的类或接口实现的接口
                     *
                     * @param proxy  表示生成的代理对象的实例
                     * @param method 表示当前调用的代理对象的方法
                     * @param args   表示当前调用的代理对象的方法里的参数
                     * @return 这个返回值表示的是，调用代理对象之后，代理对象最终返回的返回
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //预处理，过滤，转发，后续处理
                        System.out.println();
                        System.out.println("即将执行方法" + method.getName());

                        long t1 = System.nanoTime();//获取开始时间

                        Object invoke = method.invoke(dog, args);
                        long t2 = System.nanoTime();//获取结束时间

                        System.out.println("耗费时间=" + (t2 - t1));

                        System.out.println("方法" + method.getName() + "执行完毕");
                        System.out.println("-------我是分割线--------");
                        System.out.println();

                        return invoke;
                    }
                }
        );
        //使用代理对象来让狗叫
        proxy.wang(1);//方法耗时 103426 纳秒
        proxy.wang(10);//方法耗时 510815 纳秒
        proxy.wang(100);//方法耗时 1641001 纳秒
    }
}
/**
 * invoke vt. 调用；祈求；引起；恳求 [ 过去式 invoked 过去分词 invoked 现在分词 invoking ]
 */

