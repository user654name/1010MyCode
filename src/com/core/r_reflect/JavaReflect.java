package com.core.r_reflect;

import org.junit.Test;

import java.lang.reflect.Field;

public class JavaReflect {


    @Test
  public   void demo1() {
        /**
         * 第一中方法
         * 实例 getClass
         */
        Cat cat = new Cat();
        Class aClass = cat.getClass();

    }

    @Test
    public   void demo2() {
        /**
         * 第二种
         * 类.class
         */

        Class<Cat> catClass = Cat.class;
        Field[] fields = catClass.getFields();

    }


    @Test
    public  void demo3() throws ClassNotFoundException {
        /**
         * 第三种Class直接Forname
         */
        Class<?> aClass = Class.forName("com.core.r_reflect.Cat");

    }


    @Test
    public void demo4Equls() {

        Cat cat = new Cat();
        cat.setAge(1);
        cat.setName("xx");

        Cat cat1 = new Cat();
        cat1.setAge(1);
        cat1.setName("xx");


        boolean equals = cat1.equals(cat);
        boolean b = cat1 == cat;
        System.out.println(equals+"--"+b);

    }


    @Test
    public void testHashCode(){




    }
    public static void main(String[] args) {
        Class<UserBean> userBeanClass = UserBean.class;
        UserBean user = new UserBean();
        Class<? extends UserBean> aClass = user.getClass();

        System.out.println("aClass = " + aClass);
        System.out.println("userBeanClass = " + userBeanClass);
        if (aClass==userBeanClass){
            System.out.println("两者相同");
        }else {
            System.out.println("是不同的");
        }



    }
}
