<%-- 
    Document   : Header
    Created on : Mar 10, 2023, 1:31:40 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Header</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- bootstrap css -->
        <link rel="stylesheet" type="text/css" href="/diet-calculator/index/css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" type="text/css" href="/diet-calculator/index/css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="/diet-calculator/index/css/responsive.css">
        <!-- fevicon -->
        <link rel="icon" href="$/diet-calculator/index/images/logo.jpg" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="/diet-calculator/index/css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <!-- fonts -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,700|Raleway:400,700&display=swap" rel="stylesheet">
        <!-- owl stylesheets --> 
        <link rel="stylesheet" href="/diet-calculator/index/css/owl.carousel.min.css">
        <link rel="stylesheet" href="/diet-calculator/index/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark main_navbar">
            <div class="logo"><a href="/diet-calculator/HomeController"><img class="logo" src="/diet-calculator/index/images/logo.jpg" alt="logo"><h1 class="title">Diet Calculator</h1></a></div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto " >
                    <li class="nav-item">
                        <a class="nav-link" href="/diet-calculator/MenuController?action=menu">Menu</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/diet-calculator/ProductListController">Shop</a>
                    </li> 
                    <li class="nav-item">
                        <a class="nav-link" href="/diet-calculator/CartController">Cart</a>
                    </li>      
                </ul>    
                </ul></div>
            <c:if test = "${sessionScope.user.getUsername()!=null}"><div style="color:white">Welcome back: ${sessionScope.user.getUsername()}</div></c:if>
            <c:if test = "${sessionScope.user.getUserID()!=null}"><a href="/diet-calculator/LoginController?action=logout"><div class="nav-link" style="color:white">Log out</div></a> </c:if>
            <c:if test = "${sessionScope.user.getUserID()==null}"> <a href="/diet-calculator/Register_Login/login.jsp"><div class="nav-link" style="color:white">Log in</div></a></c:if>
            <div class="user-logo"><a href="UserController?action=view&userID=${sessionScope.user.getUserID()}"><img src="/diet-calculator/index/images/user-logo.jpg" alt="user_logo"></a>
            </div>
        </nav>
    </body>
</html>
