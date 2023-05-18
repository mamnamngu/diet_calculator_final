/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.controller;

import com.dietcalculator.dao.ProductDAO;
import com.dietcalculator.dto.Product;
import com.dietcalculator.dto.User;
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
public class ProductController extends HttpServlet {

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
        User user = (User) request.getSession().getAttribute("user");

        if (user == null || user.getRank() < 0) {
            try (PrintWriter out = response.getWriter()) {
                out.print("<h1>You don't have permission</h1");
            }
        } else {
            String action = request.getParameter("action");
            ProductDAO dao = new ProductDAO();

            if (action == null || action.equals("read")) {
                ArrayList<Product> fullList = dao.readProduct();

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
                List<Product> list = paginProduct(page, pageSize, fullList);

                request.setAttribute("page", (int) page);
                request.setAttribute("totalPages", totalPages);
                request.setAttribute("productList", list);
                RequestDispatcher rd = request.getRequestDispatcher("./Administrator/ViewDeleteProduct.jsp");

                rd.forward(request, response);

            } else if (action.equals("create")) {
                if (!request.getParameter("productID").isEmpty()) {
                    try {
                        String productID = request.getParameter("productID");
                        String productname = request.getParameter("productname");
                        String type = request.getParameter("type");
                        double price = Double.parseDouble(request.getParameter("price"));
                        int quantity = Integer.parseInt(request.getParameter("quantity"));
                        String brand = request.getParameter("brand");
                        String origin = request.getParameter("origin");
                        double volume = Double.parseDouble(request.getParameter("volume"));
                        String effect = request.getParameter("effect");
                        double rate = Double.parseDouble(request.getParameter("rate"));
                        int purchase = Integer.parseInt(request.getParameter("purchase"));
                        dao.createProduct(productID, productname, type, price, quantity, brand, origin, volume, effect, rate, purchase);

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    response.sendRedirect("ProductController");
                } else {
                    response.sendRedirect("ProductController");
                }

            } else if (action.equals("update")) {
                if (request.getParameter("productname") == null) {
                    Product product = productByID(request.getParameter("productID"));
                    request.setAttribute("product", product);
                    RequestDispatcher rd = request.getRequestDispatcher("Administrator/EditProduct.jsp");
                    rd.forward(request, response);
                } else if (!request.getParameter("productname").isEmpty()) {
                    try {
                        String productID = request.getParameter("productID");
                        String productname = request.getParameter("productname");
                        String type = request.getParameter("type");
                        double price = Double.parseDouble(request.getParameter("price"));
                        int quantity = Integer.parseInt(request.getParameter("quantity"));
                        String brand = request.getParameter("brand");
                        String origin = request.getParameter("origin");
                        double volume = Double.parseDouble(request.getParameter("volume"));
                        String effect = request.getParameter("effect");
                        double rate = Double.parseDouble(request.getParameter("rate"));
                        double purchase = Double.parseDouble(request.getParameter("purchase"));
                        dao.updateProduct(productID, productname, type, price, quantity, brand, origin, volume, effect, rate, purchase);
                    } catch (Exception e) {

                    }

                    response.sendRedirect("ProductController");
                }

            } else if (action.equals("delete")) {
                String[] ids = request.getParameterValues("productID");
                if (ids != null) {
                    for (String id : ids) {
                        dao.deleteProduct(id);
                    }
                }

                response.sendRedirect("ProductController");
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

    public ArrayList<Product> listProductByType(ArrayList<Product> ProductDataset, String type) {
        ArrayList<Product> productList = new ArrayList();
        String[] types = type.trim().split(Constants.DELIMITER);
        for (Product x : ProductDataset) {
            if (Utils.isInStringArray(types, x.getType())) {
                productList.add(x);
            }
        }
        return productList;
    }

    private Product productByID(String productID) {
        ProductDAO dao = new ProductDAO();
        ArrayList<Product> list = dao.readProduct();
        for (Product product : list) {
            if (product.getProductID().equals(productID)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> paginProduct(int pageNum, int pageSize, List<Product> product) {
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, product.size());
        List<Product> list = product.subList(startIndex, endIndex);
        return list;
    }
}
