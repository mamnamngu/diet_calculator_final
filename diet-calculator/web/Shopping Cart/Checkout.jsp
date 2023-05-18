<%@page import="com.dietcalculator.dto.ProductDetail"%>
<%@page import="com.dietcalculator.dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shopping Cart</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    </head>
    <body>
        <%@ include file = "/index/UserHeader.jsp" %>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">INVOICE</h1>
            </div>
        </section>

        <div class="container mb-4">
            <div class="row">
                <div class="col-12">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">Product Name</th>
                                    <th scope="col" class="text-center">Quantity</th>
                                    <th scope="col" class="text-right">Unit Price</th>
                                    <th scope="col" class ="text-center">Cost</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="i" value="0"></c:set>
                                <c:forEach items="${detailList}" var="x">
                                <form method="get" action="CartController">
                                    <tr>
                                        <td>${productList.get(i).getProductname()}</td>
                                        <td>${x.getQuantity()}</td>
                                        <td class="text-right"> ${productList.get(i).getPrice()}</td>
                                        <td class="text-center">${x.getQuantity()*productList.get(i).getPrice()}</td>
                                    </tr>
                                </form>
                                <c:set var="i" value="${i+1}"></c:set>
                                </c:forEach>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td><strong>Total</strong></td>
                                    <td class="text-right">${total}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="info">
                <form action="/diet-calculator/CartController" method="get">
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="recipient">Recipient's Name</label>
                            <input type="text" name="recipient" id="recipient" value="${sessionScope.user.getUsername()}">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="phone">Phone Number</label>
                            <input type="text" name="phone" id="phone" value="${sessionScope.user.getPhone()}">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label for="address">Shipping Address</label>
                            <input type="text" name="address" id="address" value="${sessionScope.user.getAddress()}">
                        </div>
                        <div class="form-group col-md-6">
                            <label for='payment'>Payment</label>
                            <select id='payment' name='payment'>
                                <option id='COD'>COD</option>
                                <option id='card'>Card</option>
                            </select>
                        </div>
                    </div>
                
                <div class='row'>
                    <div class='col-md-12'>
                        <button type='submit'>Pay</button>
                    </div>
                </div>
                        <input type='hidden' name='action' value='pay'>
            </form>
        </div>
    </body>
</html>