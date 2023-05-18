
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : ShowPopUp
    Created on : Mar 10, 2023, 10:28:10 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <title></title>
        <style>
            .bg-img {
                position: absolute;
                z-index: -1;
            }
            .has-bg-img {
                width: 100%;
            }
        </style>
    </head>
    <body>
        <!-- Button trigger modal -->
        <!--        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Launch demo modal
                </button>-->

        <!-- Modal -->
        <div class="modal fade hide" id="myModal">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content bg-transparent border-0">
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    <div class="row has-bg-img">
                        <c:forEach var="pop" items="${list}">
                            <img src="${pop.theme}" class="img-responsive p-0 m-0 bg-img" alt="deal"/>
                            <c:forEach var="img" items="${imageList}">
                                <div class="col-md-6 p-0 m-0">
                                    <img class="w-100 h-100" src="${img.url}"/>
                                </div>
                            </c:forEach>
                            <c:forEach var="pro" items="${productList}">
                                <div class="col-md-6 p-0 m-0">
                                    <h2><a href="ProductInfoController?productID=${pro.productID}">${pro.productname}</a></h2>
                                </div>
                            </c:forEach>
                            <h1 class="text-center">${pop.description}</h1>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            $(window).on('load', function () {
                $('#myModal').modal('show');
            });
        </script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
