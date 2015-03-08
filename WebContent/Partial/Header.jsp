<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h2>The Book Store</h2>
		<h3>Best Online Book Selections</h3>
	</header>
	<nav id="nav_bar">
		<ul>
			<li><a href="UserAuthServlet?action=checkUser">Login/SignUp</a></li>
			<li><a href="BookServlet?action=getall">See our list of
					books</a></li>
		</ul>
	</nav>
</body>
</html>