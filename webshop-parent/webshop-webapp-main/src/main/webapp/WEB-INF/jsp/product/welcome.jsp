<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUrl" scope="page" value="${(pageContext.request.contextPath)}/"/>

<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

	<div class="jumbotron">
		<h1>Products</h1>
	</div>
	<div class="row marketing">

		

		<table class="table table-hover">
			<thead>
				<tr>

					<th>Products</th>
					<th>Price</th>
					<th>Category</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products.content}" var="product">
					<tr>
						<td>
						<p class="lead"><a href="${baseUrl}product/${product.id}">${product.name}</a></p>
						<p>${product.description}</p>
						</td>
						<td>${product.price}</td>
						<td>${product.category.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>
			Total products: ${products.totalElements}
		</p>

	</div>
</body>
</html>