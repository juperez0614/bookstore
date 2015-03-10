<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  id="insertBook" name="insertBook" action="BookServlet" method="post">
	 <input type="hidden" name="insertBook" value="bookmanagement"/> 
	<label>Title:</label>
	<input type="text" id="title" name="title" placeholder="Enter Title"/>
	<br/>
	<label>ISBN:</label>
	<input type="text" id="isbn" name="isbn" placeholder="Enter isbn"/>
	<br/>
	<label>Summary:</label>
	<textarea id="Summary" name="summary" placeholder="Enter Summary">
	</textarea>
	<br/>
	<label>Price:</label>
	<input type="text" id="price" name="price" placeholder="Enter Price"/>
	<br/>
<input value="Manage Book" type="submit" />
</form>
</body>
</html>