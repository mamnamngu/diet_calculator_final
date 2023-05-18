package com.dietcalculator.controller;

import com.dietcalculator.dao.ImageDAO;
import com.dietcalculator.dao.ProductDAO;
import com.dietcalculator.dto.Image;
import com.dietcalculator.dto.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class ProductInfoController extends HttpServlet {

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
            ProductDAO pd = new ProductDAO();
            ArrayList<Product> pl = pd.readProduct();
            ImageDAO id = new ImageDAO();
            ArrayList<Image> il = id.readImageByProductID();
            String productID = request.getParameter("productID");
            Product p = new Product();
            for (Product product : pl) {
                if (product.getProductID().equals(productID)) {
                    p = product;
                }
            }
           
            Image i = new Image();
            for (Image image : il) {
                if(image.getProductID().equals(p.getProductID())){
                    i = image;
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher("Product List/ProductDetail.jsp");
            request.setAttribute("product", p);
            request.setAttribute("image", i);
            rd.include(request, response);
            rd = request.getRequestDispatcher("RelatedProduct");
            request.setAttribute("type", p.getType());
            rd.include(request, response);
        }
    }
//    public static void main(String[] args) {
//                    ProductDAO pd = new ProductDAO();
//            ArrayList<Product> pl = pd.readProduct();
//            ImageDAO id = new ImageDAO();
//            ArrayList<Image> il = id.readImageByProductID();
//
//            Product p = new Product();
//            for (Product product : pl) {
//                if (product.getProductID().equals("PRO0001")) {
//                    p = product;
//                }
//            }
//            Image i = new Image();
//
//            i.setUrl("https://www.bootdey.com/image/250x220/FFB6C1/000000");
//            System.out.println(p.toString()+","+i.getUrl());
//    }
    

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
