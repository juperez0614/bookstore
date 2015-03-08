<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="customer" class="bs.models.Customer" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/Partial/Header.jsp"></jsp:include>
	<div class="container theme-showcase">
		<form id="insertCust" name="insertCust" action="CustomerServlet"
			method="post" class="form-inline">
			<input type="hidden" name="insertCust" value="addCustomer" />
			<div class="form-group">
			 <label>First
				Name:</label> <input type="text" id="firstName" name="firstName"
				placeholder="Enter First Name" class="form-control"/> 
				</div>
				<br /> 
				<div class="form-group">
				<label>Last Name:</label>
			<input type="text" id="lastName" name="lastName"
				placeholder="Enter Last Name" class="form-control" /> 
				</div>
				<br /> 
					<div class="form-group">
				<label>Address:</label> <input
				type="text" id="address" name="address" placeholder="Address" class="form-control"/> 
				</div>
				<br />
				<div class="form-group">
			<label>Address Line 2:</label> <input type="text" id="address2"
				name="address2" placeholder="Address 2" class="form-control"/>
				</div> 
				<br /> 
				<div class="form-group">
				<label>City:</label>
			<input type="text" id="city" name="city" placeholder="City" class="form-control" /> 
			</div><br />
			<div class="form-group">
			<label>State:</label> <input type="text" id="state" name="state"
				placeholder="State" class="form-control"/> </div>
				<br />
				<div class="form-group"></div>
				 <label>Zip:</label> <input
				type="text" id="zipcode" name="zipcode" placeholder="Zipcode" class="form-control"/> <br />
			<div class="form-group">
			<label>Email:</label> <input type="text" id="email" name="email"
				placeholder="Email" class="form-control"/> 
				</div>
				<br />
			<div id="warning" class="feedback"></div>
			<button type="submit" class="btn btn-default" id="submit">Create Account</button>
		</form>
		</div>
		<script type="text/javascript"
			src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<script>
			$(document).ready(function() {
				if (document.getElementById('firstName').value == "") {
					document.getElementById('firstName').focus();
				}
				var elMsg = document.getElementById('warning');

				function loginCheck() {
					if (document.getElementById('firstName').value == "") {
						elMsg.textContent = "Pleaes enter your first name";
						document.getElementById('firstName').focus();
						return false;
					}
					if (document.getElementById('lastName').value == "") {
						elMsg.textContent = "Please enter your last name";
						document.getElementById('lastName').focus();
						return false;
					}
					if (document.getElementById('address').value == "") {
						elMsg.textContent = "Please enter your address";
						document.getElementById('address').focus();
						return false;
					}
					if (document.getElementById('city').value == "") {
						elMsg.textContent = "Please enter your city";
						document.getElementById('city').focus();
						return false;
					}
					if (document.getElementById('state').value == "") {
						elMsg.textContent = "Please enter your state";
						document.getElementById('state').focus();
						return false;
					}
					if (document.getElementById('zipcode').value == "") {
						elMsg.textContent = "Please enter your zipcode";
						document.getElementById('zipcode').focus();
						return false;
					}
					if (document.getElementById('email').value == "") {
						elMsg.textContent = "Please enter your email";
						document.getElementById('email').focus();
						return false;
					}
				}
				var elSubmit = document.getElementById('submit');
				elSubmit.onclick = loginCheck;
			});
		</script>
</body>
</html>