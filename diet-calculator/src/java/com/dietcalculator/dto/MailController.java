/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.dto;

import com.dietcalculator.dao.ProductDAO;
import com.dietcalculator.dao.UserDAO;
import com.dietcalculator.mailer.Mailer;
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
public class MailController extends HttpServlet {

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
        String action = request.getParameter("action");
        if(action == null){
            
        }else if(action.equals("newOrderNoti")){
            ArrayList<ProductDetail> order = (ArrayList<ProductDetail>) request.getAttribute("cart");
            ArrayList<Product> productList= new ArrayList();
            ProductDAO productDAO = new ProductDAO();
            for(ProductDetail x: order)
                productList.add(productDAO.searchProductByProductID(x.getProductID()));
            
            //MAILING INFORMATION
            final String from = "prj301.pgnb@gmail.com";
            final String password = "nqlgrybvvyqjoaxw";
            final String to = "prj301.pgnb@gmail.com";
            final String subtitle = "A New Order Has Been Made From Diet Calculator";
            
            String content = "";
            //PAGE LAYOUT
            final int WIDTH = 136;
            final int DEFAULT_PADDING = 20;
            final int index = 10;
            final int name = 50;
            final int quantity = 10;
            final int unit_price = 30;
            final int cost = 36;
            
            //CONTENT LAYOUT
            final String WELCOME = "NEW ORDER FROM DIET CALCULATOR";
            
            String[] HEADER = {"date","userID","username","phone","address"};
            String[] FOOTER = {"Shipping","Payment"};
            
            //GETTING TIME STRING
            long millis=System.currentTimeMillis();  
            java.sql.Date date=new java.sql.Date(millis);
            final String DATE = "DATE: " + date.toString();
            
            //GETTING USER INFORMATION
            //userID
            String userID = order.get(0).getUserID();
            final String USERID = "USERID: " + userID;
            UserDAO userDAO = new UserDAO();
            User user = userDAO.searchUser(userID);
            
            //username
            final String USERNAME = "USERNAME: " + user.getUsername();
            
            //Phone
            final String PHONE = "PHONE: " + user.getPhone();
            
            //Address
            final String ADDRESS = "ADDRESS: " + user.getAddress();
            
            //SHIPPING
            final String SHIPPING = "SHIPPING: GIAO HANG NHANH";
            
            //PAYMENT
            final String PAYMENT = "PAYMENT: COD";
            
            //HEADER
            String header = "";
            header += Utils.printMiddle(WIDTH, WELCOME, 1);
            header += Utils.printMiddle(WIDTH, DATE, 1);
            header += Utils.printHalf(WIDTH, USERID, DEFAULT_PADDING, "left");
            header += Utils.printHalf(WIDTH, USERNAME, DEFAULT_PADDING, "right");
            header += Utils.printHalf(WIDTH, PHONE, DEFAULT_PADDING, "left");
            header += Utils.printHalf(WIDTH, ADDRESS, DEFAULT_PADDING, "right");
            
            //BODY
            String body = "";
            String TABLE_HEADER = "";
            TABLE_HEADER += Utils.printMiddle(index, "Index", 0);
            TABLE_HEADER += Utils.printMiddle(name, "Product Name", 0);
            TABLE_HEADER += Utils.printMiddle(quantity, "Quantity", 0);
            TABLE_HEADER += Utils.printMiddle(unit_price, "Unit Price", 0);
            TABLE_HEADER += Utils.printMiddle(cost, "Cost", 1);
            
            body += TABLE_HEADER;
            
            String TABLE_BODY = "";
            double total = 0;
            for(int i = 0; i < order.size(); i++){
                String TABLE_ROW = "";
                TABLE_ROW += Utils.printTable(index, String.valueOf(i + 1), "left", 0);
                TABLE_ROW += Utils.printTable(name,productList.get(i).getProductname(), "left", 0);
                TABLE_ROW += Utils.printTable(quantity, String.valueOf(order.get(i).getQuantity()), "right", 0);
                TABLE_ROW += Utils.printTable(unit_price, String.valueOf(productList.get(i).getPrice()), "right", 0);
                TABLE_ROW += Utils.printTable(cost, String.valueOf(productList.get(i).getPrice() * order.get(i).getQuantity()), "right", 1);
                total += productList.get(i).getPrice() * order.get(i).getQuantity();
                TABLE_BODY += TABLE_ROW;
            }
            TABLE_BODY += Utils.printMiddle(WIDTH, "Total: " + total, 1);
            
            body += TABLE_BODY;
            
            //FOOTER
            String footer = "";
            footer += Utils.printHalf(WIDTH, SHIPPING, DEFAULT_PADDING, "left");
            footer += Utils.printHalf(WIDTH, PAYMENT, DEFAULT_PADDING, "right");
            
            //ASSEMBLY
            content = header + "\n\n" + body + "\n\n" + footer;
            
            //SENDING EMAIL
            Mailer.send(from, password, to, subtitle, content);
            response.sendRedirect("Shopping Cart/ShoppingCart.jsp");
        }else if(action.equals("sendMail")){
            
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
