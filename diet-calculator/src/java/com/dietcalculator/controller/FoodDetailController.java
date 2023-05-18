/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dietcalculator.controller;

import com.dietcalculator.dto.Day;
import com.dietcalculator.dto.Food;
import com.dietcalculator.dto.FoodDetail;
import com.dietcalculator.dto.Meal;
import com.dietcalculator.util.Constants;
import static com.dietcalculator.util.Constants.CARBOHYDRATE_TO_KCAL;
import static com.dietcalculator.util.Constants.FAT_FROM_DAIRIES_AND_DESSERT;
import static com.dietcalculator.util.Constants.FAT_TO_KCAL;
import static com.dietcalculator.util.Constants.FIRST_PROTEIN_SOURCE;
import static com.dietcalculator.util.Constants.FOOD_DETAIL_BY_MEAL;
import static com.dietcalculator.util.Constants.FRUIT_FIBER_SOURCE;
import static com.dietcalculator.util.Constants.PROTEIN_TO_KCAL;
import static com.dietcalculator.util.Constants.RELATIVE_ESTIMATE;
import static com.dietcalculator.util.Constants.SECOND_PROTEIN_SOURCE;
import static com.dietcalculator.util.Constants.VEGETABLES_FIBER_SOURCE;
import com.dietcalculator.util.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asout
 */
public class FoodDetailController extends HttpServlet {
 
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FoodDetailController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FoodDetailController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public final ArrayList<FoodDetail> generateFoodDetailSubstituteByCategory(Meal meal, ArrayList<Food> allApplicableFood, String category){
        ArrayList<FoodDetail> fdByCategory = new ArrayList();
        FoodController fc = new FoodController();
        ArrayList<Food> foodOfCategory = fc.listFoodByCategory(allApplicableFood, category);
        double ratio = 0;
        double calories = 0;
   
        
        for(int idx = 0; idx < foodOfCategory.size(); idx++){
            FoodDetail detail = new FoodDetail();
            Food currentFood = foodOfCategory.get(idx);
            
            if(category.equalsIgnoreCase("fruit/nuts/legumes/dairies&dessert")){
                //the amount of break fast is based on Calories 
                calories = Utils.roundDouble(meal.getCarbohydratestd());   //NO NEED FOR RELATIVE_ESTIMATE
                ratio = Utils.roundDouble(calories/currentFood.getCaloricintake());
            }else if(category.equalsIgnoreCase("vegetables")){
                //the amount of vegetables is based on Fiber 
                calories = Utils.roundDouble(RELATIVE_ESTIMATE*meal.getFiberstd()*VEGETABLES_FIBER_SOURCE);
                ratio = Utils.roundDouble(calories/(currentFood.getFiber()*CARBOHYDRATE_TO_KCAL));
            }else if(category.equalsIgnoreCase("fruit")){
                //the amount of fruit is based on Fiber 
                calories = Utils.roundDouble(RELATIVE_ESTIMATE*meal.getFiberstd()*FRUIT_FIBER_SOURCE);
                ratio = Utils.roundDouble(calories/(currentFood.getFiber()*CARBOHYDRATE_TO_KCAL));
            }else if(category.equalsIgnoreCase("meat/poultry")){
                //the amount of meat is based on Protein 
                calories =Utils.roundDouble(RELATIVE_ESTIMATE*meal.getProteinstd()*FIRST_PROTEIN_SOURCE);
                ratio = Utils.roundDouble(calories/(currentFood.getProtein()*PROTEIN_TO_KCAL));
            }else if(category.equalsIgnoreCase("fish/seafood/egg")){
                //the amount of fish/seafood/egg is based on Protein 
                calories = Utils.roundDouble(RELATIVE_ESTIMATE*meal.getProteinstd()*SECOND_PROTEIN_SOURCE);
                ratio = Utils.roundDouble(calories/(currentFood.getProtein()*PROTEIN_TO_KCAL));
            }else if(category.equalsIgnoreCase("starch")){
                //the amount of starch is based on Carbohydrate 
                calories = Utils.roundDouble(RELATIVE_ESTIMATE*meal.getCarbohydratestd());
                ratio = Utils.roundDouble(calories/(currentFood.getCarbohydrate()*CARBOHYDRATE_TO_KCAL));}
            else if(category.equalsIgnoreCase("dairies&dessert")){
                //the amount of dairies and dessert is based on Fat 
                calories = Utils.roundDouble(FAT_FROM_DAIRIES_AND_DESSERT*meal.getFatstd());   //FAT ALSO COMES FROM MEAT AND OTHER FOOD
                ratio = Utils.roundDouble(calories/(currentFood.getCarbohydrate()*FAT_TO_KCAL));}
            else if(category.equalsIgnoreCase("drinks")){
                //the amount of drink is based on Water 
                calories = Utils.roundDouble(meal.getWaterstd());  //NO NEED FOR RELATIVE_ESTIMATE
                ratio = Utils.roundDouble(calories/(currentFood.getWater()));
            }
            
                //Setting parameters
            detail.setFoodID(foodOfCategory.get(idx).getFoodID());
            detail.setMealID("");
            detail.setAmount(Utils.roundDouble(ratio*currentFood.getSize()));
            detail.setTotalCal(Utils.roundDouble(ratio*currentFood.getCaloricintake()));
            detail.setCarbohydrate(Utils.roundDouble(ratio*currentFood.getCarbohydrate()));
            detail.setFiber(Utils.roundDouble(ratio*currentFood.getFiber()));
            detail.setProtein(Utils.roundDouble(ratio*currentFood.getProtein()));
            detail.setFat(Utils.roundDouble(ratio*currentFood.getFat()));
            detail.setWater(Utils.roundDouble(ratio*currentFood.getWater()));
            detail.setIcon(currentFood.getIcon());
            detail.setCategory(category.toLowerCase());
            
            //Add to the list
            fdByCategory.add(detail);
        }
        
        return fdByCategory;
    }
    
    public final FoodDetail generateFoodDetail(Meal meal, ArrayList<Food> foodDataset, String category){
        FoodDetail detail = new FoodDetail();
        int idx = Utils.randomInt(0, foodDataset.size() - 1);
        //Calculating ratio based category
        double ratio = 0;
        double calories = 0;
        String icon = foodDataset.get(idx).getIcon();
        if(category.equalsIgnoreCase("fruit/nuts/legumes/dairies&dessert")){
            //the amount of break fast is based on Calories 
            calories = Utils.roundDouble(meal.getCarbohydratestd());   //NO NEED FOR RELATIVE_ESTIMATE
            ratio = Utils.roundDouble(calories/foodDataset.get(idx).getCaloricintake());
        }else if(category.equalsIgnoreCase("vegetables")){
            //the amount of vegetables is based on Fiber 
            calories = Utils.roundDouble(RELATIVE_ESTIMATE*meal.getFiberstd()*VEGETABLES_FIBER_SOURCE);
            ratio = Utils.roundDouble(calories/(foodDataset.get(idx).getFiber()*CARBOHYDRATE_TO_KCAL));
        }else if(category.equalsIgnoreCase("fruit")){
            //the amount of fruit is based on Fiber 
            calories = Utils.roundDouble(RELATIVE_ESTIMATE*meal.getFiberstd()*FRUIT_FIBER_SOURCE);
            ratio = Utils.roundDouble(calories/(foodDataset.get(idx).getFiber()*CARBOHYDRATE_TO_KCAL));
        }else if(category.equalsIgnoreCase("meat/poultry")){
            //the amount of meat is based on Protein 
            calories =Utils.roundDouble(RELATIVE_ESTIMATE*meal.getProteinstd()*FIRST_PROTEIN_SOURCE);
            ratio = Utils.roundDouble(calories/(foodDataset.get(idx).getProtein()*PROTEIN_TO_KCAL));
        }else if(category.equalsIgnoreCase("fish/seafood/egg")){
            //the amount of fish/seafood/egg is based on Protein 
            calories = Utils.roundDouble(RELATIVE_ESTIMATE*meal.getProteinstd()*SECOND_PROTEIN_SOURCE);
            ratio = Utils.roundDouble(calories/(foodDataset.get(idx).getProtein()*PROTEIN_TO_KCAL));
        }else if(category.equalsIgnoreCase("starch")){
            //the amount of starch is based on Carbohydrate 
            calories = Utils.roundDouble(RELATIVE_ESTIMATE*meal.getCarbohydratestd());
            ratio = Utils.roundDouble(calories/(foodDataset.get(idx).getCarbohydrate()*CARBOHYDRATE_TO_KCAL));}
        else if(category.equalsIgnoreCase("dairies&dessert")){
            //the amount of dairies and dessert is based on Fat 
            calories = Utils.roundDouble(FAT_FROM_DAIRIES_AND_DESSERT*meal.getFatstd());   //FAT ALSO COMES FROM MEAT AND OTHER FOOD
            ratio = Utils.roundDouble(calories/(foodDataset.get(idx).getCarbohydrate()*FAT_TO_KCAL));}
        else if(category.equalsIgnoreCase("drinks")){
            //the amount of drink is based on Water 
            calories = Utils.roundDouble(meal.getWaterstd());  //NO NEED FOR RELATIVE_ESTIMATE
            ratio = Utils.roundDouble(calories/(foodDataset.get(idx).getWater()));
        }
        
        //Setting parameters
        detail.setFoodID(foodDataset.get(idx).getFoodID());
        detail.setMealID("");
        detail.setAmount(Utils.roundDouble(ratio*foodDataset.get(idx).getSize()));
        detail.setTotalCal(Utils.roundDouble(ratio*foodDataset.get(idx).getCaloricintake()));
        detail.setCarbohydrate(Utils.roundDouble(ratio*foodDataset.get(idx).getCarbohydrate()));
        detail.setFiber(Utils.roundDouble(ratio*foodDataset.get(idx).getFiber()));
        detail.setProtein(Utils.roundDouble(ratio*foodDataset.get(idx).getProtein()));
        detail.setFat(Utils.roundDouble(ratio*foodDataset.get(idx).getFat()));
        detail.setWater(Utils.roundDouble(ratio*foodDataset.get(idx).getWater()));
        detail.setIcon(icon);
        detail.setCategory(category.toLowerCase());
        
        return detail;
    }
    
    public final ArrayList<ArrayList<FoodDetail>> generateLoadsOfFoodDetail(ArrayList<Food> allApplicableFood, Meal meal, int numDay){
        String[] listOfFoodDetail = Constants.FOOD_DETAIL_BY_MEAL.get(meal.getMealindex());
        ArrayList<ArrayList<FoodDetail>> details = new ArrayList(); //MEALS-DAYS-DETAILS
        
        FoodController fc = new FoodController();
        ArrayList<Food> foodOfCategory;
        ArrayList<FoodDetail> foodDetailByDay = new ArrayList();
            for(int j = 0; j < numDay; j++){            //DAYS
                for(int i = 0; i < listOfFoodDetail.length; i++){       //DETAILS
                    foodOfCategory = fc.listFoodByCategory(allApplicableFood, listOfFoodDetail[i]);
                    foodDetailByDay.add(generateFoodDetail(meal,foodOfCategory,listOfFoodDetail[i]));
                }
                details.add(foodDetailByDay);
                
                //RESET foodDetailByMeal
                foodDetailByDay = new ArrayList();
            }
        return details;
    }
    
    public final ArrayList<ArrayList<ArrayList<FoodDetail>>> generateFoodDetail(ArrayList<Food> allApplicableFood, ArrayList<ArrayList<Meal>> meals, ArrayList<Day> days){
        //Calculate the number of days
        int numOfDay = days.size();
        int numOfMeal = meals.size();
        //Creating loads of food details for each kind of meals
        ArrayList<ArrayList<ArrayList<FoodDetail>>> foodDetails = new ArrayList();
                //[meals.length][Constants.MAX_FOODDETAIL];
        //meals.length = number of meals per day
        //MAX_FOODDETAIL = max number of FoodDetail per meal
        //Looping through each of the type of meals
        for(int i = 0; i < numOfMeal; i++)
                foodDetails.add(generateLoadsOfFoodDetail(allApplicableFood,meals.get(i).get(0),numOfDay));//Meals = a load of breakfasts, a load of lunches, ....
        //Getting the first meal of each type of meal = get(0);
        
        //Mapping meals with their corresponding food details
        for(int j = 0; j < numOfMeal; j++){
            for(int i = 0; i < numOfDay; i++){
                for(int k = 0; k < Constants.FOOD_DETAIL_BY_MEAL.get(meals.get(j).get(0).getMealindex()).length; k++){
                    //Getting the mealID
                    String mealID = meals.get(j).get(i).getMealID();
                    //Update the mealID for food details
                    foodDetails.get(j).get(i).get(k).setMealID(mealID);
                }
            }
        }
        //Updating the parameter for the meals and days
        double totalCaloriesMeal = 0;
        double totalCarbohydrateMeal = 0;
        double totalFiberMeal = 0;
        double totalProteinMeal = 0;
        double totalFatMeal = 0;
        double totalWaterMeal = 0;
        
        //UPDATING INATKES FOR MEALS
        for(int j = 0; j < numOfMeal; j++){
            for(int i = 0; i < numOfDay; i++){
                for(int k = 0; k < Constants.FOOD_DETAIL_BY_MEAL.get(meals.get(j).get(0).getMealindex()).length; k++){                 
                    totalCaloriesMeal += foodDetails.get(j).get(i).get(k).getTotalCal();
                    totalCarbohydrateMeal += foodDetails.get(j).get(i).get(k).getCarbohydrate()*CARBOHYDRATE_TO_KCAL;
                    totalFiberMeal += foodDetails.get(j).get(i).get(k).getFiber()*CARBOHYDRATE_TO_KCAL; 
                    totalProteinMeal += foodDetails.get(j).get(i).get(k).getProtein()*PROTEIN_TO_KCAL;
                    totalFatMeal += foodDetails.get(j).get(i).get(k).getFat()*FAT_TO_KCAL;
                    totalWaterMeal += foodDetails.get(j).get(i).get(k).getWater();
                }
                //Updating meals
                meals.get(j).get(i).setTotalCal(totalCaloriesMeal);
                meals.get(j).get(i).setCarbohydrate(totalCarbohydrateMeal);
                meals.get(j).get(i).setFiber(totalFiberMeal);
                meals.get(j).get(i).setProtein(totalProteinMeal);
                meals.get(j).get(i).setFat(totalFatMeal);
                meals.get(j).get(i).setWater(totalWaterMeal);
                
                //Reset meal accumulatives
                totalCaloriesMeal = 0;
                totalCarbohydrateMeal = 0;
                totalFiberMeal = 0;
                totalProteinMeal = 0;
                totalFatMeal = 0;
                totalWaterMeal = 0;
            }
        }
        
        double totalCaloriesDay = 0;
        double totalCarbohydrateDay = 0;
        double totalFiberDay = 0;
        double totalProteinDay = 0;
        double totalFatDay = 0;
        double totalWaterDay = 0;
        
        
        //UPDATING INTAKES FOR DAYS
        for(int i = 0; i < numOfDay; i++){
            for(int j = 0; j < numOfMeal; j++){
                //Update day accumulatives
                totalCaloriesDay += meals.get(j).get(i).getTotalCal();
                totalCarbohydrateDay += meals.get(j).get(i).getCarbohydrate();
                totalFiberDay += meals.get(j).get(i).getFiber();
                totalProteinDay += meals.get(j).get(i).getProtein();
                totalFatDay += meals.get(j).get(i).getFat();
                totalWaterDay += meals.get(j).get(i).getWater();
            }
            days.get(i).setTotalCal(totalCaloriesDay);
            days.get(i).setCarbohydrate(totalCarbohydrateDay);
            days.get(i).setFiber(totalFiberDay);
            days.get(i).setProtein(totalProteinDay);
            days.get(i).setFat(totalFatDay);
            days.get(i).setWater(totalWaterDay);

            //Reset day accumulatives
            totalCaloriesDay = 0;
            totalCarbohydrateDay = 0;
            totalFiberDay = 0;
            totalProteinDay = 0;
            totalFatDay = 0;
            totalWaterDay = 0;
        }
        return foodDetails;
        
    }
//    
//    public static final FoodDetail sideMealCalculator(double calories, ArrayList<Food> sideMealSources){
//        FoodDetail detail = new FoodDetail();
//        int idx = Utils.randomInt(0, sideMealSources.size() - 1);
//        //Calculating ratio based on calories size
//        double ratio = calories/sideMealSources.get(idx).getCaloricintake();
//        
//        //Setting parameters
//        detail.setFoodID(sideMealSources.get(idx).getFoodID());
//        detail.setMealID("");
//        detail.setAmount(ratio*sideMealSources.get(idx).getSize());
//        detail.setTotalCal(ratio*sideMealSources.get(idx).getCaloricintake());
//        detail.setCarbohydrate(ratio*sideMealSources.get(idx).getCarbohydrate());
//        detail.setFiber(ratio*sideMealSources.get(idx).getFiber());
//        detail.setProtein(ratio*sideMealSources.get(idx).getProtein());
//        detail.setFat(ratio*sideMealSources.get(idx).getFat());
//        detail.setWater(ratio*sideMealSources.get(idx).getWater());
//        
//        return detail;
//    }
//    
//    //Carbohydrate Calculator recieving starch sources
//    public static final FoodDetail carbohydrateCalculator(double calories, ArrayList<Food> starchSources){
//        FoodDetail detail = new FoodDetail();
//        int idx = Utils.randomInt(0, starchSources.size() - 1);
//        
//        //Calculating ratio based on calories size
//        double ratio = calories/(starchSources.get(idx).getCarbohydrate()*CARBOHYDRATE_TO_KCAL);
//        
//        //Setting parameters
//        detail.setFoodID(starchSources.get(idx).getFoodID());
//        detail.setMealID("");
//        detail.setAmount(ratio*starchSources.get(idx).getSize());
//        detail.setTotalCal(ratio*starchSources.get(idx).getCaloricintake());
//        detail.setCarbohydrate(ratio*starchSources.get(idx).getCarbohydrate());
//        detail.setFiber(ratio*starchSources.get(idx).getFiber());
//        detail.setProtein(ratio*starchSources.get(idx).getProtein());
//        detail.setFat(ratio*starchSources.get(idx).getFat());
//        detail.setWater(ratio*starchSources.get(idx).getWater());
//        
//        return detail;
//    }
//    
//    //Fiber Calculator from 2 sources: fruit and vegetables
//    public static final HashMap<Food,Double> fiberCalculator(double calories, ArrayList<Food> fruitSources, ArrayList<Food> vegetablesSources){
//        HashMap<Food,Double> fiber = new HashMap();
//        int idxFruit = Utils.randomInt(0, fruitSources.size() - 1);
//        double amountFruit = FRUIT_FIBER_SOURCE*calories*fruitSources.get(idxFruit).getSize()/(fruitSources.get(idxFruit).getFiber()*CARBOHYDRATE_TO_KCAL);
//        fiber.put(fruitSources.get(idxFruit), amountFruit);
//        
//        int idxVegetables = Utils.randomInt(0, vegetablesSources.size() - 1);
//        double amountVegetables = VEGETABLES_FIBER_SOURCE*calories*vegetablesSources.get(idxVegetables).getSize()/(vegetablesSources.get(idxVegetables).getFiber()*CARBOHYDRATE_TO_KCAL);
//        fiber.put(vegetablesSources.get(idxVegetables), amountVegetables);
//        
//        return fiber;
//    }
//    
//    //Protein Calculator for breakfasts, which require 1 source of protein from meat/poultry
//    public static final HashMap<Food,Double> proteinCalculator(double calories, ArrayList<Food> proteinSources){
//        HashMap<Food,Double> protein = new HashMap();
//        int idx = Utils.randomInt(0, proteinSources.size() - 1);
//        double amount = calories*proteinSources.get(idx).getSize()/(proteinSources.get(idx).getProtein()*PROTEIN_TO_KCAL);
//        protein.put(proteinSources.get(idx), amount);   
//        return protein;
//    }
//    
//    //Protein Calculator for dinners and lunches, which require 2 sources of protein from meat/poultry and fish/seafood/egg
//    public static final HashMap<Food,Double> proteinCalculator(double calories, ArrayList<Food> mainProteinSources, ArrayList<Food> secondaryProteinSource){
//        HashMap<Food,Double> protein = new HashMap();
//        int idxMain = Utils.randomInt(0, mainProteinSources.size() - 1);
//        double amountMain = FIRST_PROTEIN_SOURCE*calories*mainProteinSources.get(idxMain).getSize()/(mainProteinSources.get(idxMain).getProtein()*PROTEIN_TO_KCAL);
//        
//        int idxSecondary = Utils.randomInt(0, secondaryProteinSource.size() - 1);
//        double amountSecondary = SECOND_PROTEIN_SOURCE*calories*secondaryProteinSource.get(idxMain).getSize()/(secondaryProteinSource.get(idxMain).getProtein()*PROTEIN_TO_KCAL);
//        
//        protein.put(mainProteinSources.get(idxMain), amountMain);
//        protein.put(secondaryProteinSource.get(idxSecondary), amountSecondary);
//        return protein;
//    }
//    
//    //Fat Calculator receiving sources from dairies&dessert
//    public static final HashMap<Food,Double> fatCalculator(double calories, ArrayList<Food> fatSources){
//        HashMap<Food,Double> fat = new HashMap();
//        int idx = Utils.randomInt(0, fatSources.size() - 1);
//        double amount = calories*fatSources.get(idx).getSize()/(fatSources.get(idx).getCarbohydrate()*FAT_TO_KCAL);
//        fat.put(fatSources.get(idx), amount);
//        return fat;
//    }
//    
//    public static final HashMap<Food,Double> waterCalculator(double demand, ArrayList<Food> waterSources){
//        HashMap<Food,Double> water = new HashMap();
//        int idx = Utils.randomInt(0, waterSources.size() - 1);
//        double amount = demand*waterSources.get(idx).getSize()/(waterSources.get(idx).getWater());
//        water.put(waterSources.get(idx), amount);
//        return water;
//    }
//    
    
    private ArrayList<Food> foodSelection(ArrayList<Food> foodDataset, String foodCategory){
        String[] subFoodCategory = foodCategory.split("/");
        ArrayList<Food> foodSelection= new ArrayList();
        
        return foodSelection;
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
