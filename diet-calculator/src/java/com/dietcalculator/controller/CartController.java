/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.controller;

import com.dietcalculator.dao.BillDAO;
import com.dietcalculator.dao.ProductDAO;
import com.dietcalculator.dao.ProductDetailDAO;
import com.dietcalculator.dto.Product;
import com.dietcalculator.dto.ProductDetail;
import com.dietcalculator.dto.User;
import com.dietcalculator.util.Constants;
import com.dietcalculator.util.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asout
 */
public class CartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ProductDetailDAO pddao = new ProductDetailDAO();
    ProductDAO pdao = new ProductDAO();
    BillDAO billDAO = new BillDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("cart") == null){
            RequestDispatcher rd = request.getRequestDispatcher("/HomeController");
            rd.forward(request, response);
        }else{
            //GETTING CURRENT CART, USER AND ACTION
            String action = request.getParameter("action");
            ArrayList<ProductDetail> cart = (ArrayList<ProductDetail>)session.getAttribute("cart");
            User user = (User) session.getAttribute("user");
            
            if(action == null ||action.equals("read")){
                ArrayList<Product> productList = new ArrayList();
                double total = 0;
                
                for(ProductDetail x: cart){
                    Product product = pdao.searchProductByProductID(x.getProductID());
                    productList.add(product);
                    total += product.getPrice() * x.getQuantity();
                }
                
                request.setAttribute("productList", productList);
                request.setAttribute("detailList", cart);
                request.setAttribute("total", total);
                request.setAttribute("message", request.getParameter("message"));
                RequestDispatcher rd = request.getRequestDispatcher("Shopping Cart/ShoppingCart.jsp");
                rd.forward(request, response);
            }else if(action.equals("add")){
                String userID = "";
                //IF USER HAS NO LOGGED IN
                if(user != null)
                    userID = user.getUserID();
                
                String productID = request.getParameter("productID");
                int amount = 1;
                int position = -1;
                for(int i = 0; i < cart.size(); i++)
                    if(cart.get(i).getProductID().equals(productID))
                        position = i;
                
                String message = "";
                if(position < 0){
                    String detailID = "";
                    //UPDATE DATABASE
                    if(user != null){
                        String lastIndex = pddao.lastIDIndex();
                        int last = Utils.extractIntFromString(lastIndex);
                        detailID = String.format("PD%08d", ++last);
                        pddao.createProductDetail(detailID, productID, userID, null, amount);
                    }
                    
                    cart.add(new ProductDetail(detailID,productID,userID,null,amount));
                }else{
                    int max = pdao.searchProductByProductID(productID).getQuantity();
                    if(cart.get(position).getQuantity() == max){
                    message = "Stock left: " + max + "! Cannot add any item!";
                    amount = max;
                    }else
                        amount += cart.get(position).getQuantity();
                    
                    cart.get(position).setQuantity(amount);

                    //UPDATE DATABASE
                    if(user != null)
                        pddao.updateProductDetail(cart.get(position).getDetailID(), cart.get(position).getProductID(), cart.get(position).getUserID(), null, amount);
                
                }
                response.sendRedirect("CartController?message=" + message);
            }else if(action.equals("update")){
                String productID = request.getParameter("productID");
                int amount = 1;
                try{
                    amount = Integer.parseInt(request.getParameter("amount"));
                }catch(Exception e){
                    e.getMessage();
                }
                
                String message = "";
                //CHECK AMOUNT
                int max = pdao.searchProductByProductID(productID).getQuantity();
                if(amount > max){
                    message = "Stock left: " + max + "!";
                    amount = max;
                }else if(amount < 0)
                    amount = 0;
                
                int position = -1;
                for(int i = 0; i < cart.size(); i++)
                    if(cart.get(i).getProductID().equals(productID))
                        position = i;
                if(position >= 0){
                    cart.get(position).setQuantity(amount);

                     //UPDATE DATABASE
                    if(user != null)
                        pddao.updateProductDetail(cart.get(position).getDetailID(), cart.get(position).getProductID(), cart.get(position).getUserID(), null, amount);
                
                }
                response.sendRedirect("CartController?message=" + message);
            }else if(action.equals("delete")){
                String productID = request.getParameter("productID");
                int position = -1;
                for(int i = 0; i < cart.size(); i++)
                    if(cart.get(i).getProductID().equals(productID))
                        position = i;
                if(position >= 0){
                    //UPDATE DATABASE
                    if(user != null)
                        pddao.deleteProductDetail(cart.get(position).getDetailID());
                
                    cart.remove(position);
                }
                response.sendRedirect("CartController");
            }else if(action.equals("checkout")){
                //CHECK IF CURRENT USER HAS LOGGED IN OR NOT
                if(user != null){
                    //LOGIN USER WILL PROCEED TO CHECK OUT
                    ArrayList<Product> productList = new ArrayList();
                    for(ProductDetail x: cart){
                        Product product = pdao.searchProductByProductID(x.getProductID());
                        productList.add(product);
                    }
                    request.setAttribute("detailList", cart);
                    request.setAttribute("productList", productList);
                    cart.size();
                    response.sendRedirect("Shopping Cart/Checkout.jsp");

                }else{
                    //CHECK IF CURRENT USER HAS SIGNED UP CAN COME BACK OR NOT
                    
                    //WHERE TO COME BACK
                    session.setAttribute("target","CartController");
                    response.sendRedirect("LoginController");
                }
            }else if(action.equals("pay")){
                String url="MailController?action=newOrderNoti";
                 for(ProductDetail x: cart){
                    Product product = pdao.searchProductByProductID(x.getProductID());
                     if (x.getQuantity()>product.getQuantity()) {
                         url="CartController";
                     }
                }
                //DEDUCT ITMES
                for(ProductDetail x: cart){
                    Product product = pdao.searchProductByProductID(x.getProductID());
                    pdao.updateProduct(product.getProductID(), product.getProductname(), product.getType(), product.getPrice(), product.getQuantity() - x.getQuantity(), product.getBrand(), product.getOrigin(), product.getVolume(), product.getEffect(), product.getRate(), product.getPurchase() + x.getQuantity());
                }
                
                ArrayList<ProductDetail> tmpCart = pddao.loadCartByUserID(user.getUserID());
                request.setAttribute("cart", tmpCart);
                //PAYMENT WILL UPDATE THE BILLID IN THE CART AND CLEAR THE CART
                payProcess(cart, user.getUserID());
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
        }
    }

    private final void payProcess(ArrayList<ProductDetail> sessionCart, String userID){
        String lastIndex = billDAO.lastIDIndex();
        int last = Utils.extractIntFromString(lastIndex);
        String billID = String.format("BILL%06d", ++last);
        //ADDING A NEW BILL
        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);
        billDAO.createBill(billID, userID, date, "FPTU", "COD");
        
        //UPDATING PRODUCT DETAILS
        for(ProductDetail x: sessionCart)
            pddao.updateProductDetail(x.getDetailID(), x.getProductID(), x.getUserID(), billID, x.getQuantity());
        
        //REMOVE ALL ITEMS IN THE CART
        sessionCart.clear();
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
