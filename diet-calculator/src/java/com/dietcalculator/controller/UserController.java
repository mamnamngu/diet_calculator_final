/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.controller;

import com.dietcalculator.dao.UserDAO;
import com.dietcalculator.dto.User;
import com.dietcalculator.util.Constants;
import com.dietcalculator.util.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asout
 */
public class UserController extends HttpServlet {
    //CONSTANTS

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
        // Check is there is user logged in
        User user = null;
        user = (User) request.getSession().getAttribute("user");

        if (user == null || user.getRank() < 0) {
            try (PrintWriter out = response.getWriter()) {
                out.print("<h1>You don't have permission</h1>");
            }
        } else {
            //Catching the action
            boolean check;
            String action = request.getParameter("action");
            UserDAO userDAO = new UserDAO();
            if (action == null || action.equalsIgnoreCase("read")) {  //LIST ALL USERS
                request.setAttribute("userList", userDAO.readUser());
                RequestDispatcher rd = request.getRequestDispatcher("/Administrator/UserList.jsp");
                rd.forward(request, response);
            } else if (action.equalsIgnoreCase("create")) {   
                //CREATE A NEW USER
                if (!request.getParameter("userID").isEmpty()) {
                    try {
                        String lastUserIndex = userDAO.lastIDIndex();
                        int lastIndex = Utils.extractIntFromString(lastUserIndex);
                        String userID = String.format(Constants.USER_ID_FORMAT, ++lastIndex);
                        String username = request.getParameter("username");
                        Date dob = Utils.convertStringToSqlDate(request.getParameter("dob"));
                        String phone = request.getParameter("phone");
                        String address = request.getParameter("address");
                        String email = request.getParameter("email");
                        String password = request.getParameter("password");
                        double weight = Double.parseDouble(request.getParameter("weight"));
                        double height = Double.parseDouble(request.getParameter("height"));
                        int gender = Integer.parseInt(request.getParameter("gender"));
                        int activity = Integer.parseInt(request.getParameter("activity"));
                        int preference = Integer.parseInt(request.getParameter("preference"));
                        int goal = Integer.parseInt(request.getParameter("goal"));
                        double amount = Double.parseDouble(request.getParameter("amount"));
                        int duration = Integer.parseInt(request.getParameter("duration"));
                        int main = Integer.parseInt(request.getParameter("main"));
                        int side = Integer.parseInt(request.getParameter("side"));
                        int session = Integer.parseInt(request.getParameter("session"));
                        int rank = Integer.parseInt(request.getParameter("rank"));
                        Date createdate = Utils.convertStringToSqlDate(request.getParameter("createdate"));
                        check = userDAO.createUser(userID, username, dob, phone, address, email, password, weight, height, gender, activity, preference, goal, amount, duration, main, side, session, rank, createdate);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    response.sendRedirect("UserController");
                }
            } else if (action.equalsIgnoreCase("update")) {
                if (request.getParameter("username") == null) { //Request for update page
                    String userID = request.getParameter("userID");
                    user = userDAO.searchUser(userID);
                    request.setAttribute("user", user);
                    RequestDispatcher rd = request.getRequestDispatcher("Administrator/EditUser.jsp");
                    rd.forward(request, response);
                } else if (!request.getParameter("username").isEmpty()) {
                    try {
                        String username = request.getParameter("username");
                        Date dob = Utils.convertStringToSqlDate(request.getParameter("dob"));
                        String phone = request.getParameter("phone");
                        String address = request.getParameter("address");
                        String email = request.getParameter("email");
                        String password = request.getParameter("password");
                        double weight = Double.parseDouble(request.getParameter("weight"));
                        double height = Double.parseDouble(request.getParameter("height"));
                        int gender = Integer.parseInt(request.getParameter("gender"));
                        int activity = Integer.parseInt(request.getParameter("activity"));
                        int preference = Integer.parseInt(request.getParameter("preference"));
                        int goal = Integer.parseInt(request.getParameter("goal"));
                        double amount = Double.parseDouble(request.getParameter("amount"));
                        int duration = Integer.parseInt(request.getParameter("duration"));
                        int main = Integer.parseInt(request.getParameter("main"));
                        int side = Integer.parseInt(request.getParameter("side"));
                        int session = Integer.parseInt(request.getParameter("session"));
                        int rank = Integer.parseInt(request.getParameter("rank"));
                        Date createdate = Utils.convertStringToSqlDate(request.getParameter("createdate"));
                        userDAO.updateUser(username, username, dob, phone, address, email, password, weight, height, gender, activity, preference, goal, amount, duration, main, side, session, rank, createdate);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    response.sendRedirect("UserController");
                }
            } else if (action.equalsIgnoreCase("delete")) {
                String[] itemsToDelete = request.getParameterValues("checkbox");
                if (itemsToDelete != null) {
                    for (String id : itemsToDelete) {
                        userDAO.deleteUser(id);
                    }
                }
                response.sendRedirect("UserController");
            } else if (action.equalsIgnoreCase("view")) {
                String userID = null;
                try {
                    userID = request.getParameter("userID");
                } catch (Exception e) {

                }

                user = null;
                if (userID != null) {
                    user = userDAO.searchUser(userID);
                }

                request.setAttribute("object", user);
                RequestDispatcher rd = request.getRequestDispatcher("UserProfilePage/UserProfile.jsp");
                rd.forward(request, response);
            } else if (action.equalsIgnoreCase("edit")) {
                if (request.getParameter("username") == null) { //Request for update page
                    String userID = request.getParameter("userID");
                    user = userDAO.searchUser(userID);
                    request.setAttribute("user", user);
                    RequestDispatcher rd = request.getRequestDispatcher("UserProfilePage/UserProfileEditor.jsp");
                    rd.forward(request, response);
                } else if (!request.getParameter("username").isEmpty()) {
                    try {
                        String username = request.getParameter("username");
                        Date dob = Utils.convertStringToSqlDate(request.getParameter("dob"));
                        String phone = request.getParameter("phone");
                        String address = request.getParameter("address");
                        String email = request.getParameter("email");
                        String password = request.getParameter("password");
                        double weight = Double.parseDouble(request.getParameter("weight"));
                        double height = Double.parseDouble(request.getParameter("height"));
                        int gender = Integer.parseInt(request.getParameter("gender"));
                        int activity = Integer.parseInt(request.getParameter("activity"));
                        int preference = Integer.parseInt(request.getParameter("preference"));
                        int goal = Integer.parseInt(request.getParameter("goal"));
                        double amount = Double.parseDouble(request.getParameter("amount"));
                        int duration = Integer.parseInt(request.getParameter("duration"));
                        int main = Integer.parseInt(request.getParameter("main"));
                        int side = Integer.parseInt(request.getParameter("side"));
                        int session = Integer.parseInt(request.getParameter("session"));
                        int rank = Integer.parseInt(request.getParameter("rank"));
                        Date createdate = Utils.convertStringToSqlDate(request.getParameter("createdate"));
                        userDAO.updateUser(username, username, dob, phone, address, email, password, weight, height, gender, activity, preference, goal, amount, duration, main, side, session, rank, createdate);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    response.sendRedirect("UserController");
                }
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

}
