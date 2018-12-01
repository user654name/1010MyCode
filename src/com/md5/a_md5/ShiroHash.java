package com.md5.a_md5;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author Tianqi.Zhang
 * @date 2018/11/30
 * @time 16:01
 * @package com.md5.a_md5
 * @project 1008MyDemo
 * @description
 */
public class ShiroHash {

    public static void main(String[] args) {
        SimpleHash simpleHash = new SimpleHash("MD5");
        String string = simpleHash.toString();
        System.out.println("string = " + string);    }
}
