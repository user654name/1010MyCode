package com.ztq.io_file_stream.io;

import java.io.File;

public class CopyDemo {

    public static void main(String[] args) {



        String parent = "D:\\MyJavaTest";
        String fileName="郭小萍 - 那年冬天.mp3";

        File file = new File(parent,fileName);

        System.out.println(        file.exists());    }

}
