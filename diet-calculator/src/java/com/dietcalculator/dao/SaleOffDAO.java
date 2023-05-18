/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.dao;

import com.dietcalculator.dto.Product;
import com.dietcalculator.dto.SaleOff;
import com.dietcalculator.util.DBUtils;
import com.dietcalculator.util.Utils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class SaleOffDAO {

    public String lastIDIndex() {
        String sql = "select top 1 saleoffID from SaleOff order by saleoffID desc";
        String index = "SALE000";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                index = rs.getString("saleoffID");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return index;
    }

    public ArrayList<SaleOff> readSaleOff() {
        ArrayList<SaleOff> list = new ArrayList<>();
        String sql = "SELECT saleoffID,description,startdate,enddate,target FROM SaleOff";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SaleOff(rs.getString("saleoffID"), rs.getString("description"), rs.getDate("startdate"), rs.getDate("enddate"), rs.getInt("target")));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;

    }

    public boolean createSaleOff(String saleoffID, String description, Date startdate, Date enddate, int target) {
        int row = 0;
        String sql = "insert into SaleOff values (?,?,?,?,?)";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, saleoffID);
            ps.setString(2, description);
            ps.setDate(3, startdate);
            ps.setDate(4, enddate);
            ps.setInt(5, target);

            row = ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return row > 0;
    }

    public boolean updateSaleOff(String saleoffID, String description, Date startdate, Date enddate, int target) {
        int row = 0;
        String sql = "UPDATE SaleOff SET  description = ?, startdate =?, enddate =?, target = ? where saleoffID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, description);
            ps.setDate(2, startdate);
            ps.setDate(3, enddate);
            ps.setInt(4, target);
            ps.setString(5, saleoffID);
            row = ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return row > 0;
    }

    public boolean deleteSaleOff(String saleoffID) {
        int row = 0;
        String sql = "DELETE from SaleOff where saleoffID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, saleoffID);
            row = ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return row > 0;
    }

    public static void main(String[] args) {
        SaleOffDAO dao = new SaleOffDAO();

        System.out.println("Create");
        dao.createSaleOff("SALE000", "Khoi bla bla", Utils.convertJavaDateToSqlDate(2023, 01, 03), Utils.convertJavaDateToSqlDate(2023, 01, 04), 20);
        ArrayList<SaleOff> list = dao.readSaleOff();
        for (SaleOff sale : list) {
            System.out.println(sale.toString());
        }

//         System.out.println("");
//         System.out.println("Update");
//         dao.updateSaleOff(saleoffID, description, startdate, enddate, 0);
//         list = dao.readSaleOff();
//           for(SaleOff sale : list){
//             System.out.println(sale.toString());
//         }
        System.out.println("");
        System.out.println("Delete");
        dao.deleteSaleOff("SALE000");
        list = dao.readSaleOff();
        for (SaleOff sale : list) {
            System.out.println(sale.toString());
        }
    }
}
