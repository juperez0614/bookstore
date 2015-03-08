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
		<tr>
			<td>${customer.firstName}</td>
			<td>${customer.lastName}</td>
			<td>${customer.userName.username }</td>
			<td>${customer.email }</td>
		</tr>
		<tr>
			<td>${customer.address}</td>
			<td>${customer.address2}</td>
			<td>${customer.city}</td>
			<td>${customer.state}</td>
		</tr>
		<tr>
		<c:forEach var="receipt" items="${invoiceList}">
		<tr>
				<td>${receipt.transactionDate }</td>
				<td>${receipt.totalAmount }</td>
		</tr>
			</c:forEach>
	</table>
</body>
</html>