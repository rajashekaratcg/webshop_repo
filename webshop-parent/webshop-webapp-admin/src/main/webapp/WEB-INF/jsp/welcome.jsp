<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pet Supplies - Admin</title>

<!-- Bootstrap core CSS -->
<link href="styles/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="styles/bootstrap/theme/theme.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="scripts/bootstrap/js/ie-emulation-modes-warning.js"></script>

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
					<li role="presentation" class="active"><a href="#">Home</a></li>
					<li role="presentation"><a href="product/welcome">Products</a></li>
					<li role="presentation"><a href="category/welcome">Categories</a></li>
					<li role="presentation"><a
						href="javascript:alert('Sorry! Upcoming feature in sprint 02.');">Logout</a></li>
				</ul>
			</nav>
			<h3 class="text-muted">
				Pet Supplies <B>Admin</B>
			</h3>
		</div>

		<div class="jumbotron">
			<h1>Pet Supplies Admin</h1>
			<p class="lead">Welcome to the Pet Supplies Administrator module.
				Here you can manage the Products and Categories sections.</p>
			<!-- <p><a class="btn btn-lg btn-success" href="#" role="button">Sign up today</a></p> -->
		</div>

		<div class="row marketing">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">Admin options</h3>
				</div>
				<div class="panel-body">
					<p>
						<a href="product/welcome"><button type="button"
								class="btn btn-lg btn-default">Products</button></a> <a
							href="category/welcome"><button type="button"
								class="btn btn-lg btn-default">Categories</button></a>
					</p>
				</div>
			</div>
		</div>

		<footer class="footer">
			<p>&copy; Rajashekar Subramany 2015</p>
		</footer>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="scripts/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="scripts/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="scripts/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>