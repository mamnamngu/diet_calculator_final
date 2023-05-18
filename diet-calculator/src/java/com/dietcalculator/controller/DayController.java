/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.controller;

import com.dietcalculator.dao.DayDAO;
import com.dietcalculator.dto.Day;
import com.dietcalculator.util.Constants;
import com.dietcalculator.util.MealValues;
import com.dietcalculator.util.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asout
 */
public class DayController extends HttpServlet {
    private final String DAY_ID_FORMAT_STRING = "DAY%05d";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DayController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DayController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public ArrayList<Day> generateDay(int week, String userID, double totalCalories, MealValues mealValues){
        ArrayList<Day> days = new ArrayList();
        
        //Getting the last ID index
        DayDAO dayDAO = new DayDAO();
        String lastIDIndex = dayDAO.lastIDIndex();
        int lastIndex = Utils.extractIntFromString(lastIDIndex);
        for (int i = 0; i < week*7; i++){
            String dayID = String.format("DAY%05d", ++lastIndex);
            double totalCalstd = totalCalories;
            double carbohydratestd = Utils.roundDouble(totalCalories*mealValues.getCarbohydrate());
            double fiberstd =  Utils.roundDouble(totalCalories*mealValues.getFiber());
            double proteinstd =  Utils.roundDouble(totalCalories*mealValues.getProtein());
            double fatstd =  Utils.roundDouble(totalCalories*mealValues.getFat());
            double waterstd =  Utils.roundDouble(mealValues.getWater());
            
            //Create a new day instance
            days.add(new Day(dayID,userID,i+1,totalCalstd,carbohydratestd,fiberstd,proteinstd,fatstd,waterstd));
        }
        return days;
    }

    //Check
    public static void main(String[] args) {
        DayController dc =new DayController();
        ArrayList<Day> days = dc.generateDay(3,"U00001",2200,Constants.PLATE_PORTION.get(1));
        for(int i = 0; i < days.size(); i++)
            System.out.println(days.get(i));
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
