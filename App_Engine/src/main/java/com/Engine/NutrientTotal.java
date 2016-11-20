package com.Engine;



import java.util.Objects;

/**
 *
 * @author donovan.beckmann
 */
public class NutrientTotal {
    private Nutrient nutrient;
    private double amount;


    public NutrientTotal(Nutrient nutrient, double amount) {
        this.nutrient = nutrient;
        this.amount = amount;
    }

    public Nutrient getNutrient() {
        return nutrient;
    }
    public void setNutrient(Nutrient n) {
        this.nutrient = n;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double d) {
        this.amount = d;
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
        final NutrientTotal other = (NutrientTotal) obj;
        if (Double.doubleToLongBits(this.amount) != Double.doubleToLongBits(other.amount)) {
            return false;
        }
        if (!Objects.equals(this.nutrient, other.nutrient)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NutrientTotal{" + "nutrient=" + nutrient + ", amount=" + amount + '}';
    }


}