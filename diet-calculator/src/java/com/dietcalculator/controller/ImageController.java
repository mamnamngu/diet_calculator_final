/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.controller;

import com.dietcalculator.dao.ImageDAO;
import com.dietcalculator.dto.FoodDetail;
import com.dietcalculator.dto.Image;
import com.dietcalculator.dto.Meal;
import com.dietcalculator.util.Constants;
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
public class ImageController extends HttpServlet {

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
            out.println("<title>Servlet ImageController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ImageController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public final ArrayList<ArrayList<ArrayList<String>>> generateImage(ArrayList<ArrayList<ArrayList<FoodDetail>>> foodDetails, ArrayList<ArrayList<Meal>> meals){
        int numOfMeals = meals.size();
        int numOfDay = foodDetails.get(0).size();
        ArrayList<ArrayList<ArrayList<String>>> images = new ArrayList();
        
        //INITIALIZING THE ARRAYLIST
        ArrayList<String> listOfMeal = new ArrayList();
        ArrayList<ArrayList<String>> listOfDay = new ArrayList();
            
        ImageDAO imageDAO = new ImageDAO();
        for(int i = 0; i < numOfMeals; i++){
            for(int k = 0; k < numOfDay; k++){
                for(int j = 0; j < Constants.FOOD_DETAIL_BY_MEAL.get(meals.get(i).get(0).getMealindex()).length; j++){
                    listOfMeal.add(foodDetails.get(i).get(k).get(j).getIcon());
                }
               listOfDay.add(listOfMeal);
               
               //RESET listOfMeal
               listOfMeal = new ArrayList();
            }
            images.add(listOfDay);
            
            //RESET listOfDay
            listOfDay = new ArrayList();
        }
        return images;
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
