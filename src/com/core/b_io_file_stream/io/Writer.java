package com.core.b_io_file_stream.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {


    public static void main(String[] args) throws IOException {

        String pathName = "D:\\Users\\Administrator\\1008MyDemo\\src\\haha.txt";

        File file = new File(pathName);

        FileWriter fileWriter = new FileWriter(file);

        int i;
        for (i = 0; i < 6; i++) {
            fileWriter.write("aaaaabbbbbbb == 0"+i+"\n");
        }
        fileWriter.flush();

        fileWriter.close();


        FileReader fileReader = new FileReader(file);

        String encoding = fileReader.getEncoding();
        System.out.println("encoding = " + encoding);

    }
}
