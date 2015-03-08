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
	<jsp:include page="/Partial/Header.jsp"></jsp:include>
	<div class="container theme-showcase">
		<h2>Almost done. Just confirm your purchase.</h2>
		<h2>We appreciate your business. Thank you!</h2>
		<input type="hidden" name="invoiceId" value="${Invoice.id }" />
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>Title</th>
							<th>Quantity</th>
							<th>Price</th>
						</tr>
					</thead>
					<c:forEach var="line" items="${cart.lineItems }">
						<tr>
							<td>${line.book.title}</td>
							<td>${line.quantity}</td>
							<td>${line.book.price}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<p>
			Your total is: <b>${Invoice.priceFormat}</b>
		</p>
		<form action="CartServlet" method="post">
			<input type="hidden" name="manageLineItem" value="confirmCheckout" />
			<input type="submit" value="Confirm Purchase" class="btn btn-default" />
		</form>
		<a href="index.jsp">Return to Home Page</a>
	</div>
</body>
</html>