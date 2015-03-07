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
	<table>
		<c:forEach var="item" items="${genreList}">
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