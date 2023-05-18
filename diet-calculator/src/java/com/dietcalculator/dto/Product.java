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
public class Product {
    private String productID;
    private String productname;
    private String type;
    private double price;
    private int quantity;
    private String brand;
    private String origin;
    private double volume;
    private String effect;
    private double rate;
    private double purchase;

    public Product() {
    }

    public Product(String productID, String productname, String type, double price, int quantity, String brand, String origin, double volume, String effect, double rate, double purchase) {
        this.productID = productID;
        this.productname = productname;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.origin = origin;
        this.volume = volume;
        this.effect = effect;
        this.rate = rate;
        this.purchase = purchase;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getPurchase() {
        return purchase;
    }

    public void setPurchase(double purchase) {
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productname=" + productname + ", type=" + type + ", price=" + price + ", quantity=" + quantity + ", brand=" + brand + ", origin=" + origin + ", volume=" + volume + ", effect=" + effect + ", rate=" + rate + ", purchase=" + purchase + '}';
    }

   
    
    
}
