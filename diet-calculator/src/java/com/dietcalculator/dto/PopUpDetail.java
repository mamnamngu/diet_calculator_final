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
public class PopUpDetail {
    private String popupID;
    private String productID;
    private String description;

    public PopUpDetail() {
    }

    public PopUpDetail(String popupID, String productID, String description) {
        this.popupID = popupID;
        this.productID = productID;
        this.description = description;
    }

    public String getPopupID() {
        return popupID;
    }

    public void setPopupID(String popupID) {
        this.popupID = popupID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PopUpDetail{" + "popupID=" + popupID + ", productID=" + productID + ", description=" + description + '}';
    }
    
    
}
