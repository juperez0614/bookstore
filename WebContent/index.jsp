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
<jsp:include page="/Top/top.jsp"></jsp:include>
<h1>Welcome to The Store, ${customer.firstName} ${customer.lastName}</h1>
<a href="UserAuthServlet?action=checkUser">Login/SignUp</a>
<a href="BookServlet?action=getall">See our list of books</a>
<c:if test="${topten.size() > 0 }">
	<h1>Top Ten</h1>
</c:if>
<table>
		<c:forEach var="item" items="${topten}">
			<tr>
				<td>${item.title }</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<c:if test="${trending.size() > 0 }">
		<h1>Trending</h1>
	</c:if>
	<table>
		<c:forEach var="item" items="${trending}">
			<tr>
				<td>${item.title }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>