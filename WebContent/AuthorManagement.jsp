<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="author" class="bs.models.Author" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form  id="insertAuthor" name="insertAuthor" action="AuthorServlet" method="post">
	 <input type="hidden" name="insertAuthor" value="authormanagement"/> 
	<label>First Name:</label>
	<input type="text" id="firstName" name="firstName" placeholder="Enter First Name"/>
	<br/>
	<label>Last Name:</label>
	<input type="text" id="lastName" name="lastName" placeholder="Enter Last Name"/>
	<br/>
	<label>Biography:</label>
	<textarea id="biography" name="biography" placeholder="Enter biography">
	</textarea>
	<br/>

<input value="Manage Author" type="submit" />
</form>

</body>
</html>