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
	<jsp:include page="/Partial/Header.jsp"></jsp:include>
	<div class="container theme-showcase">
	<h4><b>Name:</b> ${customer.firstName} ${customer.lastName}</h4>
	<p><b>Username:</b> ${customer.userName.username }</p>
	<p><b>Email:</b> ${customer.email }</p>
	<p><b>Address: </b> ${customer.address}</p>
	<p><b>Address:</b> ${customer.address2}</p>
	<p><b>City:</b> ${customer.city} <b>State:</b> ${customer.state} <b>Zipcode:</b> ${customer.zipcode}</p>
		<div class="row">
			<div class="col-md-6">
				<table class="table">
				<thead>
						<tr>
							<th>Transaction Date</th>
							<th>Total Amount</th>
						</tr>
					</thead>
					<tbody>
					<tr>
						<c:forEach var="receipt" items="${invoiceList}">
							<tr>
								<td>${receipt.transactionDate }</td>
								<td>${receipt.totalAmount }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>