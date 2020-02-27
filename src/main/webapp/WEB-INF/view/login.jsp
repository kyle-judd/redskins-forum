<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,400,700&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
	<title>Login</title>
</head>
<body>
	<nav id="mainNavbar" class="navbar navbar-dark navbar-expand-md py-0">
		<a href="${pageContext.request.contextPath}/" class="navbar-brand">HTTR</a>
		<button class="navbar-toggler" data-toggle="collapse" data-target="#navLinks" aria-label="toggle navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navLinks">
			<ul class="navbar-nav">
				<li class="nav-item"><a href="" class="nav-link">ABOUT</a></li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item"><a href="" class="nav-link">CONTACT</a></li>
			</ul>
		</div>
	</nav>

	<div id="content" class="container">
		<div class="row justify-content-center">
			<div class="col-md-10">
				<div id="loginArea">
					<h1 id="loginHeader" class="display-4 text-center mb-4">Login</h1>
					<c:if test = "${param.error != null}">           
						<div id="loginError" class="alert alert-danger w-50 mx-auto">
							Invalid username or password.
						</div>
					</c:if>											
					<form:form action="loginProcessing" method="POST">
						<div class="form-group">
							<input type="text" name="username" placeholder="Username" class="form-control w-50 m-auto">
						</div>
						<div class="form-group">
							<input type="password" name="password" placeholder="Password" class="form-control w-50 m-auto">
						</div>
						<button type="submit" id="loginButton" class="btn btn-primary w-50 mx-auto">Submit<i class="fas fa-angle-double-right ml-2"></i></button>
					</form:form>
				</div>
			</div>
		</div>
	</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>