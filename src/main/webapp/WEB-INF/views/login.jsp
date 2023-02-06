<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign In Form</title>


<!-- Font Icon -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/material-design-iconic-font.min.css" />">


<!-- Main css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/signup.css" />">
<script type="text/javascript">
	setTimeout(function() {
		$('#hide').fadeOut('fast');
	}, 5000);
	setTimeout(function() {
		$('#hide1').fadeOut('fast');
	}, 5000);
</script>
</head>
<body>
	<div class="main">

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					
					<div class="signin-image">
						<figure>
							<img src="<c:url value="/resources/img/signin-image.jpg" />"
								alt="Image">
						</figure>
						<a href="registration" class="signup-image-link">Create an
							account</a>
					</div>

					<div class="signin-form">
					<h2 style="color: green;" id="hide" class="text-center">${succesmsg}</h2>
					<h2 style="color: red;" id="hide1" class="text-center">${succeserr}</h2>
						<h2 class="form-title">Sign in</h2>
						<form method="post" action="loginuser" class="register-form"
							id="login-form">
							<div class="form-group">
								<label for="username"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="username" id="username"
									placeholder="Your Email" required="required"/>
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="password"
									placeholder="Password" required="required"/>
							</div>
							<div class="form-group">
								<input type="checkbox" name="remember-me" id="remember-me"
									class="agree-term" /> <label for="remember-me"
									class="label-agree-term"><span><span></span></span>Remember
									me</label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Log in" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>

	</div>
	   
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	
</body>

</html>