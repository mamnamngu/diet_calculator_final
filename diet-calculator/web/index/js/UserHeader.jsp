<%-- 
    Document   : UserHeader
    Created on : Mar 18, 2023, 8:20:51 AM
    Author     : MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- style css -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index/css/responsive.css">
        <!-- fevicon -->

        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index/css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <!-- fonts -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,700|Raleway:400,700&display=swap" rel="stylesheet">
        <!-- owl stylesheets --> 
        <link rel="stylesheet" href="${pageContext.request.contextPath}/index/css/owl.carousel.min.css">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
    </head>
    <body>
        <!--header section start -->
        <div class="header_section1">
            <div class="header-nav">
                <nav class="navbar navbar-expand-lg navbar-dark main_navbar">
                    <div class="logo"><a href="index.jsp"><img class="logo" src="./index/images/logo.jpg" alt="logo"><h1 class="title">Diet Calculator</h1></a></div>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="./calculator/DietForm.jsp">Diet</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="ProductListController">Product</a>
                            </li> 
                            <li class="nav-item">
                                <a class="nav-link" href="">Contact Us</a>
                            </li>      
                        </ul>
                        <div class="user-logo"><a href="../LoginController"><img src="./index/images/user-logo.jpg" alt="user_logo"></a></div>
                    </div>
                </nav>
            </div>
    </body>
</html>
