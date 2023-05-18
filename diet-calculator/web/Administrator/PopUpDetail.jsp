<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : PopUpDetail
    Created on : Mar 6, 2023, 6:05:30 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>PopUpDetail List</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>
    </head>

    <body>
        <jsp:include page="../index/AdminHeader.jsp" />
        <div class="container mt-5 mb-5">
            <div class="row tm-content-row">
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-products">
                        <div class="row">
                            <div class="col-10">
                                <h2 class="tm-block-title d-inline-block">Details for PopUp <strong>${popup}</strong></h2>
                            </div>
                            <div class="col-2">
                                <form action="/diet-calculator/PopUpController">
                                    <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success"> << Return</button>                            
                                </form>
                            </div>
                        </div>
                        <a href="PopUpDetailController?action=create&popupID=${popup}" class="btn btn-primary btn-block text-uppercase mb-3 bg-success">Add new details for PopUp</a>
                        <div class="tm-product-table-container">
                           
                            <form action="PopUpDetailController" method="post">
                                <input type="hidden" name="action" value="delete">

                                <table class="table table-hover tm-table-small tm-product-table">
                                    <thead>
                                        <tr>
                                            <th scope="col">&nbsp;</th>
                                            <th scope="col">POPUPID</th>
                                            <th scope="col">PRODUCTID</th>
                                            <th scope="col">DESCRIPTION</th>
                                            <th scope="col">&nbsp;</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="p" items="${list}">
                                            <tr><th scope=row><input type="checkbox" name="checkProductId" value=${p.productID}></th>
                                        <input type="hidden" name="popUpId" value=${p.popupID}>
                                        <td> ${p.popupID} </td>
                                        <td> ${p.productID} </td>
                                        <td> ${p.description} </td>
                                        <td><a href="./PopUpDetailController?action=edit&popupID=${p.popupID}&productID=${p.productID}" 
                                               class="btn btn-primary btn-block bg-success">Edit</a></td>
                                        </tr>
                                    </c:forEach>    
                                    </tbody>
                                </table>
                                <input type="submit" value="Delete selected PopUp Details" class="btn btn-primary btn-block text-uppercase bg-success">

                            </form>
                        </div>
                        <!-- table container -->

                    </div>
                </div>
                <!-- <div class="col-sm-12 col-md-12 col-lg-4 col-xl-4 tm-block-col">
                  <div class="tm-bg-primary-dark tm-block tm-block-product-categories">
                    <h2 class="tm-block-title">Product Categories</h2>
                    <div class="tm-product-table-container">
                      <table class="table tm-table-small tm-product-table">
                        <tbody>
                          <tr>
                            <td class="tm-product-name">Product Category 1</td>
                            <td class="text-center">
                              <a href="#" class="tm-product-delete-link">
                                <i class="far fa-trash-alt tm-product-delete-icon"></i>
                              </a>
                            </td>
                          </tr>
                          <tr>
                            <td class="tm-product-name">Product Category 2</td>
                            <td class="text-center">
                              <a href="#" class="tm-product-delete-link">
                                <i class="far fa-trash-alt tm-product-delete-icon"></i>
                              </a>
                            </td>
                          </tr>
                          <tr>
                            <td class="tm-product-name">Product Category 3</td>
                            <td class="text-center">
                              <a href="#" class="tm-product-delete-link">
                                <i class="far fa-trash-alt tm-product-delete-icon"></i>
                              </a>
                            </td>
                          </tr>
                          <tr>
                            <td class="tm-product-name">Product Category 4</td>
                            <td class="text-center">
                              <a href="#" class="tm-product-delete-link">
                                <i class="far fa-trash-alt tm-product-delete-icon"></i>
                              </a>
                            </td>
                          </tr>
                          <tr>
                            <td class="tm-product-name">Product Category 5</td>
                            <td class="text-center">
                              <a href="#" class="tm-product-delete-link">
                                <i class="far fa-trash-alt tm-product-delete-icon"></i>
                              </a>
                            </td>
                          </tr>
                          <tr>
                            <td class="tm-product-name">Product Category 6</td>
                            <td class="text-center">
                              <a href="#" class="tm-product-delete-link">
                                <i class="far fa-trash-alt tm-product-delete-icon"></i>
                              </a>
                            </td>
                          </tr>
                          <tr>
                            <td class="tm-product-name">Product Category 7</td>
                            <td class="text-center">
                              <a href="#" class="tm-product-delete-link">
                                <i class="far fa-trash-alt tm-product-delete-icon"></i>
                              </a>
                            </td>
                          </tr>
                          <tr>
                            <td class="tm-product-name">Product Category 8</td>
                            <td class="text-center">
                              <a href="#" class="tm-product-delete-link">
                                <i class="far fa-trash-alt tm-product-delete-icon"></i>
                              </a>
                            </td>
                          </tr>
                          <tr>
                            <td class="tm-product-name">Product Category 9</td>
                            <td class="text-center">
                              <a href="#" class="tm-product-delete-link">
                                <i class="far fa-trash-alt tm-product-delete-icon"></i>
                              </a>
                            </td>
                          </tr>
                          <tr>
                            <td class="tm-product-name">Product Category 10</td>
                            <td class="text-center">
                              <a href="#" class="tm-product-delete-link">
                                <i class="far fa-trash-alt tm-product-delete-icon"></i>
                              </a>
                            </td>
                          </tr>
                          <tr>
                            <td class="tm-product-name">Product Category 11</td>
                            <td class="text-center">
                              <a href="#" class="tm-product-delete-link">
                                <i class="far fa-trash-alt tm-product-delete-icon"></i>
                              </a>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                    <button class="btn btn-primary btn-block text-uppercase mb-3">
                      Add new category
                    </button>
                  </div>
                </div> -->
            </div>
        </div>
        <br>
        <jsp:include page="../index/UserFooter.jsp" />

        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <!--        <script>
                    $(function () {
                        $(".tm-product-name").on("click", function () {
                            window.location.href = "EditProduct.html";
                        });
                    });
               
        </script>-->
    </body>

</html>
