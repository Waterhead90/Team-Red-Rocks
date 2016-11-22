package com.Engine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jordan.r.falcon
 */
public class Nutrient implements Serializable {

    private String name;
    private String unit;

    public Nutrient (String n, String u)
    {
        name = n;
        unit = u;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nutrient)) return false;

        Nutrient nutrient = (Nutrient) o;

        if (name != null ? !name.equals(nutrient.name) : nutrient.name != null) return false;
        return unit != null ? unit.equals(nutrient.unit) : nutrient.unit == null;

    }

    @Override
    public String toString() {
        return "nutrient{" + "name =" + name + ", unit =" + unit + '}';
    }


}
