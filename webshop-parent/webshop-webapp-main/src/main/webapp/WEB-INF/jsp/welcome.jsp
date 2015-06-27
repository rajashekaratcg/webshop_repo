<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
</head>

<body>
	<div class="jumbotron">
		<h1>Pet Supplies</h1>
		<p class="lead">
			Welcome to Pet Supplies. <br />Your one-stop shop for all things
			pets!
		</p>
		<sec:authorize  access="isAnonymous()">
		<p>
			<a class="btn btn-lg btn-success" href="user/signup" role="button">Sign up today</a>
		</p>
		</sec:authorize>
	</div>

	<div class="row marketing">

		<div class="col-lg-6">

			<h4>Browse</h4>
			<ul class="list-group">
				<c:forEach items="${parentCategories}" var="parent">
					<li class="list-group-item"><a href="${baseUrl}product/category/${parent.id}">${parent.name}</a></li>					
				</c:forEach>
			</ul>
		</div>

		<div class="col-lg-6">
			<h4>Latest products</h4>
			<ul class="list-group">
				<c:forEach items="${products.content}" var="product">
					<li class="list-group-item">
						<p>
							<a href="product/welcome">${product.name}</a> - &#8364;
							${product.price}
						</p>
						<p><c:out value="${fn:substring(product.description,0,100)}"/>${fn:length(product.description)>100 ? '...' : ''}</p>
					</li>
				</c:forEach>
			</ul>

		</div>


	</div>
</body>
</html>