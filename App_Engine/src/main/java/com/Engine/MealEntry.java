package com.Engine;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Objects;

/**
 *
 * @author mitchell.olson.1
 */
public class MealEntry extends MenuItem{

    /**
     * @param args the command line arguments
     */
    //Declare Variables
    MenuItem menuItem = new MenuItem();
    double amount;

    public MealEntry(MenuItem item, double amount) {
        if(item != null)
            menuItem = item;

        if(amount >= 0)
            this.amount = amount;

    }

    public MenuItem getMenuItem(){
        return menuItem;
    }

    public void setMenuItem(MenuItem item){
        this.menuItem = item;
    }
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "MealEntry{" + "menuItem=" + menuItem + ", amount=" + amount + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.menuItem);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >>> 32));
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
        final MealEntry other = (MealEntry) obj;
        if (Double.doubleToLongBits(this.amount) != Double.doubleToLongBits(other.amount)) {
            return false;
        }
        if (!Objects.equals(this.menuItem, other.menuItem)) {
            return false;
        }
        return true;
    }



}
