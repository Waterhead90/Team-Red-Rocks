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
public interface RecommendedDailyAllowance {

    public List<NutrientTotal> getAdjustedRDA(int calories);

    @Override
    public String toString();

    @Override
    public boolean equals(Object o);

}
