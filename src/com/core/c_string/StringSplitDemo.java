package com.core.c_string;

public class StringSplitDemo {

    public static void main(String[] args) {
        
        String string1 ="明月出天山，苍茫云海间。长风几万里，吹度玉门关";

        String[] qieGeString = string1.split("。");
        for (String s : qieGeString) {
            String[] split = s.split("，");
            for (String s1 : split) {
                System.out.println("s1 = " + s1);
            }
        }
    }
}
