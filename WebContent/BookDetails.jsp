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

				<p><b>Title: </b> ${Book.title}</p>
				<p><b>Price: </b>${Book.priceFormat}</p>
				<p><b>ISBN: </b>${Book.ISBN }</p>
				<p><b>Genre: </b>${Book.genre.genre }</p>
				<p><b>Publisher: </b>${Book.publisher.companyName }</p>
				<c:choose>
					<c:when test="${Inventory.quantity  > 0}">
						<p id="inventoryquantity" ><b>Quantity</b> ${Inventory.quantity }</p>
					</c:when>
					<c:otherwise >
						<p id= "inventoryquantity" >Out of stock!!</p>
					</c:otherwise>
				</c:choose>
		<div class="row">
			<div class="col-md-6">
				<table class="table">
				<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
						</tr>
					</thead>
					<tbody>
				<c:forEach var="author" items="${Book.authorList}">
				<tr>
					<td>${author.firstName }</td>
					<td>${author.lastName }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		</div>
		<form action="CartServlet" method="POST" class="form-inline">
			<input type="hidden" name="manageLineItem" value="addToCart" /> 
			<div class="form-group">
			<input
				type="text" name="quantity" value="1" id = "purchasequantity"
				onkeypress="return isNumber(event)" class="form-control" /> 
				<input type="submit" id="purchasesubmit" value="puchase" class="btn btn-default"/>
				<div id="msg" style="color:red" ></div>
			</div>
		</form>

		<jsp:include page="Partial/ShowRatings.jsp"></jsp:include>
		<c:if test="${ratingList.size() == 5}">
			<form id='ratingForm' action="BookServlet">
				<input type="hidden" name="action" value="showAllRatings" /> <input
					type="hidden" name="bookId" value="${Book.id }" /> <input
					type="submit" value="show all ratings" class="btn btn-default"/>
			</form>
		</c:if>
		<button id="showRatingForm" class="btn btn-default">Write a Review</button>
		<div id="ratingInput" style="visibility: hidden">
			<form action="RatingServlet" method="Post">
				<input type="hidden" name="bookid" value="${Book.id }" /> 
				<select
					name="ratingNumber" class="form-control">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				<textarea name="ratingReview" rows="8" cols="50" class="form-control"></textarea>
				<input type="submit" value="Submit Review" class="btn btn-default"/>
			</form>
		</div>
	</div>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script>
	

	$('#showRatingForm').click(function(){
		$('#ratingInput').css('visibility', 'visible');
	});
	
	
	function isNumber(evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	        return false;
	    }
	    return true;
	};
	console.log(document.getElementById("inventoryquantity").innerText);
	console.log(document.getElementById("purchasesubmit").value);
	if(document.getElementById("inventoryquantity").innerText == "Out of stock!!"){
		console.log("were in");
		document.getElementById("purchasesubmit").disabled = true;
		document.getElementById("msg").innerText = "No Inventory";
	}
	</script>


</body>
</html>