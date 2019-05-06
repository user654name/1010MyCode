package com.pkm.db;

import com.pkm.model.Pkm;
import com.pkm.model.TypeRst;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Tianqi.Zhang
 * @date 2019/4/30
 * @time 15:31
 * @package com.pkm.db
 * @project 1008MyDemo
 * @description
 */
public class TypeDb {

    public static List<TypeRst> typeDb = new ArrayList<>();

    static {
        typeDb.add(new TypeRst("G", "G", 0.5));
        typeDb.add(new TypeRst("G", "F", 0.0));
        typeDb.add(new TypeRst("G", "W", 2.0));
        typeDb.add(new TypeRst("F", "G", 2.0));
        typeDb.add(new TypeRst("F", "F", 0.5));
        typeDb.add(new TypeRst("F", "W", 0.0));
        typeDb.add(new TypeRst("W", "G", 0.0));
        typeDb.add(new TypeRst("W", "F", 2.0));
        typeDb.add(new TypeRst("W", "W", 0.5));
    }

   public static Double aHitd(Pkm a, Pkm d) {
        Integer aAtt = a.getAtt();
        Integer dAtt = d.getAtt();
        for (TypeRst typeRst : typeDb) {
            if (Objects.equals(typeRst.getA(), a.getType())) {
                if (Objects.equals(typeRst.getD(), d.getType())) {
                    return typeRst.getRst();
                }
            }
        }
        return 100000.0;
    }

}
