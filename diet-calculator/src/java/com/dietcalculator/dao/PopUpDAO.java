/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.dao;

import com.dietcalculator.dto.PopUp;

import com.dietcalculator.util.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class PopUpDAO {
    
    
    
    
    public String lastIDIndex(){
        String sql = "SELECT TOP 1 popupID from PopUp order by popupID desc";
        String index = "POP000";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                index = rs.getString("popupID");
            }
            rs.close();
            ps.close();
            conn.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        return index;
    }
    
    public ArrayList<PopUp> readPopUp(){
        ArrayList<PopUp> list = new ArrayList<>();
        String sql = "SELECT popupID,description,status,theme FROM PopUp ";
         try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new PopUp(rs.getString("popupID"),rs.getString("description"),rs.getInt("status"), rs.getString("theme")));
            }
            rs.close();
            ps.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }
    
    public ArrayList<PopUp> readAvailablePopUp(int status){
        ArrayList<PopUp> list = new ArrayList<>();
        String sql = "SELECT popupID,description,status,theme FROM PopUp WHERE status = ?";
         try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new PopUp(rs.getString("popupID"),rs.getString("description"),rs.getInt("status"), rs.getString("theme")));
            }
            rs.close();
            ps.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }
    
     public boolean createPopUp(String popupID, String description, int status, String theme){
        int row = 0;
        String sql = "insert into PopUp values (?,?,?,?) ";
         try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, popupID);
            ps.setString(2, description);
            ps.setInt(3, status);
            ps.setString(4, theme);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return row  > 0;
    }
     
    public boolean updatePopUp(String popupID, String description, int status, String theme){
        int row = 0;
        String sql = "update PopUp SET description = ?, status = ?, theme = ? where popupID = ? ";
         try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
     
            ps.setString(1, description);
            ps.setInt(2, status);
            ps.setString(3, theme);
            ps.setString(4, popupID);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
            
        }catch (Exception e){
            System.out.println(e);
        }
        return row > 0;
    }
    
     public boolean deletePopUp(String popupID){
        int row =0;
        String sql ="DELETE from PopUp where popupID = ?";
        try{
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,popupID);
            row = ps.executeUpdate();
            ps.close();
            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return row > 0;
    }
     
     
     
     public static void main(String[]args){
        PopUpDAO dao = new PopUpDAO();
         
        System.out.println("Create");
        dao.createPopUp("POP000", "Khoi dep troai", 0, "xanh");
        ArrayList<PopUp> list = dao.readAvailablePopUp(1);
        for(PopUp pop : list){
             System.out.println(pop.toString());
        }
//         
         System.out.println("");
         System.out.println("Update");
         dao.updatePopUp("POP000", "Khoi xau troai", 0, "do");
         list = dao.readPopUp();
           for(PopUp pop : list){
             System.out.println(pop.toString());
         }
           
//           System.out.println("");
//           System.out.println("Delete");
//           dao.deletePopUp("POP000");
//           list = dao.readPopUp();
//                for(PopUp pop : list){
//             System.out.println(pop.toString());
//         }
     }
    
    
    
    
    
    
    
    
    
    }
   
    

