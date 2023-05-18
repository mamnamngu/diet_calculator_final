/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.dao;

import com.dietcalculator.dto.PopUpDetail;

import com.dietcalculator.util.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class PopUpDetailDAO {

    public ArrayList<PopUpDetail> readPopUpDetail(String popupID) {
        ArrayList<PopUpDetail> list = new ArrayList<>();
        String sql = "SELECT popupID, productID,description FROM PopUpDetail WHERE popupID = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, popupID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new PopUpDetail(rs.getString("popupID"), rs.getString("productID"), rs.getString("description")));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public boolean createPopUpDetail(String popupID, String productID, String description) {
        int row = 0;
        String sql = "insert into PopUpDetail values (?,?,?)";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, popupID);
            ps.setString(2, productID);
            ps.setString(3, description);

            row = ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return row > 0;
    }

    public boolean updatePopUpDetail(String popupID, String productID, String description) {
        int row = 0;
        String sql = " UPDATE PopUpDetail SET description = ? where popupID = ? and productID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, description);
            ps.setString(2, popupID);
            ps.setString(3, productID);

            row = ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return row > 0;
    }

    public boolean deletePopUpDetail(String popupID, String productID) {
        int row = 0;
        String sql = "DELETE from PopUpDetail where popupID = ? and productID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, popupID);
            ps.setString(2, productID);
            row = ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return row > 0;
    }

    public static void main(String[] args) {
//        PopUpDetailDAO dao = new PopUpDetailDAO();

//        System.out.println("Create");
//        dao.createPopUpDetail("POP000", "PRO0000","SAn Pham Chat luong kem");
//        ArrayList<PopUpDetail> list = dao.readPopUpDetail();
//        for(PopUpDetail pop : list){
//             System.out.println(pop.toString());
//        }
//         
//         System.out.println("");
//         System.out.println("Update");
//         dao.updatePopUpDetail("POP000", "PRO0000", "San Pham Chat Luong Cao");
//         list = dao.readPopUpDetail();
//           for(PopUpDetail pop : list){
//             System.out.println(pop.toString());
//         }
//          
//           System.out.println("");
//           System.out.println("Delete");
//           dao.deletePopUpDetail("POP000", "PRO0000");
//          list = dao.readPopUpDetail();
//                for(PopUpDetail pop : list){
//             System.out.println(pop.toString());
//         }
    }
}
