package com.core.i_io_file_stream.file;

import java.io.File;

public class MyTestFile {

    public static void main(String[] args) {

        File file = new File("src\\com\\core\\file\\haha.txt");
        boolean exists = file.exists();
        System.out.println("exists = " + exists);


        File file2 = new File("haha.txt");

        boolean exists1 = file2.exists();
        System.out.println("exists1 = " + exists1);

    }


}
