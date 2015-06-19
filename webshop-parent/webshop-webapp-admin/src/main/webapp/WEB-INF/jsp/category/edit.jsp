<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pet Supplies - Admin</title>

<!-- Bootstrap core CSS -->
<link href="../styles/bootstrap/css/bootstrap.min.css" rel="stylesheet">

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

	<div class="container">
		<div class="header clearfix">
			<nav>
				<ul class="nav nav-pills pull-right">
					<li role="presentation"><a href="../welcome">Home</a></li>
					<li role="presentation"><a href="../product/welcome">Products</a></li>
					<li role="presentation" class="active"><a href="welcome">Categories</a></li>
					<li role="presentation"><a
						href="javascript:alert('Sorry! Upcoming feature in sprint 02.');">Logout</a></li>
				</ul>
			</nav>
			<h3 class="text-muted">
				Pet Supplies <B>Admin</B>
			</h3>
		</div>

		<c:if test="${not empty info}">
			<div class="alert alert-success" role="alert">${info}</div>
		</c:if>

		<div class="jumbotron">
			<p class="lead">${mode}Category</p>
		</div>

		<div class="row marketing">
			<!-- Main Content Start  -->

			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">${mode}Category${mode == 'Edit' ? category.id : ''}</h3>
				</div>
				<div class="panel-body">
					<form:form commandName="category" methodParam="POST">
						<table>
							<tr>
								<td><spring:message code="name" /></td>
								<td><form:input path="name" /></td>
								<td><form:errors path="name" cssClass="error" /></td>
							</tr>
							<tr>
								<td><spring:message code="parent" /></td>
								<td><form:select path="parent">
										<form:option value="-1" label="Select" />
										<form:options items="${categories}" itemValue="id"
											itemLabel="name" />
									</form:select></td>
								<td><form:errors path="parent" cssClass="error" /></td>
							</tr>
							<tr>
								<td colspan="3"><input type="submit"
									class="btn btn-default" value="Save" /> <a href="welcome"><button
											type="button" class="btn btn-default">Cancel</button></a></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>

			<!-- Main Content End  -->
		</div>

		<footer class="footer">
			<p>&copy; Rajashekar Subramany 2015</p>
		</footer>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../scripts/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="../scripts/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../scripts/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>




