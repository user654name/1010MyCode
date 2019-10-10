package com.rate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/31
 * @time 15:41
 * @package com.rate
 * @project 1008MyDemo
 * @description
 */
public class RateDeomm {

    public static void main(String[] args) {
        int aim = 6000;
        int playerScore = 5895;
        int win = 30;
        int lose = -28;
//        Rate rate = new Rate(3, 3, 3);
        Rate rate = new Rate(7, 8, 2);
        System.out.println("rate = " + rate);

        Map<Integer, Integer> result = getMap();
        for (int i = 0; i < 1; i++) {
            Record record = finishAim(aim, playerScore, win, lose, rate);
            int times = record.getTimes();
            int win1 = record.getWin();
            int lose1 = record.getLose();
            int draw = record.getDraw();
            int cost = times * 5;
            int h = cost / 60;
//            System.out.println("从" + playerScore + "达到" + aim + "经历" + times + "局" + "，其中赢" + win1 + "输" + lose1 + "平" + draw + "，耗时" + cost + "分钟大约" + h + "小时");
            if (h < 1) {
                result.put(1, result.get(1) + 1);
            } else if (h < 2) {
                result.put(2, result.get(2) + 1);
            } else if (h < 3) {
                result.put(3, result.get(3) + 1);
            } else if (h < 4) {
                result.put(4, result.get(4) + 1);
            } else if (h < 5) {
                result.put(5, result.get(5) + 1);
            } else if (h < 6) {
                result.put(6, result.get(6) + 1);
            } else if (h < 7) {
                result.put(7, result.get(7) + 1);
            } else {
                result.put(8, result.get(8) + 1);
            }
        }
        System.out.println("result = " + result);

        int sum = 0;
        for (Integer integer : result.keySet()) {
            sum = sum + result.get(integer);
        }
        System.out.println("样本数 = " + sum);
        for (Integer integer : result.keySet()) {
            Integer changci = result.get(integer);
            int rateee = changci* 1000 / sum ;
            result.put(integer,rateee);
        }
        for (Integer integer : result.keySet()) {
            if (integer == 8){
                System.out.println("大于"+integer+"小时达到6000分的概率为"+result.get(integer)/10.0+"%");
            }else {
                System.out.println("花费"+integer+"小时达到6000分的概率为"+result.get(integer)/10.0+"%");
            }
        }
    }

    private static Map<Integer, Integer> getMap() {
        Map<Integer, Integer> result = new HashMap(8);
        result.put(1, 0);
        result.put(2, 0);
        result.put(3, 0);
        result.put(4, 0);
        result.put(5, 0);
        result.put(6, 0);
        result.put(7, 0);
        result.put(8, 0);
        return result;
    }

    private static Record finishAim(int aim, int playerScore, int win, int lose, Rate rate) {
        Record record = new Record();
        int times = 0;
        int winn = 0;
        int losee = 0;
        int draww = 0;
        while (playerScore < aim) {
            times++;
            if (playAndWin(rate) > 0) {
                winn++;
                playerScore += win;
//                System.out.print("Game " + times);
//                System.out.print(",  Win + " + win);
//                System.out.println(", Score = " + playerScore);
            } else if (playAndWin(rate) < 0) {
                losee++;
                playerScore += lose;
//                System.out.print("Game " + times);
//                System.out.print(",  Lose - " + (0 - lose));
//                System.out.println(", Score = " + playerScore);
            } else {
                draww++;
//                System.out.print("Game " + times);
//                System.out.print(",  Draw + 0");
//                System.out.println(", Score = " + playerScore);
            }
        }
        record.setTimes(times);
        record.setWin(winn);
        record.setLose(losee);
        record.setDraw(draww);
        return record;
    }

    private static int playAndWin(Rate rate) {
        double winRate = rate.winRate;
        double loseRate = rate.loseRate;
        double random = Math.random();
        if (random < winRate) {
            return 1;
        } else if (random < winRate + loseRate) {
            return -1;
        } else {
            return 0;
        }
    }

    public static class Record {
        public int times;
        public int win;
        public int lose;
        public int draw;

        public Record() {

        }

        public Record(int times, int win, int lose, int draw) {
            this.times = times;
            this.win = win;
            this.lose = lose;
            this.draw = draw;
        }

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }

        public int getWin() {
            return win;
        }

        public void setWin(int win) {
            this.win = win;
        }

        public int getLose() {
            return lose;
        }

        public void setLose(int lose) {
            this.lose = lose;
        }

        public int getDraw() {
            return draw;
        }

        public void setDraw(int draw) {
            this.draw = draw;
        }

        public void setDraw() {
        }
    }


    public static class Rate {
        public double winRate;
        public double loseRate;
        public double drawRate;
        private int win;
        private int lost;
        private int draw;

        public Rate(int win, int lost, int draw) {
            this.win = win;
            this.lost = lost;
            this.draw = draw;
            int total = win + lost + draw;
            this.winRate = win * 1.0 / total;
            this.loseRate = lost * 1.0 / total;
            this.drawRate = draw * 1.0 / total;
        }

        @Override
        public String toString() {
            return "Rate{" +
                    "winRate=" + winRate +
                    ", loseRate=" + loseRate +
                    ", drawRate=" + drawRate +
                    ", win=" + win +
                    ", lost=" + lost +
                    ", draw=" + draw +
                    '}';
        }


    }


}
