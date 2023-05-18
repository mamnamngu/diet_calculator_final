<%-- 
    Document   : register
    Created on : Feb 28, 2023, 6:24:02 PM
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
	<title>Register</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>

<body>
	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
				<div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
					<div class="text-center my-1">
						<img src="logo.jpg" alt="logo" width="200">
					</div>
					<div class="card shadow-lg">
						<div class="card-body p-5">
							<h1 class="fs-4 card-title fw-bold mb-4">Register</h1>
							<form action="/diet-calculator/LoginController" method="GET" class="needs-validation" novalidate="" autocomplete="off">
                                                            <input type="hidden" name="action" value="register">
								<div class="mb-3">
									<label class="mb-2 text-muted" for="username">Username</label>
									<input type="text" class="form-control" name="username" value="" required autofocus>
									<div class="invalid-feedback">
										Name is required	
									</div>
								</div>

								<div class="mb-3">
									<label class="mb-2 text-muted" for="dob">Date of Birth</label>
									<input id="name" type="date" class="form-control" name="dob" value="" required>
									<div class="invalid-feedback">
										Date of Birth is required
									</div>
								</div>

								<div class="mb-3">
									<label class="mb-2 text-muted" for="phone">Phone</label>
									<input id="name" type="text" class="form-control" name="phone" value="" required>
									<div class="invalid-feedback">
										Phone is required
									</div>
								</div>

								<div class="mb-3">
									<label class="mb-2 text-muted" for="address">Address</label>
									<input id="name" type="text" class="form-control" name="address" value="" required>
									<div class="invalid-feedback">
										Address is required
									</div>
								</div>

								<div class="mb-3">
									<label class="mb-2 text-muted" for="email">E-Mail Address</label>
									<input id="email" type="email" class="form-control" name="email" value="" required>
									<div class="invalid-feedback">
										Email is invalid
									</div>
								</div>

								<div class="mb-3">
									<label class="mb-2 text-muted" for="password">Password</label>
									<input id="password" type="password" class="form-control" name="password" required>
								    <div class="invalid-feedback">
								    	Password is required
							    	</div>
								</div>

								<p class="form-text text-muted mb-3">
									By registering you agree with our terms and condition.
								</p>

								<div class="align-items-center d-flex">
									<button type="submit" class="btn btn-success ms-auto">
										Register	
									</button>
								</div>
							</form>
						</div>
						<div class="card-footer py-3 border-0">
							<div class="text-center">
								Already have an account? <a href="/diet-calculator/Register_Login/login.jsp" class="text-dark">Login</a>
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

