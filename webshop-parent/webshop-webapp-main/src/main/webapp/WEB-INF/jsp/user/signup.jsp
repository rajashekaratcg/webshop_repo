<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
</head>

<body>

<h3>Sign Up!</h3>
<form:form commandName="user" methodParam="POST" cssStyle="form-horizontal">
	<form:errors path="*" cssClass="alert alert-danger" element="div" />
	
	<div class="form-group">
		<spring:message code="fullName" var="fullName" />
		<label for="fullName" class="col-sm-2 control-label">${fullName}</label>
		<div class="col-sm-10">
			<form:input path="fullName" cssClass="form-control" cssErrorClass="error"  />
			<!-- <input type="text" class="form-control" id="inputFullName" placeholder="FullName"> -->
		</div>
	</div>
	
	<div class="form-group">
		<spring:message code="username" var="username" />
		<label for="fullName" class="col-sm-2 control-label">${username}</label>
		<div class="col-sm-10">
			<form:input path="username" cssClass="form-control" cssErrorClass="error"  />
		</div>
	</div>	
	
	<div class="form-group">
		<spring:message code="password" var="password" />
		<label for="password" class="col-sm-2 control-label">${password}</label>
		<div class="col-sm-10">
			<form:password path="password"  cssClass="form-control" cssErrorClass="error"  />		
		</div>
	</div>
	
	<div class="form-group">
		<spring:message code="email" var="email" />
		<label for="email" class="col-sm-2 control-label">${email}</label>
		<div class="col-sm-10">
			<form:input path="email" cssClass="form-control" cssErrorClass="error" />
		</div>
	</div>	
	
	<p>
	Address
	</p>
	<div class="form-group">
		<spring:message code="address" var="address" />
		<label for="userAddress[0].address" class="col-sm-2 control-label">${address}</label>
		<div class="col-sm-10">
			<form:input path="userAddress[0].address" cssClass="form-control" cssErrorClass="error"  />
		</div>
	</div>	
	<div class="form-group">
		<spring:message code="city" var="city" />
		<label for="userAddress[0].city" class="col-sm-2 control-label">${city}</label>
		<div class="col-sm-10">
			<form:input path="userAddress[0].city" cssClass="form-control" cssErrorClass="error"  />
		</div>
	</div>	
	<div class="form-group">
		<spring:message code="state" var="state" />
		<label for="userAddress[0].state" class="col-sm-2 control-label">${state}</label>
		<div class="col-sm-10">
			<form:input path="userAddress[0].state" cssClass="form-control" cssErrorClass="error"  />
		</div>
	</div>	
	<div class="form-group">
		<spring:message code="zipcode" var="zipcode" />
		<label for="userAddress[0].zipcode" class="col-sm-2 control-label">${zipcode}</label>
		<div class="col-sm-10">
			<form:input path="userAddress[0].zipcode" cssClass="form-control" cssErrorClass="error"  />
		</div>
	</div>	
	<div class="form-group">
		<spring:message code="country" var="country" />
		<label for="userAddress[0].country" class="col-sm-2 control-label">${country}</label>
		<div class="col-sm-10">
			<form:input path="userAddress[0].country" cssClass="form-control" cssErrorClass="error"  />
		</div>
	</div>
		
		
	<p>
	Phone
	</p>	
	<div class="form-group">
		<spring:message code="type" var="type" />
		<label for="userPhones[0].type" class="col-sm-2 control-label">${type}</label>
		<div class="col-sm-10">
			<form:select path="userPhones[0].type" cssClass="form-control" cssErrorClass="error">
				<form:options />
			</form:select>
			<%-- <form:options items="${phoneTypes}" itemValue="name" itemLabel="name" /> --%>
		</div>
	</div>	
	<div class="form-group">
		<spring:message code="number" var="number" />
		<label for="userPhones[0].number" class="col-sm-2 control-label">${number}</label>
		<div class="col-sm-10">
			<form:input path="userPhones[0].number" cssClass="form-control" cssErrorClass="error"  />
		</div>
	</div>		
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Create account</button>
			<a href="${pageContext.request.contextPath}/"><button class="btn btn-default">Later...</button></a>
		</div>
	</div>
</form:form>

	
</body>
</html>