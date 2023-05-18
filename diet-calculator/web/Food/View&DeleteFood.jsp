<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.dietcalculator.dto.Food"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Food List</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>
    </head>
    <style>
        .break {
            word-break: break-all;
        }
    </style>
    <body>
        <jsp:include page="../index/AdminHeader.jsp" />
        <div class="container mt-5 mb-5">
            <div class="row tm-content-row">
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-products">
                        <div class="row">
                            <div class="col-10">
                                <h2 class="tm-block-title d-inline-block">View & Delete Food</h2>
                            </div>
                            <div class="col-2">
                                <form action="/diet-calculator/FoodController">
                                    <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success mb-2"> << Return</button>                            
                                </form>
                            </div>
                        </div>
                        <a href="Food/AddFood.jsp" class="btn btn-primary btn-block text-uppercase mb-3 bg-success">Add new Food</a>
                        <form action="/diet-calculator/FoodController" method="get" class="tm-edit-product-form">
                            <div class="tm-product-table-container">

                                <input type="hidden" name="action" value="delete"/>
                                <table class="table table-hover table-sm">
                                    <thead>
                                        <tr>
                                            <th scope="col">&nbsp;</th>
                                            <th scope="col">Food ID</th>
                                            <th scope="col">Food name</th>
                                            <th scope="col">category</th>
                                            <th scope="col">size</th>
                                            <th scope="col">caloricintake</th>
                                            <th scope="col">carbohydrate</th>
                                            <th scope="col">fiber</th>
                                            <th scope="col">protein</th>
                                            <th scope="col">fat</th>
                                            <th scope="col">water</th>
                                            <th scope="col">icon</th>
                                            <th scope="col">description</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${foodList}" var="x">
                                            <tr>
                                                <th scope="row">&nbsp;<input type="checkbox" name="foodID" value="${x.getFoodID()}"/></th>
                                                <td>${x.getFoodID()}</td>
                                                <td>${x.getFoodname()}</td>
                                                <td>${x.getCategory()}</td>
                                                <td>${x.getSize()}</td>
                                                <td>${x.getCaloricintake()}</td>
                                                <td>${x.getCarbohydrate()}</td>
                                                <td>${x.getFiber()}</td>
                                                <td>${x.getProtein()}</td>
                                                <td>${x.getFat()}</td>
                                                <td>${x.getWater()}</td>
                                                <td class="break">${x.getIcon()}</td>
                                                <td>${x.getDescription()}</td>
                                                <td><a href="FoodController?action=update&foodID=${x.getFoodID()}" class="btn btn-primary btn-block bg-success">Update</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <section class="panel">
                                <div class="panel-body">
                                    <div class="pull-right">
                                        <ul class="pagination pagination-sm pro-page-list text-light">
                                            <li class="page-item ${page == 1 ? 'disabled' : ''}">
                                                <a class="page-link" href="FoodController?page=${page>1?page - 1:1}" aria-label="Previous">
                                                    <span aria-hidden="true">&laquo;</span>
                                                    <span class="sr-only">Previous</span>
                                                </a>
                                            </li>

                                            <c:forEach var="i" begin="1" end="${totalPages}">
                                                <li class="page-item ${i == page ? 'active' : ''}">
                                                    <a class="page-link" href="FoodController?page=${i}">${i}</a>
                                                </li>
                                            </c:forEach>
                                            <li class="page-item ${page == totalPages ? 'disabled' : ''}">
                                                <a class="page-link" href="FoodController?page=${page<totalPages?page + 1:totalPages}" aria-label="Next">
                                                    <span aria-hidden="true">&raquo;</span>
                                                    <span class="sr-only">Next</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </section>
                            <!-- table container -->
                            <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success">
                                Delete selected products
                            </button>
                        </form>

                    </div>
                </div>
            </div>
        </div>
        <br>
        <jsp:include page="../index/UserFooter.jsp" />
        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script>
            $(function () {
                $(".tm-product-name").on("click", function () {
                    window.location.href = "EditProduct.html";
                });
            });
        </script>
    </body>

</html>