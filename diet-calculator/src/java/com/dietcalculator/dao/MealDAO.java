package com.dietcalculator.dao;

import com.dietcalculator.dto.Meal;
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
public class MealDAO {
    public String lastIDIndex(){
        String sql = "SELECT TOP 1 mealID FROM Meal ORDER BY mealID DESC";
        String index = "MEAL00000";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) 
                index = rs.getString("mealID");
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return index;
    }

    public ArrayList<Meal> readMealByDayID(String dayID) {
        ArrayList<Meal> list = new ArrayList<>();
        String sql = "SELECT mealID,userID,dayID,mealindex,totalCalstd,carbohydratestd,fiberstd,proteinstd,fatstd,waterstd,totalCal,carbohydrate,fiber,protein,fat,water FROM Meal WHERE dayID = ? ORDER BY mealindex ASC";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dayID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Meal(rs.getString("mealID"), rs.getString("userID"), rs.getString("dayID"), rs.getInt("mealindex"), rs.getDouble("totalCalstd"),rs.getDouble("carbohydratestd"),rs.getDouble("fiberstd"),rs.getDouble("proteinstd"),rs.getDouble("fatstd"),rs.getDouble("waterstd"),rs.getDouble("totalCal"),rs.getDouble("carbohydrate"),rs.getDouble("fiber"),rs.getDouble("protein"),rs.getDouble("fat"),rs.getDouble("water")));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public boolean createMeal(String mealID, String userID, String dayID, int mealindex, double totalCalstd, double carbohydratestd, double fiberstd, double proteinstd, double fatstd, double waterstd, double totalCal, double carbohydrate, double fiber, double protein, double fat, double water) {
        int row = 0;
        String sql = "INSERT INTO Meal(mealID,userID,dayID,mealindex,totalCalstd,carbohydratestd,fiberstd,proteinstd,fatstd,waterstd,totalCal,carbohydrate,fiber,protein,fat,water) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mealID);
            ps.setString(2, userID);
            ps.setString(3, dayID);
            ps.setInt(4, mealindex);
            ps.setDouble(5, totalCalstd);
            ps.setDouble(6, carbohydratestd);
            ps.setDouble(7, fiberstd);
            ps.setDouble(8, proteinstd);
            ps.setDouble(9, fatstd);
            ps.setDouble(10, waterstd);
            ps.setDouble(11, totalCal);
            ps.setDouble(12, carbohydrate);
            ps.setDouble(13, fiber);
            ps.setDouble(14, protein);
            ps.setDouble(15, fat);
            ps.setDouble(16, water);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }
    
    public boolean createMeal(Meal meal){
        return createMeal(meal.getMealID(), meal.getUserID(), meal.getDayID(), meal.getMealindex(), meal.getTotalCalstd(), meal.getCarbohydratestd(), meal.getFiberstd(), meal.getProteinstd(), meal.getFatstd(), meal.getWaterstd(), meal.getTotalCal(), meal.getCarbohydrate(), meal.getFiber(), meal.getProtein(), meal.getFat(), meal.getWater());
    }

    public boolean updateMeal(String mealID, String userID, String dayID, int mealindex, double totalCalstd, double carbohydratestd, double fiberstd, double proteinstd, double fatstd, double waterstd, double totalCal, double carbohydrate, double fiber, double protein, double fat, double water) {
        int row = 0;
        String sql = "UPDATE Meal SET userID = ?,dayID = ?,mealindex = ?,totalCalstd = ?,carbohydratestd = ?,fiberstd = ?,proteinstd = ?,fatstd = ?,waterstd = ?,totalCal = ?,carbohydrate = ?,fiber = ?,protein = ?,fat = ?,water = ? WHERE mealID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, dayID);
            ps.setInt(3, mealindex);
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
            ps.setString(16, mealID);

            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }

    public boolean deleteMeal(String mealID) {
        int row = 0;
        String sql = "DELETE FROM Meal WHERE mealID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mealID);

            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }
    
    public boolean deleteMealByUserID(String userID) {
        int row = 0;
        String sql = "DELETE FROM Meal WHERE userID = ?";
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
    
    public Meal readMealByMealID(String mealID) {
        String sql = "SELECT mealID,userID,dayID,mealindex,totalCalstd,carbohydratestd,fiberstd,proteinstd,fatstd,waterstd,totalCal,carbohydrate,fiber,protein,fat,water FROM Meal WHERE mealID = ?";
        Meal meal = null;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mealID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                meal = new Meal(rs.getString("mealID"), rs.getString("userID"), rs.getString("dayID"), rs.getInt("mealindex"), rs.getDouble("totalCalstd"),rs.getDouble("carbohydratestd"),rs.getDouble("fiberstd"),rs.getDouble("proteinstd"),rs.getDouble("fatstd"),rs.getDouble("waterstd"),rs.getDouble("totalCal"),rs.getDouble("carbohydrate"),rs.getDouble("fiber"),rs.getDouble("protein"),rs.getDouble("fat"),rs.getDouble("water"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return meal;
    }
    
    public ArrayList<Meal> readMealByUserID(String userID){
        ArrayList<Meal> list = new ArrayList<>();
        String sql = "SELECT mealID,userID,dayID,mealindex,totalCalstd,carbohydratestd,fiberstd,proteinstd,fatstd,waterstd,totalCal,carbohydrate,fiber,protein,fat,water FROM Meal WHERE userID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Meal(rs.getString("mealID"), rs.getString("userID"), rs.getString("dayID"), rs.getInt("mealindex"), rs.getDouble("totalCalstd"),rs.getDouble("carbohydratestd"),rs.getDouble("fiberstd"),rs.getDouble("proteinstd"),rs.getDouble("fatstd"),rs.getDouble("waterstd"),rs.getDouble("totalCal"),rs.getDouble("carbohydrate"),rs.getDouble("fiber"),rs.getDouble("protein"),rs.getDouble("fat"),rs.getDouble("water")));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }
    
    public static void main(String[] args) {
        MealDAO dao = new MealDAO();
        
                System.out.println("Create");
        dao.createMeal("MEAL000000", "U00000", "DAY00000", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        ArrayList<Meal> list = dao.readMealByDayID("DAY00000");
        for (Meal x : list) {
            System.out.println(x.toString());
        }

        System.out.println("Update");
        dao.updateMeal("MEAL000000", "U00000", "DAY00000", 9999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
         list = dao.readMealByDayID("DAY00000");
        for (Meal x : list) {
            System.out.println(x.toString());
        }

        System.out.println("Delete");
        dao.deleteMeal("MEAL000000");
         list = dao.readMealByDayID("DAY00000");
        for (Meal x : list) {
            System.out.println(x.toString());
        }
    }
    
}
