package com.util.pc;

import com.util.CopyUtil;
import com.util.HttpRequestUtil;
import com.util.StringFileToolkit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

/**
 * @author Tianqi.Zhang
 * @date 2020/5/30
 * @time 1:04
 * @package com.util.pc
 * @project 1008MyDemo
 * @description
 */
public class DownloadPic {
    public static void main(String[] args) throws IOException {
        int index = 943788;
        for (int i = 0; i < 100; i++) {
            String url = "https://www.ivsky.com/tupian/shuangjianbao_meinv_v59696/pic_" + (index + i) + ".html";
            try {
                downloadImg(index + i, url);
                Thread.sleep(1000);
            } catch (IOException e) {
                System.out.println("error");
            } catch (InterruptedException e) {
                System.out.println("sleep error");
            }catch (Exception e){
                System.out.println("skip");
            }

        }


    }

    private static void downloadImg(int index, String url) throws IOException {
        String html = HttpRequestUtil.sendGet(url, null);
        System.out.println("url " + url);
        Document document = Jsoup.parse(html);
        Element imgis = document.getElementById("imgis");
        String imgSrc = imgis.attr("src");
        imgSrc = imgSrc.substring(2, imgSrc.length());
        imgSrc = "http://" + imgSrc;
        System.out.println(imgSrc);
        File file = StringFileToolkit.getFileByUrl(imgSrc, "jpg");
        System.out.println(file);
        File dir = new File("D:\\Users\\Administrator\\1008MyDemo\\src\\com\\util\\pic");
        File file1 = new File(dir, "" + index + ".jpg");
        CopyUtil.CopyFile(file, file1);
    }
}
