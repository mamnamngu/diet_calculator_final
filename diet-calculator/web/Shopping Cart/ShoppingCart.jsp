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
        <link rel="canonical" href="https://getbootstrap.com/docs/4.0/components/dropdowns/">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    </head>
    <body>
        <%@ include file = "/index/UserHeader.jsp" %>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">YOUR CART</h1>
            </div>
        </section>

        <div class="container mb-4">
            <div class="row">
                <div class="col-12">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col"> </th>
                                    <th scope="row">Index</th>
                                    <th scope="col">Product Name</th>
                                    <th scope="col" class="text-center">Quantity</th>

                                    <th></th>
                                    <th scope="col">Available</th>
                                    <th scope="col" class="text-right">Unit Price</th>
                                    <th scope="col" class ="text-center">Cost</th>
                                    <th> </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="i" value="0"></c:set>
                                <c:forEach items="${detailList}" var="x">
                                <form method="get" action="CartController">
                                    <tr>
                                        <td>
                                            <input type="hidden" name="productID" value="${productList.get(i).getProductID()}">
                                            <input type="hidden" name="action" value="update">
                                        </td>
                                        <th scope="row">${i+1}</th>
                                        <td>${productList.get(i).getProductname()}</td>
                                        <td>
                                            <input class="form-control" type="number" min="0" max="${productList.get(i).getQuantity()}" name="amount" value="${x.getQuantity()}">
                                            ${message}

                                            <%!boolean check;%>
                                            <%check = false;%>
                                            <c:if test="${x.getQuantity()>productList.get(i).getQuantity()}">
                                                <span onmouseover="Alert()" style="color:red">&#9888;</span>
                                                <%check = true;%>
                                            </c:if>
                                            <c:if test="${x.getQuantity()<productList.get(i).getQuantity()}">
                                                <%check = false;%>
                                            </c:if>
                                                
                                        <td>
                                            /${productList.get(i).getQuantity()}
                                        </td>
                                        <td class="text-right"> ${productList.get(i).getPrice()}</td>
                                        <td class="text-center">${x.getQuantity()*productList.get(i).getPrice()}</td>
                                        <td class="text-right">
                                            <button class="btn btn-sm btn-danger"><a href="CartController?action=delete&productID=${productList.get(i).getProductID()}">Delete</a></button>
                                        </td>
                                    </tr>
                                </form>
                                <c:set var="i" value="${i+1}"></c:set>
                            </c:forEach>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><strong>Total</strong></td>
                                <td class="text-right">${total}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col mb-2">
                    <div class="row">
                        <div class="col-sm-12  col-md-6">

                            <button class="btn btn-block btn-light"> <a class="nav-link" href="/diet-calculator/ProductListController">Continue Shopping</a></button>

                        </div>
                        <div class="col-sm-12 col-md-6 text-right">
                            <%  if (check == false) {
                                    out.print("<button class=\"btn btn-lg btn-block btn-success text-uppercase\"><a class=\"nav-link\" href=\"/diet-calculator/CartController?action=checkout\">Checkout</a></button>");
                                } else {
                                    out.print("<button onmouseover=\"Alert()\" class=\"btn btn-lg btn-block btn-success text-uppercase\"><a class=\"nav-link\">Unable to Checkout</a></button>");
                                }
                            %>






                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script>
        $('#select-all').click(function (event) {
            if (this.checked) {
                // Iterate each checkbox
                $(':checkbox').each(function () {
                    this.checked = true;
                });
            } else {
                $(':checkbox').each(function () {
                    this.checked = false;
                });
            }
        });

        function Alert() {
            alert("The quantity must be <= avaible");
        }
        ;


    </script>
</html>