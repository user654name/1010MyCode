package com.pkm.model;

/**
 * @author Tianqi.Zhang
 * @date 2019/4/30
 * @time 14:08
 * @package com.pkm
 * @project 1008MyDemo
 * @description
 */
public class Pkm {

    private Integer id;
    private String name;
    private String type;
    private Integer att;
    private Integer def;
    private Integer accuracy;
    private Integer avoid;
    private Integer evolutionId;
    private Integer exp;

    @Override
    public String toString() {
        return "Pkm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", att=" + att +
                ", def=" + def +
                ", accuracy=" + accuracy +
                ", avoid=" + avoid +
                ", evolutionId=" + evolutionId +
                ", exp=" + exp +
                '}';
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Pkm(Integer id, String name, String type, Integer att, Integer def, Integer accuracy, Integer avoid, Integer evolutionId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.att = att;
        this.def = def;
        this.accuracy = accuracy;
        this.avoid = avoid;
        this.evolutionId = evolutionId;
        this.exp = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAtt() {
        return att;
    }

    public void setAtt(Integer att) {
        this.att = att;
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public Integer getAvoid() {
        return avoid;
    }

    public void setAvoid(Integer avoid) {
        this.avoid = avoid;
    }

    public Integer getEvolutionId() {
        return evolutionId;
    }

    public void setEvolutionId(Integer evolutionId) {
        this.evolutionId = evolutionId;
    }
}
