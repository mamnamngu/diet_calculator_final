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
public class ProductDetail {
    private String detailID;
    
    private String productID;
    private String userID;
    private String billID;
    private int quantity;

    public ProductDetail() {
    }

    public ProductDetail(String detailID, String productID, String userID, String billID, int quantity) {
        this.detailID = detailID;
        this.productID = productID;
        this.userID = userID;
        this.billID = billID;
        this.quantity = quantity;
    }

    public String getDetailID() {
        return detailID;
    }

    public void setDetailID(String detailID) {
        this.detailID = detailID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductDetail{" + "detailID=" + detailID + ", productID=" + productID + ", userID=" + userID + ", billID=" + billID + ", quantity=" + quantity + '}';
    }

   
}
