package com.core.collection.menudemo.model;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Tianqi.Zhang
 * @date 2018/12/13
 * @time 22:26
 * @package com.core.collection.menudemo.model
 * @project 1008MyDemo
 * @description
 */
public class Menu implements Comparable<Menu> {


    private Long menuId;

    private Long parentId;

    private String name;

    private String isLeaf;


    public Menu(Long menuId, Long parentId, String name,String isLeaf) {
        this.menuId = menuId;
        this.parentId = parentId;
        this.name = name;
        this.isLeaf = isLeaf;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", isLeaf='" + isLeaf + '\'' +
                ", subMenu=" + subMenu +
                '}';
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    Set<Menu> subMenu;



    public Menu() {
    }



    public boolean addToSub(Menu menu) {

        if (this.subMenu == null) {
            // 若为null 则新建子菜单
            subMenu = new TreeSet<>();
            this.setSubMenu(subMenu);
        }
        Set<Menu> subMenu = this.subMenu;
        boolean add = subMenu.add(menu);

        return add;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Menu)) {
            return false;
        }
        Menu menu = (Menu) o;
        return Objects.equals(getMenuId(), menu.getMenuId()) &&
                Objects.equals(getParentId(), menu.getParentId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getMenuId(), getParentId());
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Menu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(Set<Menu> subMenu) {
        this.subMenu = subMenu;
    }


    @Override
    public int compareTo(Menu other) {

        int ret;
        Long menuId1 = this.menuId;
        Long menuId2 = other.menuId;

        if (menuId1 < menuId2) {
            ret = -1;
        } else if (menuId1 > menuId2) {
            ret = 1;
        } else {
            ret = 0;
        }
        return ret;
    }
}
