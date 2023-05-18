/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.dto;

/**
 *
 * @author MSI
 */
public class PopUp {
    private String popupID;
    private String description;
    private int status;
    private String theme;

    public PopUp() {
    }

    public PopUp(String popupID, String description, int status, String theme) {
        this.popupID = popupID;
        this.description = description;
        this.status = status;
        this.theme = theme;
    }

    public String getPopupID() {
        return popupID;
    }

    public void setPopupID(String popupID) {
        this.popupID = popupID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "PopUp{" + "popupID=" + popupID + ", description=" + description + ", status=" + status + ", theme=" + theme + '}';
    }
    
    
    
}
