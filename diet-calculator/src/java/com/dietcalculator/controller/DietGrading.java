/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.controller;

import com.dietcalculator.dto.Day;
import com.dietcalculator.util.Constants;
import com.dietcalculator.util.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asout
 */
public class DietGrading extends HttpServlet {

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
        List<Day> days = (List<Day>)request.getAttribute("days");
        String[] dayName = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

        //OVERALL COVERAGE
        //Daily coverage
        ArrayList<Double> dailyCoverage = new ArrayList();
        double coverage = 0;
        for(Day x: days){
            double totalCalOffset = 1 - Math.abs(1 - (x.getTotalCal()/x.getTotalCalstd()));
            double carbohydrateOffset = 1 - Math.abs(1 - (x.getCarbohydrate()/x.getCarbohydratestd()));
            double fiberCalOffset = 1 - Math.abs(1 - (x.getFiber()/x.getFiberstd()));
            double proteinCalOffset = 1 - Math.abs(1 - (x.getProtein()/x.getProteinstd()));
            double fatCalOffset = 1 - Math.abs(1 - (x.getFat()/x.getFatstd()));
            double waterCalOffset = 1 - Math.abs(1 - (x.getWater()/x.getWaterstd()));
            
            coverage = Math.round(totalCalOffset*carbohydrateOffset*fiberCalOffset*proteinCalOffset*fatCalOffset*waterCalOffset*1000)/10.0;
            dailyCoverage.add(coverage);
        }
        
        ArrayList<Double> weeklyCoverage = new ArrayList();
        double totalCalAccum = 0;
        double carbohydrateAccum = 0;
        double fiberAccum = 0;
        double proteinAccum = 0;
        double fatAccum = 0;
        double waterAccum = 0;
        for(Day x: days){
            totalCalAccum += x.getTotalCal();
            carbohydrateAccum += x.getCarbohydrate();
            fiberAccum += x.getFiber();
            proteinAccum += x.getProtein();
            fatAccum += x.getFat();
            waterAccum += x.getWater();
        }
        double totalCalCover = Math.round(1000*totalCalAccum/(7*days.get(0).getTotalCalstd()))/10.0;
        double carbohydrateCover = Math.round(1000*carbohydrateAccum/(7*days.get(0).getCarbohydratestd()))/10.0;
        double fiberCover = Math.round(1000*fiberAccum/(7*days.get(0).getFiberstd()))/10.0;
        double proteinCover = Math.round(1000*proteinAccum/(7*days.get(0).getProteinstd()))/10.0;
        double fatCover = Math.round(1000*fatAccum/(7*days.get(0).getFatstd()))/10.0;
        double waterCover = Math.round(1000*waterAccum/(7*days.get(0).getWaterstd()))/10.0;
        
        weeklyCoverage.add(totalCalCover);
        weeklyCoverage.add(carbohydrateCover);
        weeklyCoverage.add(fiberCover);
        weeklyCoverage.add(proteinCover);
        weeklyCoverage.add(fatCover);
        weeklyCoverage.add(waterCover);
        
        request.setAttribute("days", days);
        request.setAttribute("dayName", dayName);
        request.setAttribute("dailyCoverage", dailyCoverage);
        request.setAttribute("weeklyCoverage", weeklyCoverage);
        RequestDispatcher rd = request.getRequestDispatcher("/Menu/DietGrading.jsp");
        rd.include(request, response);
        
        //SUPPLEMENT SUGGESTIONS
        String type = "";
        if(carbohydrateCover < Constants.CUT_OFF){
            type = "carbohydrate";
            request.setAttribute("type",type);
            rd = request.getRequestDispatcher("RelatedProduct");
            rd.include(request, response);
        }
         
        if(fiberCover < Constants.CUT_OFF){
            type = "fiber";
            request.setAttribute("type",type);
            rd = request.getRequestDispatcher("RelatedProduct");
            rd.include(request, response);
        }
        
        if(proteinCover < Constants.CUT_OFF){
            type = "protein";
            request.setAttribute("type",type);
            rd = request.getRequestDispatcher("RelatedProduct");
            rd.include(request, response);
        }
        
        if(fatCover < Constants.CUT_OFF){
            type = "fat";
            request.setAttribute("type",type);
            rd = request.getRequestDispatcher("RelatedProduct");
            rd.include(request, response);
        }
        
        if(waterCover < Constants.CUT_OFF){
            type = "water";
            request.setAttribute("type",type);
            rd = request.getRequestDispatcher("RelatedProduct");
            rd.include(request, response);
        }
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
