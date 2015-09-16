<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUrl" scope="page" value="${(pageContext.request.contextPath)}/"/>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pet Supplies - Admin</title>

<!-- Bootstrap core CSS -->
<link href="${baseUrl}styles/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${baseUrl}styles/bootstrap/theme/theme.css" rel="stylesheet">

<!-- Application specific styling  -->
<link href="${baseUrl}styles/app.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="${baseUrl}scripts/bootstrap/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- Angular libs -->
<script src="${baseUrl}scripts/angular/angular.js"></script>		
<script src="${baseUrl}scripts/angular/angular-resource.min.js"></script>		
<script src="${baseUrl}scripts/angular/angular-mocks.js"></script>		
<script src="${baseUrl}scripts/angular/angular-ui-router.js"></script>	
		
<!-- Angular Module -->
<script src="${baseUrl}scripts/app/app.js"></script>	
<!-- 		<script src="common/common.services.js"></script>	
		<script src="common/productResource.js"></script>	
		<script src="common/productResourceMock.js"></script>	 -->

<!-- Controllers -->
<%-- <script src="${baseUrl}scripts/app/product/productListController.js"></script> --%>	


</head>

<body>

	<div class="container">
		<div class="header clearfix">
			<nav>
				<ul class="nav nav-pills pull-right">
					<li role="presentation" class="active"><a href="${baseUrl}">Home</a></li>
					<li role="presentation"><a href="${baseUrl}product/welcome">Products</a></li>
					<li role="presentation"><a href="${baseUrl}category/welcome">Categories</a></li>
					<li role="presentation"><a
						href="${baseUrl}user/signout">Sign Out</a></li>
				</ul>
			</nav>
			<h3 class="text-muted">
				Pet Supplies <B>Admin</B>
			</h3>
		</div>
		<c:if test="${not empty param.info}">
			<div class="alert alert-success" role="alert">${param.info}</div>
		</c:if>
		<c:if test="${not empty param.warning}">
			<div class="alert alert-warning" role="alert">${param.warning}</div>
		</c:if>		

	<div class="jumbotron">
		<h1>Pet Supplies Admin</h1>
		<p class="lead">Welcome to the Pet Supplies Administrator module.
			Here you can manage the Products and Categories sections.</p>
		<!-- <p><a class="btn btn-lg btn-success" href="#" role="button">Sign up today</a></p> -->
	</div>

	<div class="row marketing">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Admin options</h3>
			</div>
			<div class="panel-body">
				<p>
					<a href="product/welcome"><button type="button"
							class="btn btn-lg btn-default">Products</button></a> <a
						href="category/welcome"><button type="button"
							class="btn btn-lg btn-default">Categories</button></a>
				</p>
			</div>
		</div>
	</div>

		<footer class="footer">
			<p>&copy; Rajashekar Subramany 2015</p>
		</footer>

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