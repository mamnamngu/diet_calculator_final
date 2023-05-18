<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add New Food</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>
    </head>
    <body>
        <jsp:include page="../index/AdminHeader.jsp" />
        <div class="container tm-mt-big tm-mb-big mt-5 mb-5">
            <div class="row">
                <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                    <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                        <div class="row">
                            <div class="col-10">
                                <h2 class="tm-block-title d-inline-block">Add Food</h2>
                            </div>
                            <div class="col-2">
                                <form action="/diet-calculator/FoodController">
                                    <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success"> << Return</button>                            
                                </form>
                            </div>
                        </div>
                        <div class="row tm-edit-product-row">
                            <div class="col-xl-12 col-lg-12 col-md-12">
                                <form action="/diet-calculator/FoodController" class="tm-edit-product-form">
                                    <input type="hidden" name="action" value="create"/>
                                    <div class="form-group mb-3">
                                        <label
                                            for="foodID"
                                            >Food ID
                                        </label>
                                        <input
                                            name="foodID"
                                            type="text"
                                            class="form-control validate"
                                            required
                                            />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label
                                            for="foodname"
                                            >Food Name
                                        </label>
                                        <input
                                            name="foodname"
                                            type="text"
                                            class="form-control validate"
                                            required
                                            />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label
                                            for="category"
                                            >Category</label
                                        >
                                        <select
                                            class="custom-select tm-select-accounts"
                                            name="category"
                                            >
                                            <option selected value="fruit">fruit</option>
                                            <option value="vegetables">vegetables</option>
                                            <option value="fish">fish</option>
                                            <option value="seafood">seafood</option>
                                            <option value="meat">meat</option>
                                            <option value="poultry">poultry</option>
                                            <option value="egg">egg</option>
                                            <option value="nuts">nuts</option>
                                            <option value="legumes">legumes</option>
                                            <option value="starch">starch</option>
                                            <option value="dairies&dessert">dairies&dessert</option>
                                            <option value="drinks">drinks</option>
                                        </select>
                                    </div>
                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="size"
                                                >size
                                            </label>
                                            <input
                                                name="size"
                                                type="number"
                                                class="form-control validate"
                                                required
                                                />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="caloricintake"
                                                >caloricintake
                                            </label>
                                            <input
                                                name="caloricintake"
                                                type="number"
                                                class="form-control validate"
                                                required
                                                />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="carbohydrate"
                                                >carbohydrate
                                            </label>
                                            <input
                                                name="carbohydrate"
                                                type="text"
                                                class="form-control validate"
                                                required
                                                />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="fiber"
                                                >fiber
                                            </label>
                                            <input
                                                name="fiber"
                                                type="text"
                                                class="form-control validate"
                                                required
                                                />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="protein"
                                                >protein
                                            </label>
                                            <input
                                                name="protein"
                                                type="text"
                                                class="form-control validate"
                                                required
                                                />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="fat"
                                                >fat
                                            </label>
                                            <input
                                                name="fat"
                                                type="text"
                                                class="form-control validate"
                                                required
                                                />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="water"
                                                >water
                                            </label>
                                            <input
                                                name="water"
                                                type="text"
                                                class="form-control validate"
                                                required
                                                />
                                        </div>                      
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="icon"
                                                >icon
                                            </label>
                                            <input
                                                name="icon"
                                                type="text"
                                                class="form-control validate"
                                                required
                                                />
                                        </div>                      
                                        <div class="form-group mb-3 col-xs-12 col-sm-6">
                                            <label
                                                for="description"
                                                >description
                                            </label>
                                            <input
                                                name="description"
                                                type="text"
                                                class="form-control validate"
                                                required
                                                />
                                        </div>                      
                                    </div>
                                    <div class="col-12">
                                        <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success">Add Food</button>
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
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <!--            <script>
                                                        $(function () {
                                                            $("#expire_date").datepicker();
                                                        });
                    </script>-->
    </body>
</html>