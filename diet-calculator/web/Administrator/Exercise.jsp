<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Exercise
    Created on : Mar 4, 2023, 3:28:12 PM
    Author     : admin
--%>

<%@page import="com.dietcalculator.dto.Exercise"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Exercise List</title>
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
        <div class="container mt-5">
            <div class="row tm-content-row">
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-products">
                        <div class="row">
                            <div class="col-10">
                                <h2 class="tm-block-title d-inline-block mb-4">Exercise Admin</h2>
                            </div>
                            <div class="col-2">
                                <form action="/diet-calculator/ExerciseController">
                                    <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success mb-2"> << Return</button>                            
                                </form>
                            </div>
                            <!--                            <div class="col-md-12">
                                                            <form action="ExerciseController" method="post">
                                                                <input type="text" name="exname" placeholder="Search by Name"/>
                                                            </form>
                                                        </div>
                                                        <div class="col-md-12">
                                                            <form action="ExerciseController" method="post">
                                                                <input type="hidden" name="action" value="sort" />
                                                                Name <input type="checkbox" name="exname" />
                                                                Calorexp <input type="checkbox" name="calorexp" />
                                                                <input type="submit" value="Sort" />
                                                            </form>
                                                        </div>-->
                        </div>
                        <a href="Administrator/AddExercise.jsp" class="btn btn-primary btn-block text-uppercase mb-3 bg-success mt-3">Add new Exercise</a>
                        <form action="ExerciseController" method="get">
                            <div class="tm-product-table-container">
                                <input type="hidden" name="action" value="delete">
                                <table class="table table-lg table-hover ">
                                    <thead>
                                        <tr>
                                            <th scope="col">&nbsp;</th>
                                            <th scope="col">ID</th>
                                            <th scope="col">EXERCISE NAME</th>
                                            <th scope="col">LOWERWEIGHT</th>
                                            <th scope="col">UPPERWEIGHT</th>
                                            <th scope="col">CALOREXP</th>
                                            <th scope="col">ICON</th>
                                            <th scope="col">DESCRIPTION</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="e" items="${list}">
                                            <tr>
                                                <th scope="row"><input type="checkbox" name="checkId" value=${e.exerciseID}></th>
                                                <td> ${e.exerciseID} </td>
                                                <td> ${e.exname} </td>
                                                <td> ${e.lowerweight} </td>
                                                <td> ${e.upperweight} </td>
                                                <td> ${e.calorexp} </td>
                                                <td class="break"> ${e.icon} </td>
                                                <td> ${e.description} </td>

                                                <td><a href="./ExerciseController?action=edit&exerciseID=${e.exerciseID}&jump=true" 
                                                       class="btn btn-primary btn-block bg-success">Edit</a></td>
                                            </tr>
                                        </c:forEach>    
                                    </tbody>
                                </table>
                                <section class="panel">
                                    <div class="panel-body">
                                        <div class="pull-right">
                                            <ul class="pagination pagination-sm pro-page-list text-light">
                                                <li class="page-item ${page == 1 ? 'disabled' : ''}">
                                                    <a class="page-link" href="ExerciseController?page=${page>1?page - 1:1}" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                        <span class="sr-only">Previous</span>
                                                    </a>
                                                </li>

                                                <c:forEach var="i" begin="1" end="${totalPages}">
                                                    <li class="page-item ${i == page ? 'active' : ''}">
                                                        <a class="page-link" href="ExerciseController?page=${i}">${i}</a>
                                                    </li>
                                                </c:forEach>
                                                <li class="page-item ${page == totalPages ? 'disabled' : ''}">
                                                    <a class="page-link" href="ExerciseController?page=${page<totalPages?page + 1:totalPages}" aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                        <span class="sr-only">Next</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </section>
                                <input type="submit" value="Delete selected Exercises" class="btn btn-primary btn-block text-uppercase bg-success">
                            </div>
                        </form>
                        <!-- table container -->

                    </div>
                </div>
            </div>
        </div>
        <br>
        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <jsp:include page="../index/UserFooter.jsp" />
    </body>

</html>
