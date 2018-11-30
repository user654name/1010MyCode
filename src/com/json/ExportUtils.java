package com.json;

/**
 * @author Tianqi.Zhang
 * @date 2018/11/29
 * @time 21:11
 * @package com.json
 * @project 1008MyDemo
 * @description
 */

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/**
 *
 * 2018年11月29日 21:20:46  老代给我的Excel代码 解析Json到Excel
 *
 * @Author: meng.liu@yintech.cn
 * @Date: 2018/7/19 20:42
 * @Description:
 * @version: V1.0
 */
public class ExportUtils {

    /**
     * 导出为PDF
     *
     * @param response response
     * @param headers PDF头信息
     * @param lists 数据展示信息
     * @param filePath PDF文件存放地址
     * @param <T> 类
     */
    public static <T> void myExportPDF(HttpServletResponse response, String[] headers, List<T> lists, String filePath) {
        Document document = new Document(PageSize.A2,50,50,50,50);
        PdfWriter pw = null;
        try {
            pw = PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            //中文字体显示，直接用下载的字体jar包也可以
            BaseFont baseFont = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H",false);
            Font font = new Font(baseFont,10, Font.NORMAL);

            Paragraph p = new Paragraph("test", font);
            document.add(p);

            PdfPTable table = new PdfPTable(headers.length);
            table.setSpacingBefore(25);
            table.setSpacingAfter(25);
            //创建表头
            for (int i = 0; i < headers.length; i++) {
                PdfPCell cell = new PdfPCell(new Paragraph(headers[i], font));
                table.addCell(cell);
            }

            // 遍历集合数据，产生数据行
            Iterator<T> it = lists.iterator();
            int index = 0;
            while (it.hasNext()) {
                index++;
                T t = (T) it.next();
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
                Field[] fields = t.getClass().getDeclaredFields();
                for (short i = 0; i < headers.length; i++) {
                    Field field = fields[i];
                    String fieldName = field.getName();
                    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    // 其它数据类型都当作字符串简单处理
                    if(value != null && value != ""){
                        textValue = value.toString();
                    }
                    if (textValue != null) {
                        XSSFRichTextString richString = new XSSFRichTextString(textValue);
                        table.addCell(new Paragraph(richString.toString(), font));
                    }
                }
            }

            document.add(table);
            document.close();
            pw.flush();
            pw.close();

            File file = new File(filePath);
            String fileName = file.getName();
            response.setContentType("application/pdf;charset=utf-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GBK"), "ISO8859-1"));
            response.setCharacterEncoding("utf-8");
            InputStream fis = new BufferedInputStream(new FileInputStream(file));
            byte[] b = new byte[fis.available()];
            fis.read(b);
            response.getOutputStream().write(b);
            response.getOutputStream().flush();
            response.getOutputStream().close();
            response.flushBuffer();
            fis.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出为Excel
     *
     * @param response response
     * @param headers PDF头信息
     * @param lists 数据展示信息
     * @param fileName 导出的文件名称
     * @param <T> 类
     */
    public static <T> void myExportExcel(HttpServletResponse response, String[] headers, List<T> lists, String fileName) {
        BufferedOutputStream fos = null;
        try {
            // 声明一个工作薄
            XSSFWorkbook workbook = new XSSFWorkbook();
            // 生成一个表格
            XSSFSheet sheet = workbook.createSheet(fileName);
            // 设置表格默认列宽度为15个字节
            sheet.setDefaultColumnWidth((short) 20);
            // 产生表格标题行
            XSSFRow row = sheet.createRow(0);
            for (short i = 0; i < headers.length; i++) {
                XSSFCell cell = row.createCell(i);
                XSSFRichTextString text = new XSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }

            // 遍历集合数据，产生数据行
            Iterator<T> it = lists.iterator();
            int index = 0;
            while (it.hasNext()) {
                index++;
                row = sheet.createRow(index);
                T t = (T) it.next();
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
                Field[] fields = t.getClass().getDeclaredFields();
                for (short i = 0; i < headers.length; i++) {
                    XSSFCell cell = row.createCell(i);
                    Field field = fields[i];
                    String fieldName = field.getName();
                    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Class tCls = t.getClass();
                    Method getMethod = null;
                    getMethod = tCls.getMethod(getMethodName, new Class[] {});

                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    // 其它数据类型都当作字符串简单处理
                    if(value != null && value != ""){
                        textValue = value.toString();
                    }
                    if (textValue != null) {
                        XSSFRichTextString richString = new XSSFRichTextString(textValue);
                        cell.setCellValue(richString);
                    }
                }
            }
            fileName = fileName + ".xlsx";
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1"));
            fos = new BufferedOutputStream(response.getOutputStream());
            workbook.write(fos);
            fos.close();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

