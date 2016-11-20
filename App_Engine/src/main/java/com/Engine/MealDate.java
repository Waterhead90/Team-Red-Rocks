package com.Engine;

import java.io.Serializable;

/**
 *
 * @author donovan.beckmann
 */
public class MealDate implements Date, Serializable{
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    public MealDate(int year, int month, int day, int hour, int minute)
    {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public void setYear(int yyyy) {
        this.year = yyyy;
    }

    @Override
    public int getMonth() {
        return this.month;
    }

    @Override
    public void setMonth(int mm) {
        this.month = mm;
    }

    @Override
    public int getDay() {
        return this.day;
    }

    @Override
    public void setDay(int dd) {
        this.day = dd;
    }

    @Override
    public int getHour() {
        return this.hour;
    }

    @Override
    public void setHour(int hh) {
        this.hour = hh;
    }

    @Override
    public int getMinute() {
        return this.minute;
    }

    @Override
    public void setMinute(int mm) {
        this.minute = mm;
    }

    @Override
    public String toLongString() {
        return "Year: " + year + " Month: " + month + " Day: " + day + " Hour: "
                + hour + " Minute: " + minute;
    }

    @Override
    public String toString()
    {
        String s = year + ", " + month + ", " + day + ", " + hour + ", " + minute;
        return s;
    }

    /*@Override
    public boolean equals(Object o)
    {

    }
    */
}
