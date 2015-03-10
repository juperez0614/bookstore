<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  id="insertPub" name="insertPub" action="PublisherServlet" method="post">
	 <input type="hidden" name="insertPub" value="publishermanagement"/> 
	<label>Company Name:</label>
	<input type="text" id="companyname" name="companyname" placeholder="Enter Publisher Name"/>
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
	<label>Zipcode:</label>
	<input type="text" id="zipcode" name="zipcode" placeholder="Zipcode"/>
	<br/>
	<label>Phone:</label>
	<input type="text" id="phone" name="phone" placeholder="Phone Number"/>
	<br/>
	<label>Point of Contact:</label>
	<input type="text" id="poc" name="poc" placeholder="Point of Contact"/>
	<br/>

<input value="Manage Publisher Account" type="submit" />
</form>
</body>
</html>