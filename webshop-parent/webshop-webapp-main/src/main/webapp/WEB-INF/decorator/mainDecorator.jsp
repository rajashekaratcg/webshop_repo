<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="baseUrl" scope="page" value="${(pageContext.request.contextPath)}/"/>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pet Supplies - Welcome to your Pet's Favorite store!</title>

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

<sitemesh:write property='head'/>    

<script>
  $('#searchButton').on('click', function () {
    $('#searchForm').submit();
  })
</script>
</head>

<body>

	<div class="container">
	
		<div class="header clearfix">
			<nav>
				<ul class="nav nav-pills pull-right">
	              	<li class="dropdown">
		                <a href="${baseUrl}product/welcome" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Products <span class="caret"></span></a>
		                <ul class="dropdown-menu">
		                	<li><a href="${baseUrl}product/welcome">All</a></li>
		                	<c:forEach items="${parentCategories}" var="parent">
							<li><a href="${baseUrl}product/category/${parent.id}">${parent.name}</a></li>
							</c:forEach>
		                </ul>
		              </li>
		            <li role="presentation"><a href="${baseUrl}">Home</a></li>  
					<sec:authorize access="isAnonymous()">
						<li role="presentation"><a href="${baseUrl}/user/signin">Sign In</a></li>	
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li role="presentation"><a href="${baseUrl}/user/signout">Sign Out</a></li>	
					</sec:authorize>
					
					<li role="presentation"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span><span class="badge">${shoppingCart.items.size()}</span></li>
				</ul>
			</nav>
			<div class="row">
			  <div class="col-lg-6">
				<h3 class="">
					Pet Supplies
					<small>All things pets!</small>
				</h3>
			  </div>
			  <div class="col-lg-6">
			  <form class="form-inline" action="${baseUrl}product/search" method="get" id="searchForm">
			    <div class="input-group">
			      <input type="text" class="form-control" name="q" placeholder="Search for..." value="${param.q}">
			      <span class="input-group-btn">
			      	 <button class="btn btn-default" type="button" id="searchButton">Go!</button>
			      </span>
			    </div>
			    </form>
			  </div>
			</div>
		</div>		 
		 
		<c:if test="${not empty param.info || not empty info}">
			<div class="alert alert-success" role="alert">${param.info}</div>
			<div class="alert alert-success" role="alert">${info}</div>
		</c:if>
		<c:if test="${not empty param.warning || not empty warning}">
			<div class="alert alert-warning" role="alert">${param.warning}</div>
			<div class="alert alert-warning" role="alert">${warning}</div>
		</c:if>		
		
		<sitemesh:write property='body'/>

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