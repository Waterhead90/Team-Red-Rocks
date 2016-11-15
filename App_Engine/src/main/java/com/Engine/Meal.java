package com.Engine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jordan.r.falcon
 */
public class Meal {

    private Venue location;
    private Date date;
    private List<MealEntry> mealEntries = new ArrayList();

    public Meal(Venue location, Date date, MealEntry mealEntry) {
        this.location = location;
        this.date = date;
        mealEntries.add(mealEntry);
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

    public List<MealEntry> getMealEntries(int index) {
        return mealEntries.subList(index, index);
    }

//      WHAT IS THIS SUPPOSE TO DO??????
//    public void setMealEntries(int index, List<MealEntry> mealEntries) {
//        mealEntries.set(index, mealEntries);
//    }




}
