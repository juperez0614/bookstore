<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = "ProfitServlet" method = "POST">
	<label>Start year</label>
	<input type = "text" name = "startyear" />
	<label>Start month</label>
	<input type = "text" name = "startmonth" />
	<label>Start day</label>
	<input type = "text" name = "startday" />
	<label>end year</label>
	<input type = "text" name = "endyear" />
	<label>end month</label>
	<input type = "text" name = "endmonth" />
	<label>end day</label>
	<input type = "text" name = "endday" />
	
	<input type = "submit" value = "Analyze Data Set"/>
	</form>

</body>
</html>