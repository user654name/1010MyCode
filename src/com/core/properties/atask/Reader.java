package com.core.properties.atask;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/10
 * @time 10:05
 * @package com.core.properties.atask
 * @project 1008MyDemo
 * @description
 */
public class Reader {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ResourceBundle bundle = PropertyResourceBundle.getBundle("com/core/properties/atask/file1");
        Set<String> strings = bundle.keySet();
        for (String string : strings) {
            System.out.println("string = " + string);
        }
        String baseBundleName = bundle.getBaseBundleName();
        System.out.println("baseBundleName = " + baseBundleName);
        Locale locale = bundle.getLocale();
        System.out.println("locale = " + locale);
//        bundle.getObject()
        String string = new String(bundle.getString("table01.name").getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("string = " + string);
        Object object = bundle.getObject("table01.1");
        Object s = bundle.getString("table01.1");
        System.out.println("object = " + s);
        System.out.println("object = " + object);




    }
}
