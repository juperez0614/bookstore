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
	<input type="hidden" name="invoiceId" value="${Invoice.id }" />
	<table>
		<tr>
			<th>Title</th>
			<th>Quantity</th>
			<th>Price</th>
		</tr>
		<c:forEach var="line" items="${cart.lineItems }">
			<tr>
				<td>${line.book.title}</td>
				<td>${line.quantity}</td>
				<td>${line.book.price}</td>
			</tr>
		</c:forEach>
	</table>
	<p>Your total is: ${Invoice.priceFormat}</p>
	<a href="index.jsp">GO home</a>
</body>
</html>