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

<form  id="insertCust" name="insertCust" action="CustomerServlet" method="post">
	 <input type="hidden" name="insertCust" value="addCustomer"/> 
	<label>First Name:</label>
	<input type="text" id="firstName" name="firstName" placeholder="Enter First Name"/>
	<br/>
	<label>Last Name:</label>
	<input type="text" id="lastName" name="lastName" placeholder="Enter Last Name"/>
	<br/>
	<label>Address:</label>
	<input type="text" id="address" name="address" placeholder="Address"/>
	<br/>
	<label>Address Line 2:</label>
	<input type="text" id="address2" name="address2" placeholder="Address 2"/>
	<br/>
	<label>City:</label>
	<input type="text" id="city" name="city" placeholder="City"/>
	<br/>
	<label>State:</label>
	<input type="text" id="state" name="state" placeholder="State"/>
	<br/>
	<label>Zip:</label>
	<input type="text" id="zipcode" name="zipcode" placeholder="Zipcode"/>
	<br/>
	<label>Email:</label>
	<input type="text" id="email" name="email" placeholder="Email"/>
	<br/>

<input value="Create Account" type="submit" />
</form>

</body>
</html>