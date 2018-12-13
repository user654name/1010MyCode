package com.core.collection.menudemo.prod;

import com.core.collection.menudemo.model.Menu;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tianqi.Zhang
 * @date 2018/12/13
 * @time 23:04
 * @package com.core.collection.menudemo.model
 * @project 1008MyDemo
 * @description
 */
public class ProdUtils {

    public static Map<Long,Menu>  getMenusFromDataBase() {

        Map<Long,Menu> menuMapWaitToDeal = new HashMap<>();
        // 用来储存菜单的Map
        Menu m1 = new Menu(88811111L,8881111L,"A11111","1");
        Menu m7 = new Menu(88811112L,8881111L,"A11112","1");
        Menu m8 = new Menu(88811113L,8881111L,"A11113","1");

//        Menu m2 = new Menu(8881111L,888111L,"A1111");
//        Menu m3 = new Menu(888111L,88811L,"A111");
//        Menu m4 = new Menu(88811L,8881L,"A11");
//        Menu m5 = new Menu(8881L,888L,"A1");
//        Menu m6 = new Menu(888L,null,"A");

        putIntoMap(menuMapWaitToDeal, m1);
        putIntoMap(menuMapWaitToDeal, m7);
        putIntoMap(menuMapWaitToDeal, m8);

        return menuMapWaitToDeal;
    }

    private static void putIntoMap(Map<Long, Menu> menuMapWaitToDeal, Menu m1) {
        menuMapWaitToDeal.put(m1.getMenuId(),m1);
    }

}
