<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
    Document   : PopUp
    Created on : Mar 6, 2023, 3:49:22 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>PopUp List</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>
    </head>

    <body>
        <jsp:include page="../index/AdminHeader.jsp" />
        <div class="container mt-5 mb-5">
            <div class="row tm-content-row">
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-products">
                        <div class="row">
                            <div class="col-10">
                                <h2 class="tm-block-title d-inline-block">PopUp Admin</h2>
                            </div>
                            <div class="col-2">
                                <form action="/diet-calculator/PopUpController">
                                    <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success mb-2"> << Return</button>                            
                                </form>
                            </div>
                        </div>
                        <a href="Administrator/AddPopUp.jsp" class="btn btn-primary btn-block text-uppercase mb-3 bg-success">Add new PopUp</a>
                        <div class="tm-product-table-container">
                            <form action="PopUpController" method="get">
                                <input type="hidden" name="action" value="delete">
                                <table class="table table-hover tm-table-small tm-product-table">
                                    <thead>
                                        <tr>
                                            <th scope="col">&nbsp;</th>
                                            <th scope="col">POPUPID</th>
                                            <th scope="col">DESCRIPTION</th>
                                            <th scope="col">STATUS</th>
                                            <th scope="col">THEME</th>
                                            <th scope="col">&nbsp;</th>
                                            <th scope="col">&nbsp;</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="p" items="${list}">
                                            <tr>
                                                <th scope=row><input type="checkbox" name="checkId" value=${p.popupID}></th>
                                                <td> ${p.popupID} </td>
                                                <td> ${p.description} </td>
                                                <td> ${p.status} </td>
                                                <td> ${p.theme} </td>
                                                <td><a href="./PopUpController?action=edit&popupID=${p.popupID}" 
                                                       class="btn btn-primary btn-block bg-success">Edit</a></td>
                                                <td><a href="./PopUpDetailController?popupID=${p.popupID}"
                                                       class="btn btn-primary btn-block bg-success">Details</a></td>
                                            </tr>
                                        </c:forEach>    
                                    </tbody>
                                </table>
                                <section class="panel">
                                    <div class="panel-body">
                                        <div class="pull-right">
                                            <ul class="pagination pagination-sm pro-page-list text-light">
                                                <li class="page-item ${page == 1 ? 'disabled' : ''}">
                                                    <a class="page-link" href="PopUpController?page=${page>1?page - 1:1}" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                        <span class="sr-only">Previous</span>
                                                    </a>
                                                </li>

                                                <c:forEach var="i" begin="1" end="${totalPages}">
                                                    <li class="page-item ${i == page ? 'active' : ''}">
                                                        <a class="page-link" href="PopUpController?page=${i}">${i}</a>
                                                    </li>
                                                </c:forEach>
                                                <li class="page-item ${page == totalPages ? 'disabled' : ''}">
                                                    <a class="page-link" href="PopUpController?page=${page<totalPages?page + 1:totalPages}" aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                        <span class="sr-only">Next</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </section>
                                <input type="submit" value="Delete selected PopUps" class="btn btn-primary btn-block text-uppercase bg-success">
                            </form>
                        </div>
                        <!-- table container -->
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
        <!--        <script>
                    $(function () {
                        $(".tm-product-name").on("click", function () {
                            window.location.href = "EditProduct.html";
                        });
                    });
                </script>-->
    </body>

</html>
