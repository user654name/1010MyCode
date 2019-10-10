package com.cr.clan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Tianqi.Zhang
 * @date 2019/10/9
 * @time 14:08
 * @package com.cr.clan
 * @project 1008MyDemo
 * @description
 */
public class ClanScore {

    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>(50);
        addInfo(scores, 6300, 1);
        addInfo(scores, 6000, 1);
        addInfo(scores, 5800, 3);
        addInfo(scores, 5650, 5);
        addInfo(scores, 5300, 13);
        addInfo(scores, 5000, 20);
//        addInfo(scores, 5000, 10);
        int clanScore = getClanScore(scores);
        System.out.println(clanScore);

    }

    /**
     * @param scores 集合
     * @param score  分数
     * @param times  人数
     */
    private static void addInfo(List<Integer> scores, int score, int times) {
        for (int i = 0; i < times; i++) {
            scores.add(score);
        }
    }

    /**
     * 先排序
     * 从高向低
     * 1-10     50%
     * 11-20    25%
     * 21-30    12%
     * 31-40    10%
     * 41-50    3%
     *
     * @param scores
     * @return
     */
    private static int getClanScore(List<Integer> scores) {

        for (int i = 0; i < 50; i++) {
            scores.add(0);
        }
        Collections.sort(scores, null);
        Collections.reverse(scores);
        int sum = 0;
        for (int i = 0; i < scores.size(); i++) {
            Integer score = scores.get(i);

            if (i < 10) {
                sum += score * 0.5;
            } else if (i < 20) {
                sum += score * 0.25;
            } else if (i < 30) {
                sum += score * 0.12;
            } else if (i < 40) {
                sum += score * 0.10;
            } else if (i < 50) {
                sum += score * 0.03;
            }

        }
        return sum;
    }
}
