<%-- 
    Document   : EditPopUpDetail
    Created on : Mar 9, 2023, 10:17:16 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit PopUp Detail</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700" />
        <link rel="stylesheet" href="css/fontawesome.min.css" />
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/templatemo-style.css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>

    <body>
        <jsp:include page="../index/AdminHeader.jsp" />
        <div class="container mt-5 mb-5">
            <div class="row tm-content-row">
                <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                    <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                        <div class="row">
                            <div class="col-10">
                                <h2 class="tm-block-title d-inline-block">Edit PopUp Details <strong>${popup.popupID}</strong></h2>
                            </div>
                            <div class="col-2">
                                <form action="/diet-calculator/PopUpDetailController">
                                    <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success"> << Return</button>                            
                                </form>
                            </div>
                        </div>
                        <div class="row tm-edit-product-row">
                            <div class="col-xl-12 col-lg-12 col-md-12">
                                <form action="PopUpDetailController" method="post" class="tm-edit-product-form">
                                    <input type=hidden name="action" value="update">
                                    <input type=hidden name="popupID" value="${popup.popupID}">
                                    <div class="form-group mb-3">
                                        <label for="productID">Product ID</label>
                                        <input type="text" name="productID" value="${popup.productID}" class="form-control validate" required/>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="name">Description</label>
                                        <input type="text" name="description" value="${popup.description}" class="form-control validate" required/>
                                    </div>
                                    <div class="col-12">
                                        <input type="submit" value="Update Detail" class="btn btn-primary btn-block text-uppercase bg-success">
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
