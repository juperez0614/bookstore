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
${customer.firstName} ${customer.lastName}
<h1>Search Bar</h1>
<form action="SearchServlet" method="get">
<input type="hidden" name = "action" value = "search"/>
<input type="text"  name = "searchbar" />
<select name="searchtype">
<option value="author">Author</option>
<option value="title">Title</option>
<option value="isbn">ISBN</option>
<option value="publisher">Publisher</option>
<option value="genre">Genre</option>
</select>
<input type="submit" name = "searchbutton" value="search"/>
</form>
<br>
	<table>
		<c:forEach var="item" items="${List}">
			<tr>
				<td><a href="BookServlet?action=${item.id }">${item.title} </a></td>
				<td>${item.priceFormat}</td>
			</tr>
		</c:forEach>
	</table>
	<aside>
		<table>
				<c:forEach var="item" items="${genretable}">
			<tr>
				
				<td><a href="SearchServlet?action=genre&genreitem=${item.genre}">${item.genre}</a></td> 
			</tr>
		</c:forEach>
		</table>
	</aside>
</body>
</html>