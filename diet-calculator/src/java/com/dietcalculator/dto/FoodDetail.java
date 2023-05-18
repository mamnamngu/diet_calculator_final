package com.dietcalculator.dto;

/**
 *
 * @author ADMIN
 */
public class FoodDetail implements Comparable{
    private String foodID;
    private String mealID;
    private double amount;
    private double totalCal;
    private double carbohydrate;
    private double fiber;
    private double protein;
    private double fat;
    private double water;
    private String icon;
    private String category;
    
    public FoodDetail() {
    }

    public FoodDetail(String foodID, String mealID, double amount, double totalCal, double carbohydrate, double fiber, double protein, double fat, double water, String icon, String category) {
        this.foodID = foodID;
        this.mealID = mealID;
        this.amount = amount;
        this.totalCal = totalCal;
        this.carbohydrate = carbohydrate;
        this.fiber = fiber;
        this.protein = protein;
        this.fat = fat;
        this.water = water;
        this.icon = icon;
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getMealID() {
        return mealID;
    }

    public void setMealID(String mealID) {
        this.mealID = mealID;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    @Override
    public String toString() {
        return "FoodDetail{" + "foodID=" + foodID + ", mealID=" + mealID + ", amount=" + amount + ", totalCal=" + totalCal + ", carbohydrate=" + carbohydrate + ", fiber=" + fiber + ", protein=" + protein + ", fat=" + fat + ", water=" + water + '}';
    }
    
    @Override
    public int compareTo(Object x){
        FoodDetail other = (FoodDetail) x;
        return this.getFoodID().compareTo(other.getFoodID());
    }
}
