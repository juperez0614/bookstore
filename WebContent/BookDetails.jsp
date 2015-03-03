<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>${Book.title}</td>
			<td>${Book.price}</td>
			<td>${Book.ISBN }</td>
			<td>${Book.genre.genre }</td>
			<td>${Book.publisher.companyName }</td>
			<c:forEach var="author" items="${Book.authorList}">
				<td>${author.firstName }</td>
				<td>${author.lastName }</td>
			</c:forEach>
			<c:forEach var="rating" items="${Book.ratingList}">
				<td>${rating.rating }</td>
				<td>${rating.review }</td>
			</c:forEach>
		</tr>
	</table>
	<form action="CartServlet" method="POST">
		<input type="submit" value="puchase" />
	</form>
</body>
</html>