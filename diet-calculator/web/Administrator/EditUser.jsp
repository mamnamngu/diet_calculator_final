<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit User</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>
    </head>

    <body>
        <jsp:include page="../index/AdminHeader.jsp" />
        <div class="container tm-mt-big tm-mb-big">
            <div class="row tm-content-row">
                <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                    <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                        <div class="row">
                            <div class="col-12">
                                <h2 class="tm-block-title d-inline-block">Edit User</h2>
                            </div>
                        </div>
                        <div class="row tm-edit-product-row">
                            <div class="col-xl-12 col-lg-12 col-md-12">
                                <form action="" method="post" class="tm-edit-product-form">
                                    <div class="form-group mb-3">
                                        <label for="userID">UserID
                                        </label>
                                        <input id="userID" name="userID" type="text" value="${user.getUserID()}" readonly
                                               class="form-control validate" />
                                    </div>
                                    <div class="row">
                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                            <label for="username">User Name
                                            </label>
                                            <input id="username" name="username" type="text" value ='${user.getUsername()}'
                                                   class="form-control validate" required/>
                                        </div>
                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                            <p>Gender</p>
                                            <label for=male"><input id="male" name="gender" type=radio value="1"
                                                                    class="form-control validate"/>Male</label>
                                            <label for="female"><input id="female" name="gender" type=radio value="0"
                                                                       class="form-control validate" />Female</label>
                                        </div>
                                        <script>
        <c:if test='${user.getGender() == 1}'>
        
        </script>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                                            <label for="dob">Date of Birth
                                                            </label>
                                                            <input id="dob" name="dob" type=date required value='${user.getDob()}'
                                                                   class="form-control validate" />
                                                        </div>
                                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                                            <label for="phone">Phone Number
                                                            </label>
                                                            <input id="phone" name="phone" type="text" required value='${user.getPhone()}'
                                                                   class="form-control validate" />
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                                            <label for="email">Email
                                                            </label>
                                                            <input id="email" name="email" type="text" required value='${user.getEmail()}'
                                                                   class="form-control validate" />
                                                        </div>
                                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                                            <label for="password">Password
                                                            </label>
                                                            <input id="password" name="password" type=text required ${user.getPassword()}
                                                                   class="form-control validate" />
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                                            <label for="weight">Weight
                                                            </label>
                                                            <input id="weight" name="weight" type=number step=0.1 min="0" required ${user.getWeight()}
                                                                   class="form-control validate" />
                                                        </div>
                                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                                            <label for="height">Height
                                                            </label>
                                                            <input id="height" name="heght" type=number step=0.1 min="0" required ${user.getHeight()}
                                                                   class="form-control validate" />
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="form-group mb-3 col-xs-12 col-md-6">
                                                            <label for="activity">Activity
                                                            </label>
                                                            <select class="custom-select tm-select-accounts" id="activity">
                                                                <option selected value='${user.getActivity()}'></option>
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
                                                    </div>
                                                    </div>

                                                    </div>
                                                    <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                                                        <div class="tm-product-img-edit mx-auto">
                                                            <!-- <img src="" alt="Product image" class="img-fluid d-block mx-auto"> -->
                                                            <i class="fas fa-cloud-upload-alt tm-upload-icon"
                                                               onclick="document.getElementById                                                        ('fileInput').click();"></i>                                                        
                                                        </div>
                                                        <div cl                                                            ass="custom-file mt-3 mb-3">
                                                            <input id="fileInput" type="fi                                                            le" style="display:none;" />
                                                            <input type="button" class="btn btn-primary btn-block mx-auto bg-succe                                                                   ss" value="CHANGE IMAGE NOW"
                                                                   o                                                        nclick="document.getElementB                                                    yId('fileInput').click();                                                    " />
                                                        </div>
                                                    </div>
                                                    <div class="col-12">
                                                        <button type="submit" class="btn btn-primary                                                    btn-block text-uppercase                                                    bg-success">Update Now</b                                                    utton>
                                                    </div>
                                                    </form>                                                    
                                                    </div>
                                                    </div>
                                                    </div>
                                                    </div>
                                                    </div>
                                                    <script src="js/jquery-3.3.1.m                                                    in.js"></script>
                                                    <!-- https://jquery.com/download/ -->
                                                    <scr                                                    ipt src="jquery-ui-datepicker/jquery-ui.min                                                    .js"></script>
                                                        <!-- https://jqueryui.com/dow                                                    nload/ -->
        <script src="js/bootstra                                                    p.min.js"></                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         script>
                                        <!-- https:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               //ge                                                                                                                                                                                                                                                                                                                                                                                                                                                             tboo                                                                                                                                                          tstrap.                                                         com/ -->
                                                        <s                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   cript>
                                                                   $(function                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              () {
                                                                           $("#expire_date").da                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         te                                                                     picker({
                                                                   d                                                                                                                 e                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fau                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             l                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     tDat                                                                                                                                                                                                                                                                                                                                                                               e: "10/                                                                                                                                                                                                        22/2020"
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                });
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     });
<                                                            /script>
</body>

</html>