package com.dietcalculator.dao;

import com.dietcalculator.dto.ExSession;
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
public class ExSessionDAO {

    public String lastIDIndex() {
        String sql = "SELECT TOP 1 sessionID FROM ExSession ORDER BY sessionID DESC";
        String index = "SES000000";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                index = rs.getString("sessionID");
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return index;
    }

    public List<ExSession> readExSession() {
        List<ExSession> list = new ArrayList<>();
        String sql = "SELECT * FROM ExSession";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ExSession(rs.getString("sessionID"), rs.getString("exerciseID"), rs.getString("userID"), rs.getString("dayID"), rs.getString("icon")));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public boolean createExSession(String sessionID, String exerciseID, String userID, String dayID, String icon) {
        String sql = "INSERT INTO ExSession VALUES(?,?,?,?,?)";
        int row = 0;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sessionID);
            ps.setString(2, exerciseID);
            ps.setString(3, userID);
            ps.setString(4, dayID);
            ps.setString(5, icon);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }

    public boolean updateExSession(String sessionID, String exerciseID, String userID, String dayID, String icon) {
        String sql = "UPDATE ExSession SET exerciseID = ?, userID = ?, dayID = ?, icon = ? WHERE sessionID = ?";
        int row = 0;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, exerciseID);
            ps.setString(2, userID);
            ps.setString(3, dayID);
            ps.setString(4, icon);
            ps.setString(5, sessionID);
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }

    public boolean deleteExSession(String sessionID) {
        int row = 0;
        String sql = "DELETE FROM ExSession WHERE sessionID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sessionID);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }
}
