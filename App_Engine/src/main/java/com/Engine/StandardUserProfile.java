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
public class StandardUserProfile implements UserProfile {

    private int recommendedCalories = 2000;
    private int weight;
    private int height;
    private char gender;
    private int age;
    private int activityLevel;

    private List <Meal> meals = new ArrayList();

    public StandardUserProfile() {

    }

    @Override
    public int getRecommendedCalories() {
        return recommendedCalories;
    }

    @Override
    public void setRecommendedCalories(int calories) {
        recommendedCalories = calories;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int pounds) {
        weight = pounds;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int inches) {
        height = inches;
    }

    @Override
    public int getActivityLevel() {
        return activityLevel;
    }

    @Override
    public void setActivityLevel(int intensity) {
        activityLevel = intensity;
    }

    @Override
    public char getGender() {
        return gender;
    }

    @Override
    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public List<Meal> getMeals() {
        return meals;
    }

    @Override
    public void setMeals(List<Meal> list) {
        this.meals = list;
    }

    @Override
    public void addMeal(Meal m) {
        meals.add(m);
    }

    @Override
    public void removeMeal(Meal m) {
        meals.remove(m);
    }

    // Double check this for me. Not sure if right or wrong.
    @Override
    public List<Meal> getMealsFor(Date date) {

            for (Meal listMeals : meals)
            {
                for (int i = 0; i < meals.size(); i++)
                if (meals.get(i).getDate().equals(date))
                {
                    return meals;
                }
            }
        return null;
    }


}
