package com.beantest;


import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/10
 * @time 15:16
 * @package com.beantest
 * @project 1008MyDemo
 * @description
 */
public class BeanTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Cat cat = new Cat("name",2);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name","数据");
        map.put("age", 23);
        // 实现了Map注入Cat
        BeanUtils.populate(cat, map);
        System.out.println("cat = " + cat);


    }


}

