package com.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 字符串与文件相互转换工具
 *
 * @author leizhimin 2009-7-14 15:54:18
 */
public class StringFileToolkit {
    private static Log log = LogFactory.getLog(StringFileToolkit.class);

    /**
     * 读取文件为一个内存字符串,保持文件原有的换行格式
     *
     * @param file    文件对象
     * @param charset 文件字符集编码
     * @return 文件内容的字符串
     */
    public static String file2String(File file, String charset) {
        StringBuffer sb = new StringBuffer();
        try {
            LineNumberReader reader = new LineNumberReader(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.getProperty("line.separator"));
            }
        } catch (UnsupportedEncodingException e) {
            log.error("读取文件为一个内存字符串失败，失败原因是使用了不支持的字符编码" + charset, e);
        } catch (FileNotFoundException e) {
            log.error("读取文件为一个内存字符串失败，失败原因所给的文件" + file + "不存在！", e);
        } catch (IOException e) {
            log.error("读取文件为一个内存字符串失败，失败原因是读取文件异常！", e);
        }
        return sb.toString();
    }

    /**
     * 将字符串存储为一个文件，当文件不存在时候，自动创建该文件，当文件已存在时候，重写文件的内容，特定情况下，还与操作系统的权限有关。
     *
     * @param text     字符串
     * @param distFile 存储的目标文件
     * @return 当存储正确无误时返回true，否则返回false
     */
    public static boolean string2File(String text, File distFile) {
        if (!distFile.getParentFile().exists()) distFile.getParentFile().mkdirs();
        BufferedReader br = null;
        BufferedWriter bw = null;
        boolean flag = true;
        try {
            br = new BufferedReader(new StringReader(text));
            bw = new BufferedWriter(new FileWriter(distFile));
            char buf[] = new char[1024 * 64];         //字符缓冲区
            int len;
            while ((len = br.read(buf)) != -1) {
                bw.write(buf, 0, len);
            }
            bw.flush();
            br.close();
            bw.close();
        } catch (IOException e) {
            flag = false;
            log.error("将字符串写入文件发生异常！", e);
        }
        return flag;
    }


    public static void main(String[] args) throws IOException {
        String url = "https://ss.nmxtmb.com/tp/girl/lulutu/youwuguan/A_024/01.txt";

        File fileByUrl = getFileByUrl(url, "jpg");
    }


    public static  File getFileByUrl(String fileUrl, String suffix) {

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        BufferedOutputStream stream = null;
        InputStream inputStream = null;

        File file = null;
        try {
            URL imageUrl = new URL(fileUrl);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            inputStream = conn.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            file = File.createTempFile("pattern", "." + suffix);
            System.out.println("临时文件创建成功={}" + file.getCanonicalPath());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            stream = new BufferedOutputStream(fileOutputStream);
            stream.write(outStream.toByteArray());

        } catch (Exception e) {

            System.out.println("创建人脸获取服务器图片异常");

        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (stream != null) {
                    stream.close();
                }
                outStream.close();
            } catch (Exception e) {
                System.out.println("关闭流异常");
            }
        }

        return file;

    }

}