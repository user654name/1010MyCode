package com.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tianqi.Zhang
 * @date 2018/11/29
 * @time 11:08
 * @package com.json
 * @project 1008MyDemo
 * @description
 */
public class Json {
    public static void main(String[] args) throws IOException {
    /*    JSONObject dataJson = new JSONObject("你的Json数据“);
                JSONObject response = dataJson.getJSONObject("response");
        JSONArray data = response.getJSONArray("data");
        JSONObject info = data.getJSONObject(0);
        String province = info.getString("province");
        String city = info.getString("city");
        String district = info.getString("district");
        String address = info.getString("address");
        System.out.println(province + city + district + address);
    */
        Map mainMap = new HashMap(2);
        Map map = new HashMap();
        map.put("LIMIT", 1);
        map.put("START", 0);
        mainMap.put("PAGE_COND", map);

        Object o = JSON.toJSON(mainMap);

       
    }
}
