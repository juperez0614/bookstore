<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<input type="password" id="password" name="pass" placeholder="Enter a password"/>
	<br/>
	<input value="Create User Account" type="submit" />
</form>
</body>
</html>