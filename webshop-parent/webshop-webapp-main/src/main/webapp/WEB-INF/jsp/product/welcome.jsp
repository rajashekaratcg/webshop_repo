<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

	<div class="jumbotron">
		<h1>Products</h1>
	</div>
	<div class="row marketing">

		

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Category</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products.content}" var="product">
					<tr>
						<td>${product.name}</td>
						<td>${product.description}</td>
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