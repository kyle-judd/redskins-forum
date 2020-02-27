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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
	<title>Home</title>
	<!-- Janky solution to profile picture -->
	<style type="text/css">
		.avatar {
			border-radius: 50%;
			height: 100px;
			width: 100px;
			background-image: url("<c:url value="profile/picture/${currentUser.profilePicture.filename}"/>");
		}
		
		.default-avatar {
			border-radius: 50%;
			height: 100px;
			width: 100px;
			background-image: url("<c:url value="profile/picture/71ed4d29fbad769786476d37b35c5441.jpg"/>");
		}
		
		.cover {
			background-size: cover;
			background-position: center;	
		}
		
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			$('.image').click(function() {
				var img = $(this).attr("src");
				var appear_image = "<div id='appear_image_div' onClick='closeImage()'></div>";
				$('body').append(appear_image);
			});
		});
		function closeImage() {
				$('#appear_image_div').remove();
			}
		
	</script>	
</head>
<body>
	<nav id="mainNavbar" class="navbar navbar-expand-md navbar-dark fixed-top py-0">
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
	<div id="postChain">
		<c:forEach var = "post" items = "${allPosts}">
			<div class="row justify-content-center">	
				<div id="postArea" class="col-sm-4">
					<div class="row">
						<div class="col-md-6">
							<c:choose>
								<c:when test="${post.user.profilePicture != null}">
									<div class="avatar cover">
									
									</div>
								</c:when>
								<c:when test="${post.user.profilePicture == null}">
									<div class="default-avatar cover">
									
									</div>
								</c:when>
							</c:choose>
						</div>
						<div class="col-md-6">
							<div class="post-info">
								<p class="">User: <span id="username">${post.user.username}</span></p>
								<p>Time: ${post.date}</p>
							</div>
						</div>
					</div>
						
						
						<div>
							${post.content}
						</div>
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

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>