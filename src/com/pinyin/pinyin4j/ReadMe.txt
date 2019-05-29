转换方式为：
1. 字母大小写设置
.setCaseType(HanyuPinyinCaseType.LOWERCASE) 将拼音以小写字母输出
(上海 –>shanghai)

.setCaseType(HanyuPinyinCaseType.UPPERCASE) 将拼音以大写字母输出
(上海 –>SHANGHAI)

2.拼音音调设置
. setToneType(HanyuPinyinToneType.WITHOUT_TONE) 无音调显示
（ 刘–>liu）

.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER)用数字表示声调
（ 刘–>liu4）

. setToneType(HanyuPinyinToneType.WITH_TONE_MARK) 用声调符表示
( 刘–> liú )

3.多音字输出(仅在存在多音字情况下)
例如：“重”可输出为
.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0] –>zhong
.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[1] –>chong

4.特殊拼音输出格式
例如：“绿”可输出为
.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON) –> lu:
.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE) –>lü
.setVCharType(HanyuPinyinVCharType.WITH_V) –> lv

5.拼音特定位
例如：“重”可输出为
.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0].charAt(0) –>z
.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0].charAt(1) –>h
.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0].charAt(2) –>o
---------------------
作者：wyky481l
来源：CSDN
原文：https://blog.csdn.net/wyky481l/article/details/70037553
版权声明：本文为博主原创文章，转载请附上博文链接！