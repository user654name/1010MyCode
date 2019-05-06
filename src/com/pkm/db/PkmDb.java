package com.pkm.db;

import com.pkm.model.Pkm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tianqi.Zhang
 * @date 2019/4/30
 * @time 14:13
 * @package com.pkm.db
 * @project 1008MyDemo
 * @description
 */
public class PkmDb {

    public static Map<Integer,Pkm> allPkmMap=new HashMap<>();
    static {
        allPkmMap.put(1,new Pkm(1,"Seed","G",2,0,100,0,2));
        allPkmMap.put(2,new Pkm(1,"Grass","G",3,0,100,0,3));
        allPkmMap.put(3,new Pkm(1,"Flower","G",5,0,100,0,0));
        allPkmMap.put(4,new Pkm(1,"BabyFire","F",2,0,100,0,5));
        allPkmMap.put(5,new Pkm(1,"Firer","F",3,0,100,0,6));
        allPkmMap.put(6,new Pkm(1,"FireDragon","F",5,0,100,0,0));
        allPkmMap.put(7,new Pkm(1,"Turtle","W",2,0,100,0,8));
        allPkmMap.put(8,new Pkm(1,"KaTur","W",3,0,100,0,9));
        allPkmMap.put(9,new Pkm(1,"RocketsTur","W",5,0,100,0,0));
    }

    public static Map<Integer, Pkm> getAllPkmMap() {
        return allPkmMap;
    }

    public static void setAllPkmMap(Map<Integer, Pkm> allPkmMap) {
        PkmDb.allPkmMap = allPkmMap;
    }
}
