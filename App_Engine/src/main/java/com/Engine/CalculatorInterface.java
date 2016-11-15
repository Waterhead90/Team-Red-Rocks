package com.Engine;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;

/**
 *
 * @author mitchell.olson.1
 */
public interface CalculatorInterface {


    public List<Recommendation> getRecommendations(int num);
    public List<Date> getListDates(int numDaysPriorToToday);
    public double getPDV(NutrientTotal nutrientTotal);
    public List<NutrientTotal> getNutrientTotals(Date fromDate, Date toDate);

}
