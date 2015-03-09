<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<div id="navbar" class="navbar-collapse">
		<nav id="nav_bar" class="navbar navbar-inverse navbar-fixed-top">
			<a href="index.jsp" class="navbar-brand">The Book Store</a>
			<ul class="nav navbar-nav">
				
				<li><a href="UserAuthServlet?action=checkUser">Login/SignUp</a></li>
				<li><a href="BookServlet?action=getall">Book List</a></li>
				<li><a href="Cart.jsp">Cart</a></li>
			</ul>
		</nav>
	</div>
	<div class="container theme-showcase">
		<header class="jumbotron">
			<h2>Welcome to the Book Store ${customer.firstName}
				${customer.lastName}</h2>
			<h3>Best Online Book Selections</h3>
		</header>
	</div>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

</body>
</html>