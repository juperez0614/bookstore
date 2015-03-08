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
	<c:forEach var="item" items="${ratingList}">
			<tr>
				<td>${item.rating}</td>
				<td>${item.review}</td>
				<td>${item.ratingDate }</td>
			</tr>
		</c:forEach>
</table>
</body>
</html>