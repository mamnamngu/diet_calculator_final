package com.dietcalculator.dto;

/**
 *
 * @author ADMIN
 */
public class Exercise {
    private String exerciseID;
    private String exname;
    private double lowerweight;
    private double upperweight;
    private int calorexp;
    private String icon;
    private String description;

    public Exercise(String exerciseID, String exname, double lowerweight, double upperweight, int calorexp, String icon, String description) {
        this.exerciseID = exerciseID;
        this.exname = exname;
        this.lowerweight = lowerweight;
        this.upperweight = upperweight;
        this.calorexp = calorexp;
        this.icon = icon;
        this.description = description;
    }

    public Exercise() {
    }

    public String getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(String exerciseID) {
        this.exerciseID = exerciseID;
    }

    public String getExname() {
        return exname;
    }

    public void setExname(String exname) {
        this.exname = exname;
    }

    public double getLowerweight() {
        return lowerweight;
    }

    public void setLowerweight(double lowerweight) {
        this.lowerweight = lowerweight;
    }

    public double getUpperweight() {
        return upperweight;
    }

    public void setUpperweight(double upperweight) {
        this.upperweight = upperweight;
    }

    public int getCalorexp() {
        return calorexp;
    }

    public void setCalorexp(int calorexp) {
        this.calorexp = calorexp;
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
        return "Exercise{" + "exerciseID=" + exerciseID + ", exname=" + exname + ", lowerweight=" + lowerweight + ", upperweight=" + upperweight + ", calorexp=" + calorexp + '}';
    }
    
}
