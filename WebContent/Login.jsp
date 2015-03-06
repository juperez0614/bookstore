<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  id="loginUser" name="UserLogon" action="UserAuthServlet" method="post">
	 <input type="hidden" name="insertUser" value="login"/> 
	<label>Username:</label>
	<input type="text" id="username" name="username" placeholder="Enter User Name"/>
	<br/>
	<label>Password:</label>
	<input type="password" id="password" name="password" placeholder="Enter a password"/>
	<br/>
	<input value="Sign in" type="submit" />
</form>
<a href="UserCredentials.jsp">Create New Account</a>
<script>
if(document.getElementById('username').value==""){
		document.getElementById("username").focus(); 
	}
</script>
</body>
</html>