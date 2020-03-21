<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
	<title>Home</title>
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
	        	<a class="nav-link" href="${pageContext.request.contextPath}/home">HOME<span class="sr-only">(current)</span></a>
	      	</li>
	      	<li class="nav-item">
	        	<a class="nav-link" href="${pageContext.request.contextPath}/myProfile">PROFILE</a>
	      	</li>
	      	<li class="nav-item">
	      		<a class="nav-link" href="${pageContext.request.contextPath}/logout">LOGOUT</a>
	      	</li>
	   	</ul>
	   	<ul class="navbar-nav ml-auto">
	   		<li class="nav-item">
	   			<a href="${pageContext.request.contextPath}/showPost" class="nav-link">NEW POST<i class="fas fa-pen ml-2"></i></a>
	   		</li>
	   	</ul>
 	</div>
</nav>

<div class="container">
	<c:forEach var = "post" items = "${allPosts}">
		<div class="card gedf-card mt-5 mb-5">
		    <div class="card-header">
		        <div class="d-flex justify-content-between align-items-center">
		            <div class="d-flex justify-content-between align-items-center">
		            	<div class="mr-2">
							<img class="custom-circle-image" width="45" src="${post.user.profilePicture.path}" alt="Profile Picture">
						</div>
		                <div class="ml-2">
		                    <div id="username" class="h5 m-0">@${post.user.username}</div>
		                    <div id="name" class="h7">${post.user.firstName} ${post.user.lastName}</div>
		                </div>
		            </div>
		            <c:url var="deletePost" value="/deletePost">
							<c:param name="postId" value="${post.id}"/>
						</c:url>
						<c:if test="${post.user.id == currentUser.id}">
							<a href="${deletePost}" onclick = "if(!(confirm('Are you sure you want to delete this post?'))) return false"><i class="fas fa-trash-alt"></i></a>
						</c:if>
		        </div>
		
		    </div>
		    <div class="card-body">
		    	<c:set var="Date" value="${post.date}" />
		        <div class="text-muted h7 mb-2"> <i class="fa fa-clock-o"></i><fmt:formatDate type="both" value="${Date}"/></div>
		        <a class="card-link" href="#">
		            <h5 class="card-title"> Lorem ipsum dolor sit amet consectetur adipisicing elit. Velit consectetur
		                deserunt illo esse distinctio.</h5>
		        </a>
		
		        <p class="card-text">
		           ${post.content}
		        </p>
		        <c:if test = "${post.postImage != null}">
		        	<div class="post-image">
						<img class="img" src="${post.postImage.path}">
					</div>
				</c:if>
		    </div>
		</div>
	</c:forEach>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>