<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="baseUrl" scope="page" value="${(pageContext.request.contextPath)}/"/>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pet Supplies Admin</title>

<!-- Bootstrap core CSS -->
<link href="${baseUrl}styles/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${baseUrl}styles/bootstrap/theme/theme.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="${baseUrl}scripts/bootstrap/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="container">
			<div class="header clearfix">
			<nav>
				<ul class="nav nav-pills pull-right">
					<%-- <li role="presentation" class="active"><a href="${baseUrl}">Home</a></li> --%>
				</ul>
			</nav>
			<h3 class="text-muted">
				Pet Supplies Admin
			</h3>
		</div>
	<c:if test="${not empty param.error}">
		<div class="alert alert-danger" role="alert">Invalid ID or password. Please try again.</div>
	</c:if>
	<c:if test="${not empty param.info}">
		<div class="alert alert-success" role="alert">${param.info}</div>
	</c:if>
	
      <form action="${baseUrl}j_spring_security_check" method="post" class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="j_username" class="sr-only">Username</label>
        <input type="text" name="j_username" id="j_username" class="form-control" placeholder="Username" maxlength="100" required autofocus>
        
        <label for="j_password" class="sr-only">Password</label>
        <input type="password" name="j_password" id="j_password" class="form-control" placeholder="Password" maxlength="50" required>       
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>   
      </form>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="${baseUrl}scripts/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${baseUrl}scripts/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${baseUrl}scripts/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>