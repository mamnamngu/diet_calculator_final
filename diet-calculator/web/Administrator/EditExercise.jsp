<%-- 
    Document   : EditExercise
    Created on : Mar 4, 2023, 4:20:28 PM
    Author     : admin
--%>

<%@page import="com.dietcalculator.dto.Exercise"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit Exercise</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>

        <link href="${pageContext.request.contextPath}/index/css/style.css" type="text/css" rel="stylesheet">
    </head>

    <body>
        <jsp:include page="../index/AdminHeader.jsp" />
            <div class="container tm-mt-big tm-mb-big mb-5 mt-5">
                <div class="row">
                    <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                        <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                            <div class="row">
                                <div class="col-10">
                                    <h2 class="tm-block-title d-inline-block">Exercise Admin</h2>
                                </div>
                                <div class="col-2">
                                    <form action="/diet-calculator/ExerciseController">
                                        <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success"> << Return</button>                            
                                    </form>
                                </div>
                            </div>

                            <div class="row tm-edit-product-row">
                                <div class="col-xl-12 col-lg-12 col-md-12">
                                    <form action="ExerciseController" method="post" class="tm-edit-product-form">
                                        <input type=hidden name="action" value="edit">
                                        <input type=hidden name="exerciseID" value="${exercise.exerciseID}">
                                        <div class="form-group mb-3">
                                            <label for="name">Exercise Name</label>
                                            <input type="text" name="exname" value="${exercise.exname}" class="form-control validate" required/>
                                        </div>
                                        <div class="row">
                                            <div class="form-group mb-3 col-xs-12 col-sm-4">
                                                <label for="lowerweight">Lower Weight</label>
                                                <input type="text" name="lowerweight" value="${exercise.lowerweight}" class="form-control validate" required/>
                                            </div>
                                            <div class="form-group mb-3 col-xs-12 col-sm-4">
                                                <label for="upperweight">Upper Weight</label>
                                                <input type="text" name="upperweight" value="${exercise.upperweight}" class="form-control validate" required/>
                                            </div>
                                            <div class="form-group mb-3 col-xs-12 col-sm-4">
                                                <label for="calorexp">Calorexp</label>
                                                <input type="text" name="calorexp" value="${exercise.calorexp}" class="form-control validate" required/>
                                            </div>
                                            <div class="form-group mb-3 col-xs-12 col-sm-4">
                                                <label for="calorexp">Icon</label>
                                                <input type="text" name="icon" value="${exercise.icon}" class="form-control validate" required/>
                                            </div>
                                            <div class="form-group mb-3 col-xs-12 col-sm-4">
                                                <label for="calorexp">Description</label>
                                                <input type="text" name="description" value="${exercise.description}" class="form-control validate" required/>
                                            </div>
                                            <div class="col-12">
                                                <input type="submit" value="Update Exercise" class="btn btn-primary btn-block text-uppercase bg-success">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        <!-- Footer -->
        <jsp:include page="../index/UserFooter.jsp" />





    </body>

</html>
