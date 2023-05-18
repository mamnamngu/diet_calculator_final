package com.dietcalculator.dto;

/**
 *
 * @author ADMIN
 */
public class Type {
    private String foodID;
    private int type;

    public Type() {
    }

    public Type(String foodID, int type) {
        this.foodID = foodID;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }
    
}
