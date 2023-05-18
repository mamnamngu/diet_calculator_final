<%-- 
    Document   : Meal
    Created on : Mar 4, 2023, 11:34:40 AM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Meal Detail</title>
   <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
   <!-- Latest compiled and minified JavaScript -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
      integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
      crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/js/standalone/selectize.min.js" integrity="sha256-+C0A5Ilqmu4QcSPxrlGpaZxJ04VjsRjKu+G82kl5UJk=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/css/selectize.bootstrap3.min.css" integrity="sha256-ze/OEYGcFbPRmvCnrSeKbRTtjG4vGLHXgOqsyLFTRjg=" crossorigin="anonymous" />
   <style>
        body {
          margin-top: 20px;
       }
      
    </style>
</head>

<body>
  <%@ include file = "/index/UserHeader.jsp" %>
   <div class="container">
      <div class="row">
         <div class="col-md-12">
             <form action="MenuController" method="post">
                 <input type="text" name="page" value="${page}" hidden>
                 <input type="text" name="action" value="show" hidden>
                 <button type="submit" style="height:40px;margin-bottom: 10px;background:green;border-radius:10px;color:white">Back to Menu</button>
             </form>
             <h1>Meal Details</h1>
            <div class="table-responsive">
                <form action="MenuController" method="get">
               <table class="table table-bordered">
                  <thead>
                     <tr>
                        <th>Index</th>
                        <th>Name</th>
                        <th>Amount (g)</th>
                        <th>Calories (KCal)</th>
                        <th>Carbohydrate (g)</th>
                        <th>Fiber (g)</th>
                        <th>Protein (g)</th>
                        <th>Fat (g)</th>
                        <th>Water (g)</th>
                        <th>Substitute</th>
                     </tr>
                  </thead>
                  <tbody>
                      <c:forEach begin="0" end="${foodDetail.size()-1}" step="1" var="i">
                        <tr>
                            <th scope="row">${i + 1}</th>
                            <td>${foodInMeal.get(i).getFoodname()}</td>
                            <td>${foodDetail.get(i).getAmount()}</td>
                            <td>${foodDetail.get(i).getTotalCal()}</td>
                            <td>${foodDetail.get(i).getCarbohydrate()}</td>
                            <td>${foodDetail.get(i).getFiber()}</td>
                            <td>${foodDetail.get(i).getProtein()}</td>
                            <td>${foodDetail.get(i).getFat()}</td>
                            <td>${foodDetail.get(i).getWater()}</td>
                            <td style="width:300px;height:50px">
                                <div style="width: 100%;">
                                    <select id="substitute${i}" name="${foodInMeal.get(i).getFoodID()}" placeholder="Pick one...">
                                        <option value="0" selected>Select a Substitute</option>
                                        <c:forEach begin="0" end="${substitutes.get(i).size()-1}" step="1" var="j">
                                            <option value="${substitutes.get(i).get(j).getFoodID()}"> ${foodSubstitute.get(i).get(j).getFoodname()} &emsp;${substitutes.get(i).get(j).getAmount()}g</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </td>
                        </tr>
                      </c:forEach>
                  </tbody>
               </table>
                    <input type="text" name="mealID" value="${meal.getMealID()}" hidden>
                    <input type="text" name="action" value="update" hidden>
                <div style="width:60%;margin-left:auto;margin-right:auto;margin-top:10px;margin-bottom:20px;background: green;border-radius: 20px">
                    <input type="submit" value="Save" class="btn btn-primary btn-block text-uppercase bg-success">
                </div>
                </form>
                
                <div class="col-md-12">
                    <h1>Nutrition Details</h1>
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                   <tr>
                                      <th>Parameter</th>
                                      <th>Total Calories (KCal)</th>
                                      <th>Carbohydrate (g)</th>
                                      <th>Fiber (g)</th>
                                      <th>Protein (g)</th>
                                      <th>Fat (g)</th>
                                      <th>Water (g)</th>
                                   </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Your Meal</td>
                                        <td>${meal.getTotalCal()}</td>
                                        <td>${meal.getCarbohydrate()}</td>
                                        <td>${meal.getFiber()}</td>
                                        <td>${meal.getProtein()}</td>
                                        <td>${meal.getFat()}</td>
                                        <td>${meal.getWater()}</td>
                                    </tr>
                                    <tr>
                                        <td>Standard</td>
                                        <td>${Math.round(meal.getTotalCalstd())}</td>
                                        <td>${Math.round(meal.getCarbohydratestd())}</td>
                                        <td>${Math.round(meal.getFiberstd())}</td>
                                        <td>${Math.round(meal.getProteinstd())}</td>
                                        <td>${Math.round(meal.getFatstd())}</td>
                                        <td>${Math.round(meal.getWaterstd())}</td>
                                    </tr>
                                    <tr>
                                        <td>Coverage</td>
                                        <td>${Math.round(1000*meal.getTotalCal()/meal.getTotalCalstd())/10}%</td>
                                        <td>${Math.round(1000*meal.getCarbohydrate()/meal.getCarbohydratestd())/10}%</td>
                                        <td>${Math.round(1000*meal.getFiber()/meal.getFiberstd())/10}%</td>
                                        <td>${Math.round(1000*meal.getProtein()/meal.getProteinstd())/10}%</td>
                                        <td>${Math.round(1000*meal.getFat()/meal.getFatstd())/10}%</td>
                                        <td>${Math.round(1000*meal.getWater()/meal.getWaterstd())/10}%</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                </div>
            </div>
            <c:set var="style" value="" scope="page"></c:set>
            <c:choose>
                <c:when test="${foodInMeal.size()==7}"><c:set var="style" value="display: grid;grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr;grid-gap: 3px"></c:set></c:when>
                <c:when test="${foodInMeal.size()==4}"><c:set var="style" value="display: grid;grid-template-columns: 1fr 1fr 1fr 1fr;grid-gap: 160px"></c:set></c:when>
                <c:when test="${foodInMeal.size()==1}"><c:set var="style" value="display: grid;grid-template-columns: 1fr;grid-gap: 150px;padding-left:550px"></c:set></c:when>
                <c:otherwise></c:otherwise>
            </c:choose>
            <h1 style="margin-left: 5px;margin-bottom: 20px">Facts About Your Meal</h1>
            <div style="${style}; margin-bottom:60px">
                <c:forEach items="${foodInMeal}" var="x">
                    <div class=''>
                        <div style="width:195px;height:420px;background: green;border-radius: 15px">
                            <div style='width:100%;height:22%;padding-top:6px'>
                                <img src='${x.getIcon()}' style='display: block;margin-left: auto;margin-right: auto;width: 80px;height: 80px;border-radius: 50%;border:3px #004d00 solid;'>
                            </div>
                            <div style='width:60%;height:8%;background:#003300;margin-left: auto;margin-right:auto;border: 3px #008000 solid;border-radius:5px;text-align: center'>
                                <p5 style='color:yellow;'>${x.getFoodname()}</p5>
                            </div>
                            <div style='width:95%;height:66%;background: #bbff99;margin-left: auto;margin-right:auto;margin-top:8px;border: 3px #008000 solid;border-radius:10px;text-align: center;padding:8px'>
                                <strong style='font-size: 10px;font-style: italic;font-family: IBM Plex Serif,sans-serif;'>${x.getDescription()}</strong>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
         </div>
      </div>
   </div>
</body>
<script>
    <c:set var="i" value="0"></c:set>
    <c:forEach items="${foodDetail}" var="y">
        $(document).ready(function () {
            $('#substitute${i}').selectize({
                sortField: 'text'
            });
          });
        <c:set var="i" value="${i+1}"></c:set>
    </c:forEach>
</script>

</html>
