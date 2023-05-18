/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.dao;

import com.dietcalculator.dto.Day;
import com.dietcalculator.util.DBUtils;
import com.dietcalculator.util.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asout
 */
public class DayDAO {

    public String lastIDIndex() {
        String sql = "SELECT TOP 1 dayID FROM Day ORDER BY dayID DESC";
        String index = "DAY00000";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                index = rs.getString("dayID");
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return index;
    }

    public ArrayList<Day> readDayByUserID(String userID) {
        ArrayList<Day> list = new ArrayList();
        String sql = "SELECT * FROM Day WHERE userID = ? ORDER BY [index]";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Day(rs.getString("dayID"), rs.getString("userID"), rs.getInt("index"), rs.getDouble("totalCalstd"), rs.getDouble("carbohydratestd"), rs.getDouble("fiberstd"), rs.getDouble("proteinstd"), rs.getDouble("fatstd"), rs.getDouble("waterstd")));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public boolean createDay(String dayID, String userID, int index, double totalCalstd, double carbohydratestd, double fiberstd, double proteinstd, double fatstd, double waterstd, double totalCal, double carbohydrate, double fiber, double protein, double fat, double water) {
        String sql = "INSERT INTO Day VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int row = 0;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dayID);
            ps.setString(2, userID);
            ps.setInt(3, index);
            ps.setDouble(4, totalCalstd);
            ps.setDouble(5, carbohydratestd);
            ps.setDouble(6, fiberstd);
            ps.setDouble(7, proteinstd);
            ps.setDouble(8, fatstd);
            ps.setDouble(9, waterstd);
            ps.setDouble(10, totalCal);
            ps.setDouble(11, carbohydrate);
            ps.setDouble(12, fiber);
            ps.setDouble(13, protein);
            ps.setDouble(14, fat);
            ps.setDouble(15, water);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }
    
    public boolean createDate(Day day){
        return createDay(day.getDayID(), day.getUserID(), day.getIndex(), day.getTotalCalstd(), day.getCarbohydratestd(), day.getFiberstd(), day.getProteinstd(), day.getFatstd(), day.getWaterstd(), day.getTotalCal(), day.getCarbohydrate(), day.getFiber(), day.getProtein(), day.getFat(), day.getWater());
    }

    public boolean updateDay(String dayID, String userID, int index, double totalCalstd, double carbohydratestd, double fiberstd, double proteinstd, double fatstd, double waterstd, double totalCal, double carbohydrate, double fiber, double protein, double fat, double water) {
        String sql = "UPDATE Day SET userID = ?, [index] = ?, totalCalstd = ?, carbohydratestd = ?, fiberstd = ?, proteinstd = ?, fatstd = ?, waterstd = ?, totalCal = ?, carbohydrate = ?, fiber = ?, protein = ?, fat = ?, water = ? WHERE dayID = ?";
        int row = 0;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setInt(2, index);
            ps.setDouble(3, totalCalstd);
            ps.setDouble(4, carbohydratestd);
            ps.setDouble(5, fiberstd);
            ps.setDouble(6, proteinstd);
            ps.setDouble(7, fatstd);
            ps.setDouble(8, waterstd);
            ps.setDouble(9, totalCal);
            ps.setDouble(10, carbohydrate);
            ps.setDouble(11, fiber);
            ps.setDouble(12, protein);
            ps.setDouble(13, fat);
            ps.setDouble(14, water);
            ps.setString(15, dayID);
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }

    public boolean deleteDay(String dayID) {
        int row = 0;
        String sql = "DELETE FROM Day WHERE dayID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dayID);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }
    
    public boolean deleteDayByUserID(String userID){
        int row = 0;
        String sql = "DELETE FROM Day WHERE userID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }
    
    public Day readDayByDayID(String dayID) {
        Day day = null;
        String sql = "SELECT * FROM Day WHERE dayID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dayID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                day = new Day(rs.getString("dayID"), rs.getString("userID"), rs.getInt("index"), rs.getDouble("totalCalstd"), rs.getDouble("carbohydratestd"), rs.getDouble("fiberstd"), rs.getDouble("proteinstd"), rs.getDouble("fatstd"), rs.getDouble("waterstd"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return day;
    }
}
