package com.bigdata.charge;

import java.text.ParseException;
import java.util.*;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/13
 * @time 9:09
 * @package com.bigdata.charge
 * @project 1008MyDemo
 * @description
 */
public class ChargeRecords {

    private static List<Charge> dataBase = new LinkedList<>();

    public static void main(String[] args) throws ParseException {
        buildDatabase();
        setGapForData();

        Map<String, Integer> map = new HashMap<>();
        for (Charge charge : dataBase) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(charge.getDate());
            int month = instance.get(Calendar.MONTH) + 1;
            int year = instance.get(Calendar.YEAR);
            String dateKey = year + "-" + month;

            if (map.containsKey(dateKey)) {
                map.put(dateKey, map.get(dateKey) + 1);
            } else {
                map.put(dateKey, 1);
            }
            System.out.println("charge = " + charge);
        }

        System.out.println("map = " + map);

    }

    private static void setGapForData() {
        List<Charge> newData = new LinkedList<>();
        Charge last = null;
        for (Charge charge : dataBase) {
            if (charge.getMileage() == 0) {
                last = charge;
                newData.add(charge);
                continue;
            }
            // 计算里程数
            charge.setGetOfMile(charge.getMileage() - last.getMileage());
            // 计算间隔天数
            long lastTime = last.getDate().getTime();
            long currentTime = charge.getDate().getTime();
            long lGap = (currentTime - lastTime) / (60 * 60 * 24 * 1000);
            charge.setGapOfDate((int) lGap);
            last = charge;
            newData.add(charge);
        }
        dataBase = newData;
    }

    public static void buildDatabase() throws ParseException {
        r201811to12();
        r201901();
        r201902();
        r201903to04();
        r201905to06();
    }

    private static void r201905to06() {
        dataBase.add(new Charge("2019-5-2", 2006));
        dataBase.add(new Charge("2019-5-5", 2055));
        dataBase.add(new Charge("2019-5-9", 2109));
    }

    private static void r201903to04() {
        //     03 13   1419
        //     03 15   1456
        //     03 19   1475
        //     03 22   1520
        //     03 26   1559
        //     03 28   1604
        dataBase.add(new Charge("2019-3-1", 1267));
        dataBase.add(new Charge("2019-3-4", 1300));
        dataBase.add(new Charge("2019-3-6", 1339));
        dataBase.add(new Charge("2019-3-10", 1379));
        dataBase.add(new Charge("2019-3-13", 1419));
        dataBase.add(new Charge("2019-3-15", 1456));
        dataBase.add(new Charge("2019-3-19", 1475));
        dataBase.add(new Charge("2019-3-22", 1520));
        dataBase.add(new Charge("2019-3-26", 1559));
        dataBase.add(new Charge("2019-3-28", 1604));
        //     04 02   1651
        //     04 09   1702
        //     04 12   1740
        //     04 15   1774
        //     04 18   1818
        //     04 21   1856
        //     04 25   1909
        //     04 29   1960
        dataBase.add(new Charge("2019-4-02", 1651));
        dataBase.add(new Charge("2019-4-09", 1702));
        dataBase.add(new Charge("2019-4-12", 1740));
        dataBase.add(new Charge("2019-4-15", 1774));
        dataBase.add(new Charge("2019-4-18", 1818));
        dataBase.add(new Charge("2019-4-21", 1856));
        dataBase.add(new Charge("2019-4-25", 1909));
        dataBase.add(new Charge("2019-4-29", 1960));
    }

    private static void r201902() {
        dataBase.add(new Charge("2019-2-11", 1074));
        dataBase.add(new Charge("2019-2-14", 1106));
        dataBase.add(new Charge("2019-2-19", 1146));
        dataBase.add(new Charge("2019-2-22", 1189));
        dataBase.add(new Charge("2019-2-27", 1231));
    }

    private static void r201901() {
        dataBase.add(new Charge("2019-1-2", 690));
        dataBase.add(new Charge("2019-1-6", 737));
        dataBase.add(new Charge("2019-1-9", 780));
        dataBase.add(new Charge("2019-1-14", 807));
        dataBase.add(new Charge("2019-1-16", 848));
        dataBase.add(new Charge("2019-1-19", 889));
        dataBase.add(new Charge("2019-1-23", 935));
        dataBase.add(new Charge("2019-1-25", 969));
        dataBase.add(new Charge("2019-1-27", 997));
        dataBase.add(new Charge("2019-1-29", 1028));
    }

    private static void r201811to12() {

        dataBase.add(new Charge("2018-11-9", 0));
        dataBase.add(new Charge("2018-11-12", 59));
        dataBase.add(new Charge("2018-11-16", 111));
        dataBase.add(new Charge("2018-11-17", 142));
        dataBase.add(new Charge("2018-11-20", 182));
        dataBase.add(new Charge("2018-11-23", 212));
        dataBase.add(new Charge("2018-11-27", 246));
        dataBase.add(new Charge("2018-11-29", 288));

        dataBase.add(new Charge("2018-12-2", 335));
        dataBase.add(new Charge("2018-12-6", 379));
        dataBase.add(new Charge("2018-12-11", 416));
        dataBase.add(new Charge("2018-12-14", 446));
        dataBase.add(new Charge("2018-12-17", 490));
        dataBase.add(new Charge("2018-12-19", 538));
        dataBase.add(new Charge("2018-12-21", 569));
        dataBase.add(new Charge("2018-12-23", 612));
        dataBase.add(new Charge("2018-12-27", 659));
    }


    /**
     * 电动车里程充电记录
     11 09   买车
     11 12   59
     11 16   111
     11 17   142
     11 20   182
     11 23   212
     11 27   246
     11 29   288
     12 02   335
     12 06   379
     12 11    416
     12 14   446
     12 17   490
     12 19   538
     12 21   569
     12 23   612
     12 27   659
     01 02   690
     01 06   737
     01 09   780
     01 14   807
     01 16   848
     01 19   889
     01 23   935
     01 25   969
     01 27   997
     01 29   1028
     02 11   1074
     02 14   1106
     02 19   1146
     02 22   1189
     02 27   1231
     03 01   1267
     03 04   1300
     03 06   1339
     03 10   1379
     03 13   1419
     03 15   1456
     03 19   1475
     03 22   1520
     03 26   1559
     03 28   1604
     04 02   1651
     04 09   1702
     04 12   1740
     04 15   1774
     04 18   1818
     04 21   1856
     04 25   1909
     04 29   1960
     05 02   2006
     05 05   2055
     05 09   2109
     */
}
