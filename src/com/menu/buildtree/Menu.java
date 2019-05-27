package com.menu.buildtree;

import java.util.List;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/27
 * @time 9:00
 * @package com.menu.buildtree
 * @project 1008MyDemo
 * @description
 */
public class Menu {

    // 菜单id
    private String id;
    // 菜单名称
    private String name;
    // 父菜单id
    private String parentId;
    private int order;
    // 子菜单
    private List<Menu> children;

    public Menu(String id, String name, String parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    @Override
    public String toString() {


        StringBuilder stringBuilder = new StringBuilder(name+" ");
        if (children!=null){
            stringBuilder.append("{" + children + "}");
        }
        return stringBuilder.toString() ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }


    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }


}
