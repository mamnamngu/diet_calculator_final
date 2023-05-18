<%-- 
    Document   : index
    Created on : Mar 10, 2023, 12:03:52 PM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Diet Calculator</title>
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
       

        <div class="header_section">
            <div class="header-nav">
                <%@ include file = "/index/UserHeader.jsp" %>
            </div>
            <!--banner section start -->
            <div class="banner_section layout_padding">
                <div class="container-fluid">
                    <section class="slide-wrapper">
                        <div class="container-fluid">
                            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <div class="container">
                                            <h1 class="banner_taital">Diet Calculator</h1>
                                            <p class="banner_text">Hello! We are team PGNB</p>
                                            <div class="btn_main">
                                                <div class="contact_bt"><a href="MenuController?action=menu">Calculate diet</a></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
            <!--banner section end -->
        </div>

        <!--header section end -->
        <!--about section start -->
        <div class="about_section layout_padding mt-5">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6 padding_0">
                        <div class="abiut_images_main rounded">

                            <div><img src="./index/images/img-2.jpg" class="image_2"></div>

                        </div>
                    </div>
                    <div class="col-lg-6 padding_0">
                        <div class="about_taital_main">
                            <h1 class="about_taital">Diet Calculator</h1>
                            <p class="about_text">It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is tha</p>
                            <br>
                            <div class="read_bt"><a href="./calculator/DietForm.jsp">Get your diet now</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--about section end -->
        <!-- vitamin section start -->
        <div class="vitamin_section layout_padding1">
            <div class="container-fluid">
                <div class="row">

                    <div class="col-lg-6">
                        <div class="vitamin_taital_main">
                            <h3 class="vitamin_taital">Vitamin supliment product</h3>
                            <p class="vitamin_text">It is a long established fact that a reader will be distracted by the readable content of a page </p>
                            <div class="vitamin_section_2">
                                <div class="vitamin_taital_left">
                                    <div class="car_box">
                                        <img src="https://thumbs2.imgbox.com/4e/a9/s08fsXhS_t.jpg" alt="image host" class="car_image"/>

                                    </div>
                                </div>
                                <div class="vitamin_taital_right">
                                    <h6 class="parking_text">Benefit 1</h6>
                                    <p class="long_text">It is a long established fact that a reader will be distracted by the readable content of a page </p>
                                </div>
                            </div>
                            <div class="vitamin_section_2">
                                <div class="vitamin_taital_left">
                                    <div class="car_box">
                                        <img src="https://thumbs2.imgbox.com/f1/68/LYzuXjKo_t.jpg" alt="image host"/>
                                    </div>
                                </div>
                                <div class="vitamin_taital_right">
                                    <h6 class="parking_text">Benefit 2</h6>
                                    <p class="long_text">It is a long established fact that a reader will be distracted by the readable content of a page </p>
                                </div>
                            </div>
                            <div class="vitamin_section_2">
                                <div class="vitamin_taital_left">
                                    <div class="car_box">
                                        <img src="https://thumbs2.imgbox.com/9a/24/bHVe3vjJ_t.jpg" alt="image host" class="car_image"/>
                                    </div>
                                </div>
                                <div class="vitamin_taital_right">
                                    <h6 class="parking_text">Benefit 3</h6>
                                    <p class="long_text">It is a long established fact that a reader will be distracted by the readable content of a page </p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6 padding_left_30">
                        <div class="vitamin_img"><img src="./index/images/product_vitamin.png"></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- vitamin section end -->
        <!-- contact section start -->
        <div class="contact_srction layout_padding3 mt-5">
            <div class="container">
                <h1 class="contact_taital">Request A call Back</h1>
                <div class="contact_srction_2">
                    <div class="mail_main">
                        <div class="row">
                            <div class="col-md-6">
                                <input type="text" class="mail_text" placeholder="Full Name" name="Full Name">
                                <input type="text" class="mail_text" placeholder="Phone Number" name="Phone Number">
                            </div>
                            <div class="col-md-6">
                                <input type="text" class="mail_text" placeholder="Email" name="Email">
                                <textarea class="massage-bt" placeholder="Massage" rows="5" id="comment" name="Massage"></textarea>
                            </div>
                        </div>
                        <div class="send_bt"><a href="#">SEND</a></div>
                    </div>
                </div>
            </div>
        </div>



        <jsp:include page="../index/UserFooter.jsp" />
    </body>
</html>
