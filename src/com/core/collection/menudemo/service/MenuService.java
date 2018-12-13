package com.core.collection.menudemo.service;

import com.core.collection.menudemo.database.Mapper;
import com.core.collection.menudemo.model.Menu;
import com.core.collection.menudemo.prod.ProdUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Tianqi.Zhang
 * @date 2018/12/13
 * @time 23:31
 * @package com.core.collection.menudemo.service
 * @project 1008MyDemo
 * @description
 */
public class MenuService {

    public void getMenu() {

        Map<Long, Menu> menusMap = ProdUtils.getMenusFromDataBase();
        Set<Long> menuIds = menusMap.keySet();

        Map<Long, Menu> topMap = new HashMap<>();
        Map<Long, Long> relationMap = new HashMap<>();

        // 遍历Map
        for (Long menuId : menuIds) {
            Menu menu = menusMap.get(menuId);

            // 对每个Map做此处理
            dealMenu(menu,topMap,relationMap);


        }

    }

    private void dealMenu(Menu menu, Map<Long, Menu> topMap, Map<Long, Long> relationMap) {

        if (menu.getParentId()==null){

        }


    }
}
