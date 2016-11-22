package com.Engine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jordan.r.falcon
 */
public class Meal implements Serializable {

    private Venue location;
    private Date date;
    private List<MealEntry> mealEntries = new ArrayList();

    public Meal(Venue location, Date date, List<MealEntry> mealList) {
        this.location = location;
        this.date = date;
        mealEntries = mealList;
    }

    public Meal()
    {

    }

    public Venue getLocation() {
        return location;
    }

    public void setLocation(Venue location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<MealEntry> getMealEntries() {
        return mealEntries;
    }

    public void setMealEntries(List<MealEntry> list) {
        this.mealEntries = list;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "location =" + location +
                ", date =" + date +
                ", Meal Entries =" + mealEntries +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meal)) return false;

        Meal meal = (Meal) o;

        if (location != null ? !location.equals(meal.location) : meal.location != null)
            return false;
        if (date != null ? !date.equals(meal.date) : meal.date != null) return false;
        return mealEntries != null ? mealEntries.equals(meal.mealEntries) : meal.mealEntries == null;

    }


}
