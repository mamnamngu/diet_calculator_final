package com.dietcalculator.dao;

import com.dietcalculator.dto.Exercise;
import com.dietcalculator.util.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ExerciseDAO {

    public String lastIDIndex() {
        String sql = "SELECT TOP 1 exerciseID FROM Exercise ORDER BY exerciseID DESC";
        String index = "EX000";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                index = rs.getString("exerciseID");
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return index;
    }

    public List<Exercise> readExercise(String exname) {
        List<Exercise> list = new ArrayList();
        String sql = "SELECT * FROM Exercise";
        String where = "";
        String whereJoinWord = " WHERE ";

        if (exname != null && !exname.trim().isEmpty()) {
            where += whereJoinWord;
            where += " exname  LIKE ?";
            whereJoinWord = " AND ";
        }
        sql += where;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            int index = 1;
            if (exname != null && !exname.trim().isEmpty()) {
                ps.setString(index, '%' + exname + '%');
                index++;
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Exercise(rs.getString("exerciseID"), rs.getString("exname"), rs.getDouble("lowerweight"), rs.getDouble("upperweight"), rs.getInt("calorexp"), rs.getString("icon"), rs.getString("description")));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }
    
    public List<Exercise> sortExercise(String exname, String calorexp) {
        List<Exercise> list = new ArrayList();
        String sql = "SELECT * FROM Exercise";
        String order = "";
        String orderJoinWord = " ORDER BY ";

        if (exname != null && !exname.trim().isEmpty()) {
            order += orderJoinWord;
            order += " exname ASC ";
            orderJoinWord = " AND ";
        }
        
        if (calorexp != null && !calorexp.trim().isEmpty()) {
            order += orderJoinWord;
            order += " calorexp ASC ";
            orderJoinWord = " AND ";
        }
        sql += order;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Exercise(rs.getString("exerciseID"), rs.getString("exname"), rs.getDouble("lowerweight"), rs.getDouble("upperweight"), rs.getInt("calorexp"), rs.getString("icon"), rs.getString("description")));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

//    public Exercise readExerciseById(String id) {
//        Exercise exercise = new Exercise();
//        String sql = "SELECT * FROM Exercise WHERE exerciseID = ?";
//        try {
//            Connection conn = DBUtils.getConnection();
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, id);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                exercise = new Exercise(rs.getString("exerciseID"), rs.getString("exname"), 
//                        rs.getDouble("lowerweight"), rs.getDouble("upperweight"), rs.getInt("calorexp"));
//            }
//            rs.close();
//            ps.close();
//            conn.close();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return exercise;
//    }
    public boolean createExercise(String exerciseID, String exname, double lowerweight, double upperweight, int calorexp, String icon, String description) {
        String sql = "INSERT INTO Exercise VALUES(?,?,?,?,?,?,?)";
        int row = 0;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, exerciseID);
            ps.setString(2, exname);
            ps.setDouble(3, upperweight);
            ps.setDouble(4, lowerweight);
            ps.setInt(5, calorexp);
            ps.setString(6, icon);
            ps.setString(7, description);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }

    public boolean updateExercise(String exerciseID, String exname, double lowerweight, double upperweight, int calorexp, String icon, String description) {
        String sql = "UPDATE Exercise SET exname = ?, lowerweight = ?, upperweight = ?, calorexp = ?, icon = ?, description = ? WHERE exerciseID = ?";
        int row = 0;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, exname);
            ps.setDouble(2, lowerweight);
            ps.setDouble(3, upperweight);
            ps.setInt(4, calorexp);
            ps.setString(5, icon);
            ps.setString(6, description);
            ps.setString(7, exerciseID);
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }

    public boolean deleteExercise(String exerciseID) {
        int row = 0;
        String sql = "DELETE FROM Exercise WHERE exerciseID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, exerciseID);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }
}
