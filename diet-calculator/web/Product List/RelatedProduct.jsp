<%-- 
    Document   : RelatedProduct
    Created on : Mar 10, 2023, 2:59:05 PM
    Author     : ADMIN
--%>

<%@page import="com.dietcalculator.dto.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!doctype html>
<html>
    <head>
        <meta charset='utf-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <title>Snippet - BBBootstrap</title>
        <link href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' rel='stylesheet'>
        <link href='https://use.fontawesome.com/releases/v5.7.2/css/all.css' rel='stylesheet'>
        <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <style>::-webkit-scrollbar {
                width: 8px;
            }
            /* Track */
            ::-webkit-scrollbar-track {
                background: #f1f1f1; 
            }

            /* Handle */
            ::-webkit-scrollbar-thumb {
                background: #888; 
            }

            /* Handle on hover */
            ::-webkit-scrollbar-thumb:hover {
                background: #555; 
            }  @import url('https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700,800,900|Rubik:300,400,500,700,900');

            * {
                margin: 0;
                padding: 0;
                -webkit-font-smoothing: antialiased;
                -webkit-text-shadow: rgba(0, 0, 0, .01) 0 0 1px;
                text-shadow: rgba(0, 0, 0, .01) 0 0 1px
            }

            body {
                font-family: 'Rubik', sans-serif;
                font-size: 14px;
                font-weight: 400;
                background: #eff6fa;
                color: #000000
            }

            div {
                display: block;
                position: relative;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box
            }




            .bbb_viewed {
                padding-top: 51px;
                padding-bottom: 60px;
                background: #eff6fa
            }

            .bbb_main_container{
                background-color: #fff;
                padding: 11px;
            }

            .bbb_viewed_title_container {
                border-bottom: solid 1px #dadada
            }

            .bbb_viewed_title {
                margin-bottom: 16px;
                margin-top: 8px;

            }

            .bbb_viewed_nav_container {
                position: absolute;
                right: -5px;
                bottom: 14px
            }

            .bbb_viewed_nav {
                display: inline-block;
                cursor: pointer
            }

            .bbb_viewed_nav i {
                color: #dadada;
                font-size: 18px;
                padding: 5px;
                -webkit-transition: all 200ms ease;
                -moz-transition: all 200ms ease;
                -ms-transition: all 200ms ease;
                -o-transition: all 200ms ease;
                transition: all 200ms ease
            }

            .bbb_viewed_nav:hover i {
                color: #606264
            }

            .bbb_viewed_prev {
                margin-right: 15px
            }

            .bbb_viewed_slider_container {
                padding-top: 13px;
            }

            .bbb_viewed_item {
                width: 100%;
                background: #FFFFFF;
                border-radius: 2px;
                padding-top: 25px;
                padding-bottom: 25px;
                padding-left: 30px;
                padding-right: 30px
            }

            .bbb_viewed_image {
                width: 150px;
                height: 150px;
            }

            .bbb_viewed_image img {
                display: block;
                max-width: 100%
            }

            .bbb_viewed_content {
                width: 100%;
                margin-top: 25px
            }

            .bbb_viewed_price {
                font-size: 16px;
                color: #000000;
                font-weight: 500
            }

            .bbb_viewed_item.discount .bbb_viewed_price {
                color: #df3b3b
            }

            .bbb_viewed_price span {
                position: relative;
                font-size: 12px;
                font-weight: 400;
                color: rgba(0, 0, 0, 0.6);
                margin-left: 8px
            }

            .bbb_viewed_price span::after {
                display: block;
                position: absolute;
                top: 6px;
                left: -2px;
                width: calc(100% + 4px);
                height: 1px;
                background: #8d8d8d;
                content: ''
            }

            .bbb_viewed_name {
                margin-top: 3px
            }

            .bbb_viewed_name a {
                font-size: 14px;
                color: #000000;
                -webkit-transition: all 200ms ease;
                -moz-transition: all 200ms ease;
                -ms-transition: all 200ms ease;
                -o-transition: all 200ms ease;
                transition: all 200ms ease
            }

            .bbb_viewed_name a:hover {
                color: #0e8ce4
            }

            .item_marks {
                position: absolute;
                top: 18px;
                left: 18px
            }

            .item_mark {
                display: none;
                width: 36px;
                height: 36px;
                border-radius: 50%;
                color: #FFFFFF;
                font-size: 10px;
                font-weight: 500;
                line-height: 36px;
                text-align: center
            }

            .item_discount { 
                background: #df3b3b;
                margin-right: 5px
            }

            .item_new {
                background: #0e8ce4
            }

            .bbb_viewed_item.discount .item_discount {
                display: inline-block
            }

            .bbb_viewed_item.is_new .item_new {
                display: inline-block
            }</style>
    </head>

    <body className='snippet-body'>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/owl.carousel.js"></script>
        <div class="bbb_viewed">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="bbb_main_container">
                            <div class="bbb_viewed_title_container">
                                <h3 class="bbb_viewed_title">Related products</h3>
                                <div class="bbb_viewed_nav_container">
                                    <div class="bbb_viewed_nav bbb_viewed_prev"><i class="fas fa-chevron-left"></i></div>
                                    <div class="bbb_viewed_nav bbb_viewed_next"><i class="fas fa-chevron-right"></i></div>
                                </div>
                            </div>
                            <div class="bbb_viewed_slider_container">
                                <div class="owl-carousel owl-theme bbb_viewed_slider"><!--
                                    <div class="owl-item">
                                        <div class="bbb_viewed_item discount d-flex flex-column align-items-center justify-content-center text-center">
                                            <div class="bbb_viewed_image"><img src="https://res.cloudinary.com/dxfq3iotg/image/upload/v1560924153/alcatel-smartphones-einsteiger-mittelklasse-neu-3m.jpg" alt=""></div>
                                            <div class="bbb_viewed_content text-center">
                                                <div class="bbb_viewed_price">₹12225<span>₹13300</span></div>
                                                <div class="bbb_viewed_name"><a href="#">Alkatel Phone</a></div>
                                            </div>
                                            <ul class="item_marks">
                                                <li class="item_mark item_discount">-25%</li>
                                                <li class="item_mark item_new">new</li>
                                            </ul>
                                        </div>
                                    </div>-->

                                    <c:forEach var="x" begin="0" end="${relateList.size()-1}" step="1">

                                        <div class="owl-item">
                                            <div class="bbb_viewed_item discount d-flex flex-column align-items-center justify-content-center text-center">
                                                <a href="ProductInfoController?productID=${relateList.get(x).getProductID()}">
                                                    <div class="bbb_viewed_image"><img class="img-responsive" src="${imageList.get(x).getUrl()}" alt="product image"></div>
                                                    <div class="bbb_viewed_content text-center">
                                                        <div class="bbb_viewed_price">${relateList.get(x).getPrice()}</div>
                                                        <div class="bbb_viewed_name"><a href="#">${relateList.get(x).getProductname()}</a></div>
                                                    </div>
                                                    <ul class="item_marks">

                                                        <li class="item_mark item_new">new!</li>
                                                    </ul>
                                                </a>
                                            </div>
                                        </div>

                                    </c:forEach>

                                </div>
                            </div> 
                        </div>
                    </div>
                </div>
            </div>
            <script type='text/javascript' src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js'></script>
            <script type='text/javascript' src='#'></script>
            <script type='text/javascript' src='#'></script>
            <script type='text/javascript' src='#'></script>
            <script type='text/javascript'>$(document).ready(function ()
                {


                    if ($('.bbb_viewed_slider').length)
                    {
                        var viewedSlider = $('.bbb_viewed_slider');

                        viewedSlider.owlCarousel(
                                {
                                    loop: true,
                                    margin: 30,
                                    autoplay: true,
                                    autoplayTimeout: 6000,
                                    nav: false,
                                    dots: false,
                                    responsive:
                                            {
                                                0: {items: 1},
                                                575: {items: 2},
                                                768: {items: 3},
                                                991: {items: 4},
                                                1199: {items: 6}
                                            }
                                });

                        if ($('.bbb_viewed_prev').length)
                        {
                            var prev = $('.bbb_viewed_prev');
                            prev.on('click', function ()
                            {
                                viewedSlider.trigger('prev.owl.carousel');
                            });
                        }

                        if ($('.bbb_viewed_next').length)
                        {
                            var next = $('.bbb_viewed_next');
                            next.on('click', function ()
                            {
                                viewedSlider.trigger('next.owl.carousel');
                            });
                        }
                    }


                });</script>
            <script type='text/javascript'>var myLink = document.querySelector('a[href="#"]');
                myLink.addEventListener('click', function (e) {
                    e.preventDefault();
                });</script>
            <br>
            <jsp:include page="../index/UserFooter.jsp" />
            </body>
            </html>