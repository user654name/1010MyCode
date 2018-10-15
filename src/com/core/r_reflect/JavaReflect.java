package com.core.r_reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Objects;

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
        Field[] fields = catClass.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            System.out.println("name = " + name);
        }
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

        String string1=new String("123123123");
        String string2 = "123123123";

        //true 他们指向堆上的东西 相同
        System.out.println(string1.equals(string2));

        //false 变量的值不相等
        System.out.println(string1 == string2);

        String string3=new String("123123123");

        System.out.println(string3 == string1);

        System.out.println("123123123" == string2);

        System.out.print(new String("123")==string3);
        System.out.println(string1.hashCode());
        System.out.println(string2.hashCode());
//
//
//        try {
//            Class.forName("");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(string1 == string2);
//        System.out.println(string1.equals(string2));
//        System.out.println(Objects.hashCode(null));

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
