package com.Engine;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;

/**
 *
 * @author jordan.r.falcon
 */
public interface UserProfile {

    public int getRecommendedCalories();
    public void setRecommendedCalories(int calories);
    public int getWeight();
    public void setWeight(int pounds);
    public int getHeight();
    public void setHeight(int inches);
    public int getActivityLevel();
    public void setActivityLevel(int intensity);
    public char getGender();
    public void setGender(char gender);
    public int getAge();
    public void setAge(int age);

    public List<Meal> getMeals();
    public void setMeals(List<Meal> list);

    public void addMeal(Meal m);
    public void removeMeal (Meal m);
    public List<Meal> getMealsFor(Date date);

    @Override
    public String toString();

    @Override
    public boolean equals(Object o);




}
