<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  	<link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,400,700&display=swap" rel="stylesheet">
  	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/about.css">
	<title>About</title>
</head>

<body>
<nav id="mainNavbar" class="navbar navbar-expand-md navbar-dark fixed-top py-0">
  		<a class="navbar-brand" href="${pageContext.request.contextPath}/">HTTR</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>

  	<div class="collapse navbar-collapse" id="navbarSupportedContent">
    	<ul class="navbar-nav mr-auto">
	      	<li class="nav-item">
	        	<a class="nav-link" href="${pageContext.request.contextPath}/about">ABOUT</a>
	      	</li>
	      	<li class="nav-item">
	      		<a class="nav-link" href="${pageContext.request.contextPath}/contact/contactForm">CONTACT</a>
	      	</li>
    	</ul>
  	</div>
</nav>

<div id="section" class="container">
	<div class="row">
		<div class="col-xs-4">
		  <h1 class="text-center">About</h1>
		  <hr>
		  	<p class="text-center">Skins Talk is a website where fans of the Washington Redskins can go to discuss anything about the organization! I've always had a love for the team and I wanted to create something that expresses that love while further advancing my developer skills. </p>			 
		</div>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>

</html>