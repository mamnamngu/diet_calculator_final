<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : ProductDetail
    Created on : Feb 28, 2023, 11:34:14 AM
    Author     : admin
--%>

<%@page import="com.dietcalculator.dto.Image"%>
<%@page import="com.dietcalculator.dto.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Details</title>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
              integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
                integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="ProductDetail.css">
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

    <body>
          <%@ include file = "/index/UserHeader.jsp" %>
        <%
//            Product product = new Product();
//            product = (Product) request.getAttribute("product");
//            Image image = new Image();
//            image = (Image) request.getAttribute("image");
        %>
        <div class="container">
            <!-- product -->
            <div class="product-content product-wrap clearfix product-deatil">
                <div class="row">
                    <div class="col-md-5 col-sm-12 col-xs-12">
                        <div class="product-image">
                            <div id="myCarousel-2" class="carousel slide">
                                <ol class="carousel-indicators">
                                    <li data-target="#myCarousel-2" data-slide-to="0" class=""></li>
                                    <li data-target="#myCarousel-2" data-slide-to="1" class="active"></li>
                                    <li data-target="#myCarousel-2" data-slide-to="2" class=""></li>
                                </ol>
                                <div class="carousel-inner">
                                    <!-- Slide 1 -->
                                    <div class="item active">
                                        <img src="${requestScope.image.url}" class="img-responsive"
                                             alt="" />
                                    </div>
                                    <!-- Slide 2 -->
                                    <div class="item">
                                        <img src="${requestScope.image.url}" class="img-responsive"
                                             alt="" />
                                    </div>
                                    <!-- Slide 3 -->
                                    <div class="item">
                                        <img src="${requestScope.image.url}" class="img-responsive"
                                             alt="" />
                                    </div>
                                </div>
                                <a class="left carousel-control" href="#myCarousel-2" data-slide="prev"> <span
                                        class="glyphicon glyphicon-chevron-left"></span> </a>
                                <a class="right carousel-control" href="#myCarousel-2" data-slide="next"> <span
                                        class="glyphicon glyphicon-chevron-right"></span> </a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-md-offset-1 col-sm-12 col-xs-12">
                        <h2 class="name">
                            ${requestScope.product.productname}
                        </h2>
                        <small>Product by ${requestScope.product.brand}</a></small>
                        <i class="fa fa-star fa-2x text-primary"></i>
                        <i class="fa fa-star fa-2x text-primary"></i>
                        <i class="fa fa-star fa-2x text-primary"></i>
                        <i class="fa fa-star fa-2x text-primary"></i>
                        <i class="fa fa-star fa-2x text-muted"></i>
                        <hr />
                        <h3 class="price-container">
                            ${requestScope.product.price}
                            <small>*includes tax</small>
                        </h3>
                        <div class="description description-tabs">
                            <!--                            <ul id="myTab" class="nav nav-pills">
                                                            <li class="active" data-toggle="tab" class="no-margin">Product Description</li>
                                                                                 <li class=""><a href="#specifications" data-toggle="tab">Specifications</a></li>
                                                                                 <li class=""><a href="#reviews" data-toggle="tab">Reviews</a></li>
                                                        </ul>-->
                            <div id="myTabContent" class="tab-content">
                                <div id="more-information">
                                    <br />
                                    <h3><strong>Description Title</strong></h3>
                                    <p>
                                        ${requestScope.product.effect}
                                    </p>
                                </div>
                                <div class="tab-pane fade" id="specifications">
                                    <br />
                                    <dl class="">
                                        <dt>Gravina</dt>
                                        <dd>Etiam porta sem malesuada magna mollis euismod.</dd>
                                        <dd>Donec id elit non mi porta gravida at eget metus.</dd>
                                        <dd>Eget lacinia odio sem nec elit.</dd>
                                        <br />

                                        <dt>Test lists</dt>
                                        <dd>A description list is perfect for defining terms.</dd>
                                        <br />

                                        <dt>Altra porta</dt>
                                        <dd>Vestibulum id ligula porta felis euismod semper</dd>
                                    </dl>
                                </div>
                                <div class="tab-pane fade" id="reviews">
                                    <br />
                                    <form method="post" class="well padding-bottom-10" onsubmit="return false;">
                                        <textarea rows="2" class="form-control" placeholder="Write a review"></textarea>
                                        <div class="margin-top-10">
                                            <button type="submit" class="btn btn-sm btn-primary pull-right">
                                                Submit Review
                                            </button>
                                            <a href="javascript:void(0);" class="btn btn-link profile-link-btn" rel="tooltip"
                                               data-placement="bottom" title="" data-original-title="Add Location"><i
                                                    class="fa fa-location-arrow"></i></a>
                                            <a href="javascript:void(0);" class="btn btn-link profile-link-btn" rel="tooltip"
                                               data-placement="bottom" title="" data-original-title="Add Voice"><i
                                                    class="fa fa-microphone"></i></a>
                                            <a href="javascript:void(0);" class="btn btn-link profile-link-btn" rel="tooltip"
                                               data-placement="bottom" title="" data-original-title="Add Photo"><i
                                                    class="fa fa-camera"></i></a>
                                            <a href="javascript:void(0);" class="btn btn-link profile-link-btn" rel="tooltip"
                                               data-placement="bottom" title="" data-original-title="Add File"><i
                                                    class="fa fa-file"></i></a>
                                        </div>
                                    </form>

                                    <div class="chat-body no-padding profile-message">
                                        <ul>
                                            <li class="message">
                                                <img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="online" />
                                                <span class="message-text">
                                                    <a href="javascript:void(0);" class="username">
                                                        Alisha Molly
                                                        <span class="badge">Purchase Verified</span>
                                                        <span class="pull-right">
                                                            <i class="fa fa-star fa-2x text-primary"></i>
                                                            <i class="fa fa-star fa-2x text-primary"></i>
                                                            <i class="fa fa-star fa-2x text-primary"></i>
                                                            <i class="fa fa-star fa-2x text-primary"></i>
                                                            <i class="fa fa-star fa-2x text-muted"></i>
                                                        </span>
                                                    </a>
                                                    Can't divide were divide fish forth fish to. Was can't form the, living life grass
                                                    darkness very image let unto fowl isn't in blessed fill life yielding above all
                                                    moved
                                                </span>
                                                <ul class="list-inline font-xs">
                                                    <li>
                                                        <a href="javascript:void(0);" class="text-info"><i class="fa fa-thumbs-up"></i>
                                                            This was helpful (22)</a>
                                                    </li>
                                                    <li class="pull-right">
                                                        <small class="text-muted pull-right ultra-light"> Posted 1 year ago </small>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li class="message">
                                                <img src="https://bootdey.com/img/Content/avatar/avatar2.png" class="online" />
                                                <span class="message-text">
                                                    <a href="javascript:void(0);" class="username">
                                                        Aragon Zarko
                                                        <span class="badge">Purchase Verified</span>
                                                        <span class="pull-right">
                                                            <i class="fa fa-star fa-2x text-primary"></i>
                                                            <i class="fa fa-star fa-2x text-primary"></i>
                                                            <i class="fa fa-star fa-2x text-primary"></i>
                                                            <i class="fa fa-star fa-2x text-primary"></i>
                                                            <i class="fa fa-star fa-2x text-primary"></i>
                                                        </span>
                                                    </a>
                                                    Excellent product, love it!
                                                </span>
                                                <ul class="list-inline font-xs">
                                                    <li>
                                                        <a href="javascript:void(0);" class="text-info"><i class="fa fa-thumbs-up"></i>
                                                            This was helpful (22)</a>
                                                    </li>
                                                    <li class="pull-right">
                                                        <small class="text-muted pull-right ultra-light"> Posted 1 year ago </small>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr />
                        <div class="row">
                            <div class="col-sm-12 col-md-6 col-lg-6">
                                <a href="CartController?action=add&productID=${requestScope.product.productID}"
                                   class="btn btn-success btn-lg">Add to cart</a>
                            </div>
                            <div class="col-sm-12 col-md-6 col-lg-6">
                                <div class="btn-group pull-right">
                                    <button class="btn btn-white btn-default"><i class="fa fa-envelope"></i> Contact Seller</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end product -->
        </div>


    </body>

</html>
