package com.pkm.model;

import java.util.List;
import java.util.Map;

/**
 * @author Tianqi.Zhang
 * @date 2019/4/30
 * @time 14:42
 * @package com.pkm.model
 * @project 1008MyDemo
 * @description
 */
public class Gamer {
    private String gamerName;
    private Map<Integer,Pkm> pkms;
    private Integer hp;

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Gamer(String gamerName) {
        this.gamerName = gamerName;
    }

    public Gamer(String gamerName, Integer hp) {
        this.gamerName = gamerName;
        this.hp = hp;
    }

    public String getGamerName() {
        return gamerName;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }

    public Map<Integer, Pkm> getPkms() {
        return pkms;
    }

    public void setPkms(Map<Integer, Pkm> pkms) {
        this.pkms = pkms;
    }
}
