package com.core.properties;

import java.io.*;
import java.util.Properties;
import java.util.Random;

/**
 * @author Tianqi.Zhang
 * @date 2019/3/6
 * @time 14:23
 * @package com.core
 * @project 1008MyDemo
 * @description 写个例子 用于读取配置文件内容
 */
public class ReadProperties {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        // 使用InPutStream流读取properties文件
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader
                        ("D:\\Users\\Administrator\\1008MyDemo\\src\\com\\core\\properties\\p.properties"));
        properties.load(bufferedReader);
        // 获取key对应的value值
        String username = properties.getProperty("username[1]");
        System.out.println("username[1] = " + username);
        String password = properties.getProperty("password");
        System.out.println("password = " + password);
        int num = Integer.parseInt(properties.getProperty("num"));
        System.out.println("num = " + num);


    }

}
