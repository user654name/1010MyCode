package com.json.fastjson;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/9
 * @time 17:04
 * @package com.json.fastjson
 * @project 1008MyDemo
 * @description
 */
public class Column {
    private String alias;
    private String name;
    private String type;
    private String location;
    private String info;
    private String order;

    @Override
    public String toString() {
        return "Column{" +
                "alias='" + alias + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", info='" + info + '\'' +
                ", order='" + order + '\'' +
                '}';
    }

    public Column() {
    }

    public Column(String alias, String name, String type, String location, String info, String order) {
        this.alias = alias;
        this.name = name;
        this.type = type;
        this.location = location;
        this.info = info;
        this.order = order;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
