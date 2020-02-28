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
	<title>Contact Form</title>
</head>
<body>
	<h1>Contact Form</h1>
	<form:form action="/sendEmail" modelAttribute="contact" method="POST">
		<label for="name">Name:</label>
		<form:input id="name" path="name"/>
		<label for="email">Email:</label>
		<form:input id="email" path="email"/>
		<label for="subject">Subject:</label>
		<form:input id="subject" path="subject"/>
		<label for="content">Content:</label>
		<form:textarea id="content" path="content" rows="5" cols="20"/>
		<input type="submit" value="Send">
	</form:form>
</body>
</html>