/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.util;

/**
 *exi
 * @author asout
 */
public class MealValues {
    private final double carbohydrate;
    private final double fiber;
    private final double protein;
    private final double standardProtein;
    private final double fat;
    private final double water;

    //FULLY LOADED CONSTRUCTOR
    public MealValues(double carbohydrate, double fiber, double protein, double standardProtein, double fat, double water) {
        this.carbohydrate = carbohydrate;
        this.fiber = fiber;
        this.protein = protein;
        this.standardProtein = standardProtein;
        this.fat = fat;
        this.water = water;
    }

    //GETTERS
    
    public double getCarbohydrate() {
        return carbohydrate;
    }

    public double getFiber() {
        return fiber;
    }

    public double getProtein() {
        return protein;
    }

    public double getStandardProtein() {
        return standardProtein;
    }

    public double getFat() {
        return fat;
    }

    public double getWater() {
        return water;
    }
    
    
}
