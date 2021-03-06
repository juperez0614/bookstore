<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
			<div class="row">
					<div class="col-md-12">
						<table class="table" id="table">
							<thead>
								<tr>
									<th>Description</th>
									<th>Price</th>
									<th>Quantity</th>
								</tr>
							</thead>
							<c:forEach var="line" items="${cart.lineItems }" varStatus="count" >
							
								<tr>
									<td>${line.book.title}</td>
									<td><c:out value="${line.book.priceFormat }"></c:out></td>
									<td>
										<form action="CartServlet" method="POST">
															
											<input type="hidden" class = "idLine" name="lineId" value="${line.id }" /> 
											<input
												type="text" class="quantity" id="quantity" name="quantity" value="${line.quantity}"
												onkeypress="return isNumber(event)" /> 
										
											<input type="submit"
												name="manageLineItem" id="update"   class="update btn btn-default"  value="update"  /> 
											<input
												type="submit" name="manageLineItem" value="delete" class="btn btn-default" />
												<div class="status"></div>
										</form>
										<input type="hidden" id="count" value="${count.index }" />
									</td>
									
								</tr>
							</c:forEach>
						</table>
						
					</div>
				</div>			
		<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script type="text/javascript">
	  $(document).ready(function() {
				var table = $("#table");
				$(table).find(".quantity").keyup(function() {
								    var $row = $(this).closest("tr");    // Find the row
								    var $tds = $row.find("form");
								    var $id = $tds.find(".idLine").val();								  
								    var $quants = $tds.find(".quantity").val();
									var button = $tds.find("#update");
									var status = $tds.find(".status");
									$(status).html(' Checking availability...');
									$.ajax({
										type : "POST",
										url : "CartServlet?manageLineItem=updateQuantityVerify&lineId=" 
											+ $id + "&quantity=" + $quants,	
													success : function(msg) {														
														$(status).html(msg);
														if (msg != "" ){
															$(button).attr("disabled", true);
														}
														else if (  $quants == 0 && msg == ""){
															$(status).html("<p style='color:red'> 0 is not a valid quantity</p>");
															$(button).attr("disabled", true);
														}
														else {
															$(button).attr("disabled", false);
														}
														
													}
									});
					}); 
			});
	</script>
</body>
</html>