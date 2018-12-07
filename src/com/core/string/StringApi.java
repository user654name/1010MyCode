package com.core.string;

import org.junit.Test;

/**
 * @author Tianqi.Zhang
 * @date 2018/12/6
 * @time 14:38
 * @package com.core.string
 * @project 1008MyDemo
 * @description
 */

public class StringApi {

    @Test
    public void doIndexOf() {

        String s = "床前明月光";
        String a = "明";
        int i = s.indexOf(a);
        System.out.println("i = " + i);
        return;
    }
}
