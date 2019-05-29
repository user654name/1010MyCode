package com.pinyin.pinyin4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/28
 * @time 16:03
 * @package com.pinyin.pinyin4j
 * @project 1008MyDemo
 * @description
 */
public class TestFindElementTime {
    public static void main(String[] args) {
        int times = 1000000;
        Map build = build(times);
        HashMap hashMap = (HashMap) build.get("h");
        ArrayList arrayList = (ArrayList) build.get("a");
        String aim = "340000";
        long start1 = System.currentTimeMillis();
        boolean b = hashMap.containsKey(aim);
        if (b){
            hashMap.get(aim);
        }
        System.out.println("time builder " + (System.currentTimeMillis() - start1));


        long start2 = System.currentTimeMillis();
        boolean contains = arrayList.contains(aim);
        if ( contains){
            for (Object o : arrayList) {
                if (Objects.equals(aim,o)){
                    break;
                }
            }
        }
        System.out.println("time buffer " + (System.currentTimeMillis() - start2));


    }

    private static Map build(int num) {

        Map r = new HashMap();
        HashMap<String, String> hashMap = new HashMap();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String s = "" + i;
            hashMap.put(s, s);
            arrayList.add(s);
        }
        r.put("h", hashMap);
        r.put("a", arrayList);
        return r;
    }
}
