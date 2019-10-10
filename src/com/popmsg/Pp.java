package com.popmsg;

import javax.swing.*;

/**
 * @author Tianqi.Zhang
 * @date 2019/8/22
 * @time 13:03
 * @package com.popmsg
 * @project 1008MyDemo
 * @description
 */
public class Pp {
    public static void main(String[] args) {
        Object o = JOptionPane.showInputDialog(null, "msg", "title", JOptionPane.PLAIN_MESSAGE,
                null, new Object[]{1, 2}, 2);
        System.out.println("o = " + o);
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath = " + projectPath);
    }   
}
