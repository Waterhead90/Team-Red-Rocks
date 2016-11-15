package com.Engine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;

/**
 *
 * THIS MAKES NO SENSE PLEASE EXPLAIN
 * LIST WILL RETURN NULL UNTIL I ASK QUESTIONS AND GET ANSWERS
 * @author mitchell.olson.1
 */
public class NutrientCalculator implements CalculatorInterface{

    @Override
    public List<Recommendation> getRecommendations(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Date> getListDates(int numDaysPriorToToday) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getPDV(NutrientTotal nutrientTotal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NutrientTotal> getNutrientTotals(Date fromDate, Date toDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<NutrientTotal> getRDANutrientTotals(int numDays){
        return null;
    }

    public List<Nutrient> lowestNutrients(int numLowest){
        return null;
    }

    public List<MealEntry> getAllMealEntries(Date date){
        return null;
    }

}
