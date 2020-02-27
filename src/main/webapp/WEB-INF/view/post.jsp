<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css?family=Montserrat:100,400,700&display=swap" rel="stylesheet">
  	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/post.css">	
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
	        	<a class="nav-link" href="${pageContext.request.contextPath}/home">HOME <span class="sr-only">(current)</span></a>
	      	</li>
	      	<li class="nav-item">
	        	<a class="nav-link" href="${pageContext.request.contextPath}/myProfile">PROFILE</a>
	      	</li>
	      	<li class="nav-item">
	      		<a class="nav-link" href="${pageContext.request.contextPath}/logout">LOGOUT</a>
	      	</li>
    	</ul>
  	</div>
</nav>

	<div id="content" class="container">
		<div class="row justify-content-center">
			<div class="col-md-10">
				<div id="postArea">
					<h1 id="loginHeader" class="display-4 text-center mb-4">New Post</h1>
					<form:form action="${pageContext.request.contextPath}/savePost"
								modelAttribute="newPost" method="POST" enctype="multipart/form-data">
						<div class="form-group">
							<form:textarea id="textArea" class="m-auto" cols="50" rows="10" path="content"/>
						</div>
						<div class="form-group">
							<label for = "image" class="w-50 mx-auto text-center"><i class="far fa-image mr-2"></i>Upload picture</label>
							<input type="file" id="image" name="imageFile">
						</div>
						<button type="submit" id="submitPost" class="btn btn-primary w-50 mx-auto">Submit<i class="fas fa-angle-double-right ml-2"></i></button>
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