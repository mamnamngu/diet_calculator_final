/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.controller;

import com.dietcalculator.dao.DayDAO;
import com.dietcalculator.dao.FoodDAO;
import com.dietcalculator.dao.FoodDetailDAO;
import com.dietcalculator.dao.ImageDAO;
import com.dietcalculator.dao.MealDAO;
import com.dietcalculator.dto.Day;
import com.dietcalculator.dto.Food;
import com.dietcalculator.dto.FoodDetail;
import com.dietcalculator.dto.Image;
import com.dietcalculator.dto.Meal;
import com.dietcalculator.dto.User;
import com.dietcalculator.util.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
public class MenuController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    FoodDAO foodDAO = new FoodDAO();
    DayDAO dayDAO = new DayDAO();
    MealDAO mealDAO = new MealDAO();
    FoodDetailDAO fdDAO = new FoodDetailDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession currentSession = request.getSession(false);
        if(currentSession == null || currentSession.getAttribute("foodDetails") == null){
            RequestDispatcher rd = request.getRequestDispatcher("/HomeController");
            rd.forward(request, response);
        }else{
            //GETTING ACTION
            String action = request.getParameter("action");
            
            //GETTING USER
            User user = (User) currentSession.getAttribute("user");
            
            //GETTING SESSION MENU LISTS
            ArrayList<Food> foodDataset = (ArrayList<Food>) currentSession.getAttribute("foodDataset");
            ArrayList<Day> days = (ArrayList<Day>) currentSession.getAttribute("days");
            ArrayList<ArrayList<Meal>> meals = (ArrayList<ArrayList<Meal>>)currentSession.getAttribute("meals");
            ArrayList<ArrayList<ArrayList<FoodDetail>>> foodDetails = (ArrayList<ArrayList<ArrayList<FoodDetail>>>)currentSession.getAttribute("foodDetails");
            ArrayList<ArrayList<ArrayList<String>>> imageUrls = (ArrayList<ArrayList<ArrayList<String>>>)currentSession.getAttribute("imageUrls");
            
            if(action.equals("menu")){
                if(foodDataset.isEmpty())
                    response.sendRedirect("/diet-calculator/calculator/DietForm.jsp");
                else{
                    response.sendRedirect("MenuController?action=show");
                }
            }else if(action.equals("generate")){
                //GETTING FORM PARAMETERS
                int age = Integer.parseInt(request.getParameter("age"));
                int gender = Integer.parseInt(request.getParameter("gender"));
                double height = Double.parseDouble(request.getParameter("height"));
                double weight = Double.parseDouble(request.getParameter("weight"));
                int activity = Integer.parseInt(request.getParameter("activity"));
                int preference = Integer.parseInt(request.getParameter("preference"));
                int goal = Integer.parseInt(request.getParameter("goal"));
                double amount = Double.parseDouble(request.getParameter("amount"));
                int duration = Integer.parseInt(request.getParameter("duration"));
                int main = Integer.parseInt(request.getParameter("main"));
                int side = Integer.parseInt(request.getParameter("side"));
                int session = Integer.parseInt(request.getParameter("session"));

                //GETTING USERID
                String userID = "";
                if (user != null)
                    userID = user.getUserID();
                
                //CALCULATING CALORIC NEED
                double totalCaloricNeed = Constants.totalCaloricNeed(gender, weight, height, age, activity, goal, amount, age);

                //GENERATING FOOD DATASET
                foodDataset = foodDAO.readFood();

                //GENERTAING DAYS, format: ArrayList: all days in a program
                DayController dc = new DayController();
                days = dc.generateDay(duration, userID, totalCaloricNeed, Constants.PLATE_PORTION.get(preference));

                //GENERATING MEALS, format: ArrayList<Meal>[meals], ArrayList: all days in a program
                MealController mc = new MealController();
                HashMap<Integer, Double> mealProportion = Constants.mealProprtion(main, side);
                meals = mc.generateMeal(days, mealProportion);

                //GENERATING FOOD DETAILS, format: ArrayList<FoodDetail>[meals][foodDetails], ArrayList: all days in a program
                FoodDetailController fdc = new FoodDetailController();
                foodDetails = fdc.generateFoodDetail(foodDataset, meals, days);

                //GENERATING IMAGES, format: ArrayList<Image>[meals], ArrayList: all days in a program
                ImageController ic = new ImageController();
                imageUrls = ic.generateImage(foodDetails, meals);

                //SETTING THESE ATTRIBUTES TO THE CURRENT SESSION
                currentSession.setAttribute("foodDataset",foodDataset);
                currentSession.setAttribute("days", days);
                currentSession.setAttribute("meals", meals);
                currentSession.setAttribute("foodDetails", foodDetails);
                currentSession.setAttribute("imageUrls", imageUrls);

                response.sendRedirect("MenuController?action=show");

            }else if(action.equals("show")){
                //GETTING PAGE NUMBER
                final int PAGE_SIZE = 7;       //7 days in a week
                int totalPages = (int) Math.ceil(days.size()/PAGE_SIZE);
                Integer page = null;
                try {
                    page = Integer.parseInt(request.getParameter("page"));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                if (page == null) {
                    page = 1;
                } else if (page > totalPages) {
                    page = totalPages;
                }

                //GETTING PAGED PARAMETERS
                List<Day> subDays = pagingDays(page,PAGE_SIZE,days);
                ArrayList<List<Meal>> subMeals = pagingMeals(page,PAGE_SIZE,meals);
                ArrayList<List<ArrayList<FoodDetail>>> subFoodDetails = pagingFoodDetails(page,PAGE_SIZE,foodDetails);
                ArrayList<List<ArrayList<String>>> subImageUrls = pagingImageUrls(page,PAGE_SIZE,imageUrls);

                request.setAttribute("page", page);
                request.setAttribute("totalPages", totalPages);
                request.setAttribute("days", subDays);
                request.setAttribute("meals", subMeals);
                request.setAttribute("foodDetails", subFoodDetails);
                request.setAttribute("imageUrls", subImageUrls);
                request.setAttribute("foodDataset", foodDataset);
                currentSession.setAttribute("subDays", subDays);

                RequestDispatcher rd = request.getRequestDispatcher("/Menu/Menu.jsp");
                rd.include(request, response);
                rd = request.getRequestDispatcher("DietGrading");
                rd.include(request, response);

            }else if(action.equals("details")){
                //GETTING REQUEST PARAMETERS
                String mealID = request.getParameter("mealID");
                Integer page = 1;
                try{
                    page = Integer.parseInt(request.getParameter("page"));
                }catch(Exception e){

                }

                Day day = null;
                Meal meal = null;
                ArrayList<FoodDetail> foodDetail = new ArrayList();

                if(mealID != null)
                    meal = findMealByMealID(meals, mealID);

                if(meal != null && days != null && foodDataset != null){
                    day = findDayByMealID(days,meal);
                    foodDetail = findFoodDetailByMealID(foodDetails,meal);
                }
                //GETTING FOODNAME
                ArrayList<Food> foodInMeal = new ArrayList();
                for(FoodDetail x: foodDetail)
                    foodInMeal.add(findFoodByFoodID(x.getFoodID(),foodDataset));

                ArrayList<ArrayList<FoodDetail>> substitutes = new ArrayList();
                FoodDetailController fdc = new FoodDetailController();
                for(FoodDetail x: foodDetail)
                    substitutes.add(fdc.generateFoodDetailSubstituteByCategory(meal, foodDataset, x.getCategory()));

                //GETTING FOODNAME FOR SUBSTITUTES
                ArrayList<ArrayList<Food>> foodSubstitute = new ArrayList();

                for(ArrayList<FoodDetail> x: substitutes){
                    ArrayList<Food> tmp = new ArrayList();
                    for(FoodDetail y: x)
                        tmp.add(findFoodByFoodID(y.getFoodID(),foodDataset));
                    foodSubstitute.add(tmp);
                }

                request.setAttribute("page", page);
                request.setAttribute("day", day);
                request.setAttribute("meal", meal);
                request.setAttribute("foodDetail", foodDetail);
                request.setAttribute("substitutes", substitutes);
                request.setAttribute("foodInMeal", foodInMeal);
                request.setAttribute("foodSubstitute", foodSubstitute);
                RequestDispatcher rd = request.getRequestDispatcher("/Meal/Meal.jsp");
                rd.forward(request, response);
                
            }else if(action.equals("update")){
                final String DEFAULT = "0";

                String mealID = request.getParameter("mealID");

                Day day = null;
                Meal meal = null;
                ArrayList<FoodDetail> foodDetail = new ArrayList();

                if(mealID != null)
                    meal = findMealByMealID(meals, mealID);

                if(meal != null && days != null && foodDataset != null){
                    day = findDayByMealID(days,meal);
                    foodDetail = findFoodDetailByMealID(foodDetails,meal);
                }

                //GETTING LIST OF SUBSTITUTES
                FoodDetailController fdc = new FoodDetailController();
                //CREATING CLONES
                Meal newMeal = new Meal(meal.getMealID(),meal.getUserID(),meal.getDayID(),meal.getMealindex(),meal.getTotalCalstd(), meal.getCarbohydratestd(), meal.getFiberstd(), meal.getProteinstd(), meal.getFatstd(),meal.getWaterstd(),meal.getTotalCal(), meal.getCarbohydrate(), meal.getFiber(), meal.getProtein(), meal.getFat(),meal.getWater());
                Day newDay = new Day(day.getDayID(),day.getUserID(),day.getIndex(),day.getTotalCalstd(),day.getCarbohydratestd(),day.getFiberstd(),day.getProteinstd(),day.getFatstd(),day.getWaterstd(),day.getTotalCal(),day.getCarbohydrate(),day.getFiber(),day.getProtein(),day.getFat(),day.getWater());
                ArrayList<FoodDetail> foodDetailClone = new ArrayList();
                for(FoodDetail x: foodDetail)
                    foodDetailClone.add(x);

                for(FoodDetail x: foodDetailClone){
                    if(!request.getParameter(x.getFoodID()).equals(DEFAULT)){
                        //GENERATE SUBSTITUTES FOR FOODDETAIL
                        ArrayList<FoodDetail> substitute = fdc.generateFoodDetailSubstituteByCategory(meal, foodDataset, x.getCategory());
                        for(FoodDetail y: substitute)
                            if(request.getParameter(x.getFoodID()).equals(y.getFoodID())){
                                newMeal = replaceFoodDetail(foodDetails,day.getIndex()-1,newMeal,foodDetail,x,y);
                                replaceImageUrls(imageUrls,day.getIndex()-1,x.getIcon(),y.getIcon());
                            }
                    }
                }
                //UPDATE MEALS AND DAYS
                newDay = replaceMeal(meals,day,meal,newMeal);
                replaceDay(days,day,newDay);

                //UPDATE SESSION ATTRIBUTES
                currentSession.setAttribute("days",days);
                currentSession.setAttribute("meals",meals);
                currentSession.setAttribute("foodDetails",foodDetails);

                //UPDATE AND REDIRECT BACK TO Meal.jsp
//                request.setAttribute("mealID", newMeal.getMealID());
                response.sendRedirect("MenuController?action=details&mealID=" + newMeal.getMealID());

            }else if(action.equals("buyFood")){
                final int PAGE_SIZE = 7;
                Integer page = 1;
                try{
                    page = Integer.parseInt(request.getParameter("page"));
                }catch(Exception e){

                }
                //GETTING SUBARRAY
                ArrayList<List<ArrayList<FoodDetail>>> subFoodDetails = pagingFoodDetails(page,PAGE_SIZE,foodDetails);
                ArrayList<FoodDetail> fd = new ArrayList();
                HashMap<Food, Double> list = new HashMap();
                for(List<ArrayList<FoodDetail>> x: subFoodDetails)
                    for(ArrayList<FoodDetail> y: x)
                        for(FoodDetail z: y)
                            fd.add(z);
                //SORT THE FOODDETAILS
                Collections.sort(fd);

                for(int i = 0;i < fd.size() - 1;){
                    String currentFoodID = fd.get(i).getFoodID();
                    double currentAmount = fd.get(i).getAmount();

                    while((i < fd.size() -1) && fd.get(++i).getFoodID().equals(currentFoodID))
                        currentAmount += fd.get(i).getAmount();
                    list.put(findFoodByFoodID(currentFoodID,foodDataset), currentAmount);
                }
                request.setAttribute("page", page);
                request.setAttribute("list", list);
                RequestDispatcher rd = request.getRequestDispatcher("/Menu/BuyFood.jsp");
                rd.forward(request, response);

            }else if(action.equals("save")){
                if(user != null){
                    String userID = user.getUserID();
                    //DELETEING
                    //DELETING FOOD DETAILS
                    fdDAO.deleteFoodDetailByUserID(userID);
                    
                    //DELETEING MEALS
                    mealDAO.deleteMealByUserID(userID);
                    
                    //DELETING DAYS
                    dayDAO.deleteDay(userID);
                    
                    //SAVING DAYS
                    for(Day x: days)
                        dayDAO.createDate(x);
                        
                    //SAVING MEALS
                    for(ArrayList<Meal> x:meals)
                        for(Meal y: x)
                            mealDAO.createMeal(y);
                    
                    //SAVING FOODDETAILS
                    for(List<ArrayList<FoodDetail>> x: foodDetails)
                        for(ArrayList<FoodDetail> y : x)
                            for(FoodDetail z: y) 
                                fdDAO.createFoodDetail(z);
                    
                    response.sendRedirect("MenuController?action=show");
                }else{
                    //WHERE TO COME BACK
                    currentSession.setAttribute("target","MenuController?action=save");
                    response.sendRedirect("LoginController");
                }
            }
        }
    }
    public void replaceImageUrls(ArrayList<ArrayList<ArrayList<String>>> imageUrls, int dayIndex, String before, String after){
         for(int i = 0; i < imageUrls.size(); i++){
             int size = imageUrls.get(i).get(dayIndex).size();
             for(int j = 0; j < size; j++ ){
                 if(imageUrls.get(i).get(dayIndex).get(j).equals(before)){
                     imageUrls.get(i).get(dayIndex).remove(before);
                     imageUrls.get(i).get(dayIndex).add(j,after);
                     return;
                }
                j++;
            }
        }
    }
    
    public Meal replaceFoodDetail(ArrayList<ArrayList<ArrayList<FoodDetail>>> foodDetails,int dayIndex, Meal meal, ArrayList<FoodDetail> fd, FoodDetail before, FoodDetail after){
        Meal newMeal = new Meal(meal.getMealID(),meal.getUserID(),meal.getDayID(),meal.getMealindex(),meal.getTotalCalstd(), meal.getCarbohydratestd(), meal.getFiberstd(), meal.getProteinstd(), meal.getFatstd(),meal.getWaterstd(),0,0,0,0,0,0);
        for(int i = 0; i < fd.size(); i++)
            if(fd.get(i).getFoodID().equals(before.getFoodID())){
                //UPDATE NEW FOODDETAIL'S MEALID
                after.setMealID(before.getMealID());
                
                //RESET NEWMEAL PARAMETERS
                newMeal.setTotalCal(meal.getTotalCal() - before.getTotalCal() + after.getTotalCal());
                newMeal.setCarbohydrate(meal.getCarbohydrate()- before.getCarbohydrate() + after.getCarbohydrate());
                newMeal.setFiber(meal.getFiber() - before.getFiber() + after.getFiber());
                newMeal.setProtein(meal.getProtein() - before.getProtein() + after.getProtein());
                newMeal.setFat(meal.getFat() - before.getFat() + after.getFat());
                newMeal.setWater(meal.getWater() - before.getWater() + after.getWater());
                
                //REPLACE IN fd
                fd.remove(i);
                fd.add(i,after);
                
                //REPLACE IN foodDetails
                for(int j = 0; j < foodDetails.size(); j++)
                    if(foodDetails.get(j).get(dayIndex).get(0).getMealID().equals(meal.getMealID())){
                        foodDetails.get(j).remove(dayIndex);
                        foodDetails.get(j).add(dayIndex,fd);
                                        return newMeal;

                    }
            }
        return newMeal;
    }
    
    public Day replaceMeal(ArrayList<ArrayList<Meal>> meals, Day day, Meal before, Meal after){
        Day newDay = new Day(day.getDayID(),day.getUserID(),day.getIndex(),day.getTotalCalstd(),day.getCarbohydratestd(),day.getFiberstd(),day.getProteinstd(),day.getFatstd(),day.getWaterstd(),0,0,0,0,0,0);
        for(int i = 0; i < meals.size(); i++)
            if(meals.get(i).get(day.getIndex() - 1).getMealID().equals(before.getMealID())){
                //RESET NEWDAY PARAMETERS
                newDay.setTotalCal(day.getTotalCal() - before.getTotalCal() + after.getTotalCal());
                newDay.setCarbohydrate(day.getCarbohydrate()- before.getCarbohydrate() + after.getCarbohydrate());
                newDay.setFiber(day.getFiber() - before.getFiber() + after.getFiber());
                newDay.setProtein(day.getProtein() - before.getProtein() + after.getProtein());
                newDay.setFat(day.getFat() - before.getFat() + after.getFat());
                newDay.setWater(day.getWater() - before.getWater() + after.getWater());
                
                //REPLACE IN meals
                meals.get(i).remove(day.getIndex() - 1);
                meals.get(i).add(day.getIndex() - 1,after);
                return newDay;
            }
        return newDay;   
    }
    
    public void replaceDay(ArrayList<Day> days, Day before, Day after){
        for(int i = 0; i < days.size(); i++)
            if(days.get(i).getDayID().equals(before.getDayID())){
                days.remove(i);
                days.add(i,after);
            }
    }
    
    public Meal findMealByMealID(ArrayList<ArrayList<Meal>> meals, String mealID){
        for(ArrayList<Meal> x: meals)
            for(Meal y: x)
                if(y.getMealID().equals(mealID))
                    return y;
        return null;
    }
    
    public Day findDayByMealID(ArrayList<Day> days, Meal meal){
        for(Day x: days)
            if(meal.getDayID().equals(x.getDayID()))
                return x;
        return null;
    }
    
    public ArrayList<FoodDetail> findFoodDetailByMealID(ArrayList<ArrayList<ArrayList<FoodDetail>>> foodDetail, Meal meal){
        for(ArrayList<ArrayList<FoodDetail>> x: foodDetail)
            for(ArrayList<FoodDetail> y: x)
                if(y.get(0).getMealID().equals(meal.getMealID()))
                    return y;
        return null;
            
    }
    
    public Food findFoodByFoodID(String foodID, ArrayList<Food> allApplicableFood){
        for(Food x: allApplicableFood)
            if(x.getFoodID().equals(foodID))
                return x;
        return null;
    }
    
    public ArrayList<List<ArrayList<FoodDetail>>> pagingFoodDetails(int pageNum, int pageSize, ArrayList<ArrayList<ArrayList<FoodDetail>>> foodDetails) {
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, foodDetails.get(0).size());
        ArrayList<List<ArrayList<FoodDetail>>> subList = new ArrayList();
        
        for(ArrayList<ArrayList<FoodDetail>> fdByMeal: foodDetails){
            List<ArrayList<FoodDetail>> fdByMealAndDay = (List<ArrayList<FoodDetail>>) fdByMeal.subList(startIndex, endIndex);
            subList.add(fdByMealAndDay);
        }
        return subList;
    }
    
    public ArrayList<List<ArrayList<String>>> pagingImageUrls(int pageNum, int pageSize, ArrayList<ArrayList<ArrayList<String>>> imageUrls) {
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, imageUrls.get(0).size());
        ArrayList<List<ArrayList<String>>> subList = new ArrayList();
        
        for(ArrayList<ArrayList<String>> urlByMeal: imageUrls){
            List<ArrayList<String>> urlByMealAndDay = (List<ArrayList<String>>) urlByMeal.subList(startIndex, endIndex);
            subList.add(urlByMealAndDay);
        }
        return subList;
    }
    
    public ArrayList<List<Meal>> pagingMeals(int pageNum, int pageSize, ArrayList<ArrayList<Meal>> meals) {
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, meals.get(0).size());
        ArrayList<List<Meal>> subList = new ArrayList();
        
        for(ArrayList<Meal> mealsByMeal: meals){
            List<Meal> mealsByMealAndDay = (List<Meal>) mealsByMeal.subList(startIndex, endIndex);
            subList.add(mealsByMealAndDay);
        }
        return subList;
    }
    
    public List<Day> pagingDays(int pageNum, int pageSize, ArrayList<Day> days) {
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, days.size());
        List<Day> subList = (List<Day>) days.subList(startIndex, endIndex);
        return subList;
    }
    
//
//    public static void main(String[] args) {
//        //SAMPLE DATA
//        String userID = "U00000";
//        int week = 8;
//        int mainMeal = 3;
//        int sideMeal = 2;
//        
//        //Generating Food dataset
//        FoodDAO foodDAO = new FoodDAO();
//        ArrayList<Food> foodDataset = foodDAO.readFood();
//        int preference = 1;
//        double caloricNeed = 2200;
//        
//        //Generating days
//        DayController dc =new DayController();
//        ArrayList<Day> days = dc.generateDay(week, userID, caloricNeed, Constants.PLATE_PORTION.get(preference));
//        
//        //Testing
////        for(Day day: days)
////            System.out.println(day);
//        
//        //Generating meals
//        MealController mc = new MealController();
//        HashMap<Integer, Double> mealProportion = Constants.mealProprtion(mainMeal, sideMeal);
//        ArrayList<ArrayList<Meal>> meals = mc.generateMeal(days, mealProportion);
//        
//        //Testing
////        for(int i = 0; i < mainMeal+sideMeal; i++){
////            for(int j = 0; j < days.size(); j++){
////                 System.out.println(meals.get(i).get(j));
////            }
////        }
//        
//
////        //Generating Food Details
//        FoodDetailController fdc = new FoodDetailController();
//        ArrayList<ArrayList<ArrayList<FoodDetail>>> foodDetails = fdc.generateFoodDetail(foodDataset, meals, days);
//        
//        //Generating Images
//        ImageController ic = new ImageController();
//        ArrayList<ArrayList<ArrayList<Image>>> images = ic.generateImage(foodDetails, meals);
//        
//        //Tetsing
//        for(int j = 0; j < mealProportion.size(); j++){
//            System.out.println("\tMEAL: " + Constants.MEAL.get(meals.get(j).get(0).getMealindex()));
//            for(int i = 0; i < days.size(); i++){
//                System.out.println("DAY: " + (i+1));
//                for(int k = 0; k < Constants.FOOD_DETAIL_BY_MEAL.get(meals.get(j).get(0).getMealindex()).length; k++){
//                    System.out.println(foodDetails.get(j).get(i).get(k));
//                    System.out.println(images.get(j).get(i).get(k));
//                }
//            }
//        }
////        //CHECK UPDATES ON MEALS AND DAYS
//        for(int i = 0; i < mainMeal + sideMeal; i++){
//            System.out.println(Constants.MEAL.get(meals.get(i).get(0).getMealindex()));
//            for(int j = 0; j < days.size(); j++)
//                System.out.println(meals.get(i).get(j));
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
