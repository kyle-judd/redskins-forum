<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
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
    <div class="row justify-content-center my-2 mx-1">
        <div class="col-lg-8 order-lg-2 custom-background px-0">
            <ul class="nav nav-tabs custom-header-color">
                <li class="nav-item">
                    <a href="" data-target="#profile" data-toggle="tab" class="nav-link">Profile</a>
                </li>
                <li class="nav-item">
                    <a href="" data-target="#yourposts" data-toggle="tab" class="nav-link">Your Posts</a>
                </li>
                <li class="nav-item">
                    <a href="" data-target="#edit" data-toggle="tab" class="nav-link">Edit</a>
                </li>
            </ul>
            <div class="custom-body-color tab-content py-4">
                <div class="tab-pane active" id="profile">
                    <h5 class="mb-3 ml-1">User Profile</h5>
                    <div class="row">
                        <div class="col-md-6">
                            <h6 class="ml-1">Username:</h6>
                            <p class="ml-1">
                                ${loggedInUser.username}
                            </p>
                            <h6 class="ml-1">Name:</h6>
                            <p class="ml-1">
                                ${loggedInUser.firstName} ${loggedInUser.lastName}
                            </p>
                            <h6 class="ml-1">Email:</h6>
                            <p class="ml-1">
                                ${loggedInUser.email}
                            </p>
                        </div>
                          <div class="col-lg-4 order-lg-1 text-center">
				            <img src="${loggedInUser.profilePicture.path}" class="mx-auto img-fluid img-circle d-block custom-circle-image" alt="avatar">
				            <form:form action="${pageContext.request.contextPath}/editProfilePicture" enctype="multipart/form-data" method="POST">
					            <h6 class="mt-2">Upload a different photo</h6>
					            <label class="custom-file">
					                <input type="file" id="file" name="profile-image" class="custom-file-input">
					                <span class="custom-file-control">Choose file</span>
					            </label>
					            <input type="submit">
				            </form:form>
				          </div>
                    </div>
                    <!--/row-->
                </div>
                <div class="tab-pane" id="yourposts">
                    	<c:forEach var = "post" items = "${postsByUser}">
							<div class="card gedf-card mt-5 mb-5">
							    <div class="card-header">
							        <div class="d-flex justify-content-between align-items-center">
							            <div class="d-flex justify-content-between align-items-center">
							            	<c:choose>
												<c:when test="${post.user.profilePicture != null}">
													<div class="mr-2">
														<img class="custom-circle-image" width="45" src="<c:url value="profile/picture/${post.user.profilePicture.filename}"/>" alt="Profile Picture">
													</div>
												</c:when>
												<c:when test="${post.user.profilePicture == null}">
													<div class="mr-2">
														<img class="custom-circle-image" width="45" src="<c:url value="profile/picture/71ed4d29fbad769786476d37b35c5441.jpg"/>">
													</div>
												</c:when>
											</c:choose>
							                <div class="ml-2">
							                    <div id="username" class="h5 m-0">@${post.user.username}</div>
							                    <div id="name" class="h7">${post.user.firstName} ${post.user.lastName}</div>
							                </div>
							            </div>
							            <c:url var="deletePost" value="/deletePost">
												<c:param name="postId" value="${post.id}"/>
											</c:url>
											<c:if test="${post.user.id == loggedInUser.id}">
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
											<img class="img" src="<c:url value="posts/images/${post.postImage.fileName}"/>">
										</div>
									</c:if>
							    </div>
							</div>
						</c:forEach>
                </div>
                <div class="tab-pane" id="edit">
                    <form:form role="form" modelAttribute="editUser" action="${pageContext.request.contextPath}/editUser" method="POST">
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">First name</label>
                            <div class="col-lg-9">
                                <form:input class="form-control" placeholder="${loggedInUser.firstName}" path="firstName"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Last name</label>
                            <div class="col-lg-9">
                                <form:input class="form-control" placeholder="${loggedInUser.lastName}" path="lastName"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Email</label>
                            <div class="col-lg-9">
                                <form:input class="form-control" placeholder="${loggedInUser.email}" path="email"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Username</label>
                            <div class="col-lg-9">
                                <form:input class="form-control" placeholder="${loggedInUser.username}" path="username"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Password</label>
                            <div class="col-lg-9">
                                <form:password class="form-control" placeholder="New Password" path="password"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Confirm password</label>
                            <div class="col-lg-9">
                                <form:password class="form-control" placeholder="Confirm New Password" path="matchingPassword"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label"></label>
                            <div class="col-lg-9">
                                <input type="reset" class="btn btn-secondary" value="Cancel">
                                <input type="submit" class="btn btn-primary" value="Save Changes">
                            </div>
                        </div>
                    </form:form>
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