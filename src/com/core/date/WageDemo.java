package com.core.date;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/9
 * @time 11:03
 * @package com.core.date
 * @project 1008MyDemo
 * @description
 */
public class WageDemo {
    public static void main(String[] args) {
        int w = 8200;
        Map<String, Integer> cost = new HashMap<>(8);
        System.out.println("wage" + w);
        int rest = w;

        cost.put("HouseRent", 2500);
        cost.put("PiP罐", 500);
        cost.put("SaveBank", 1000);
        cost.put("EatWithPig", 1800);
        cost.put("EatAtNoon", 10*22);

        cost.put("BuyAGameInSteam",100 );
        cost.put("PayForCR",128 );



        for (String costKey : cost.keySet()) {
            rest = rest - cost.get(costKey);
        }



        System.out.println("rest = " + rest);
    }
}
