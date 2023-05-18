<%-- 
    Document   : DietGrading
    Created on : Mar 20, 2023, 1:24:38 PM
    Author     : asout
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Diet Menu</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="Menu.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/style.css">
    </head>
    <body>
        
    <div class="Grading">
        <div class="col-md-12" style="margin-left:650px;margin-bottom: 50px;margin-top:50px"><h1><strong>Weekly Diet Assessment</strong></h1></div>
        <div class="table-responsive" style="width: 1150px;margin-left: 200px;overflow-x: hidden;">
            <table class="table table-bordered text-center">
               <thead>
                  <tr class="" style="color:white;background: green">
                      <th class=""><div>Day</div><div class="font-size13"></div></th>
                     <th class=""><div>Total Calories</div><div class="font-size13">${days.get(0).getTotalCalstd()} KCal</div></th>
                     <th class=""><div>Carbohydrates</div><div class="font-size13">${days.get(0).getCarbohydratestd()} KCal</div></th>
                     <th class=""><div>Fiber</div><div class="font-size13">${days.get(0).getFiberstd()} KCal</div></th>
                     <th class=""><div>Protein</div><div class="font-size13">${days.get(0).getProteinstd()} KCal</div></th>
                     <th class=""><div>Fat</div><div class="font-size13">${days.get(0).getFatstd()} KCal</div></th>
                     <th class=""><div>Water</div><div class="font-size13">${days.get(0).getWaterstd()} g</div></th>
                     <th class=""><div>Coverage</div><div class="font-size13"></div></th>
                  </tr>
               </thead>
               <tbody>
                   <c:set var="i" value="0"></c:set>
                   <c:forEach items="${days}" var="x">
                       <tr>
                           <th><strong>${dayName[i]}</strong></th>
                           <th><div style="font-size:17px;">${x.getTotalCal()} KCal</div><div style="color:${Math.abs(x.getTotalCal()/x.getTotalCalstd() - 1)<0.1?'green':'red'};font-size:15px">${Math.round(x.getTotalCal()*1000/x.getTotalCalstd())/10}%</div></th>
                           <th><div style="font-size:17px;">${x.getCarbohydrate()} KCal</div><div style="color:${Math.abs(x.getCarbohydrate()/x.getCarbohydratestd() - 1)<0.1?'green':'red'};font-size:15px">${Math.round(x.getCarbohydrate()*1000/x.getCarbohydratestd())/10}%</div></th>
                           <th><div style="font-size:17px;">${x.getFiber()} KCal</div><div style="color:${Math.abs(x.getFiber()/x.getFiberstd() - 1)<0.1?'green':'red'};font-size:15px">${Math.round(x.getFiber()*1000/x.getFiberstd())/10}%</div></th>
                           <th><div style="font-size:17px;">${x.getProtein()} KCal</div><div style="color:${Math.abs(x.getProtein()/x.getProteinstd() - 1)<0.1?'green':'red'};font-size:15px">${Math.round(x.getProtein()*1000/x.getProteinstd())/10}%</div></th>
                           <th><div style="font-size:17px;">${x.getFat()} KCal</div><div style="color:${Math.abs(x.getFat()/x.getFatstd() - 1)<0.1?'green':'red'};font-size:15px">${Math.round(x.getFat()*1000/x.getFatstd())/10}%</div></th>
                           <th><div style="font-size:17px;">${x.getWater()}</div><div style="color:${Math.abs(x.getWater()/x.getWaterstd() - 1)<0.1?'green':'red'};font-size:15px">${Math.round(x.getWater()*1000/x.getWaterstd())/10}%</div></th>
                           <th>${dailyCoverage.get(i)}%</th>
                       </tr>
                       <c:set var="i" value="${i+1}"></c:set>
                   </c:forEach>
                       
                       <!--WEEKLY COVERAGE -->
                       <tr>
                           <th></th>
                           <th>${weeklyCoverage.get(0)}%</th>
                           <th>${weeklyCoverage.get(1)}%</th>
                           <th>${weeklyCoverage.get(2)}%</th>
                           <th>${weeklyCoverage.get(3)}%</th>
                           <th>${weeklyCoverage.get(4)}%</th>
                           <th>${weeklyCoverage.get(5)}%</th>
                           <th></th>
                       </tr>
               </tbody>
            </table>
        </div>
    </div>
    </body>
</html>
