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
	<jsp:include page="/Partial/Header.jsp"></jsp:include>
	<div class="container theme-showcase">
		<form action="ProfitServlet" method="POST" class="form-inline">
			<div class="form-group">
				<label>Start year</label> <input type="text" name="startyear" class="form-control"/> 
			</div>
			<br>
			<div class="form-group">
				<label>Start month</label> <input type="text" name="startmonth" class="form-control" />
			</div>
			<br>
			<div class="form-group">
				<label>Start day</label> <input type="text" name="startday" class="form-control"/>
			</div>
			<br>
			<div class="form-group">
				<label>end year</label> <input type="text" name="endyear" class="form-control"/>
			</div>
			<br>
			<div class="form-group">
				<label>end month</label> <input type="text" name="endmonth" class="form-control"/>
			</div>
			<br>
			<div class="form-group">
				<label>end day</label> <input type="text" name="endday" class="form-control"/>
			</div>
			<br>
			<input type="submit" value="Analyze Data Set" class="btn btn-default"/>
		</form>
	</div>
</body>
</html>