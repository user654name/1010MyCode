package com.pkm.model;

/**
 * @author Tianqi.Zhang
 * @date 2019/4/30
 * @time 15:32
 * @package com.pkm.model
 * @project 1008MyDemo
 * @description
 */
public class TypeRst {
    private String a;
    private String d;
    private Double rst;

    public TypeRst(String a, String d, Double rst) {
        this.a = a;
        this.d = d;
        this.rst = rst;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public Double getRst() {
        return rst;
    }

    public void setRst(Double rst) {
        this.rst = rst;
    }
}
