/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.dao;

import com.dietcalculator.dto.Product;
import com.dietcalculator.util.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class ProductDAO {
    
    public String lastIDIndex() {
        String sql = "select top 1 productID from Product order by productID desc";
        String index = "PRO0000";
        
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                index = rs.getString("productID");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return index;
    }
    
    public ArrayList<Product> readProduct() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT  productID,productname,type,price,quantity,brand,origin,volume,effect,rate,purchase FROM Product";
        
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString("productID"),
                        rs.getString("productname"),
                        rs.getString("type"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("brand"),
                        rs.getString("origin"),
                        rs.getDouble("volume"),
                        rs.getString("effect"),
                        rs.getDouble("rate"),
                        rs.getDouble("purchase")));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public ArrayList<Product> readProduct(String keyword, String type, String price, String quantity) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT  productID,productname,type,price,quantity,brand,origin,volume,effect,rate,purchase FROM Product";
        String order = "";
        String orderJoinWord = " ORDER BY ";
        String where = "";
        String whereJoinWord = " where ";
        
        if (keyword != null && !keyword.trim().isEmpty()) {
            where += whereJoinWord;
            where += " (productname  like  ? OR effect like ? )";
            whereJoinWord = " and ";
        }
        if (type != null && !type.trim().isEmpty()) {
            where += whereJoinWord;
            where += " type  LIKE ? ";
            whereJoinWord = " and ";
        }
        
        if (price != null && (price.equals("ASC") || price.equals("DESC"))) {
            order += orderJoinWord;
            order += " price " + price;
            orderJoinWord = " , ";
        }
        
        if (quantity != null && (quantity.equals("ASC") || quantity.equals("DESC"))) {
            order += orderJoinWord;
            order += " quantity " + quantity + " ";
            orderJoinWord = " , ";
        }
        sql += where + order;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            int index = 1;
            if (keyword != null && !keyword.trim().isEmpty()) {
                ps.setString(index, '%'+keyword+'%');
                index++;
                ps.setString(index, '%'+keyword+'%');
                index++;
            }
            if (type != null && !type.trim().isEmpty()) {
                ps.setString(index, '%'+type+'%');
                index++;
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString("productID"),
                        rs.getString("productname"),
                        rs.getString("type"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("brand"),
                        rs.getString("origin"),
                        rs.getDouble("volume"),
                        rs.getString("effect"),
                        rs.getDouble("rate"),
                        rs.getDouble("purchase")));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        ArrayList<Product> list = dao.readProduct("a", "vitamin","DESC", "ASC" );
        for (Product product : list) {
            System.out.println(product);
        }
    }
    
    public boolean createProduct(String productID, String productname, String type, double price, int quantity, String brand, String origin, double volume, String effect, double rate, double purchase) {
        int row = 0;
        String sql = "insert into Product values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productID);
            ps.setString(2, productname);
            ps.setString(3, type);
            ps.setDouble(4, price);
            ps.setInt(5, quantity);
            ps.setString(6, brand);
            ps.setString(7, origin);
            ps.setDouble(8, volume);
            ps.setString(9, effect);
            ps.setDouble(10, rate);
            ps.setDouble(11, purchase);
            
            row = ps.executeUpdate();
            ps.close();
            conn.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return row > 0;
    }
    
    public boolean updateProduct(String productID, String productname, String type, double price, int quantity, String brand, String origin, double volume, String effect, double rate, double purchase) {
        int row = 0;
        String sql = "UPDATE Product SET productname = ?, type = ?, price =?, quantity =?, brand = ?, origin =?, volume =?, effect =?, rate =?, purchase=? where productID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productname);
            ps.setString(2, type);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, brand);
            ps.setString(6, origin);
            ps.setDouble(7, volume);
            ps.setString(8, effect);
            ps.setDouble(9, rate);
            ps.setDouble(10, purchase);
            ps.setString(11, productID);
            
            row = ps.executeUpdate();
            ps.close();
            conn.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return row > 0;
    }
    
    public boolean deleteProduct(String productID) {
        int row = 0;
        String sql = "DELETE from Product where  productID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, productID);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return row > 0;
    }
    
    public Product searchProductByProductID(String productID){
        Product product = null;
        String sql = "SELECT * FROM Product WHERE productID = ?";
        try{
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productID);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product(rs.getString("productID"),
                        rs.getString("productname"),
                        rs.getString("type"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("brand"),
                        rs.getString("origin"),
                        rs.getDouble("volume"),
                        rs.getString("effect"),
                        rs.getDouble("rate"),
                        rs.getDouble("purchase"));
            }
            rs.close();
            ps.close();
            conn.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return product;
    }
    
//    public static void main(String[] args) {
//        ProductDAO dao = new ProductDAO();
//        
//        System.out.println("Create");
//        dao.createProduct("PRO0000", "Khoi", "Dep troai", 0, 0, "Quan 9", "VietNam", 0, "Hoc gioi", 0, 0);
//        ArrayList<Product> list = dao.readProduct();
//        for (Product product : list) {
//            System.out.println(product.toString());
//        }
//        
//        System.out.println("");
//        System.out.println("Update");
//        
//        System.out.println(dao.updateProduct("PRO0000", "Khoi", "Xau troai", 0, 0, "Quan 10", "USA", 0, "Hljkasdnfkljasnasdnfb", 0, 0));
//        list = dao.readProduct();
//        for (Product product : list) {
//            System.out.println(product.toString());
//        }
//        
//        System.out.println("");
//        System.out.println("Delete");
//        dao.deleteProduct("PRO0000");
//        list = dao.readProduct();
//        for (Product product : list) {
//            System.out.println(product.toString());
//        }
//    }
    
}
