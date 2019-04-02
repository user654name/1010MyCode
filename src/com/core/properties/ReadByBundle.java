package com.core.properties;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author Tianqi.Zhang
 * @date 2019/3/28
 * @time 18:44
 * @package com.core.properties
 * @project 1008MyDemo
 * @description
 */
public class ReadByBundle {
    public static void main(String[] args) throws UnsupportedEncodingException {

        ResourceBundle.Control control = PropertyResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
        ResourceBundle bundle = PropertyResourceBundle
                .getBundle("com/core/properties/p", Locale.SIMPLIFIED_CHINESE, control);
        for (String s : bundle.keySet()) {
            String string = bundle.getString(s);
            System.out.println(s + " = " + new String
                    (string.getBytes("ISO-8859-1"), "UTF-8"));
        }
    }
}
