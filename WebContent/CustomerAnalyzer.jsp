<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/Partial/Header.jsp"></jsp:include>
	<div class="container theme-showcase">
		<button id="customerBookButton" class="btn btn-default">Search by Book Quantity</button>
		<div id="custBook" style="display: none">
			<form action="CustomerAnalysisServlet" method="Post">
				<input type="hidden" name=actionTag value=customerbookidquantity />
				<p>Book id:</p>
				<input type="text" name="customerbookid" />
				<p>Book Quantity:</p>
				<input type="text" name="customerbookquantity" /> <input
					type="submit" value="Submit query" class="btn btn-default"/> 
			</form>
		</div>


		<button id="customerNameButton" class="btn btn-default">Search by Customer Name</button>
		<div id="custName" style="display: none">
			<form action="CustomerAnalysisServlet" method="Post">
				<input type="hidden" name=actionTag value=customername />
				<p>First Name:</p>
				<input type="text" name="customerFirstName" />
				<p>Last Name:</p>
				<input type="text" name="customerLastName" /> <input type="submit"
					value="Submit query" class="btn btn-default"/>
			</form>
		</div>

		<button id="customerIdButton" class="btn btn-default">Search by Id</button>
		<div id="custId" style="display: none">
			<form action="CustomerAnalysisServlet" method="Post">
				<input type="hidden" name="actionTag" value="customerid" />
				<p>ID:</p>
				<input type="text" name="customerid" /> <input type="submit"
					value="Submit query" class="btn btn-default"/>
			</form>
		</div>


		<button id="customerAddressButton" class="btn btn-default">Search by Address</button>
		<div id="custAdd" style="display: none">
			<form action="CustomerAnalysisServlet" method="Post">
				<input type="hidden" name="actionTag" value="customeraddress">
				<p>Address:</p>
				<input type="text" name="customerAddress" />
				<p>Address2:</p>
				<input type="text" name="customerAddress2" />
				<p>City:</p>
				<input type="text" name="customerCity" />
				<p>State:</p>
				<input type="text" name="customerState" />
				<p>Zipcode:</p>
				<input type="text" name="customerZipcode" /> <input type="submit"
					value="Submit query" class="btn btn-default"/>
			</form>
		</div>


		<button id="customerEmailButton" class="btn btn-default">Search by Email</button>
		<div id="custEmail" style="display: none">
			<form action="CustomerAnalysisServlet" method="Post">
				<input type="hidden" name="actionTag" value="customeremail" />
				<p>Email:</p>
				<input type="text" name="customerEmail" /> <input type="submit"
					value="Submit query" class="btn btn-default" />
			</form>
		</div>


		<button id="customerUsernameButton" class="btn btn-default">Search by Username</button>
		<div id="custUsername" style="display: none">
			<form action="CustomerAnalysisServlet" method="Post">
				<input type="hidden" name="actionTag" value="customerusername" />
				<p>Username:</p>
				<input type="text" name="customerUsername" /> <input type="submit"
					value="Submit query" class="btn btn-default" />
			</form>
		</div>
	</div>




	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script>
		$('#customerNameButton').click(function() {
			$('#custName').css('display', 'block');
		});

		$('#customerIdButton').click(function() {
			$('#custId').css('display', 'block');
		});

		$('#customerAddressButton').click(function() {
			$('#custAdd').css('display', 'block');
		});

		$('#customerEmailButton').click(function() {
			$('#custEmail').css('display', 'block');
		});

		$('#customerUsernameButton').click(function() {
			$('#custUsername').css('display', 'block');
		});

		$('#customerBookButton').click(function() {
			$('#custBook').css('display', 'block');
		});
	</script>

</body>
</html>