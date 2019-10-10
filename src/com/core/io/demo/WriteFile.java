package com.core.io.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Tianqi.Zhang
 * @date 2019/8/26
 * @time 16:49
 * @package com.core.io.demo
 * @project 1008MyDemo
 * @description
 */
public class WriteFile {
    public static void main(String[] args) throws IOException {
        File guan = CreateFile.getFile("关");
        FileWriter fileWriter = new FileWriter(guan);
        fileWriter.write(getStr());
        fileWriter.flush();
        fileWriter.close();
        System.out.println("写入文件成功 ！");
    }

    private static String getStr() {
        StringBuilder text = new StringBuilder();
        text.append("明月出天山").append("，\n");
        text.append("苍茫云海间").append("。\n");
        text.append("李白").append("\n");
        return text.toString();
    }
}
