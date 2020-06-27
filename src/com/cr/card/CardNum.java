package com.cr.card;

import lombok.Data;

import java.util.Date;

/**
 * @author Tianqi.Zhang
 * @date 2019/10/17
 * @time 9:03
 * @package com.cr.card
 * @project 1008MyDemo
 * @description
 */
@Data
public class CardNum {
    private Date date;
    private int commons;
    private int rares;
    private int epics;
    private int legendaries;

    public CardNum() {
    }

    public CardNum(Date date, int commons, int rares, int epics, int legendaries) {

        this.date = date;
        this.commons = commons;
        this.rares = rares;
        this.epics = epics;
        this.legendaries = legendaries;
    }
}
