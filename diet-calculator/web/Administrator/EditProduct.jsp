<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit Product</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>
    </head>

    <body>
        <jsp:include page="../index/AdminHeader.jsp" />
        <br>
        <div class="container tm-mt-big tm-mb-big">
            <div class="row">
                <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                    <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                        <div class="row">
                            <div class="col-10">
                                <h2 class="tm-block-title d-inline-block">Edit Product</h2>
                            </div>
                            <div class="col-2">
                                <form action="/diet-calculator/ProductController">
                                    <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success"> << Return</button>                            
                                </form>
                            </div>
                        </div>
                        <div class="row tm-edit-product-row">
                            <div class="col-xl-12 col-lg-12 col-md-12">
                                <form action="/diet-calculator/ProductController" method="get" class="tm-edit-product-form">
                                    <input type = "hidden" name="action" value="update">
                                    <div class="form-group mb-3">
                                        <label for="productID">Product ID</label>
                                        <input id="productID" type="text" class="form-control validate"  name="productID" required value="${product.getProductID()}">
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="productname">Product Name</label>
                                        <input id="productname" type="text" class="form-control validate"  name="productname" required value="${product.getProductname  ()}">
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="type">Type</label>
                                        <select
                                            id="type"
                                            class="custom-select tm-select-accounts"
                                            name="type"
                                            >
                                            <option selected value="${product.getType()}">${product.getType()} (default)</option>
                                            <option value="vitamin">Vitamin</option>
                                            <option value="protein">Protein</option>
                                            <option value="eaa">EAA</option>
                                            <option value="bcaa">BCAA</option>
                                            <option value="fiber">Fiber</option>
                                            <option value="carbohydrate">Carbohydrate</option>
                                            <option value="mass">Mass</option>
                                            <option value="water">Water</option>
                                        </select>
                                    </div>

                                    <div class="form-group mb-3">
                                        <label for="price">Price</label>
                                        <input id="price" type="text" class="form-control validate"  name="price" required value="${product.getPrice()}">
                                    </div>

                                    <div class="form-group mb-3">
                                        <label for="quantity">Quantity</label>
                                        <input id="quantity" type="text" class="form-control validate"  name="quantity" required value="${product.getQuantity()}">
                                    </div>

                                    <div class="form-group mb-3">
                                        <label for="brand">Brand</label>
                                        <input id="brand" type="text" class="form-control validate"  name="brand" required value="${product.getBrand()}">
                                    </div>

                                    <div class="form-group mb-3">
                                        <label for="origin">Origin</label>
                                        <input id="origin" type="text" class="form-control validate"  name="origin" required value="${product.getOrigin()}">
                                    </div>

                                    <div class="form-group mb-3">
                                        <label for="volume">Volume</label>
                                        <input id="volume" type="text" class="form-control validate"  name="volume" required value="${product.getVolume()}">
                                    </div>

                                    <div class="form-group mb-3">
                                        <label for="origin">Origin</label>
                                        <input id="origin" type="text" class="form-control validate"  name="origin" required value="${product.getOrigin()}">
                                    </div>

                                    <div class="form-group mb-3">
                                        <label for="effect">Effect</label>
                                        <input id="effect" type="textare" class="form-control validate"  name="effect" required value="${product.getEffect()}">
                                    </div>

                                    <div class="form-group mb-3">
                                        <label for="rate">Rate</label>
                                        <input id="rate" type="text" class="form-control validate"  name="rate" required value="${product.getRate()}">
                                    </div>

                                    <div class="form-group mb-3">
                                        <label for="purchase">Purchase</label>
                                        <input id="purchase" type="text" class="form-control validate"  name="purchase" required value="${product.getPurchase()}">
                                    </div>

                                    <div class="col-12">
                                        <input type="submit" value="Update Product" class="btn btn-primary btn-block text-uppercase bg-success">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <jsp:include page="../index/AdminFooter.jsp" />
        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="jquery-ui-datepicker/jquery-ui.min.js"></script>
        <!-- https://jqueryui.com/download/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
    </body>

</html>