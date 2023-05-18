package com.dietcalculator.controller;

import com.dietcalculator.dao.ImageDAO;
import com.dietcalculator.dao.ProductDAO;
import com.dietcalculator.dto.Image;
import com.dietcalculator.dto.Product;
import java.io.IOException;
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
public class RelatedProduct extends HttpServlet {

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
        ProductDAO dao = new ProductDAO();

        String type = null;
        type = String.valueOf(request.getAttribute("type"));
        if (type != null) {
            ArrayList<Product> productList = dao.readProduct();
            ArrayList<Product> relateList = new ArrayList<>();
            for (Product product : productList) {
                if (product.getType().equalsIgnoreCase(type)) {
                    relateList.add(product);
                }
            }
            ArrayList<Image> imagelist = new ArrayList<>();
            for (Product product : relateList) {
                if (readImageByProductId(product.getProductID()) != null) {
                    imagelist.add(readImageByProductId(product.getProductID()));
                } else {
                    imagelist.add(new Image("", "", "", "", "https://www.bootdey.com/image/250x220/FFB6C1/000000"));
                }
            }
            request.setAttribute("relateList", relateList);
            request.setAttribute("imageList", imagelist);
            RequestDispatcher rd = request.getRequestDispatcher("Product List/RelatedProduct.jsp");
            try {
                Thread.sleep(1000); // delay 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            rd.include(request, response);
        }

    }

    private static Image readImageByProductId(String id) {
        ImageDAO imageDao = new ImageDAO();
        ArrayList<Image> imageList = imageDao.searchImageByProductID(id);
        for (Image image : imageList) {
            if (image.getProductID().equals(id)) {
                return image;
            }
        }
        return null;
    }
//    public static void main(String[] args) {
//                ProductDAO dao = new ProductDAO();
//
//        String type = "Vitamin";
//    
// 
//            ArrayList<Product> productList = dao.readProduct();
//            ArrayList<Product> relateList = new ArrayList<>();
//            for (Product product : productList) {
//                if (product.getType().equals(type)) {
//                    relateList.add(product);
//                }
//            ArrayList<Image> imagelist = new ArrayList<>();
//            for (Product pr : relateList) {
//                if (readImageByProductId(pr.getProductID()) != null) {
//                    imagelist.add(readImageByProductId(pr.getProductID()));
//                } else {
//                    imagelist.add(new Image("", "", "", "", "https://www.bootdey.com/image/250x220/FFB6C1/000000"));
//                }
//            }
//                for (Image image : imagelist) {
//                    System.out.println(image.getUrl());
//                }
//            }}

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
