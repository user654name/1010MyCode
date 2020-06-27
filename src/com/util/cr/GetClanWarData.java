package com.util.cr;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tianqi.Zhang
 * @date 2020/5/29
 * @time 23:19
 * @package com.util.cr
 * @project 1008MyDemo
 * @description
 */
public class GetClanWarData {


    public static void main(String[] args) throws IOException {

        String url = "https://royaleapi.com/clan/PCRQUPLG/war/analytics";
//        String html = HttpRequestUtil.sendGet(url, "");
        Document document = Jsoup.connect(url).get();
//        Elements elementsByClass = document.getElementsByClass("ui single line unstackable attached fluid sortable roster table");
////        document.get
//        System.out.println(elementsByClass);
//        document.select("img[src$]")

        // 0-9 日期
        Elements fields = document.getElementsByClass("one wide center aligned");
        Map dateMap = new HashMap(10);
        for (int i = 0; i < 10; i++) {
            dateMap.put(i,fields.get(i).text());
        }



    }
}
