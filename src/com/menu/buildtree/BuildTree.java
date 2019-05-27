package com.menu.buildtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/27
 * @time 9:00
 * @package com.menu.buildtree
 * @project 1008MyDemo
 * @description
 */
public class BuildTree {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // 获取模拟数据
        List<Menu> all = getAll();
        // 获取根节点
        Menu root = new Menu("1", "A", "0");

        // 递归找到
        List<Menu> child = getChild(root.getId(), all);
        root.setChildren(child);
        System.out.println("root = " + root);
    }

    private static List<Menu> getAll() {
        List<Menu> list = new ArrayList<>();
        /**
         * 树形结构
         * A___B___E___H
         * |   |   |___I
         * |   |   |___J
         * |   |
         * |   |___F
         * |
         * |___C___G
         * |
         * |___D
         *
         * root = A {[B {[E {[H {[]}, I {[]}, J {[]}]}, F {[]}]}, C {[G {[]}]}, D {[]}]}
         */
        list.add(new Menu("1", "A", "0"));
        list.add(new Menu("2", "B", "1"));
        list.add(new Menu("3", "C", "1"));
        list.add(new Menu("4", "D", "1"));
        list.add(new Menu("5", "E", "2"));
        list.add(new Menu("6", "F", "2"));
        list.add(new Menu("7", "G", "3"));
        list.add(new Menu("8", "H", "5"));
        list.add(new Menu("9", "I", "5"));
        list.add(new Menu("10", "J", "5"));
        return list;
    }


    public static Map<String, Object> findTree() {
        Map<String, Object> data = new HashMap<String, Object>();
        try {//查询所有菜单
//            List<Menu> allMenu = menuDao.findTree();
            List<Menu> allMenu = null;
            //根节点
            List<Menu> rootMenu = new ArrayList<Menu>();
            for (Menu nav : allMenu) {
                if (nav.getParentId().equals("0")) {//父节点是0的，为根节点。
                    rootMenu.add(nav);
                }
            }

            //为根菜单设置子菜单，getClild是递归调用的
            for (Menu nav : rootMenu) {
                /* 获取根节点下的所有子节点 使用getChild方法*/
                List<Menu> childList = getChild(nav.getId(), allMenu);
                nav.setChildren(childList);//给根节点设置子节点
            }
            /**
             * 输出构建好的菜单数据。
             *
             */
            data.put("success", "true");
            data.put("list", rootMenu);
            return data;
        } catch (Exception e) {
            data.put("success", "false");
            data.put("list", new ArrayList());
            return data;
        }
    }


    /**
     * 获取子节点
     *
     * @param id      父节点id
     * @param allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    public static List<Menu> getChild(String id, List<Menu> allMenu) {
        //子菜单
        List<Menu> childList = new ArrayList<>();
        for (Menu nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if (nav.getParentId().equals(id)) {
                childList.add(nav);
            }
        }
        //递归
        for (Menu nav : childList) {
            nav.setChildren(getChild
                    (nav.getId(), allMenu));
        }
        //如果节点下没有子节点，返回一个空List（递归退出）
        if (childList.size() == 0) {
            return new ArrayList<Menu>();
        }
        return childList;
    }
}
