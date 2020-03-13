<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
	<title>Registration Form</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,400,700&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
	<link rel=stylesheet type="text/css" href="${pageContext.request.contextPath}/css/registration.css"> 
</head>
<body>

<nav id="mainNavbar" class="navbar navbar-expand-md navbar-dark py-0">
 		<a class="navbar-brand" href="${pageContext.request.contextPath}/">HTTR</a>
 		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
   		<span class="navbar-toggler-icon"></span>
 		</button>

 		<div class="collapse navbar-collapse" id="navbarSupportedContent">
   		<ul class="navbar-nav mr-auto">
     			<li class="nav-item active">
       			<a class="nav-link" href="${pageContext.request.contextPath}/about">ABOUT <span class="sr-only">(current)</span></a>
     			</li>
      		<li class="nav-item">
        		<a class="nav-link" href="${pageContext.request.contextPath}/contact/contactForm">CONTACT</a>
      		</li>
   		</ul>
 		</div>
</nav>

<div id="content" class="container">
	<div class="row justify-content-around">
		<div class="col-xs-4">
			<h1 class="text-center">New User</h1>
			<form:form action="${pageContext.request.contextPath}/register/processRegistrationForm" modelAttribute="customUser" enctype="multipart/form-data" method="POST">
				<c:if test="${registrationError != null}">
					<div class="alert alert-danger">
						${registrationError}
					</div>
				</c:if>
				<!-- Username -->
				
				<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text" id="basic-addon1"><i class="fas fa-user"></i></span>
				  </div>
  				  <form:input path="username" class="form-control" placeholder="Username"/>
  				  <form:errors path="username" class="alert alert-danger"/>
				</div>
				
				<!-- Password -->
				
				<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text"><i class="fas fa-key"></i></span>
				  </div>
				  <form:password path="password" class="form-control" placeholder="Password"/>
				  <form:errors path="password" class="alert alert-danger"/>
				</div>
				
				<!-- Confirm Password -->
				
				<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text"><i class="fas fa-key"></i></span>
				  </div>
				  <form:password path="matchingPassword" class="form-control" placeholder="Confirm Password"/>
				  <form:errors path="matchingPassword" class="alert alert-danger"/>
				</div>
				
				<!-- First Name -->
				
				<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text"><i class="fas fa-pencil-alt"></i></span>
				  </div>					  
  				  <form:input path="firstName" class="form-control" placeholder="First Name"/>
  				  <form:errors path="firstName" class="alert alert-danger"/>
				</div>
				
				<!-- Last Name -->
				
				<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text"><i class="fas fa-pencil-alt"></i></span>
				  </div>					  
  				  <form:input path="lastName" class="form-control" placeholder="Last Name"/>
  				  <form:errors path="lastName" class="alert alert-danger"/>
				</div>
				
				
				<!-- Email -->
				
				<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text"><i class="fas fa-at"></i></span>
				  </div>					  
  				  <form:input path="email" class="form-control" placeholder="Email"/>
  				  <form:errors path="email" class="alert alert-danger"/>
				</div>
				
				<div class="input-group mb-3">
					<label for="profilePicture" class="w-100 p-2 mx-auto text-center"><i class="far fa-image mr-2"></i>Upload Profile Picture (Optional)</label>
					<input type="file" id="profilePicture" name="image">
				</div>
				
				<!-- Submit Button -->
				<button type="submit" class="btn btn-primary w-100 mx-auto" id="submitButton">Create Account<i class="fas fa-user-plus ml-2"></i></button>
			</form:form>
		</div>
	</div>
   </div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>