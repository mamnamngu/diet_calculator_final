<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : EditPopUp
    Created on : Mar 6, 2023, 5:17:30 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit PopUp</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>
    </head>

    <body>
        <jsp:include page="../index/AdminHeader.jsp" />
        <div class="container mt-5">
        <div class="row tm-content-row">
            <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                    <div class="row">
                        <div class="col-10">
                            <h2 class="tm-block-title d-inline-block">Edit PopUp <strong>${popup.popupID}</strong></h2>
                        </div>
                        <div class="col-2">
                            <form action="/diet-calculator/PopUpController">
                                <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success"> << Return</button>                            
                            </form>
                        </div>
                    </div>
                    <div class="row tm-edit-product-row">
                        <div class="col-xl-12 col-lg-12 col-md-12">
                            <form action="PopUpController" method="post" class="tm-edit-product-form">

                                <input type=hidden name="action" value="update">
                                <input type=hidden name="popupID" value="${popup.popupID}">
                                <div class="form-group mb-3">
                                    <label for="des">PopUp ID</label>
                                    <input type="text" name="description" value="${popup.popupID}" class="form-control validate" readonly />
                                </div>

                                <div class="form-group mb-3">
                                    <label for="des">Description</label>
                                    <input type="text" name="description" value="${popup.description}" class="form-control validate" required/>
                                </div>
                                <div class="row">
                                    <div class="form-group mb-3 col-xs-12 col-sm-2">
                                        <label for="status">Status</label>
                                        <input type="text" name="status" value="${popup.status}" class="form-control validate" required/>
                                    </div>
                                    <div class="form-group mb-3 col-xs-12 col-sm-10">
                                        <label for="theme">Theme</label>
                                        <input type="text" name="theme" value="${popup.theme}" class="form-control validate"/>
                                    </div>
                                    <div class="col-12">
                                        <input type="submit" value="Update PopUp" class="btn btn-primary btn-block text-uppercase bg-success">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <jsp:include page="../index/UserFooter.jsp" />
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- https://jquery.com/download/ -->
    <script src="jquery-ui-datepicker/jquery-ui.min.js"></script>
    <!-- https://jqueryui.com/download/ -->
    <script src="js/bootstrap.min.js"></script>
    <!-- https://getbootstrap.com/ -->
</body>

</html>
