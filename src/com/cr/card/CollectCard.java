package com.cr.card;

import com.util.DateUtil;

/**
 * @author Tianqi.Zhang
 * @date 2019/10/17
 * @time 9:03
 * @package com.cr.card
 * @project 1008MyDemo
 * @description
 */
public class CollectCard {

    public static void main(String[] args) {
        CardNum c0704 = new CardNum(DateUtil.toDate("2019-07-04"), 225236, 53518, 5662, 169);
        CardNum c1017 = new CardNum(DateUtil.toDate("2019-10-17"), 229850, 65018, 7362, 244);

        int gap = DateUtil.getGap(c0704.getDate(), c1017.getDate());
        System.out.println("gap = " + gap);
        gap = 105;
        int r = (c1017.getRares() - c0704.getRares()) / gap;
        int e = (c1017.getEpics() - c0704.getEpics()) / gap;
        double l = (c1017.getLegendaries() - c0704.getLegendaries()) * 1.0 / gap;

        System.out.println("r = " + r * 7);
        System.out.println("e = " + e * 7);
        System.out.println("l = " + l * 7);
    }
}
