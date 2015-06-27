<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUrl" scope="page"
	value="${(pageContext.request.contextPath)}/" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Error! Unauthorized access</title>
</head>
<body>
	<h2>Sorry, you are not authorized to view the requested resource.</h2>
	<p>
		<a href="${baseUrl}welcome">Return to home.</a>
	</p>
</body>
</html>