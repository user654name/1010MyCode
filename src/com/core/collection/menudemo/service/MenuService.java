package com.core.collection.menudemo.service;

import com.core.collection.menudemo.database.Mapper;
import com.core.collection.menudemo.model.Menu;
import com.core.collection.menudemo.prod.ProdUtils;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import java.util.*;

/**
 * @author Tianqi.Zhang
 * @date 2018/12/13
 * @time 23:31
 * @package com.core.collection.menudemo.service
 * @project 1008MyDemo
 * @description
 */
public class MenuService {

    @Test
    public void getMenu() {

        Map<Long, Menu> menusMap = ProdUtils.getMenusFromDataBase();
        printMap(menusMap);
        System.out.println("menusMap = " + menusMap);
        Set<Long> menuIds = menusMap.keySet();

        Map<Long, Menu> topMap = new HashMap<>();
        Map<Long, Long> relationMap = new HashMap<>();

        // 遍历Map
        for (Long menuId : menuIds) {
            Menu menu = menusMap.get(menuId);

            // 对每个Map做此处理
            dealMenu(menu,topMap,relationMap);


        }

        printMap(topMap);
    }

    private void printMap(Map<Long, Menu> topMap) {
        Set<Long> longs = topMap.keySet();
        for (Long aLong : longs) {
            Menu menu = topMap.get(aLong);
            System.out.println("menu = " + menu);
        }
    }

    private void dealMenu(Menu menu, Map<Long, Menu> topMap, Map<Long, Long> relationMap) {

        // 是否顶级
        if (menu.getParentId()==null){
            //  顶级
            // 放如Top集合
            topMap.put(menu.getMenuId(), menu);
            // 维护表
            updateTable(menu, relationMap);
        } else {
            // 不是顶级
            if (menu.getIsLeaf() == "0") {
                // 不是叶 维护表
                updateTable(menu, relationMap);
            }
            // 父亲是否再Table
            boolean atTable = relationMap.containsKey(menu.getParentId());
            if (atTable) {
                // 父亲在表里
                // 找到父亲 将子类写入并放回
                findAndWriteParentMenu(menu, relationMap, topMap);
            } else {
                // 父亲不在表里
                // 查库 获得父亲
                Menu pMenu = Mapper.getMenuById(menu.getMenuId());
                // 放入子类
                pMenu.addToSub(menu);

                // 递归
                menu = pMenu;
                System.out.println("递归查找");
                dealMenu(menu, topMap, relationMap);
            }
        }


    }

    /**
     * 将 Menu找到父类并放入
     *
     * @param menu
     * @param relationMap
     * @param topMap
     */
    private void findAndWriteParentMenu(Menu menu, Map<Long, Long> relationMap, Map<Long, Menu> topMap) {

        Stack<Long> addrStack = new Stack();
        boolean mutiLevel = false;
        int times = 0;
        // 父亲地址是-1L 则跳出循环
        Long resultId = null;
        Long searchId = menu.getParentId();

        // 地址如果不是-1L 执行循环
        while (resultId != -1L) {
            // 记录父亲名
            addrStack.push(searchId);
            // 根据父亲ID 查找其位置
            resultId = relationMap.get(searchId);
            times++;
        }
        System.out.println("【当前Menu是】" + menu);
        System.out.println("【while结束打印栈】" + addrStack);
        // 此时stack中填满地址
        mutiLevel = times == 1 ? false : true;

        if (mutiLevel) {
            // 是多级结构 多级放入 全部找到 依次放入
            // 第一级查找是找到顶级父级
            Menu topPMenu = topMap.get(addrStack.pop());
            times--;

            Stack<Menu> parentStack = new Stack();
            parentStack.push(topPMenu);
            // 第二级及以上查找 是找到顶级父级下属父类
            for (int i = 0; i < times; i++) {
                // 用一个Stack保存所有查询到的父类
                saveToStack(topPMenu, parentStack, addrStack);
            }

            // 按照栈的父亲对象 构造新的对象，写入topMap
            putSubIntoTop(menu, topMap, parentStack);


        } else {
            // 是一级结构 一次放入
            Menu pMenu = topMap.get(addrStack.pop());
            pMenu.addToSub(menu);
            topMap.put(pMenu.getMenuId(), pMenu);
        }

    }

    private void putSubIntoTop(Menu menu, Map<Long, Menu> topMap, Stack<Menu> parentStack) {
        // 表示构造好的对象
        Menu builded = menu;
        while (!parentStack.empty()) {
            Menu pop = parentStack.pop();
            pop.getSubMenu().add(builded);
            builded = pop;
        }
        // 全部构造好 写入
        topMap.put(builded.getMenuId(),builded);
    }

    /**
     * 最重要一步，根据顶级菜单，地址栈，填充父菜单对象
     *
     * @param topPMenu
     * @param parentStack （顶级已经进站）
     * @param addrStack
     */
    private void saveToStack(Menu topPMenu, Stack<Menu> parentStack, Stack<Long> addrStack) {
        // 弹出一个地址 就是要寻找的地址
        Long popAddr = addrStack.pop();

        Set<Menu> subMenu = topPMenu.getSubMenu();
        if (subMenu == null) {
            System.out.println("subMenu = " + subMenu + "严重错误");
        } else {
            // 遍历子菜单
            for (Menu menu : subMenu) {
                // 如果找到了栈 就放入
                if (Objects.equals(menu.getMenuId(), popAddr)) {
                    parentStack.push(menu);
                }
            }
        }
    }

    private void updateTable(Menu menu, Map<Long, Long> relationMap) {
        if (menu.getParentId() != null) {
            // 父亲不为空
            relationMap.put(menu.getMenuId(), menu.getParentId());
        } else {
            // 父亲为空 标志-1L
            relationMap.put(menu.getMenuId(), -1L);
        }
    }
}
