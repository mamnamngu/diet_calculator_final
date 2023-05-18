/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.controller;

import com.dietcalculator.dao.SaleOffDAO;
import com.dietcalculator.dto.SaleOff;
import com.dietcalculator.dto.User;
import com.dietcalculator.util.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSI
 */
public class SaleOffController extends HttpServlet {

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
        User user = (User) request.getSession().getAttribute("user");

        if (user == null || user.getRank() < 0) {
            try (PrintWriter out = response.getWriter()) {
                out.print("<h1>You don't have permission</h1");
            }
        } else {
            String action = request.getParameter("action");
            SaleOffDAO dao = new SaleOffDAO();

            if (action == null || action.equals("read")) {
                ArrayList<SaleOff> fullList = dao.readSaleOff();

                int pageSize = 12;
                int totalPages = (int) Math.ceil(fullList.size() / pageSize);
                Integer page = null;
                try {
                    page = Integer.parseInt(request.getParameter("page"));
                } catch (Exception e) {
                }
                if (page == null) {
                    page = 1;
                } else if (page > totalPages) {
                    page = totalPages;
                }
                List<SaleOff> list = paginSaleOff(page, pageSize, fullList);

                request.setAttribute("page", (int) page);
                request.setAttribute("totalPages", totalPages);

                request.setAttribute("saleoffList", list);
                RequestDispatcher rd = request.getRequestDispatcher("./Administrator/ViewDeleteSaleOff.jsp");

                rd.forward(request, response);

            } else if (action.equals("create")) {
                if (!request.getParameter("saleoffID").isEmpty()) {
                    try {
                        String saleoffID = request.getParameter("saleoffID");
                        String description = request.getParameter("description");
                        Date startdate = Utils.convertStringToSqlDate(request.getParameter("startdate"));
                        Date enddate = Utils.convertStringToSqlDate(request.getParameter("enddate"));
                        int target = Integer.parseInt(request.getParameter("target"));
                        dao.createSaleOff(saleoffID, description, startdate, enddate, target);

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    response.sendRedirect("SaleOffController");
                } else {
                    response.sendRedirect("SaleOffController");
                }

            } else if (action.equals("update")) {
                if (request.getParameter("description") == null) {
                    SaleOff saleoff = saleoffByID(request.getParameter("saleoffID"));
                    request.setAttribute("saleoff", saleoff);
                    RequestDispatcher rd = request.getRequestDispatcher("Administrator/EditSaleOff.jsp");
                    rd.forward(request, response);
                } else if (!request.getParameter("description").isEmpty()) {
                    try {
                        String saleoffID = request.getParameter("saleoffID");
                        String description = request.getParameter("description");
                        Date startdate = Utils.convertStringToSqlDate(request.getParameter("startdate"));
                        Date enddate = Utils.convertStringToSqlDate(request.getParameter("enddate"));
                        int target = Integer.parseInt(request.getParameter("target"));
                        dao.updateSaleOff(saleoffID, description, startdate, enddate, target);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    response.sendRedirect("SaleOffController");
                }
            } else if (action.equals("delete")) {
                String[] ids = request.getParameterValues("saleoffID");
                if (ids != null) {
                    for (String id : ids) {
                        dao.deleteSaleOff(id);
                    }
                }

                response.sendRedirect("SaleOffController");
            }
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

    private SaleOff saleoffByID(String saleoffID) {
        SaleOffDAO dao = new SaleOffDAO();
        ArrayList<SaleOff> list = dao.readSaleOff();
        for (SaleOff saleoff : list) {
            if (saleoff.getSaleoffID().equals(saleoffID)) {
                return saleoff;
            }
        }
        return null;
    }

    public List<SaleOff> paginSaleOff(int pageNum, int pageSize, List<SaleOff> saleoff) {
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, saleoff.size());
        List<SaleOff> list = saleoff.subList(startIndex, endIndex);
        return list;
    }
}
