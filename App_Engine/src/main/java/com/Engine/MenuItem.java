package com.Engine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jordan.r.falcon
 */
public class MenuItem implements MenuInterface{

    private String name;
    private double servingSize;
    private String servingUnit;
    private List<NutrientTotal> nutrientTotal;
    private String category;
    private String infoSource;
    private String venue;

    public MenuItem(String name, double servingSize, String servingUnit, List<NutrientTotal> nutrientList, String category, String infoSource, String venue)
    {

        this.name = name;
        this.servingSize = servingSize;
        this.servingUnit = servingUnit;
        nutrientTotal = nutrientList;
        this.category = category;
        this.infoSource = infoSource;
        this.venue = venue;
    }

    // Does this need to be here. If so, what default values are needed?
    MenuItem() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuItem other = (MenuItem) obj;
        if (Double.doubleToLongBits(this.servingSize) != Double.doubleToLongBits(other.servingSize)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.servingUnit, other.servingUnit)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.infoSource, other.infoSource)) {
            return false;
        }
        if (!Objects.equals(this.venue, other.venue)) {
            return false;
        }
        if (!Objects.equals(this.nutrientTotal, other.nutrientTotal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "name=" + name + ", servingSize=" + servingSize + ", servingUnit=" + servingUnit + ", nutrients=" + nutrientTotal + ", category=" + category + ", infoSource=" + infoSource + ", venue=" + venue + '}';
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getServingSize() {
        return servingSize;
    }

    @Override
    public void setServingSize(double serving) {
        this.servingSize = serving;
    }

    @Override
    public String getServingUnit() {
        return servingUnit;
    }

    @Override
    public void setServingUnit(String servingUnit) {
        this.servingUnit = servingUnit;
    }

        //Explain how this should function. Like does this need to be a list of nutrient totals that get added
        //when this class is created or is there suppose to be a list already made that has this information.
    @Override
    public List<NutrientTotal> getNutrientTotals() {
        return nutrientTotal;
    }

    @Override
    public void setNutrients(List<NutrientTotal> list) {
        this.nutrientTotal = list;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getInfoSource() {
        return infoSource;
    }

    @Override
    public void setInfoSource(String source) {
        this.infoSource = source;
    }

    @Override
    public String getVenue() {
        return venue;
    }

    @Override
    public void setVenue(String venue) {
        this.venue = venue;
    }

}
