package com.Engine;

/**
 *
 * @author donovan.beckmann
 */
public interface Date {
    public int getYear();
    public void setYear(int yyyy);

    public int getMonth();
    public void setMonth(int mm);

    public int getDay();
    public void setDay(int dd);

    public int getHour();
    public void setHour(int hh);

    public int getMinute();
    public void setMinute(int mm);

    public String toLongString();
    public String toString();
    public boolean equals(Object o); //MealDate doesn't use this method yet, Ask Ryan
}
