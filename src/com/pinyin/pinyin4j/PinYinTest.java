package com.pinyin.pinyin4j;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/24
 * @time 9:35
 * @package com.pinyin.pinyin4j
 * @project 1008MyDemo
 * @description
 */
public class PinYinTest {
    @Test
    public void amain() throws BadHanyuPinyinOutputFormatCombination {


        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        //设置汉子拼音输出的格式

        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);

        char c = '大';
        String s = PinyinHelper.toHanyuPinyinStringArray(c, format)[0];
        System.out.println(s);
//
//        String[] strings1 = PinyinHelper.toGwoyeuRomatzyhStringArray(c);
//        print(strings1);
//        System.out.println();
//
//        String[] strings2 = PinyinHelper.toMPS2PinyinStringArray(c);
//        print(strings2);
//        System.out.println();
//
//        String[] strings3 = PinyinHelper.toHanyuPinyinStringArray(c);
//        print(strings3);
//        System.out.println();


    }

    private static void print(String[] strings) {
        for (String string : strings) {
            System.out.print(string);
        }
    }

}
