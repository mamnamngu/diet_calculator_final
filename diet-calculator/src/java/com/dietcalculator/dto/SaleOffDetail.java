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
public class SaleOffDetail {
    private String detailID;
    private String saleoffID;
    private String productID;
    private int percentoff;
    private double priceoff;
    private String gift;

    public SaleOffDetail() {
    }

    public SaleOffDetail(String detailID, String saleoffID, String productID, int percentoff, double priceoff, String gift) {
        this.detailID = detailID;
        this.saleoffID = saleoffID;
        this.productID = productID;
        this.percentoff = percentoff;
        this.priceoff = priceoff;
        this.gift = gift;
    }

    public String getDetailID() {
        return detailID;
    }

    public void setDetailID(String detailID) {
        this.detailID = detailID;
    }

    public String getSaleoffID() {
        return saleoffID;
    }

    public void setSaleoffID(String saleoffID) {
        this.saleoffID = saleoffID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getPercentoff() {
        return percentoff;
    }

    public void setPercentoff(int percentoff) {
        this.percentoff = percentoff;
    }

    public double getPriceoff() {
        return priceoff;
    }

    public void setPriceoff(double priceoff) {
        this.priceoff = priceoff;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    @Override
    public String toString() {
        return "SaleOffDetail{" + "detailID=" + detailID + ", saleoffID=" + saleoffID + ", productID=" + productID + ", percentoff=" + percentoff + ", priceoff=" + priceoff + ", gift=" + gift + '}';
    }
    
    
    
}
