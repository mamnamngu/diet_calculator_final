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
public class SaleOff {
    private String saleoffID;
    private String description;
    private Date startdate;
    private Date enddate;
    private int target;

    public SaleOff() {
    }

    public SaleOff(String saleoffID, String description, Date startdate, Date enddate, int target) {
        this.saleoffID = saleoffID;
        this.description = description;
        this.startdate = startdate;
        this.enddate = enddate;
        this.target = target;
    }

    public String getSaleoffID() {
        return saleoffID;
    }

    public void setSaleoffID(String saleoffID) {
        this.saleoffID = saleoffID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "SaleOff{" + "saleoffID=" + saleoffID + ", description=" + description + ", startdate=" + startdate + ", enddate=" + enddate + ", target=" + target + '}';
    }
    
    
    
}
