/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.dto;

import java.sql.Date;

/**
 *
 * @author MSI
 */
public class Bill {
    private String billID;
    private String userID;
    private Date date;
    private String delivery;
    private String payment;

    public Bill() {
    }

    public Bill(String billID, String userID, Date date, String delivery, String payment) {
        this.billID = billID;
        this.userID = userID;
        this.date = date;
        this.delivery = delivery;
        this.payment = payment;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Bill{" + "billID=" + billID + ", userID=" + userID + ", date=" + date + ", delivery=" + delivery + ", payment=" + payment + '}';
    }
    
    
    
}
