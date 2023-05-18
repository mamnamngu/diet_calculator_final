/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.dto;

/**
 *
 * @author asout
 */
public class Day {
    String dayID;
    String userID;
    int index;
    double totalCalstd;
    double carbohydratestd;
    double fiberstd;
    double proteinstd;
    double fatstd;
    double waterstd;
    double totalCal;
    double carbohydrate;
    double fiber;
    double protein;
    double fat;
    double water;

    public Day(){
        
    }

    public Day(String dayID, String userID, int index, double totalCalstd, double carbohydratestd, double fiberstd, double proteinstd, double fatstd, double waterstd, double totalCal, double carbohydrate, double fiber, double protein, double fat, double water) {
        this.dayID = dayID;
        this.userID = userID;
        this.index = index;
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
    
    public Day(String dayID, String userID, int index, double totalCalstd, double carbohydratestd, double fiberstd, double proteinstd, double fatstd, double waterstd) {
        this.dayID = dayID;
        this.userID = userID;
        this.index = index;
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
    
    public void updateDay(double totalCal, double carbohydrate, double fiber, double protein, double fat, double water){
        this.totalCal = totalCal;
        this.carbohydrate = carbohydrate;
        this.fiber = fiber;
        this.protein = protein;
        this.fat = fat;
        this.water = water;
    }

    public String getDayID() {
        return dayID;
    }

    public void setDayID(String dayID) {
        this.dayID = dayID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getTotalCal() {
        return totalCal;
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
        return "Day{" + "dayID=" + dayID + ", userID=" + userID + ", index=" + index + ", totalCalstd=" + totalCalstd + ", carbohydratestd=" + carbohydratestd + ", fiberstd=" + fiberstd + ", proteinstd=" + proteinstd + ", fatstd=" + fatstd + ", waterstd=" + waterstd + ", totalCal=" + totalCal + ", carbohydrate=" + carbohydrate + ", fiber=" + fiber + ", protein=" + protein + ", fat=" + fat + ", water=" + water + '}';
    }
    
    
}
