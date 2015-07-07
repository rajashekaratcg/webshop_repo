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
		<h3>Your <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Shopping Cart!</h3>
	</div>
	<div class="row marketing">



		<table class="table table-hover">
			<thead>
				<tr>

					<th>Product</th>
					<th>Qty</th>
					<th colspan="2">Price</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${shoppingCart.items}" var="shoppingCart">
					<tr>
						<td>
						<p class="lead"><a href="${baseUrl}product/${shoppingCart.product.id}">${shoppingCart.product.name}</a></p>
						</td>
						<td>${shoppingCart.quantity}</td>
						<td>${shoppingCart.product.price}</td>
						<td><form action="${baseUrl}user/shopping/cart/remove" method="post"><input type="hidden" name="productId" value="${shoppingCart.product.id}"><input type="submit" value="Remove" class="btn btn-warning btn-xs"></form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3>
			Total Amount: &#8364; ${shoppingCart.amount}
		</h3>
		<p>
			<a href="${baseUrl}user/shopping/cart/checkout" class="btn btn-primary">Checkout &raquo;</a>
		</p>

	</div>
</body>
</html>