package com.dietcalculator.dto;

/**
 *
 * @author admin
 */
public class ExSession {
    private String sessionID;
    private String exerciseID;
    private String userID;
    private String dayID;
    private String icon;

    public ExSession() {
    }

    public ExSession(String sessionID, String exerciseID, String userID, String dayID, String icon) {
        this.sessionID = sessionID;
        this.exerciseID = exerciseID;
        this.userID = userID;
        this.dayID = dayID;
        this.icon = icon;
    }

    public String getDayID() {
        return dayID;
    }

    public void setDayID(String dayID) {
        this.dayID = dayID;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(String exerciseID) {
        this.exerciseID = exerciseID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    @Override
    public String toString() {
        return "ExSession{" + "sessionID=" + sessionID + ", exerciseID=" + exerciseID + ", userID=" + userID + ", dayID=" + dayID + '}';
    }
    
}
