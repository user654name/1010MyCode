package com.core.properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

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
        File file = new File("D:\\Users\\Administrator\\1008MyDemo\\src\\com\\core\\properties\\p.properties");
        System.out.println(file.exists());
        String path = file.getPath();

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        properties.load(bufferedReader);

        Enumeration<?> enumeration = properties.propertyNames();
        System.out.println(enumeration);
        while (enumeration.hasMoreElements()) {
            Object o = enumeration.nextElement();
            System.out.println("o = " + o);
            System.out.println(properties.getProperty(o.toString()));
        }
    }

}
