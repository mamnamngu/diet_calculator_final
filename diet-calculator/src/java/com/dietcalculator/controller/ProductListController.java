package com.dietcalculator.controller;

import com.dietcalculator.dao.ImageDAO;
import com.dietcalculator.dao.ProductDAO;
import com.dietcalculator.dto.Image;
import com.dietcalculator.dto.Product;
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
 * @author ADMIN
 */
// url path:    productlist
public class ProductListController extends HttpServlet {

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
            ProductDAO pdao = new ProductDAO();
            String keyword = null;
            String type = null;
            String price = null;
            String quantity = null;

            try {
                keyword = request.getParameter("keyword");
                type = request.getParameter("type");
                price = request.getParameter("price");
                quantity = request.getParameter("quantity");
            } catch (Exception e) {
            }
            ArrayList<Product> fullProductList = pdao.readProduct(keyword, type, price, quantity);
            ImageDAO idao = new ImageDAO();
            ArrayList<Image> imagelist = new ArrayList<>();

            int pageSize = 12;
            int totalPages = (int) Math.ceil(fullProductList.size() / pageSize);
            Integer page = null;
            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (Exception e) {
            }
            if (page == null || page == 0) {
                page = 1;
            } else if (page > totalPages) {
                page = totalPages;
            }
            List<Product> productList = paginProducts(page, pageSize, fullProductList);
            for (Product product : productList) {
                if (readImageByProductId(product.getProductID()) != null) {
                    imagelist.add(readImageByProductId(product.getProductID()));
                } else {
                    imagelist.add(new Image("", "", "", "", "https://www.bootdey.com/image/250x220/FFB6C1/000000"));
                }
            }

            request.setAttribute("page", (int) page);
            request.setAttribute("totalPages", totalPages);
            request.setAttribute("productlist", productList);
            request.setAttribute("imagelist", imagelist);
            RequestDispatcher rd = request.getRequestDispatcher("Product List/ProductList.jsp");
            rd.forward(request, response);
        }
    }

    private Image readImageByProductId(String id) {
        ImageDAO imageDao = new ImageDAO();
        ArrayList<Image> imageList = imageDao.searchImageByProductID(id);
        for (Image image : imageList) {
            if (image.getProductID().equals(id)) {
                return image;
            }
        }
        return null;
    }

    public List<Product> paginProducts(int pageNum, int pageSize, List<Product> products) {
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, products.size());
        List<Product> productList = products.subList(startIndex, endIndex);
        return productList;
    }

//    public static void main(String[] args) {
//          ProductDAO pdao = new ProductDAO();
//            ArrayList<Product> fullProductList = pdao.readProduct();
//            ImageDAO idao = new ImageDAO();
//            ArrayList<Image> imagelist = new ArrayList<>();
//            Integer page = null;
//
//            if(page == null){
//                page = 1;
//            } 
//            
//            List<Product> productList  = fullProductList.subList((page-1)*12, page*12);
//  
//                    for (Product product : productList) {
////                imagelist.add(idao.searchImageByProductID(product.getProductID()).get(0));
//                imagelist.add(new Image("", "", "", "", "https://www.bootdey.com/image/250x220/FFB6C1/000000"));
//            }
//                    for (Image Image : imagelist) {
//                        System.out.println(Image.getUrl());
//        }
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
