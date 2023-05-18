package com.dietcalculator.controller;

import com.dietcalculator.dao.DayDAO;
import com.dietcalculator.dao.FoodDAO;
import com.dietcalculator.dao.FoodDetailDAO;
import com.dietcalculator.dao.MealDAO;
import com.dietcalculator.dao.ProductDetailDAO;
import com.dietcalculator.dao.UserDAO;
import com.dietcalculator.dto.Day;
import com.dietcalculator.dto.Food;
import com.dietcalculator.dto.FoodDetail;
import com.dietcalculator.dto.Meal;
import com.dietcalculator.dto.ProductDetail;
import com.dietcalculator.dto.User;
import com.dietcalculator.util.Utils;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class LoginController extends HttpServlet {

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
        //        try (PrintWriter out = response.getWriter()) {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        UserDAO dao = new UserDAO();
//        HttpSession checkSession = request.getSession(false);
//        if (checkSession != null && checkSession.getAttribute("usersession") != null) {
//            response.sendRedirect("index/index.html");
//        }
        if (action != null && action.equals("logout")) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();             
            }
            response.sendRedirect("/diet-calculator/LoginController");
        } else if (action == null || request.getParameter("username") == null || request.getParameter("password") == null) {
            response.sendRedirect("Register_Login/login.jsp");
        } else if (action.equals("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = null;
            user = dao.login(username, password);
            if (user != null && user.getUserID()!=null) {
                HttpSession session = request.getSession(true);
                
                //SETTING CART IF IT IS NOT AVAILABLE
                if(session.getAttribute("cart") == null)
                    session.setAttribute("cart", new ArrayList());
                
                //GET CURRENT SESSION CART
                ArrayList<ProductDetail> sessionCart = (ArrayList<ProductDetail>) session.getAttribute("cart");
                
                //MERGING USERCART AND SESSIONCART
                ProductDetailDAO pddao = new ProductDetailDAO();
                ArrayList<ProductDetail> userCart = pddao.loadCartByUserID(user.getUserID());
                mergeCart(sessionCart, userCart, user.getUserID());
                
                //SETTING MENU LISTS IF THEY ARE NOT AVALABLE
                if(session.getAttribute("foodDataset") == null || session.getAttribute("days") == null || session.getAttribute("meals") == null || session.getAttribute("foodDetails") == null || session.getAttribute("imageUrls") == null){
                    session.setAttribute("foodDataset", new ArrayList());
                    session.setAttribute("days", new ArrayList());
                    session.setAttribute("meals", new ArrayList());
                    session.setAttribute("foodDetails", new ArrayList());
                    session.setAttribute("imageUrls", new ArrayList());
                }
                
                //GETTING CURRENT MENU LISTS
                ArrayList<Food> foodDataset = (ArrayList<Food>) session.getAttribute("foodDataset");
                ArrayList<Day> days = (ArrayList<Day>) session.getAttribute("days");
                ArrayList<ArrayList<Meal>> meals = (ArrayList<ArrayList<Meal>>)session.getAttribute("meals");
                ArrayList<ArrayList<ArrayList<FoodDetail>>> foodDetails = (ArrayList<ArrayList<ArrayList<FoodDetail>>>)session.getAttribute("foodDetails");
                ArrayList<ArrayList<ArrayList<String>>> imageUrls = (ArrayList<ArrayList<ArrayList<String>>>)session.getAttribute("imageUrls");
            
                
                //LOAD THE USER MENU LISTS
                //USER DAYS
                DayDAO dayDAO = new DayDAO();
                ArrayList<Day> userDays = dayDAO.readDayByUserID(user.getUserID());
                
                //IF LOGGED USER HAS HIS OWN DATABASE MENU LISTS, WE WILL RETRIEVE THE DATABASE LISTS AND REMOVE THE SESSION LISTS
                if(!userDays.isEmpty()){       //USER HAS MENU LISTS IN DATABASE
                    //USER MEALS
                    MealDAO mealDAO = new MealDAO();
                    ArrayList<ArrayList<Meal>> tmpMeal = new ArrayList();

                    for(Day day: userDays)
                        tmpMeal.add(mealDAO.readMealByDayID(day.getDayID()));

                    ArrayList<ArrayList<Meal>> userMeals = new ArrayList();
                    if(!tmpMeal.isEmpty() && !tmpMeal.get(0).isEmpty()){
                        for(int i = 0; i < tmpMeal.get(0).size(); i++){ //number of meals
                            ArrayList<Meal> tmp = new ArrayList();
                            for(int j = 0; j < tmpMeal.size(); j++)
                                tmp.add(tmpMeal.get(j).get(i));
                            
                            userMeals.add(tmp);
                        }
                    }
                    
                    //USER FOOD DETAILS
                    FoodDetailDAO fdDAO =new FoodDetailDAO();
                    ArrayList<ArrayList<ArrayList<FoodDetail>>>userFoodDetails = new ArrayList();
                    
                    if(!userMeals.isEmpty() && !userDays.isEmpty()){
                        for(int i = 0; i < userMeals.size(); i++){
                            ArrayList<ArrayList<FoodDetail>> tmpFDMeal = new ArrayList();
                            for(int j = 0; j < userDays.size(); j++)
                                tmpFDMeal.add(fdDAO.readFoodDetailByMealID(userMeals.get(i).get(j).getMealID()));
                            userFoodDetails.add(tmpFDMeal);
                        }
                    }
                    
                    //USER IMAGES
                    ImageController ic = new ImageController();
                    ArrayList<ArrayList<ArrayList<String>>> userImageUrls = ic.generateImage(userFoodDetails, userMeals);
                    
                    //SETTING SESSION PARAMETERS
                    FoodDAO foodDAO = new FoodDAO();
                    session.setAttribute("foodDataset", foodDAO.readFood());
                    session.setAttribute("days", userDays);
                    session.setAttribute("meals", userMeals);
                    session.setAttribute("foodDetails", userFoodDetails);
                    session.setAttribute("imageUrls", userImageUrls);
                }else{  //IF USER IS NEW OR HAS NO DATABASE LISTS
                    //UPDATE THE userID
                    String userID = user.getUserID();
                    
                    //SETTING userID for days
                    for(Day day: days)
                        day.setUserID(userID);
                    
                    //SETTING userID for days
                    for(ArrayList<Meal> x: meals)
                        for(Meal y: x)
                            y.setUserID(userID);
                }
                
                //user session is USER
                session.setAttribute("user", user);
                
                //GETTING TARGET PLACE
                String url = "HomeController";
                if(session.getAttribute("target") != null)
                    url = (String)session.getAttribute("target");
                            
                if(user.getRank()>0){
                     url="UserController";
                }
                response.sendRedirect(url);

            } else {
                request.setAttribute("error", "Wrong username or password");
                RequestDispatcher rd = request.getRequestDispatcher("Register_Login/login.jsp");
                rd.forward(request, response);
            }
        } else if (action.equals("register")) {
            try {
                String username = request.getParameter("username");
                Date dob = Date.valueOf(request.getParameter("dob"));
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                LocalDate createDate = java.time.LocalDate.now();
                
                dao.createUser(getUserID(), username, dob, phone, address, email, password, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        Utils.convertJavaDateToSqlDate(createDate.getYear(), createDate.getMonthValue(), createDate.getDayOfMonth()));
            } catch (Exception e) {
                System.out.println(e);
            }

            response.sendRedirect("/diet-calculator/Register_Login/login.jsp");
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

     private final void mergeCart(ArrayList<ProductDetail> sessionCart, ArrayList<ProductDetail> userCart, String userID){
        for(ProductDetail y: userCart){
            int position = -1;
            for(int i = 0; i < sessionCart.size(); i++){
                if(sessionCart.get(i).getProductID().equals(y.getProductID()))
                    position = i;
            }
            if(position < 0) //new item
                sessionCart.add(y);
            else
                sessionCart.get(position).setQuantity(sessionCart.get(position).getQuantity() + y.getQuantity());
        }
        
        //UPDATE userID
        for(ProductDetail x: sessionCart)
            x.setUserID(userID);
        
        //DELETE THE USERCART IN THE DATABASE
        ProductDetailDAO pddao = new ProductDetailDAO();
        for(ProductDetail y: userCart)
            pddao.deleteProductDetail(y.getDetailID());
        
        //SAVE THE SESSION CART TO DATABASE
        String lastIndex = pddao.lastIDIndex();
        int last = Utils.extractIntFromString(lastIndex);
        for(ProductDetail x: sessionCart){
            String detailID = String.format("PD%08d",++last);
            pddao.createProductDetail(detailID, x.getProductID(), userID, null, x.getQuantity());
        }
    }
     
    private static String getUserID() {
        UserDAO dao = new UserDAO();
        String lastIndex = dao.lastIDIndex();
        int last = Utils.extractIntFromString(lastIndex);
        return String.format("U%05d", ++last);
    }

//    public static void main(String[] args) {
//        System.out.println(getUserID());
//    }
}
