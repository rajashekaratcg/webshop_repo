<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Pet Supplies - Admin</title>

    <!-- Bootstrap core CSS -->
    <link href="../styles/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="../styles/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../styles/bootstrap/theme/theme.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../scripts/bootstrap/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>      

	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">${mode} Product ${mode == 'Edit' ? product.id : ''}</h3>
	  </div>
	  <div class="panel-body">
    	<form:form commandName="product" methodParam="POST">
			<table>
				<tr>
					<td><spring:message code="name" /></td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:message code="description" /></td>
					<td><form:input path="description" /></td>
					<td><form:errors path="description" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:message code="price" /></td>
					<td><form:input path="price" /></td>
					<td><form:errors path="price" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:message code="category" /></td>
					<td>
					<form:select path="category">
				    	<form:options items="${categories}" itemValue="id" itemLabel="name"/>
					</form:select>
					</td>
					<td><form:errors path="category" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="3">
					<input type="submit" class="btn btn-default" value="Update" />
					<a href="welcome"><button type="button" class="btn btn-default">Cancel</button></a>
					</td>					
				</tr>
			</table>
		</form:form>
	  </div>
	</div>
          




	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../scripts/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../scripts/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>