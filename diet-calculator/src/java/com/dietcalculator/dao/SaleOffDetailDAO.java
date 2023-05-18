/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.dao;
import com.dietcalculator.dto.ProductDetail;
import com.dietcalculator.dto.SaleOffDetail;
import com.dietcalculator.util.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class SaleOffDetailDAO {
    
    public ArrayList<SaleOffDetail> readSaleOffDetail(){
        ArrayList<SaleOffDetail>list = new ArrayList<>();
        String sql ="SELECT detailID,saleoffID,productID,percentoff,priceoff,gift FROM SaleOffDetail";
    
        try{
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new SaleOffDetail(rs.getString("detailID"),rs.getString("saleoffID"), rs.getString("productID"),rs.getInt("percentoff"), rs.getFloat("priceoff"), rs.getString("gift")));
                        
            }
            rs.close();
            ps.close();

            
        }catch (Exception e){
        System.out.println(e);
        }
        return list;
    }
    
     public boolean createSaleOffDetail(String detailID, String saleoffID, String productID, int percentoff, float priceoff, String gift){
        int row = 0;
        String sql ="insert into SaleOffDetail values(?,?,?,?,?,?)";
        try{
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, detailID);
            ps.setString(2, productID);
            ps.setString(3, saleoffID);
            ps.setInt(4, percentoff);
            ps.setFloat(5, priceoff);
            ps.setString(6, gift);
            ps.close();
            conn.close();
         }catch (Exception e){
        System.out.println(e);
        }
        return row > 0;
    }
     
      public boolean updateSaleOffDetail(String saleoffID, String productID, int percentoff, float priceoff, String gift){
        int row = 0;
        String sql ="update SaleOffDetail SET saleoffID = ?, productID =?, percentoff =?, priceoff =?, gift =? where detailID";
        try{
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
          
            ps.setString(1, productID);
            ps.setString(2, saleoffID);
            ps.setInt(3, percentoff);
            ps.setFloat(4, priceoff);
            ps.setString(5, gift);
            ps.close();
            conn.close();
         }catch (Exception e){
        System.out.println(e);
        }
        return row > 0;
    }
      
       public boolean deleteProductDetail(String detailID){
        int row = 0;
        String sql ="DELETE from SaleOffDetail where detailID = ?";
        try{
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
          
            ps.setString(1, detailID);
        
         }catch (Exception e){
        System.out.println(e);
        }
        return row > 0;
    }
    
     
}
