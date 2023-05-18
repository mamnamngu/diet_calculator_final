<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add new sale off</title>
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
                                <h2 class="tm-block-title d-inline-block">Add Sale off</h2>
                            </div>
                            <div class="col-2">
                                <form action="/diet-calculator/SaleOffController">
                                    <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success"> << Return</button>                            
                                </form>
                            </div>
                        </div>
                        <div class="row tm-edit-product-row">
                            <div class="col-xl-12 col-lg-12 col-md-12">
                                <form action="/diet-calculator/SaleOffController" class="tm-edit-product-form">
                                    <input type="hidden" name="action" value="create"/>
                                    <div class="form-group mb-3">
                                        <label
                                            for="saleoffID"
                                            >Sale off ID
                                        </label>
                                        <input
                                            name="saleoffID"
                                            type="text"
                                            class="form-control validate"
                                            required
                                            />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label
                                            for="description"
                                            >Description
                                        </label>
                                        <input
                                            name="description"
                                            type="text"
                                            class="form-control validate"
                                            required
                                            />
                                    </div>


                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="startdate"
                                                >Start date
                                            </label>
                                            <input
                                                name="startdate"
                                                type="date"
                                                class="form-control validate"
                                                required
                                                />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="enddate"
                                                >End date
                                            </label>
                                            <input
                                                name="enddate"
                                                type="date"
                                                class="form-control validate"
                                                required
                                                />
                                        </div>

                                    </div>

                                    <div class="form-group mb-3">
                                        <label
                                            for="target"
                                            >target
                                        </label>
                                        <input
                                            name="target"
                                            type="text"
                                            class="form-control validate"
                                            required
                                            />
                                    </div>

                            </div>
<!--                            <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                                <div class="tm-product-img-dummy mx-auto">
                                    <i
                                        class="fas fa-cloud-upload-alt tm-upload-icon"
                                        onclick="document.getElementById('fileInput').click();"
                                        ></i>
                                </div>
                                                <div class="custom-file mt-3 mb-3">
                                                  <input id="fileInput" type="file" style="display:none;" />
                                                  <input
                                                    type="button"
                                                    class="btn btn-primary btn-block mx-auto bg-success"
                                                    value="UPLOAD PRODUCT IMAGE"
                                                    onclick="document.getElementById('fileInput').click();"
                                                  />
                                                </div>
                            </div>-->
                            <div class="col-12">
                                <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success">Add Sale Off</button>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
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
                                                $("#expire_date").datepicker();
                                            });
        </script>-->
    </body>
</html>