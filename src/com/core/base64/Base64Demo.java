package com.core.base64;

import java.util.Base64;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/27
 * @time 13:28
 * @package com.core.base64
 * @project 1008MyDemo
 * @description
 */
public class Base64Demo {
    private static final String DATA = "张TianQi";

    public static void main(String[] args) {
        try {
            // BASE64加密
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] data = encoder.encode(DATA.getBytes());
            System.out.println("BASE64加密(标准)：" + new String(data));
            /**
             * 或者采用以下方法，但是不赞成使用该方法，源码也做了@deprecation标记
             */
            System.out.println("BASE64加密(不推荐)：" + encoder.encodeToString(DATA.getBytes()));

            // BASE64解密
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] bytes = decoder.decode(data);
            System.out.println("BASE64解密(正确的打印)：" + new String(bytes));
            System.out.println("BASE64解密(错误的打印)：" + bytes.toString());

            // 结果
            // BASE64加密：Y29tLmJhc2U2NC5kZW1v
            // BASE64解密：com.base64.demo
        } catch (Exception e) {
            System.out.println("BASE64加解密异常");
            e.printStackTrace();
        }
    }
}
