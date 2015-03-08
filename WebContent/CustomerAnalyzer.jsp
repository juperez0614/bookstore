<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<button id="customerBookButton">Search by Book Quantity</button>
	<div id="custBook" style="visibility: hidden">
		<form action="CustomerAnalysisServlet" method="Post">
			<input type="hidden" name=actionTag value=customerbookidquantity/>
		<p>Book id: </p>
			<input type = "text" name="customerbookid" />
		<p>Book Quantity: </p>
			<input type = "text" name="customerbookquantity"/>
			<input type="submit" value="Submit query" />
		</form>
	</div>


	<button id="customerNameButton">Search by Customer Name</button>
	<div id="custName" style="visibility: hidden">
		<form action="CustomerAnalysisServlet" method="Post">
			<input type="hidden" name=actionTag value=customername/>
		<p>First Name: </p>
			<input type = "text" name="customerFirstName" />
		<p>Last Name: </p>
			<input type= "text" name = "customerLastName"/>
			<input type="submit" value="Submit query" />
		</form>
	</div>

		<button id="customerIdButton">Search by Id</button>
	<div id="custId" style="visibility: hidden">
		<form action="CustomerAnalysisServlet" method="Post">
			<input type="hidden" name="actionTag" value="customerid"/>
		<p>ID: </p>
			<input type = "text" name="customerid" />
			<input type="submit" value="Submit query" />
		</form>
	</div>
	

		<button id="customerAddressButton">Search by Address</button>
	<div id="custAdd" style="visibility: hidden">
		<form action="CustomerAnalysisServlet" method="Post">
			<input type="hidden" name="actionTag" value="customeraddress">
		<p>Address: </p>
			<input type = "text" name="customerAddress" />
		<p>Address2: </p>
			<input type = "text" name="customerAddress2" />
		<p>City: </p>
			<input type = "text" name="customerCity" />
		<p>State: </p>
			<input type = "text" name="customerState" />
		<p>Zipcode: </p>
			<input type = "text" name="customerZipcode" />
			<input type="submit" value="Submit query" />
		</form>
	</div>


		<button id="customerEmailButton">Search by Email</button>
	<div id="custEmail" style="visibility: hidden">
		<form action="CustomerAnalysisServlet" method="Post">
		<input type="hidden" name="actionTag" value="customeremail"/>
		<p>Email: </p>
			<input type = "text" name="customerEmail" />
			<input type="submit" value="Submit query" />
		</form>
	</div>
	

		<button id="customerUsernameButton">Search by Username</button>
	<div id="custUsername" style="visibility: hidden">
		<form action="CustomerAnalysisServlet" method="Post">
		<input type="hidden" name="actionTag" value="customerusername"/>
		<p>Username: </p>
			<input type = "text" name="customerUsername" />
			<input type="submit" value="Submit query" />
		</form>
	</div>
	
	


	
	
	
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script>
	
	$('#customerNameButton').click(function(){
		$('#custName').css('visibility', 'visible');
	});
	
	
	$('#customerIdButton').click(function(){
		$('#custId').css('visibility', 'visible');
	});
	
	
	$('#customerAddressButton').click(function(){
		$('#custAdd').css('visibility', 'visible');
	});
	
	
	$('#customerEmailButton').click(function(){
		$('#custEmail').css('visibility', 'visible');
	});

	
	$('#customerUsernameButton').click(function(){
		$('#custUsername').css('visibility', 'visible');
	});

	$('#customerBookButton').click(function(){
		$('#custBook').css('visibility', 'visible');
	});
	
	</script>

</body>
</html>