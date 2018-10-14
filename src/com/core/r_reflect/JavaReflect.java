package com.core.r_reflect;

import java.util.Queue;

public class JavaReflect {
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
