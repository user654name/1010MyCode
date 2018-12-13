package com.core.collection.menudemo.database;

import com.core.collection.menudemo.model.Menu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tianqi.Zhang
 * @date 2018/12/13
 * @time 23:55
 * @package com.core.collection.menudemo.database
 * @project 1008MyDemo
 * @description
 */
public class Mapper {
    public static Menu getMenuById(Long menuId) {

        Map<Long, Menu> mysql = new HashMap();
        Menu m1 = new Menu(88811111L,8881111L,"A11111","1");
        Menu m2 = new Menu(8881111L,888111L,"A1111","0");
        Menu m3 = new Menu(888111L,88811L,"A111","0");
        Menu m4 = new Menu(88811L,8881L,"A11","0");
        Menu m5 = new Menu(8881L,888L,"A1","0");
        Menu m6 = new Menu(888L,null,"A","0");
        Menu m7 = new Menu(88811112L,8881111L,"A11112","1");
        Menu m8 = new Menu(88811113L,8881111L,"A11113","1");

        putIntoMap(mysql,m1);
        putIntoMap(mysql,m2);
        putIntoMap(mysql,m3);
        putIntoMap(mysql,m4);
        putIntoMap(mysql,m5);
        putIntoMap(mysql,m6);
        putIntoMap(mysql,m7);
        putIntoMap(mysql,m8);


        return mysql.get(menuId);
    }

    private static void putIntoMap(Map<Long, Menu> menuMapWaitToDeal, Menu m1) {
        menuMapWaitToDeal.put(m1.getMenuId(),m1);
    }

}
