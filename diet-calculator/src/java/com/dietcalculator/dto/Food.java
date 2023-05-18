package com.dietcalculator.dto;

/**
 *
 * @author ADMIN
 */
public class Food {
    private String foodID;
    private String foodname;
    private String category;
    private int size;
    private int caloricintake;
    private double carbohydrate;
    private double fiber;
    private double protein;
    private double fat;
    private double water;
    private String icon;
    private String description;

    public Food() {
    }

    public Food(String foodID, String foodname, String category, int size, int caloricintake, double carbohydrate, double fiber, double protein, double fat, double water, String icon, String description) {
        this.foodID = foodID;
        this.foodname = foodname;
        this.category = category;
        this.size = size;
        this.caloricintake = caloricintake;
        this.carbohydrate = carbohydrate;
        this.fiber = fiber;
        this.protein = protein;
        this.fat = fat;
        this.water = water;
        this.icon = icon;
        this.description = description;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCaloricintake() {
        return caloricintake;
    }

    public void setCaloricintake(int caloricintake) {
        this.caloricintake = caloricintake;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Food{" + "foodID=" + foodID + ", foodname=" + foodname + ", category=" + category + ", size=" + size + ", caloricintake=" + caloricintake + ", carbohydrate=" + carbohydrate + ", fiber=" + fiber + ", protein=" + protein + ", fat=" + fat + ", water=" + water + '}';
    }
    
    
}
