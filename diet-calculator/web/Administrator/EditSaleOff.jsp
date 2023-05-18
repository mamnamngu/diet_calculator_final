<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit Sale off</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>
    </head>

    <body>
        <jsp:include page="../index/AdminHeader.jsp" />
        <div class="container tm-mt-big tm-mb-big mt-5 mb-5">
            <div class="row tm-content-row">
                <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                    <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                        <div class="row">
                            <div class="col-10">
                                <h2 class="tm-block-title d-inline-block">Edit Product</h2>
                            </div>
                            <div class="col-2">
                                <form action="/diet-calculator/SaleOffController">
                                    <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success"> << Return</button>                            
                                </form>
                            </div>
                        </div>
                        <div class="row tm-edit-product-row">
                            <div class="col-xl-12 col-lg-12 col-md-12">
                                <form action="/diet-calculator/SaleOffController" method="get" class="tm-edit-product-form">
                                    <input type="hidden" name="action" value="update"/>
                                    <div class="form-group mb-3">
                                        <label
                                            for="saleoffID"
                                            >Sale Off ID
                                        </label>
                                        <input
                                            id="saleoffID"
                                            name="saleoffID"
                                            type="text"
                                            class="form-control validate"
                                            readonly
                                            required
                                            value = "${saleoff.getSaleoffID()}"
                                            />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label
                                            for="description"
                                            >Description
                                        </label>
                                        <input
                                            id="description"
                                            name="description"
                                            type="text"
                                            class="form-control validate"
                                            required
                                            value = "${saleoff.getDescription()}"
                                            />
                                    </div>

                                    <div class="form-group mb-3">
                                        <label
                                            for="target"
                                            >Target
                                        </label>
                                        <input
                                            id="target"
                                            name="target"
                                            type="text"
                                            class="form-control validate"
                                            required
                                            value = "${saleoff.getTarget()}"
                                            />
                                    </div>


                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="startdate"
                                                >Start Date
                                            </label>
                                            <input
                                                id="startdate"
                                                name="startdate"
                                                type="date"
                                                class="form-control validate"
                                                required
                                                value = "${saleoff.getStartdate()}"
                                                />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="enddate"
                                                >End Date
                                            </label>
                                            <input
                                                id="enddate"
                                                name="enddate"
                                                type="text"
                                                class="form-control validate"
                                                required
                                                value = "${saleoff.getEnddate()}"
                                                />

                                        </div>


                                    </div>


                                    <div class="col-12">
                                        <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success">Update Sale Off</button>
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