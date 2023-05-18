package com.dietcalculator.dto;

/**
 *
 * @author ADMIN
 */
public class Meal {
    private String mealID;
    private String userID;
    private String dayID;
    private int mealindex;
    private double totalCalstd;
    private double carbohydratestd;
    private double fiberstd;
    private double proteinstd;
    private double fatstd;
    private double waterstd;
    private double totalCal;
    private double carbohydrate;
    private double fiber;
    private double protein;
    private double fat;
    private double water;

    public Meal() {
    }

    public Meal(String mealID, String userID, String dayID, int mealindex, double totalCalstd, double carbohydratestd, double fiberstd, double proteinstd, double fatstd, double waterstd, double totalCal, double carbohydrate, double fiber, double protein, double fat, double water) {
        this.mealID = mealID;
        this.userID = userID;
        this.dayID = dayID;
        this.mealindex = mealindex;
        this.totalCalstd = totalCalstd;
        this.carbohydratestd = carbohydratestd;
        this.fiberstd = fiberstd;
        this.proteinstd = proteinstd;
        this.fatstd = fatstd;
        this.waterstd = waterstd;
        this.totalCal = totalCal;
        this.carbohydrate = carbohydrate;
        this.fiber = fiber;
        this.protein = protein;
        this.fat = fat;
        this.water = water;
    }

    public Meal(String mealID, String userID, String dayID, int mealindex, double totalCalstd, double carbohydratestd, double fiberstd, double proteinstd, double fatstd, double waterstd) {
        this.mealID = mealID;
        this.userID = userID;
        this.dayID = dayID;
        this.mealindex = mealindex;
        this.totalCalstd = totalCalstd;
        this.carbohydratestd = carbohydratestd;
        this.fiberstd = fiberstd;
        this.proteinstd = proteinstd;
        this.fatstd = fatstd;
        this.waterstd = waterstd;
        this.totalCal = 0;
        this.carbohydrate = 0;
        this.fiber = 0;
        this.protein = 0;
        this.fat = 0;
        this.water = 0;
    }
    
    public void updateMeal(double totalCal, double carbohydrate, double fiber, double protein, double fat, double water){
        this.totalCal = totalCal;
        this.carbohydrate = carbohydrate;
        this.fiber = fiber;
        this.protein = protein;
        this.fat = fat;
        this.water = water;
    }

    public String getMealID() {
        return mealID;
    }

    public void setMealID(String mealID) {
        this.mealID = mealID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getDayID() {
        return dayID;
    }

    public void setDayID(String dayID) {
        this.dayID = dayID;
    }

    public int getMealindex() {
        return mealindex;
    }

    public void setMealindex(int mealindex) {
        this.mealindex = mealindex;
    }

    public double getTotalCalstd() {
        return totalCalstd;
    }

    public void setTotalCalstd(double totalCalstd) {
        this.totalCalstd = totalCalstd;
    }

    public double getCarbohydratestd() {
        return carbohydratestd;
    }

    public void setCarbohydratestd(double carbohydratestd) {
        this.carbohydratestd = carbohydratestd;
    }

    public double getFiberstd() {
        return fiberstd;
    }

    public void setFiberstd(double fiberstd) {
        this.fiberstd = fiberstd;
    }

    public double getProteinstd() {
        return proteinstd;
    }

    public void setProteinstd(double proteinstd) {
        this.proteinstd = proteinstd;
    }

    public double getFatstd() {
        return fatstd;
    }

    public void setFatstd(double fatstd) {
        this.fatstd = fatstd;
    }

    public double getWaterstd() {
        return waterstd;
    }

    public void setWaterstd(double waterstd) {
        this.waterstd = waterstd;
    }

    public double getTotalCal() {
        return totalCal;
    }

    public void setTotalCal(double totalCal) {
        this.totalCal = totalCal;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public double getFiber() {
        return fiber;
    }

    public void setFiber(double fiber) {
        this.fiber = fiber;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    @Override
    public String toString() {
        return "Meal{" + "mealID=" + mealID + ", userID=" + userID + ", dayID=" + dayID + ", mealindex=" + mealindex + ", totalCalstd=" + totalCalstd + ", carbohydratestd=" + carbohydratestd + ", fiberstd=" + fiberstd + ", proteinstd=" + proteinstd + ", fatstd=" + fatstd + ", waterstd=" + waterstd + ", totalCal=" + totalCal + ", carbohydrate=" + carbohydrate + ", fiber=" + fiber + ", protein=" + protein + ", fat=" + fat + ", water=" + water + '}';
    }
    
}
