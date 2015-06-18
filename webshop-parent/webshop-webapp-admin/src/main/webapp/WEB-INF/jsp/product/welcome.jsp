<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
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
    <script src="../scripts/bootstrap/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>      
	<c:if test="${not empty info}">
	<div class="alert alert-success" role="alert">
        ${info}
     </div>
     </c:if>


	<a href="create"><button type="button" class="btn btn-default">Create Product</button></a>
	
	<table class="table table-striped">
	     <thead>
	       <tr>
	         <th>Id</th>
	         <th>Name</th>
	         <th>Description</th>
	         <th>Price</th>
	         <th>Category</th>
	         <th>action</th>
	       </tr>
	     </thead>
	     <tbody>
		<c:forEach items="${products.content}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>${product.price}</td>
				<td>${product.category.name}</td>
				<td>
					<a href="edit?id=${product.id}"><button type="button" class="btn btn-xs btn-default">Edit</button></a>
					<a href="delete?id=${product.id}"><button type="button" class="btn btn-xs btn-default">Delete</button></a>
				</td>
			</tr>			
		</c:forEach>            
        </tbody>
      </table>
      <p>
      Page ${products.number+1} of ${products.totalPages}. Total products: ${products.totalElements}
      </p>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../scripts/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../scripts/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>