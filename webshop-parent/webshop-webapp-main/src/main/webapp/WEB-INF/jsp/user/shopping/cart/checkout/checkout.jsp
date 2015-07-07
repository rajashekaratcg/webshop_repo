<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="baseUrl" scope="page" value="${(pageContext.request.contextPath)}/"/>

<!DOCTYPE html>
<html lang="en">
<head>
<script>
$(document).ready(function(){
  $('#sameAsAbove').on('click', function () {
    if (this.checked) {
		$('#billingAddress_address').val($('#shippingAddress_address').val());
		$('#billingAddress_city').val($('#shippingAddress_city').val());
		$('#billingAddress_state').val($('#shippingAddress_state').val());
		$('#billingAddress_zipcode').val($('#shippingAddress_zipcode').val());
		$('#billingAddress_country').val($('#shippingAddress_country').val());
    } else {
		$('#billingAddress_address').val('');
		$('#billingAddress_city').val('');
		$('#billingAddress_state').val('');
		$('#billingAddress_zipcode').val('');
		$('#billingAddress_country').val('');
    }
  });
});
</script>
</head>
<body>

<div class="page-header">
  <h2>Confirm Order</h2><h2><small>Checkout Step 2 of 2</small></h2>
</div>

<form:form commandName="order" methodParam="POST" cssClass="form-horizontal" action="${baseUrl}user/shopping/cart/checkout">
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Shipping Address</h3>
  </div>
  <div class="panel-body">

	<div class="form-group">
		<spring:message code="address" var="address" />
		<label for="shippingAddress.address" class="col-sm-2 control-label">${address}</label>
		<div class="col-sm-10">
			<form:input path="shippingAddress.address" cssClass="form-control" id="shippingAddress_address" cssErrorClass="error"  />
		</div>
	</div>	
	<div class="form-group">
		<spring:message code="city" var="city" />
		<label for="shippingAddress.city" class="col-sm-2 control-label">${city}</label>
		<div class="col-sm-10">
			<form:input path="shippingAddress.city" cssClass="form-control" id="shippingAddress_city" cssErrorClass="error"  />
		</div>
	</div>	
	<div class="form-group">
		<spring:message code="state" var="state" />
		<label for="shippingAddress.state" class="col-sm-2 control-label">${state}</label>
		<div class="col-sm-10">
			<form:input path="shippingAddress.state" cssClass="form-control" id="shippingAddress_state" cssErrorClass="error"  />
		</div>
	</div>	
	<div class="form-group">
		<spring:message code="zipcode" var="zipcode" />
		<label for="shippingAddress.zipcode" class="col-sm-2 control-label">${zipcode}</label>
		<div class="col-sm-10">
			<form:input path="shippingAddress.zipcode" cssClass="form-control" id="shippingAddress_zipcode" cssErrorClass="error"  />
		</div>
	</div>	
	<div class="form-group">
		<spring:message code="country" var="country" />
		<label for="shippingAddress.country" class="col-sm-2 control-label">${country}</label>
		<div class="col-sm-10">
			<form:input path="shippingAddress.country" cssClass="form-control" id="shippingAddress_country" cssErrorClass="error"  />
		</div>
	</div>

  </div>
</div>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Billing Address</h3>
  </div>
  <div class="panel-body">

	<p>
	<input type="checkbox" id="sameAsAbove"> Same as above
	</p>

	<div class="form-group">
		<spring:message code="address" var="address" />
		<label for="billingAddress.address" class="col-sm-2 control-label">${address}</label>
		<div class="col-sm-10">
			<form:input path="billingAddress.address" cssClass="form-control"id="billingAddress_address"  cssErrorClass="error"  />
		</div>
	</div>	
	<div class="form-group">
		<spring:message code="city" var="city" />
		<label for="billingAddress.city" class="col-sm-2 control-label">${city}</label>
		<div class="col-sm-10">
			<form:input path="billingAddress.city" cssClass="form-control" id="billingAddress_city" cssErrorClass="error"  />
		</div>
	</div>	
	<div class="form-group">
		<spring:message code="state" var="state" />
		<label for="billingAddress.state" class="col-sm-2 control-label">${state}</label>
		<div class="col-sm-10">
			<form:input path="billingAddress.state" cssClass="form-control" id="billingAddress_state" cssErrorClass="error"  />
		</div>
	</div>	
	<div class="form-group">
		<spring:message code="zipcode" var="zipcode" />
		<label for="billingAddress.zipcode" class="col-sm-2 control-label">${zipcode}</label>
		<div class="col-sm-10">
			<form:input path="billingAddress.zipcode" cssClass="form-control" id="billingAddress_zipcode" cssErrorClass="error"  />
		</div>
	</div>	
	<div class="form-group">
		<spring:message code="country" var="country" />
		<label for="billingAddress.country" class="col-sm-2 control-label">${country}</label>
		<div class="col-sm-10">
			<form:input path="billingAddress.country" cssClass="form-control" id="billingAddress_country" cssErrorClass="error"  />
		</div>
	</div>

  </div>
</div>

<div class="form-group">
	<div class="col-sm-offset-2 col-sm-10">
		<button type="submit" class="btn btn-primary">Confirm Order</button>
		<a href="${pageContext.request.contextPath}/" class="btn btn-default">Cancel</a>
	</div>
</div>
	
</form:form>

</body>
</html>