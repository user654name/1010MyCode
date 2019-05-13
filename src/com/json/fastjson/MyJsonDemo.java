package com.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.JSONWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/9
 * @time 17:03
 * @package com.json.fastjson
 * @project 1008MyDemo
 * @description
 */
public class MyJsonDemo {
    public static void main(String[] args) {
        Map map =new HashMap(8);
        map.put("1","2");
        map.put("13","2");
        map.put("13123","2");
        map.put("12","2");

        Object json = JSONObject.toJSON(map);
        System.out.println("json = " + json);
        Map map1 = JSON.parseObject(json.toString(), Map.class);
        System.out.println("map1 = " + map1);

    }
}
