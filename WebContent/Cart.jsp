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
<c:choose> 
  <c:when test="${cart.isEmpty == 'true'}">
    <h1>Your cart is empty, check out our selections <a href="BookDisplay.jsp">Here!</a></h1>
  </c:when>
  <c:otherwise>
    <table>

		<tr>
			<c:forEach var="line" items="${cart.lineItems }">
				<td>${line.book.title}</td>
				<form action="CartServlet" method="POST">
				<input type="hidden" name="invoiceId" value="${Invoice.id }"/>
				<input type="hidden" name="lineId" value="${line.id }"/>
					<input type="text" name="quantity" value="${line.quantity}"
						onkeypress="return isNumber(event)"/>
					<input type="submit" name="manageLineItem" value="update" />
					 <input type="submit" name = "manageLineItem" value="delete" />
					 <input type="submit" name="manageLineItem" value="checkout" />
				</form>
			</c:forEach>
		</tr>
	</table>
	<a href="BookDisplay.jsp">Continue Shopping</a>
  </c:otherwise>
</c:choose>
	<%-- <table>

		<tr>
			<c:forEach var="line" items="${cart.lineItems }">
				<td>${line.book.title}</td>
				<form action="CartServlet" method="POST">
				<input type="hidden" name="invoiceId" value="${Invoice.id }"/>
				<input type="hidden" name="lineId" value="${line.id }"/>
					<input type="text" name="quantity" value="${line.quantity}"
						onkeypress="return isNumber(event)"/>
					<input type="submit" name="manageLineItem" value="update" />
					 <input type="submit" name = "manageLineItem" value="delete" />
					 <input type="submit" name="manageLineItem" value="checkout" />
				</form>
			</c:forEach>
		</tr>
	</table>
	<a href="BookDisplay.jsp">Continue Shopping</a> --%>
	
	
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