<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.dietcalculator.dto.Food"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product List</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>

    </head>

    <body >

        <jsp:include page="../index/AdminHeader.jsp" />
        <div class="container mt-5">
            <div class="row tm-content-row">
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-products">
                        <div class="row">
                            <div class="col-10">
                                <h2 class="tm-block-title d-inline-block">Product Admin</h2>
                            </div>
                            <div class="col-2">
                                <form action="/diet-calculator/ProductController">
                                    <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success mb-2"> << Return</button>                            
                                </form>
                            </div>
                        </div>
                        <a href="Administrator/AddProduct.jsp" class="btn btn-primary btn-block text-uppercase mb-3 bg-success">Add new Product</a>
                        <p>${test}</p>
                        <form action="/diet-calculator/ProductController" method="get" class="tm-edit-product-form">
                            <div class="tm-product-table-container">

                                <table class="table table-hover tm-table-small tm-product-table">
                                    <input type="hidden" name="action" value="delete"/>
                                    <thead>
                                        <tr>
                                            <th scope="col">&nbsp;</th>
                                            <th scope="col">Product ID</th>
                                            <th scope="col">Product name</th>
                                            <th scope="col">Type</th>
                                            <th scope="col">Price</th>
                                            <th scope="col">Quantity</th>
                                            <th scope="col">Brand</th>
                                            <th scope="col">Origin</th>
                                            <th scope="col">Volume</th>
                                            <th scope="col">Effect</th>
                                            <th scope="col">Rate</th>
                                            <th scope="col">Purchase</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${productList}" var="x">
                                            <tr>
                                                <th scope="row"><input type="checkbox" name="productID" value="${x.getProductID()}"/></th>
                                                <td>${x.getProductID()}</td>
                                                <td>${x.getProductname()}</td>
                                                <td>${x.getType()}</td>
                                                <td>${x.getPrice()}</td>
                                                <td>${x.getQuantity()}</td>
                                                <td>${x.getBrand()}</td>
                                                <td>${x.getOrigin()}</td>
                                                <td>${x.getVolume()}</td>
                                                <td>${x.getEffect()}</td>
                                                <td>${x.getRate()}</td>
                                                <td>${x.getPurchase()}</td>
                                                <td><a href="ProductController?action=update&productID=${x.getProductID()}" class="btn btn-primary btn-block bg-success">Update</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <section class="panel mt-3 mb-4">
                                    <div class="panel-body">
                                        <div class="pull-right">
                                            <ul class="pagination pagination-sm pro-page-list text-light">
                                                <li class="page-item ${page == 1 ? 'disabled' : ''}">
                                                    <a class="page-link" href="ProductController?page=${page>1?page - 1:1}" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                        <span class="sr-only">Previous</span>
                                                    </a>
                                                </li>

                                                <c:forEach var="i" begin="1" end="${totalPages}">
                                                    <li class="page-item ${i == page ? 'active' : ''}">
                                                        <a class="page-link" href="ProductController?page=${i}">${i}</a>
                                                    </li>
                                                </c:forEach>
                                                <li class="page-item ${page == totalPages ? 'disabled' : ''}">
                                                    <a class="page-link" href="ProductController?page=${page<totalPages?page + 1:totalPages}" aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                        <span class="sr-only">Next</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </section>

                            </div>
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
    </body>

</html>