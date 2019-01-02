package com.menu.nolevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Tianqi.Zhang
 * @date 2019/1/2
 * @time 14:26
 * @package com.menu.nolevel
 * @project 1008MyDemo
 * @description
 */
public class MenuUtil {

    public static List<Menu> showDatabase() {
        List<Menu> menuDatabase = new ArrayList<>();
        // 顶级菜单
        menuDatabase.add(new Menu(1L, null, null, "0"));
        menuDatabase.add(new Menu(2L, null, null, "0"));
        menuDatabase.add(new Menu(3L, null, null, "0"));

        // 次级菜单
        menuDatabase.add(new Menu(4L, null, null, "0"));
        menuDatabase.add(new Menu(5L, null, null, "0"));
        menuDatabase.add(new Menu(6L, null, null, "0"));
        menuDatabase.add(new Menu(7L, null, null, "1"));
        menuDatabase.add(new Menu(8L, null, null, "1"));

        // 三级菜单
        menuDatabase.add(new Menu(9L, null, null, "0"));
        menuDatabase.add(new Menu(10L, null, null, "1"));
        menuDatabase.add(new Menu(11L, null, null, "1"));
        menuDatabase.add(new Menu(12L, null, null, "1"));

        // 四级菜单
        menuDatabase.add(new Menu(13L, null, null, "1"));
        menuDatabase.add(new Menu(14L, null, null, "1"));

        return menuDatabase;
    }


    public static List<Menu> getMenu() {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu(7L, null, null, "1"));
        menuList.add(new Menu(8L, null, null, "1"));
        // 三级菜单
        menuList.add(new Menu(10L, null, null, "1"));
        menuList.add(new Menu(11L, null, null, "1"));
        menuList.add(new Menu(12L, null, null, "1"));
        // 四级菜单
        menuList.add(new Menu(13L, null, null, "1"));
        menuList.add(new Menu(14L, null, null, "1"));

        return menuList;
    }


    /**
     * 根据id查询菜单对象
     */
    public static Menu getMenuById(Long id) {

        List<Menu> menuList = showDatabase();
        for (Menu menu : menuList) {
            if (Objects.equals(menu.getMenuId(), id)) {
                return menu;
            }
        }
        return null;
    }


}
