package com.dietcalculator.dao;

import com.dietcalculator.dto.Image;
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
public class ImageDAO {

    public String lastIDIndex() {
        String sql = "SELECT TOP 1 ImageID FROM Image ORDER BY ImageID DESC";
        String index = "IMG00000";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                index = rs.getString("ImageID");
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return index;
    }

    public boolean createImage(String imageID, String productID, String foodID, String commentID, String url) {
        String sql = "insert into Image values (?,?,?,?,?)";
        int row = 0;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, imageID);
            ps.setString(2, productID);
            ps.setString(3, foodID);
            ps.setString(4, commentID);
            ps.setString(5, url);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }

    public boolean updateImage(String imageID, String productID, String foodID, String commentID, String url) {
        String sql = "update Image set productID=?, foodID=?, commentID=?,  url=? where imageID=?";
        int row = 0;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, productID);
            ps.setString(2, foodID);
            ps.setString(3, commentID);
            ps.setString(4, url);
            ps.setString(5, imageID);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }

    public boolean deleteImage(String imageID) {
        String sql = "DELETE FROM Image WHERE imageID = ?";
        int row = 0;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, imageID);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return row > 0;
    }

    public ArrayList<Image> readImageByProductID() {
        ArrayList<Image> list = new ArrayList<>();
        String sql = "SELECT * FROM Image WHERE productID is not null";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Image(rs.getString("imageID"), rs.getString("productID"), rs.getString("foodID"), rs.getString("commentID"), rs.getString("url")));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }
    public ArrayList<Image> searchImageByProductID(String id) {
        ArrayList<Image> list = new ArrayList<>();
        String sql = "SELECT * FROM Image WHERE productID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Image(rs.getString("imageID"), rs.getString("productID"), rs.getString("foodID"), rs.getString("commentID"), rs.getString("url")));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }


    public ArrayList<Image> readImageByFoodID(String foodID) {
        ArrayList<Image> list = new ArrayList();
        String sql = "SELECT * FROM Image WHERE foodID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, foodID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Image(rs.getString("imageID"), rs.getString("productID"), rs.getString("foodID"), rs.getString("commentID"), rs.getString("url")));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public ArrayList<Image> readImageUrlByCommentID() {
        ArrayList<Image> list = new ArrayList<>();
        String sql = "SELECT * FROM Image WHERE commnentID is not null";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Image(rs.getString("imageID"), rs.getString("productID"), rs.getString("foodID"), rs.getString("commentID"), rs.getString("url")));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

//    public static void main(String[] args) {
//        ImageDAO dao = new ImageDAO();
//
//        System.out.println("Create");
//        dao.createImage("IMG000000", "PRO0001", null, null, "abc");
//        ArrayList<Image> list = dao.readImageByProductID();
//        for (Image image : list) {
//            System.out.println(image);
//        }
//
//        System.out.println("Update");
//        System.out.println(dao.updateImage("IMG000000", "PRO0002", null, null, "bed"));
//        list = dao.readImageByProductID();
//        for (Image image : list) {
//            System.out.println(image);
//        }
//
//        System.out.println("Delete");
//        System.out.println(dao.deleteImage("IMG000000"));
//                dao.createImage("IMG000000", "PRO0001", null, null, "https://www.bootdey.com/image/250x220/FFB6C1/000000");
//                
//                
//        
//    }
}
