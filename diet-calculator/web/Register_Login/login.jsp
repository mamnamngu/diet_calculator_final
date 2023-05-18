<%-- 
    Document   : login
    Created on : Feb 28, 2023, 6:22:27 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="author" content="Muhamad Nauval Azhar">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <meta name="description" content="This is a login page template based on Bootstrap 5">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    </head>

    <body>
        <section class="h-100">
            <div class="container h-100">
                <div class="row justify-content-sm-center h-100">
                    <div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
                        <div class="text-center my-1">
                            <img src="/diet-calculator/Register_Login/logo.jpg" alt="logo" width="200">
                        </div>
                        <div class="card shadow-lg">
                            <div class="card-body p-5">
                                <h1 class="fs-4 card-title fw-bold mb-4">Login</h1>
                                
                               <div class="text-danger">${error}</div>
                               
                                <form action="/diet-calculator/LoginController" method="POST" class="needs-validation" novalidate="" autocomplete="off">
                                    <input type="hidden" name="action" value="login">
                                    <div class="mb-3">
                                        <label class="mb-2 text-muted" for="username">Username</label>
                                        <input type="text" class="form-control" name="username" value="" required autofocus>
                                        <div class="invalid-feedback">
                                            Username is invalid
                                        </div>
                                    </div>

                                    <div class="mb-3">
                                        <div class="mb-2 w-100">
                                            <label class="text-muted" for="password">Password</label>
                                            <!-- <a href="forgot.html" class="float-end">
                                                    Forgot Password?
                                            </a> -->
                                        </div>
                                        <input id="password" type="password" class="form-control" name="password" required>
                                        <div class="invalid-feedback">
                                            Password is required
                                        </div>
                                    </div>

                                    <div class="d-flex align-items-center">
<!--                                        <div class="form-check">
                                            <input type="checkbox" name="remember" id="remember" class="form-check-input">
                                            <label for="remember" class="form-check-label">Remember Me</label>
                                        </div>-->
                                        <button type="submit" class="btn btn-success ms-auto">
                                            Login
                                        </button>
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer py-3 border-0">
                                <div class="text-center">
                                    Don't have an account? <a href="/diet-calculator/Register_Login/register.jsp" class="text-dark">Create One</a>
                                </div>
                            </div>
                        </div>
                        <!-- <div class="text-center mt-5 text-muted">
                                Copyright &copy; 2017-2021 &mdash; Your Company 
                        </div> -->
                    </div>
                </div>
            </div>
        </section>

        <script src="js/login.js"></script>
    </body>
</html>

