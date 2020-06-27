package com.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpRequestUtil {

    public static void main(String[] args) {
//        String s;
////        s = sendGet("https://royaleapi.com/clan/PCRQUPLG", null);
//
//        s= StringFileToolkit.file2String(new File("D:\\Users\\Administrator\\1008MyDemo\\src\\com\\util\\clanInfo.html"),"utf8");
//
//        Document document = Jsoup.parse(s);
//
//        // 获取表格
//        Element roster = document.getElementById("roster");
//        Elements userInfoElems = roster.getElementsByAttribute("data-role");
//        int i = 1;
//        for (Element userInfoElem : userInfoElems) {
//            Player player = new Player();
//            player.setTag(userInfoElem.attr("data-tag"));
//            player.setRole(userInfoElem.attr("data-role"));
//            Elements td = userInfoElem.getElementsByTag("td");
//            String rankNow = td.get(0).attr("data-sort-value");
//            String nickName = td.get(1).attr("data-sort-value");
//            String trophies = td.get(7).attr("data-sort-value");
//            String level = td.get(8).attr("data-sort-value");
//            String donate = td.get(9).attr("data-sort-value");
//            String received = td.get(10).attr("data-sort-value");
//
////            System.out.println(td.get(8));
//            player.setNickName(nickName);
//            player.setTrophies(trophies);
//            player.setLevel(level);
//            player.setDonate(donate);
//            player.setReceived(received);
//
////            for (int j = 0; j < td.size(); j++) {
////                /*
////                 j=0 data-sort-value部落当前排名
////                 j=1 data-sort-value昵称
////                 j=234 图
////                 j=5 text职位
////                 j=6 ？？
////                 j=7 text杯数
////                 j=8 国王塔等级
////                 j=9 data-sort-value捐卡数目
////                 j=10 data-sort-value求卡数目
////                 */
//////                System.out.println("NUMN"+j+td.get(j));
////            }
//
//
//
//            System.out.println(player);
//        }

    }
    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "utf-8"));//防止乱码
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }



}