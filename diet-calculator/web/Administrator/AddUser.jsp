<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add User</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>
    </head>

    <body>
        <jsp:include page="../index/AdminHeader.jsp" />
        <div class="container mt-5 tm-mt-big tm-mb-big">
            <div class="row tm-content-row">
                <div class="col-md-12 col-sm-12 mx-auto">
                    <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                        <div class="row">
                            <div class="col-12">
                                <h2 class="tm-block-title d-inline-block">Add User</h2>
                            </div>
                        </div>
                        <form action="../UserController" method="post" class="tm-edit-product-form">
                            <input type="hidden" name="action" value="create" />
                            <div class="row tm-edit-product-row">
                                <div class="col-md-12">
                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                            <label for="username">User Name
                                            </label>
                                            <input id="username" name="username" type="text"
                                                   class="form-control validate" required/>
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                            <p>Gender</p>
                                            <label for=gender"><input id="gender" name="gender" type=radio value="1"
                                                                      class=" validate"/>Male</label>
                                            <label for="type"><input id="gender" name="gender" type=radio value="0"
                                                                     class=" validate" />Female</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                            <label for="dob">Date of Birth
                                            </label>
                                            <input id="dob" name="dob" type=date required
                                                   class="form-control validate" />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                            <label for="phone">Phone Number
                                            </label>
                                            <input id="phone" name="phone" type="text" required
                                                   class="form-control validate" />
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                            <label for="email">Email
                                            </label>
                                            <input id="email" name="email" type="text" required
                                                   class="form-control validate" />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                            <label for="password">Password
                                            </label>
                                            <input id="password" name="password" type=text required
                                                   class="form-control validate" />
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                            <label for="weight">Weight
                                            </label>
                                            <input id="weight" name="weight" type=number step=0.1 min="0" required
                                                   class="form-control validate" />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                            <label for="height">Height
                                            </label>
                                            <input id="height" name="heght" type=number step=0.1 min="0" required
                                                   class="form-control validate" />
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                            <label for="activity">Activity
                                            </label>
                                            <select class="custom-select tm-select-accounts" id="activity">
                                                <option value="1">Sedentary</option>
                                                <option value="2" selected>Lightly Active</option>
                                                <option value="3">Moderately Active</option>
                                                <option value="4">Active</option>
                                                <option value="5">Very Active</option>
                                            </select>
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                            <label for="preference">Preference
                                            </label>
                                            <select class="custom-select tm-select-accounts" id="preference">
                                                <option value="0" selected>No Preference</option>
                                                <option value="1">Asian & Pacific</option>
                                                <option value="2">European & North American</option>
                                                <option value="3">Mediterranean & Hispanic</option>
                                                <option value="4">Vegan</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-md-4">
                                            <label for="goal">Goal
                                            </label>
                                            <select class="custom-select tm-select-accounts" id="activity">
                                                <option value="0" selected>Weight Maintenance</option>
                                                <option value="1">Gain Weight</option>
                                                <option value="-1">Lose Weight</option>
                                            </select>
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-md-4">
                                            <label for="amount">Amount of Change
                                            </label>
                                            <input id="amount" name="amount" type=number step =0.1 min =0 required
                                                   class="form-control validate" />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-md-4">
                                            <label for="duration">Duration (weeks)
                                            </label>
                                            <input id="duration" name="duration" type=number step =1 min =1 max =12 required
                                                   class="form-control validate" />
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-md-4">
                                            <label for="main">Main Meals per Day
                                            </label>
                                            <input id="main" name="main" type=number step =1 min =2 max =3 required
                                                   class="form-control validate" />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-md-4">
                                            <label for="side">Side Meals per Day
                                            </label>
                                            <input id="side" name="side" type=number step =1 min =0 max =2 required
                                                   class="form-control validate" />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-md-4">
                                            <label for="session">Ex Session per Day
                                            </label>
                                            <input id="session" name="session" type=number step =1 min =1 max =3 required
                                                   class="form-control validate" />
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                            <label for="rank">Rank
                                            </label>
                                            <input id="rank" name="rank" type=number step =1 min =1 max =3 required
                                                   class="form-control validate" />
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                            <label for="createdate">Create Date
                                            </label>
                                            <input id="createdate" name="createdate" type=date value=''
                                                   class="form-control validate" />
                                        </div>
                                        <script>
                                            date = new Date();
                                            year = date.getFullYear();
                                            month = date.getMonth() + 1;
                                            day = date.getDate();
                                            document.getElementById("createdate").setAttribute("value", year + "-" + month + "-" + day);
                                        </script>       
                                    </div>
                                </div>
                                <div class="col-md-12 mx-auto mb-4">
                                    <div class="tm-product-img-edit mx-auto">
                                        <!-- <img src="" alt="Product image" class="img-fluid d-block mx-auto"> -->
                                        <i class="fas fa-cloud-upload-alt tm-upload-icon"
                                           onclick="document.getElementById('fileInput').click();"></i>
                                    </div>
                                    <div class="custom-file mt-3 mb-3">
                                        <input id="fileInput" type="file" style="display:none;" />
                                        <input type="button" class="btn btn-primary btn-block mx-auto bg-success" value="CHANGE IMAGE NOW"
                                               onclick="document.getElementById('fileInput').click();" />
                                    </div>
                                </div>
                                <div class="col-12">
                                    <input type="submit" value="Update Now" class="btn btn-primary btn-block text-uppercase bg-success">
                                </div>
                            </div>
                        </form>
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
    <!--    <script>
                                               $(function () {
                                                   $("#expire_date").datepicker({
                                                       defaultDate: "10/22/2020"
                                                   });
                                               });
        </script>-->
</body>

</html>