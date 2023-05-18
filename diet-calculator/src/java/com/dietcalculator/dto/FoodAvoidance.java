package com.dietcalculator.dto;

/**
 *
 * @author ADMIN
 */
public class FoodAvoidance {
    private String userID;
    private String foodID;

    public FoodAvoidance() {
    }

    public FoodAvoidance(String userID, String foodID) {
        this.userID = userID;
        this.foodID = foodID;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "FoodAvoidance{" + "userID=" + userID + ", foodID=" + foodID + '}';
    }
    
}
