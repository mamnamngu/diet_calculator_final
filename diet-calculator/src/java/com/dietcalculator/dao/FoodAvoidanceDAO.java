package com.dietcalculator.dao;

import com.dietcalculator.util.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class FoodAvoidanceDAO {

    public ArrayList<String> readFoodAvoidanceByUserID(String userID) {
        ArrayList<String> list = new ArrayList();
        String sql = "SELECT foodID FROM FoodAvoidance WHERE userID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("foodID"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public boolean createFoodAvoidance(String userID, String foodID) {
        String sql = "INSERT INTO FoodAvoidance(userID, foodID) VALUES (?,?)";
        int row = 0;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, foodID);

            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }

    public boolean deleteFoodAvoidance(String userID, String foodID) {
        String sql = "DELETE FROM FoodAvoidance WHERE userID = ? AND foodID = ?";
        int row = 0;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, foodID);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }

//    public boolean updateFoodAvoidanceByUserID(String userID, String foodID) {
//        String sql = "UPDATE FoodAvoidance SET foodID = ?  WHERE userID = ?";
//        int row = 0;
//        try {
//            Connection conn = DBUtils.getConnection();
//            PreparedStatement ps = conn.prepareStatement(sql);
//    
//            ps.setString(1, foodID);
//            ps.setString(2, userID);
//
//            row = ps.executeUpdate();
//            ps.close();
//            conn.close();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return row > 0;
//    }
    public static void main(String[] args) {
        FoodAvoidanceDAO dao = new FoodAvoidanceDAO();
        System.out.println("Create");
        dao.createFoodAvoidance("U00000", "FD00001");
        dao.createFoodAvoidance("U00000", "FD00002");
        ArrayList<String> list = dao.readFoodAvoidanceByUserID("U00000");
        for (String x : list) {
            System.out.println(x);
        }
        dao.deleteFoodAvoidance("U00000", "FD00001");
        dao.deleteFoodAvoidance("U00000", "FD00002");
        list = dao.readFoodAvoidanceByUserID("U00000");
        for (String x : list) {
            System.out.println(x);
        }

    }
}
