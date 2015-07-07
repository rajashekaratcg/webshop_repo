<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUrl" scope="page" value="${(pageContext.request.contextPath)}/"/>

<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

<div class="page-header">
  <h2>Select your Shipping Address</h2><h2><small>Checkout Step 1 of 2</small></h2>
</div>


<div class="row">
<c:forEach items="${addresses}" var="address" varStatus="count">
  	<div class="col-md-6">
		<div class="panel panel-info">
		  <div class="panel-body">
			  ${address.address}<br>
			  ${address.city}, ${address.state}<br>
			  ${address.zipcode}<br>
			  ${address.country}
		  </div>
		  <div class="panel-footer"><a href="${baseUrl}user/shopping/cart/checkout/selectAddress/${address.id}" class="btn btn-default">Select Address &raquo;</a></div>
		</div>
	</div>  
</c:forEach>
</div>
	

<p>
<a href="${baseUrl}user/shopping/cart/checkout/selectAddress/0" class="btn btn-primary">New Address &raquo;</a>
</p>

</body>
</html>