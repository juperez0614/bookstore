<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="loginUser" name="UserLogon" action="UserAuthServlet"
		method="post">
		<input type="hidden" name="insertUser" value="login" /> <label>Username:</label>
		<input type="text" class="uname" id="username" name="uname"
			placeholder="Enter User Name" /><br> <label>Password:</label> <input
			type="password" id="password" name="password"
			placeholder="Enter a password" /> <br /> <input value="Sign in"
			type="submit" />
	</form>
	<a href="UserCredentials.jsp">Create New Account</a>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			if(document.getElementById('username').value == ""){
				document.getElementById('username').focus();
			}
		});
	</script>
</body>
</html>