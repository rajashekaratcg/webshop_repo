<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUrl" scope="page" value="${(pageContext.request.contextPath)}/"/>

<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

<ol class="breadcrumb">
  <li><a href="${baseUrl}product/welcome">Product</a></li>
  <li><a href="${baseUrl}product/category/${product.category.id}">${product.category.name}</a></li>
  <li class="active">${product.name}</li>
</ol>


<div class="page-header">
  <h1>${product.name}</h1>
  <h2><small>&#8364; ${product.price}</small></h2>
</div>

<p>
<form class="form-inline" action="${baseUrl}user/shopping/cart/add" method="post">
  <div class="form-group">
    <label class="" for="quantity">Qty</label>
    <div class="input-group">
      <input type="hidden" name="productId" value="${product.id}">	
      <input type="text" class="form-control"  name="quantity" id="quantity" value="1">
    </div>
  </div>
  <button type="submit" class="btn btn-primary">Add to Cart</button>
</form>
</p>

<div class="well">${product.description}</div>

</body>
</html>