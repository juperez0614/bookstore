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

				<%-- <div class="row">
					<div class="col-md-12">
						<table class="table">
							<thead>
								<tr>
									<th>Description</th>
									<th>Price</th>
									<th>Quantity</th>
								</tr>
							</thead>
							<c:forEach var="line" items="${cart.lineItems }" varStatus="count" >
							<input type="hidden" id="count" value="${count.index }" />
								<tr>
									<td>${line.book.title}</td>
									<td><c:out value="${line.book.priceFormat }"></c:out></td>
									<td>
									
										<form action="CartServlet" method="POST">
															
											<input type="hidden" class = "idLine" name="lineId" value="${line.id }" /> 
											<input
												type="text" class="quantity" id="quantity${count.index }" name="quantity" value="${line.quantity}"
												onkeypress="return isNumber(event)" /> 
										
											<input type="submit"
												name="manageLineItem" id="update${count.index }"   class="update btn btn-default"  value="update${line.id }"  /> 
											<input
												type="submit" name="manageLineItem" value="delete" class="btn btn-default" />
												<div class="status"></div>
										</form>
									</td>
								</tr>
							</c:forEach>
						</table>
						
					</div>
				</div> --%>
				<a href="BookDisplay.jsp">Continue Shopping</a>
				<form action="CartServlet" method="POST">
					<input type="hidden" name="invoiceId" value="${Invoice.id }" /> <input
						type="submit" name="manageLineItem" value="checkout" class="btn btn-default" />
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
	
	/*   $(document)
	.ready(
			
			
			function() {
				var table = $("#table");
				console.log(table);
				$(table).find(".quantity")
						.keyup(
								function() {
									var row = $(table).closest("tr");
									console.log(row);
									var quantity = $(row).find(".quantity").val();
									var lineid = $(row).find(".lineid").val();
									var count = $(row).find("#count").val();
									console.log("after count: "+count);
									console.log(lineid + " is wdjal;jd" );
										$(".status")
												.html(
														' Checking availability...');
										$
												.ajax({
													type : "POST",
													url : "CartServlet?manageLineItem=updateQuantityVerify&lineId=" 
															+ lineid + "&quantity=" + quantity,
													data: count, 
													
													success : function(
															msg) {
														
														
														$('.status')
																.html(
																		msg);
														if (msg != ""){
				
															$("#update" +count ).attr("disabled", true);
														}
														else {
															$("#update" +count).attr("disabled", false);
														}
														
													}
											
												}); 
												

								});
				
				
			}); */
	  
	</script>
</body>
</html>