<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/test/uploadTest" enctype="multipart/form-data" method="POST">
		<input type="file" name="image">
		<input type="submit">
	</form:form>
</body>
</html>