package com.util;

import com.util.model.Player;

import java.lang.reflect.Method;

public class BeanUtil {

    /**
     * 根据属性，获取get方法
     * @param ob 对象
     * @param name 属性名
     * @return
     * @throws Exception
     */
    public static Object getGetMethod(Object ob , String name)throws Exception{
        Method[] m = ob.getClass().getMethods();
        for(int i = 0;i < m.length;i++){
            if(("get"+name).toLowerCase().equals(m[i].getName().toLowerCase())){
                return m[i].invoke(ob);
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        Player player = new Player();
        player.setDonate("123");
        player.setTrophies("333123");
        Object donate = getGetMethod(player, "donate");
        Object setTrophies = getGetMethod(player, "trophies");
        System.out.println(donate);
        System.out.println(setTrophies);
    }

}