package com.ztq.a_collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashOk {
    public static void main(String[] args) {
        Map hashMap = new HashMap();
        Map hashtable = new Hashtable();

        hashMap.put("电器老鼠", "皮卡丘");
        Object 电器老鼠 = hashMap.get("电器老鼠");





        hashtable.put("大猪猪", "拓明芬");
        Object 大猪猪1 = hashtable.get("大猪猪");


        System.out.println("大猪猪1 = " + 大猪猪1);

    }
}
