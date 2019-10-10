package com.http;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Tianqi.Zhang
 * @date 2019/8/17
 * @time 7:21
 * @package com.http
 * @project 1008MyDemo
 * @description
 */
public class HttpDemo {
    public static void main(String[] args) {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        String name = "5.jpg";
        HttpGet httpGet = new HttpGet("https://img1.mm131.me/pic/5096/" + name);

        //设置代理IP
//        HttpHost proxy = new HttpHost("186.233.104.25", 8080);
        //设置超时时间
//        RequestConfig config = RequestConfig.custom().setProxy(proxy).setConnectTimeout(5000).setConnectionRequestTimeout(5000).setSocketTimeout(5000).build();
        //添加请求头
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
//        httpGet.setConfig(config);
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                if (responseEntity.isStreaming()) {
                    InputStream inputStream = responseEntity.getContent();
                    String dir = "D:\\Users\\Administrator\\1008MyDemo\\src\\com\\http\\download\\dir0817";
                    File file = new File(dir, name);
                    FileOutputStream fileOut = new FileOutputStream(file);
                    byte[] buffer = new byte[10 * 1024];
                    int ch = 0;
                    while ((ch = inputStream.read(buffer)) != -1) {
                        fileOut.write(buffer, 0, ch);
                    }
                    inputStream.close();
                    fileOut.flush();
                    fileOut.close();
                } else {
                    System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
