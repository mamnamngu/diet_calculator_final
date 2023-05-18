<%-- 
    Document   : Menu.jsp
    Created on : Mar 2, 2023, 6:45:19 PM
    Author     : asout
--%>
<%@page import="com.dietcalculator.dto.Food"%>
<%@page import="com.dietcalculator.dto.Image"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.dietcalculator.dto.FoodDetail"%>
<%@page import="com.dietcalculator.dto.Day"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dietcalculator.util.Constants"%>
<%@page import="com.dietcalculator.dto.Meal"%>
<%@page import="com.dietcalculator.util.Utils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8" />
   <meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <meta name="viewport" content="width=device-width, initial-scale=1.0" />
   <title>Diet Menu</title>
   <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
   <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="Menu.css" />
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/style.css">
   <style>
       body{
   margin-top:20px;
}
.bg-light-gray1 {
   background-color: #f7f7f7;
}
.table-bordered1 thead td, .table-bordered1 thead th {
   border-bottom-width: 2px;
}
.table1 thead th {
   vertical-align: bottom;
   border-bottom: 2px solid #dee2e6;
}
.table-bordered1 td, .table-bordered1 th {
   border: 1px solid #dee2e6;
}

.bg-sky.box-shadow1 {
   box-shadow: 0px 5px 0px 0px #00a2a7
}

.bg-orange.box-shadow1 {
   box-shadow: 0px 5px 0px 0px #af4305
}

.bg-green.box-shadow1 {
   box-shadow: 0px 5px 0px 0px #4ca520
}

.bg-yellow.box-shadow1 {
   box-shadow: 0px 5px 0px 0px #dcbf02
}

.bg-pink.box-shadow1 {
   box-shadow: 0px 5px 0px 0px #e82d8b
}

.bg-purple.box-shadow1 {
   box-shadow: 0px 5px 0px 0px #8343e8
}

.bg-lightred.box-shadow1 {
   box-shadow: 0px 5px 0px 0px #d84213
}


.bg-sky {
   background-color: #02c2c7
}

.bg-orange {
   background-color: #e95601
}

.bg-green {
   background-color: #5bbd2a
}

.bg-yellow {
   background-color: #f0d001
}

.bg-pink {
   background-color: #ff48a4
}

.bg-purple {
   background-color: #9d60ff
}

.bg-lightred {
   background-color: #ff5722
}

.padding-15px-lr {
   padding-left: 15px;
   padding-right: 15px;
}
.padding-5px-tb {
   padding-top: 5px;
   padding-bottom: 5px;
}
.margin-10px-bottom {
   margin-bottom: 10px;
}
.border-radius-5 {
   border-radius: 5px;
}

.margin-10px-top {
   margin-top: 10px;
}
.font-size14 {
   font-size: 14px;
}

.text-light-gray {
   color: #d6d5d5;
}
.font-size13 {
   font-size: 13px;
}

.font-size12 {
   font-size: 1px;
}

.table-bordered1 td, .table-bordered1 th {
   border: 1px solid #dee2e6;
}
.table td, .table th {
   padding: .75rem;
   vertical-align: top;
   border-top: 1px solid #dee2e6;
}
a:hover {
   text-decoration: none;
}

.round {
  text-decoration: none;
  display: inline-block;
  padding: 8px 16px;
  border-radius: 50%;
}

.round:hover{
  background-color: #ddd;
  color: black;
}

.previous {
  background-color: #f1f1f1;
  color: black;
}

.next {
  background-color: #04AA6D;
  color: white;
}

.row {
  display: flex;
}

.column {
  flex: 70%;
  font-family:Cambria;
  font-size: 14px;
  margin-top: 3px; 
  padding-left: 1.3em;
  text-align: left;
}

.column-tooltip1{
  font-family:Cambria;
  font-size: 11px;
  margin-top: 2px; 
  padding-left: 0.5em;
  text-align: left;
}

.column-50 {
  width: 50%;
  padding-left: 1.5em;
}
.column-25{
 width: 40%;
}

.tooltips1{
  position: relative;
  display: inline-block;
}

.tooltiptext1{
  visibility: hidden;
  width: 9.2em;
  height: 12em;
  background-color: white;
  color: #000;
  text-align: center;
  border-radius: 6px;
  padding: 2px 0;
  position: absolute;
  z-index: 1;
  bottom: -12%;
  left: 50%;
  margin-left: -4.7em;
  opacity: 0;
  transition: opacity 1s;
}

.tooltips1:hover .tooltiptext1 {
  visibility: visible;
  opacity: 1;
}

.blank-gray{
    width: 10.5em;
    height: 10em;
    background-color: #f7f7f7;
    background-image: url("./logo.jpg");
}

   </style>
</head>

<body>
     <!--header section start -->
        <nav class="navbar navbar-expand-lg navbar-dark main_navbar">
            <div class="logo"><a href="/diet-calculator/HomeController"><img class="logo" src="/diet-calculator/index/images/logo.jpg" alt="logo"><h1 class="title">Diet Calculator</h1></a></div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto " >
                    <li class="nav-item">
                        <a class="nav-link" href="/diet-calculator/MenuController?action=menu">Menu</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/diet-calculator/ProductListController">Shop</a>
                    </li> 
                    <li class="nav-item">
                        <a class="nav-link" href="/diet-calculator/CartController">Cart</a>
                    </li>      
                </ul>    
                </ul></div>
            <c:if test = "${sessionScope.user.getUsername()!=null}"><div style="color:white">Welcome back: ${sessionScope.user.getUsername()}</div></c:if>
            <c:if test = "${sessionScope.user.getUserID()!=null}"><a href="/diet-calculator/LoginController?action=logout"><div class="nav-link" style="color:white">Log out</div></a> </c:if>
            <c:if test = "${sessionScope.user.getUserID()==null}"> <a href="/diet-calculator/Register_Login/login.jsp"><div class="nav-link" style="color:white">Log in</div></a></c:if>
            <div class="user-logo"><a href="ProfileController"><img src="/diet-calculator/index/images/user-logo.jpg" alt="user_logo"></a>
            </div>
        </nav>
    
   <div class="container">
      <div class="timetable-img text-center">
         <img src="img/content/timetable.png" alt="" />
      </div>
       <div style="margin-left: 880px;margin-bottom:20px;font-size: 13px;">
       <a href="MenuController?page=${page}&action=buyFood" class="btn btn-info btn-lg" style="background:green">
          Food List For This Week
        </a>
        </div>
      <div class="text-center">
          <h1>Week ${page}</h1>
      </div>     
      <div class="table-responsive" style="width: 1250px;padding-right: 150px;overflow-x: hidden;">
         <table class="table table-bordered text-center">
            <thead>
               <tr class="bg-light-gray1">
                  <th class="text-uppercase">Time</th>
                  <th class="text-uppercase">Monday</th>
                  <th class="text-uppercase">Tuesday</th>
                  <th class="text-uppercase">Wednesday</th>
                  <th class="text-uppercase">Thursday</th>
                  <th class="text-uppercase">Friday</th>
                  <th class="text-uppercase">Saturday</th>
                  <th class="text-uppercase">Sunday</th>
               </tr>
            </thead>
            <tbody>
   <%!
        public final String[] MEAL_COLOR_INDEX = {"bg-sky","bg-green","bg-yellow","bg-lightred","bg-purple"};
        //FORMAT FOR PARAMETERS
            //meal = side+main; day = 7
            //ArrayList<ArrayList<ArrayList<FoodDetail>>>   MEALS-DAYS-FOODDETAILS
            //ArrayList<ArrayList<ArrayList<String>>>   MEALS-DAYS-FOODDETAILS
            //ArrayList<ArrayList<Meal>>                MEALS-DAYS
            //ArrayList<Day>

        public final String menuCode(ArrayList<List<ArrayList<FoodDetail>>> foodDetailsByWeek, ArrayList<List<ArrayList<String>>> imagesByWeek, ArrayList<List<Meal>> meals, List<Day> days, ArrayList<Food> foodDataset,int currentPage){
            String html = "";
            int numOfMeals = meals.size();  //= number of rows
            for(int index = 0; index < numOfMeals; index++){
                int mealIndex = meals.get(index).get(0).getMealindex();
                html += printMealByRow(mealIndex,meals.get(index),foodDetailsByWeek.get(index),imagesByWeek.get(index), foodDataset,currentPage);
            }
            return html;
        }

        public final String printMealByRow(int mealIndex, List<Meal> meals, List<ArrayList<FoodDetail>> foodDetailsByRow, List<ArrayList<String>> imagesByRow, ArrayList<Food> foodDataset, int currentPage){
        //GEETING GENERAL INFORMATION
            String color = MEAL_COLOR_INDEX[mealIndex - 1];
            int numOfFoodDetail = foodDetailsByRow.get(0).size();
            String mealIndexStr = Constants.MEAL.get(mealIndex);
            String time = Constants.MEAL_TIME.get(mealIndex);
        
        //HTML CODE
            String html=    "<tr>\n"
                            +"<td class=\"align-middle\">" + time + "</td>\n";
            for(int day = 0; day < 7; day++){
                    html += "<td>\n"
                            +"<div class=\"tooltips1\" style=\"border: none;width: 8em;height: 10em;padding-left: 0px\">"
                            +" <span "
                            +"   class=\"" + color + " padding-5px-tb padding-15px-lr border-radius-5 margin-10px-bottom text-white font-size16 xs-font-size13\">" + mealIndexStr + "</span>\n"
                            +"<div class=\"font-size13 text-light-gray\" style = \"margin-top: 5px\">" + meals.get(day).getTotalCal() + " KCal</div>";
                    //IMPORT IMAGES INTO TOOLTIP
                    html +=  displayImage(mealIndex, imagesByRow.get(day));

                    //IMPORT DETAILS OF FOODDETAIL INTO TOOLTIPTEXT
                    html +=  displayDetailsFoodDetail(foodDetailsByRow.get(day), foodDataset, currentPage);
                    html += "</div>";
                    html += "</td>\n";
            }
            //END THE ROW
            html += "</tr>";

            return html;
        }

        public final String displayImage(int mealIndex, ArrayList<String> imagesByWeek){
            //GETTING BASIC INFORMATION
            final int size = 25;
            int numOfFoodDetail = 0;
            String html = "";  //INITIALIZING FIRST ROW
            if(mealIndex <= 1){
                numOfFoodDetail = Constants.BREAKFAST_CATEGORIES.length;
                for(int i = 1; i <= numOfFoodDetail; i++){
                    if(i%2 == 1)
                        html += "<div class = \"row\">";
                    
                    html += "<div class=\"col-md-6 col-sm-6\" style='padding-bottom:20px;'><img src=\"" + imagesByWeek.get(i-1) + "\" width=" + size + " height=" + size + " ></div>\n";
                    
                    if(i%2 == 0)
                        html += "</div>\n";
                }
            }else if(mealIndex <= 3){
                numOfFoodDetail = Constants.LUNCH_DINNER_CATEGORIES.length;
                for(int i = 1; i <= numOfFoodDetail; i++){
                    if(i%2 == 1)
                        html += "<div class = \"row\">";
                    
                    html += "<div class=\"col-md-6 col-sm-6\"><img src=\"" + imagesByWeek.get(i-1) + "\" width=" + size + " height=" + size + " ></div>\n";
                    
                    if(i%2 == 0)
                        html += "</div>\n";
                }
                html += "</div>\n";
            }else{
                numOfFoodDetail = Constants.SIDE_MEAL_CATEGORIES.length;
                html += "<div class = \"row\">";
                    html += "<div class=\"col-md-12 col-sm-12\" style='padding: 30px'><img src=\"" + imagesByWeek.get(0) + "\" width=" + size + " height=" + size + " ></div>\n";
                html += "</div>\n";
            }
            return html;
        }

        public String displayDetailsFoodDetail(ArrayList<FoodDetail> fd, ArrayList<Food> foodDataset, int currentPage){
            String html = "<span class = \"tooltiptext1\" style = \"\">";
            for(FoodDetail x: fd){
                html += "<div class = \"row\">"
                       +"<div class=\"column-tooltip1 column-50\">" + searchFoodNameByFoodID(x.getFoodID(),foodDataset) + "</div>"
                       +"<div class=\"column-tooltip1 column-25\">"+ x.getAmount() +" g</div>"
                       +"</div>";
            }
                html += "<form action=\"MenuController\" method=\"get\">\n"
                       + "<input type=text name=action value=details hidden/>"
                       + "<input type=text name=mealID value=" + fd.get(0).getMealID() +  " hidden/>"
                       + "<input type=text name=page value=" + currentPage + " hidden/>"
                       + "<input type=submit value=Details>"
                       + "</form>";
                html += "</span>";
            return html;
        }

        public String searchFoodNameByFoodID(String foodID, ArrayList<Food> foodDataset){
            for(Food x: foodDataset)
                if(x.getFoodID().equals(foodID))
                    return x.getFoodname();
            return "Unknown";
        }
    %>
    
    <%
        ArrayList<List<ArrayList<FoodDetail>>> foodDetailsByWeek = (ArrayList<List<ArrayList<FoodDetail>>>) request.getAttribute("foodDetails");
        ArrayList<List<ArrayList<String>>> imagesByWeek = (ArrayList<List<ArrayList<String>>>) request.getAttribute("imageUrls");
        ArrayList<List<Meal>>  meals = (ArrayList<List<Meal>> ) request.getAttribute("meals");
        List<Day>  days = (List<Day>) request.getAttribute("days");
        ArrayList<Food> foodDataset = (ArrayList<Food>) request.getAttribute("foodDataset");
        int currentPage = (int)request.getAttribute("page");
        out.print(menuCode(foodDetailsByWeek,imagesByWeek,meals,days,foodDataset,currentPage));
    %>
            </tbody>
         </table>
      </div>
   </div>
   <div class="text-center" style="margin-left:670px;">
       <ul class="pagination pagination-sm pro-page-list">
            <li class="page-item ${page == 1 ? 'disabled' : ''}">
                <a class="page-link" href="MenuController?page=${page>1?page - 1:1}&action=show" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                </a>
            </li>

            <c:forEach var="i" begin="1" end="${totalPages}">


                <li class="page-item ${i == page ? 'active' : ''}">
                    <a class="page-link" href="MenuController?page=${i}&action=show">${i}</a>
                </li>
            </c:forEach>
            <li class="page-item ${page == totalPages ? 'disabled' : ''}">
                <a class="page-link" href="MenuController?page=${page<totalPages?page + 1:totalPages}&action=show" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                </a>
            </li>
        </ul>
   </div>  
    <div style="width:60%;margin-left:auto;margin-right:auto;margin-top:10px;margin-bottom:20px;background: green;border-radius: 20px">
        <button class="btn btn-primary btn-block text-uppercase bg-success"><a href="MenuController?action=save">Save Your Diet</a></button>
    </div>
</body>


</html>

