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
  	<link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,400,700&display=swap" rel="stylesheet">
  	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/myProfile.css">
	
	<!-- Janky solution to profile picture -->
	<style type="text/css">
		.avatar {
			border-radius: 50%;
			height: 200px;
			width: 200px;
			background-image: url("<c:url value="profile/picture/${loggedInUser.profilePicture.filename}"/>");
		}
		
		.cover {
			background-size: cover;
			background-position: center;	
		}
		
	</style>
	<title>My Profile</title>
</head>
<body>
	
	<c:url var="editProfile" value="/editProfile">
		<c:param name="userId" value="${loggedInUser.id}"/>
	</c:url>

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
		        	<a class="nav-link" href="${editProfile}">EDIT PROFILE</a>
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
		<div class="row justify-content-around py-5">
			<div class="col-md-12 px-0">
				<div id="profileArea" class="mx-auto">
					<h1 id="header" class="text-center">My Profile</h1>
					<hr>
					<div class="row">
						<div class="col-md-6 pr-0 divider">
							<c:if test="${loggedInUser.profilePicture != null}">
								<div class="row">
									<div class="col-md-12">
										<div class="avatar cover mx-auto">
												
										</div>
									</div>
								</div>
							</c:if>
							<div class="row">
								<div class="col-md-12 text-center group-info">
									<p class="ml-5 mb-5 user-info-heading">Name: <span class="user-info">${loggedInUser.firstName} ${loggedInUser.lastName}</span></p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 text-center group-info">
									<p class="ml-5 mb-5 user-info-heading">Username: <span class="user-info">${loggedInUser.username}</span></p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 text-center group-info">
									<p class="ml-5 mb-5 user-info-heading">Email: <span class="user-info">${loggedInUser.email}</span></p>
								</div>
							</div>
					
						</div>
						<div class="col-md-6 pl-0">
							<p class="lead text-center post-header">Your Posts</p>
							<div id="postChain">
								<c:forEach var = "post" items = "${postsByUser}">
									<div class="row justify-content-center">	
										<div id="postArea" class="col-md-8">
											${post.content}
											<p>Submitted by: <span id="username">${post.user.username}</span> at ${post.date}</p>
											<c:if test = "${post.postImage != null}">
												<div id="imageArea">
													<img class="image" src="<c:url value="posts/images/${post.postImage.fileName}"/>">
												</div>
											</c:if>
											<c:url var="deletePost" value="/deletePost">
												<c:param name="postId" value="${post.id}"/>
											</c:url>
											<c:if test="${post.user.id == currentUser.id}">
												<a href="${deletePost}" onclick = "if(!(confirm('Are you sure you want to delete this post?'))) return false"><i class="fas fa-trash-alt"></i></a>
											</c:if>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>	
	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>