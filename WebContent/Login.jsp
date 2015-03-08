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
	<jsp:include page="/Partial/Header.jsp"></jsp:include>
	<div class="container theme-showcase">
		<form id="loginUser" name="UserLogon" action="UserAuthServlet"
			method="post" class="form-inline">
			<input type="hidden" name="insertUser" value="login" />
			<div class="form-group">
				<label for="loginUserName">Username:</label> <input type="text"
					class="form-control" class="uname" id="username" name="uname"
					placeholder="Enter User Name" />
			</div>
			<br> <br>
			<div class="form-group">
				<label for="loginPassword">Password:</label> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="Enter a password" />
			</div>
			<br />
			<button type="submit" class="btn btn-default">Log in</button>
		</form>
		<a href="UserCredentials.jsp">Create New Account</a>
	</div>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			if (document.getElementById('username').value == "") {
				document.getElementById('username').focus();
			}
		});
	</script>
</body>
</html>