<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Edit Product</title>
   <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700" />
   <link rel="stylesheet" href="css/fontawesome.min.css" />
   <link rel="stylesheet" href="css/bootstrap.min.css" />
   <link rel="stylesheet" href="css/templatemo-style.css">
   <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
   <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
   <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/index/css/style.css">
</head>

<body>
    <!--header section start -->
          <%@ include file = "/index/UserHeader.jsp" %>
    
   <div class="container tm-mt-big tm-mb-big mt-5 mb-5">
      <div class="row">
         <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
            <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
               <div class="row">
                  <div class="col-12">
                     <h2 class="tm-block-title d-inline-block">Diet Design Form</h2>
                  </div>
               </div>
               <div class="row tm-edit-product-row">
                  <div class="col-xl-12 col-lg-12 col-md-12">
                     <form action="../MenuController" method="get" class="tm-edit-product-form">
                         <div class="row">
                            <div class="form-group mb-3 col-xs-12 col-md-6">
                                <label for="username">Age
                                </label>
                                <input type="text" name='age' class="form-control validate" id="age" autocomplete="off" required/>
                           </div>
                           <div class="form-group mb-3 col-xs-12 col-md-6">
                              <p>Gender</p>
                              <label for="male"><input id="male" name="gender" type=radio value="1"
                                                        class="form-control validate"/>Male</label>
                              <label for="female"><input id="female" name="gender" type=radio value="0"
                                                       class="form-control validate" />Female</label>
                           </div>
                         </div>
                         
                         <div class="row">
                         <div class="form-group mb-3 col-xs-12 col-md-6">
                           <label for="weight">Weight(kg)
                           </label>
                             <input id="weight" name="weight" type=number step=0.1 min="0" required
                              class="form-control validate" />
                        </div>
                         <div class="form-group mb-3 col-xs-12 col-md-6">
                           <label for="height">Height(cm)
                           </label>
                           <input id="height" name="height" type=number step=0.1 min="0" required
                              class="form-control validate" />
                        </div>
                          </div>
                         
                         <div class="row">
                            <div class="form-group mb-3 col-xs-12 col-md-6">
                               <label for="activity">Activity
                                </label>
                                <select class="custom-select tm-select-accounts" id="activity" name='activity'>
                                   <option value="1">Sedentary (little or no exercise)</option>
                                   <option value="2" selected>Lightly Active(exercise 1-3 days/week)</option>
                                   <option value="3">Moderately Active (exercise 3-5 days/week)</option>
                                   <option value="4">Active (exercise 6-7 days/week)</option>
                                   <option value="5">Very Active (hard exercise 6-7 days/week)</option>
                                </select>
                            </div>
                             <div class="form-group mb-3 col-xs-12 col-md-6">
                                <label for="preference">Preference
                                </label>
                                <select class="custom-select tm-select-accounts" id="preference" name='preference'>
                                  <option value="0" selected>No Preference</option>
                                  <option value="1">Asian & Pacific</option>
                                  <option value="2">European & North American</option>
                                  <option value="3">Mediterranean & Hispanic</option>
                                  <option value="4">Vegan</option>
                                </select>
                            </div>
                         </div>
                         <div class="row">
                            <div class="form-group mb-3 col-xs-12 col-md-6">
                                <label for="goal">Goal</label>
                                <select class="custom-select tm-select-accounts" id="goal" name='goal'>
                                    <option value="0" selected>Weight Maintenance</option>
                                    <option value="1">Gain Weight</option>
                                    <option value="-1">Lose Weight</option>
                                </select>
                            </div>
                            <div class="form-group mb-3 col-xs-12 col-md-6">
                                <label for="amount">Amount of Change</label>
                                <input id="amount" name="amount" type=number step =0.1 min =0 required
                                 class="form-control validate" />
                            </div>
                         </div>
                          
                        <div class="row">
                        <div class="form-group mb-3 col-xs-12 col-md-6">
                            <label for="duration">Duration (weeks)
                              </label>
                              <input id="duration" name="duration" type=number step =1 min =1 max =12 required
                                 class="form-control validate" />
                        </div>
                        <div class="form-group mb-3 col-xs-12 col-md-6">
                            <label for="session">Ex Session per Day
                              </label>
                              <input id="session" name="session" type=number step =1 min =1 max =3 required
                                 class="form-control validate" />
                        </div>
                         </div>
                            
                         <div class="row">
                            <div class="form-group mb-3 col-xs-12 col-md-6">
                              <label for="main">Main Meals per Day
                              </label>
                              <input id="main" name="main" type=number step =1 min =2 max =3 required
                                 class="form-control validate" />
                           </div>
                            <div class="form-group mb-3 col-xs-12 col-md-6">
                              <label for="side">Side Meals per Day
                              </label>
                              <input id="side" name="side" type=number step =1 min =0 max =2 required
                                 class="form-control validate" />
                           </div>
                        </div>
                         </div>
                    </div>

                  </div>
                  <div class="col-xl-6 col-lg-6 col-md-12 mx-auto mb-4">
                     <div class="tm-product-img-edit mx-auto">
                        <!-- <img src="" alt="Product image" class="img-fluid d-block mx-auto"> -->
                        <i class="fas fa-cloud-upload-alt tm-upload-icon"
                           onclick="document.getElementById('fileInput').click();"></i>
                     </div>
                  </div>
                  <div class="col-12">
                     <button type="submit" class="btn btn-primary btn-block text-uppercase bg-success">Design Diet</button>
                  </div>
                    <input type='text' name='action' value='generate' hidden>
                  </form>
               </div>
            </div>
         </div>
      </div>
   </div>
   <!-- <footer class="tm-footer row tm-mt-small">
      <div class="col-12 font-weight-light">
         <p class="text-center text-white mb-0 px-4 small">
            Copyright &copy; <b>2018</b> All rights reserved.

            Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
         </p>
      </div>
   </footer> -->

   <script src="js/jquery-3.3.1.min.js"></script>
   <!-- https://jquery.com/download/ -->
   <script src="jquery-ui-datepicker/jquery-ui.min.js"></script>
   <!-- https://jqueryui.com/download/ -->
   <script src="js/bootstrap.min.js"></script>
   <!-- https://getbootstrap.com/ -->
   <script>
      $(function () {
         $("#expire_date").datepicker({
            defaultDate: "10/22/2020"
         });
      });
   </script>
   
   <jsp:include page="../index/UserFooter.jsp" />
</body>

</html>