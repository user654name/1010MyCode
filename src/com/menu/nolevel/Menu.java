package com.menu.nolevel;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Tianqi.Zhang
 * @date 2019/1/2
 * @time 14:13
 * @package com
 * @project 1008MyDemo
 * @description
 */
public class Menu {

    /** 主键 */
    Long menuId;
    /** 父亲 */
    Long menuParentId;
    /** 子菜单 */
    Set<Menu> subMenu;
    /** 叶菜单 */
    String isLeaf;

    public Menu(Long menuId, Long menuParentId, Set<Menu> subMenu,String isLeaf) {
        this.menuId = menuId;
        this.menuParentId = menuParentId;
        this.subMenu = subMenu;
        this.isLeaf = isLeaf;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "主键=" + menuId +
                ", 父ID=" + menuParentId +
                ", 子菜单=" + subMenu +
                ", 是功能菜单='" + isLeaf + '\'' +
                '}';
    }

    public Menu() {

    }

    public boolean addToSub(Menu subMenu){
        if (this.subMenu==null){
            this.subMenu=new TreeSet<Menu>();
        }
        return this.subMenu.add(subMenu);
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Long menuParentId) {
        this.menuParentId = menuParentId;
    }

    public Set getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(Set subMenu) {
        this.subMenu = subMenu;
    }
}
