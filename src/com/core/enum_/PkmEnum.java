package com.core.enum_;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/7
 * @time 15:25
 * @package com.core.enum_
 * @project 1008MyDemo
 * @description
 */
public enum PkmEnum {
    MiaoWaZhongZi(1, "妙蛙种子"),
    XiaoHuoLong(4, "小火龙"),
    JieNiGui(7, "杰尼龟");

    public Integer id;
    public String name;

    PkmEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println(PkmEnum.JieNiGui.name);
    }
}

