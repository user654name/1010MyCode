package com.util;

import java.io.*;

/**
 * 复制文件夹或文件夹
 */
public class CopyUtil {
    public static boolean _choice = true;

    // 复制文件
    public static void CopyFile(File sourceFile, File targetFile)
            throws IOException {
        // 新建文件输入流并对它进行缓冲
        FileInputStream input = new FileInputStream(sourceFile);
        BufferedInputStream inBuff = new BufferedInputStream(input);

        // 新建文件输出流并对它进行缓冲
        FileOutputStream output = new FileOutputStream(targetFile);
        BufferedOutputStream outBuff = new BufferedOutputStream(output);

        // 缓冲数组
        byte[] b = new byte[1024 * 5];
        int len;
        while ((len = inBuff.read(b)) != -1) {
            outBuff.write(b, 0, len);
        }
        // 刷新此缓冲的输出流
        outBuff.flush();

        // 关闭流
        inBuff.close();
        outBuff.close();
        output.close();
        input.close();
    }

    // 复制文件夹
    public static void CopyDirectory(String sourceDir, String targetDir)
            throws IOException {
        // 新建目标目录
        (new File(targetDir)).mkdirs();
        // 获取源文件夹当前下的文件或目录
        File[] file = (new File(sourceDir)).listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                // 源文件
                File sourceFile = file[i];
                // 目标文件
                File targetFile = new File(
                        new File(targetDir).getAbsolutePath() + File.separator
                                + file[i].getName());
                CopyFile(sourceFile, targetFile);
            }
            if (file[i].isDirectory()) {
                // 准备复制的源文件夹
                String dir1 = sourceDir + File.separator + file[i].getName();
                // 准备复制的目标文件夹
                String dir2 = targetDir + File.separator + file[i].getName();
                CopyDirectory(dir1, dir2);
            }
        }
    }

    /**
     * 稍作包装，
     * 如果 url1 是文件的话，直接copyFile
     * 如果 url1 是文件夹的话，再 copyDirectory
     * @throws IOException
     */
    public static boolean PowerCopy(String source, String dest) {
        try {
            File input = new File(source);
            if(input.isFile() && !_choice) {
                // 如果输入是一个文件~
                (new File(dest)).mkdirs();
                File output = new File(dest+File.separator+input.getName());
                CopyFile(input, output);
            } else if(input.isFile() && _choice) {
                CopyFile(new File(source), new File(dest));
            } else {
                // 如果输入是一个文件夹~
                CopyDirectory(source, dest);
            }
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    /**
     * usage!!
     */
    public static void main(String args[]) throws IOException {
        // 单文件~
        String url1 = "/Users/user/Desktop/480*320.png";
        String url2 = "/Users/user/Desktop/481*320.png";

        // 源文件夹 -> 目标文件夹
//      String url1 = "/Users/user/Desktop/Resources";
//      String url2 = "/Users/user/Desktop/Resources2";
        PowerCopy(url1, url2);
    }
}