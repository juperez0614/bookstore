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
		<c:choose>
			<c:when test="${cart.isEmpty == 'true'}">
				<h2>
					Your cart is empty, check out our selections <a
						href="BookDisplay.jsp">Here!</a>
				</h2>
			</c:when>
			<c:otherwise>
				<jsp:include page="/Partial/CartTable.jsp"></jsp:include>
				<a href="BookDisplay.jsp">Continue Shopping</a>
				<form action="CartServlet" method="POST">
					<input type="hidden" name="invoiceId" value="${Invoice.id }" /> <input
						type="submit" name="manageLineItem" value="checkout"
						class="btn btn-default" />
				</form>
			</c:otherwise>
		</c:choose>
	</div>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script type="text/javascript">
	function isNumber(evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	        return false;
	    }
	    return true;
	};
	</script>
</body>
</html>