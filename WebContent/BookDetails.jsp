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
			<td>${Book.priceFormat}</td>
			<td>${Book.ISBN }</td>
			<td>${Book.genre.genre }</td>
			<td>${Book.publisher.companyName }</td>
			<c:forEach var="author" items="${Book.authorList}">
				<td>${author.firstName }</td>
				<td>${author.lastName }</td>
			</c:forEach>
			<c:choose>
				<c:when test="${Inventory.quantity  > 0}">
					<td>${Inventory.quantity }</td>
				</c:when>
				<c:otherwise>
					<td>Out of stock!!</td>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
	<form action="CartServlet" method="POST">
		<input type="hidden" name="manageLineItem" value="addToCart" /> <input
			type="text" name="quantity" value="1"
			onkeypress="return isNumber(event)" /> <input type="submit"
			value="puchase" />
	</form>

	<jsp:include page="Partial/ShowRatings.jsp"></jsp:include>
	<form id='ratingForm' action="BookServlet">
		<input type="hidden" name="action" value="showAllRatings" /> 
		<input type="hidden" name="bookId" value="${Book.id }" /> 
		<input type="submit" value="show all ratings" />
	</form>
	<button id="showRatingForm">Write a Review</button>
	<div id="ratingInput" style="visibility: hidden">
		<form action="RatingServlet" method="Post">
			<input type="hidden" name="bookid" value="${Book.id }" />
			<select name="ratingNumber">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
			<textarea name="ratingReview" rows="8" cols="50"></textarea>
			<input type="submit" value="Submit Review" />
		</form>
	</div>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script>
	

	$('#showRatingForm').click(function(){
		$('#ratingInput').css('visibility', 'visible');
	});
	
/* 	 $(function(){
		$('form#ratingForm').submit(function(){
			$(this).children('input[type=submit]').hide();
			return false;
		});
	});  */
	
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