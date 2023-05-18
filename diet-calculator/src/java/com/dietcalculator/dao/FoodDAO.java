/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.dao;

import com.dietcalculator.dto.Food;
import com.dietcalculator.util.DBUtils;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author asout
 */
public class FoodDAO {

    public ArrayList<Food> foodDataSet(int type, ArrayList<String> foodAvoidanceID) {
        ArrayList<Food> list = new ArrayList();
        String sql = "SELECT foodID,foodname,category,size,caloricintake,carbohydrate,fiber,protein,fat,water from Food WHERE ";
        return list;
    }

    public String lastIDIndex() {
        String sql = "SELECT TOP 1 foodID FROM Food ORDER BY foodID DESC";
        String index = "FD00000";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                index = rs.getString("foodID");
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return index;
    }

    public ArrayList<Food> readFood() {
        ArrayList<Food> list = new ArrayList<>();
        String sql = "select * from Food";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Food(rs.getString("foodID"), rs.getString("foodname"), rs.getString("category"), rs.getInt("size"), rs.getInt("caloricintake"),
                        rs.getDouble("carbohydrate"), rs.getDouble("fiber"), rs.getDouble("protein"), rs.getDouble("fat"), rs.getDouble("water"), rs.getString("icon"), rs.getString("description")));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public boolean createFood(String foodID, String foodname, String category, int size, int caloricintake, double carbohydrate, double fiber, double protein, double fat, double water, String icon, String description) {
        int row = 0;
        String sql = "insert into Food values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, foodID);
            ps.setString(2, foodname);
            ps.setString(3, category);
            ps.setInt(4, size);
            ps.setInt(5, caloricintake);
            ps.setDouble(6, carbohydrate);
            ps.setDouble(7, fiber);
            ps.setDouble(8, protein);
            ps.setDouble(9, fat);
            ps.setDouble(10, water);
            ps.setString(11, icon);
            ps.setString(12, description);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }

    public boolean updateFood(String foodID, String foodname, String category, int size, int caloricintake, double carbohydrate, double fiber, double protein, double fat, double water, String icon, String description) {
        String sql = "UPDATE Food SET foodname = ?, category = ?, size = ?, caloricintake = ?, carbohydrate = ?, fiber = ?, protein = ?, fat = ?, water = ?, icon = ?, description = ? WHERE foodID = ?";
        int row = 0;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, foodname);
            ps.setString(2, category);
            ps.setInt(3, size);
            ps.setInt(4, caloricintake);
            ps.setDouble(5, carbohydrate);
            ps.setDouble(6, fiber);
            ps.setDouble(7, protein);
            ps.setDouble(8, fat);
            ps.setDouble(9, water);
            ps.setString(10, icon);
            ps.setString(11, description);
            ps.setString(12, foodID);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }

    public boolean deleteFood(String foodID) {
        int row = 0;
        String sql = "DELETE FROM Food WHERE foodID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, foodID);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }

    public static void main(String[] args) {
        FoodDAO dao = new FoodDAO();
        
        System.out.println("Create");
        dao.createFood("FD00000", "test", "test", 0, 0, 0, 0, 0, 0, 0,"","");
        ArrayList<Food> list = dao.readFood();
        for (Food food : list) {
            System.out.println(food.toString());
        }

        System.out.println("Update");
        dao.updateFood("FD00000", "test Update", "test", 0, 0, 0, 0, 0, 0, 0,"","");
        list = dao.readFood();
        for (Food food : list) {
            System.out.println(food.toString());
        }

        System.out.println("Delete");
        dao.deleteFood("FD00000");
                 list = dao.readFood();
        for (Food food : list) {
            System.out.println(food.toString());
        }
    }
}
