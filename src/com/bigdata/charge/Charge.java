package com.bigdata.charge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Tianqi.Zhang
 * @date 2019/5/13
 * @time 9:02
 * @package com.bigdata.charge
 * @project 1008MyDemo
 * @description
 */
public class Charge {

    private Date date;
    private String dateString;
    private int mileage;
    private int gapOfDate;
    private int getOfMile;

    public Charge(Date date, int mileage) {
        this.dateString = date.getYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
        this.date = date;
        this.mileage = mileage;
    }

    public Charge(String dateString, int mileage) {
        this.dateString = dateString;
        Date parse = null;
        try {
            parse = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.date = parse;
        this.mileage = mileage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getGapOfDate() {
        return gapOfDate;
    }

    public void setGapOfDate(int gapOfDate) {
        this.gapOfDate = gapOfDate;
    }

    public int getGetOfMile() {
        return getOfMile;
    }

    public void setGetOfMile(int getOfMile) {
        this.getOfMile = getOfMile;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "date=" + dateString +
                ", mileage='" + mileage + '\'' +
                ", gapOfDate='" + gapOfDate + '\'' +
                ", getOfMile='" + getOfMile + '\'' +
                '}';
    }
}
