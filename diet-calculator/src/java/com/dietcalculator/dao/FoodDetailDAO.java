package com.dietcalculator.dao;

import com.dietcalculator.dto.FoodDetail;
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
public class FoodDetailDAO {

    public ArrayList<FoodDetail> readFoodDetail(String foodID, String mealID) {
        ArrayList<FoodDetail> list = new ArrayList<>();
        String sql = "SELECT * FROM FoodDetail WHERE foodID = ? AND mealID = ? ";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, foodID);
            ps.setString(2, mealID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FoodDetail(rs.getString("foodID"), rs.getString("mealID"), rs.getDouble("amount"),
                        rs.getDouble("totalCal"), rs.getDouble("carbohydrate"), rs.getDouble("fiber"), rs.getDouble("protein"), rs.getDouble("fat"), rs.getDouble("water"), rs.getString("icon"), rs.getString("category")));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public ArrayList<FoodDetail> readFoodDetailByFoodID(String foodID) {
        ArrayList<FoodDetail> list = new ArrayList<>();
        String sql = "SELECT * FROM FoodDetail WHERE foodID = ? ORDER BY foodID ASC";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, foodID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FoodDetail(rs.getString("foodID"), rs.getString("mealID"), rs.getDouble("amount"),
                        rs.getDouble("totalCal"), rs.getDouble("carbohydrate"), rs.getDouble("fiber"), rs.getDouble("protein"), rs.getDouble("fat"),  rs.getDouble("water"), rs.getString("icon"), rs.getString("category")));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public ArrayList<FoodDetail> readFoodDetailByMealID(String mealID) {
        ArrayList<FoodDetail> list = new ArrayList<>();
        String sql = "SELECT * FROM FoodDetail WHERE mealID = ? ORDER BY mealID ASC";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mealID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FoodDetail(rs.getString("foodID"), rs.getString("mealID"), rs.getDouble("amount"),
                        rs.getDouble("totalCal"), rs.getDouble("carbohydrate"), rs.getDouble("fiber"), rs.getDouble("protein"), rs.getDouble("fat"), rs.getDouble("water"), rs.getString("icon"), rs.getString("category")));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public boolean createFoodDetail(String foodID, String mealID, double amount, double totalCal, double carbohydrate, double fiber, double protein, double fat, double water, String icon, String category) {
        int row = 0;
        String sql = "INSERT INTO FoodDetail(foodID,mealID,amount,totalCal,carbohydrate,fiber,protein,fat,water,icon, category)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, foodID);
            ps.setString(2, mealID);
            ps.setDouble(3, amount);
            ps.setDouble(4, totalCal);
            ps.setDouble(5, carbohydrate);
            ps.setDouble(6, fiber);
            ps.setDouble(7, protein);
            ps.setDouble(8, fat);
            ps.setDouble(9, water);
            ps.setString(10, icon);
            ps.setString(11, category);

            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }
    
    public boolean createFoodDetail(FoodDetail fd){
        return createFoodDetail(fd.getFoodID(), fd.getMealID(), fd.getAmount(), fd.getTotalCal(), fd.getCarbohydrate(), fd.getFiber(), fd.getProtein(), fd.getFat(), fd.getWater(), fd.getIcon(), fd.getCategory());
    }

    public boolean UpdateFoodDetail(String foodID, String mealID, double amount, double totalCal, double carbohydrate, double fiber, double protein, double fat, double water, String icon, String category) {
        int row = 0;
        String sql = "UPDATE FoodDetail SET amount = ? ,totalCal=?, carbohydrate=?, fiber=?,"
                + "protein=?, fat=? ,water=?, icon=?, category=? WHERE foodID = ? AND mealID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, amount);
            ps.setDouble(2, totalCal);
            ps.setDouble(3, carbohydrate);
            ps.setDouble(4, fiber);
            ps.setDouble(5, protein);
            ps.setDouble(6, fat);
            ps.setDouble(7, water);
            ps.setString(8, icon);
            ps.setString(9, category);
            ps.setString(10, foodID);
            ps.setString(11, mealID);

            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }

    public boolean DeleteFoodDetail(String foodID, String mealID) {
        int row = 0;
        String sql = "DELETE FROM FoodDetail WHERE foodID = ? AND mealID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, foodID);
            ps.setString(2, mealID);

            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }
    
    public boolean deleteFoodDetailByUserID(String userID){
        int row = 0;
        String sql = "DELETE FROM [dbo].[FoodDetail] WHERE mealID IN (SELECT mealID FROM Meal WHERE userID = ?)";
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

    public static void main(String[] args) {
        FoodDetailDAO dao = new FoodDetailDAO();
        ArrayList<FoodDetail> ls = dao.readFoodDetailByMealID("1");
        for (FoodDetail l : ls) {
            System.out.println(l.toString());
        }

        System.out.println("Create");
        dao.createFoodDetail("FD00001", "MEAL000000", 123,0,0,0,0,0,0,"","");
        ArrayList<FoodDetail> list = dao.readFoodDetail("FD00001", "MEAL000000");
        for (FoodDetail food : list) {
            System.out.println(food.toString());
        }

        System.out.println("Update");
        dao.UpdateFoodDetail("FD00001", "MEAL000000", 999,0,0,0,0,0,0,"","");
        list = dao.readFoodDetail("FD00001", "MEAL000000");
        for (FoodDetail food : list) {
            System.out.println(food.toString());
        }

        System.out.println("Delete");
        dao.DeleteFoodDetail("FD00001", "MEAL000000");
        list = dao.readFoodDetail("FD00001", "MEAL000000");
        for (FoodDetail food : list) {
            System.out.println(food.toString());
        }
    }
}
