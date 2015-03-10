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
				<label>Start year</label> <input type="text" id="startyear" name="startyear" class="form-control"/> 
			</div>
			<br>
			<div class="form-group">
				<label>Start month</label> <input type="text" id="startmonth" name="startmonth" class="form-control" />
			</div>
			<br>
			<div class="form-group">
				<label>Start day</label> <input type="text" id="startday" name="startday" class="form-control"/>
			</div>
			<br>
			<div class="form-group">
				<label>end year</label> <input type="text" id="endyear" name="endyear" class="form-control"/>
			</div>
			<br>
			<div class="form-group">
				<label>end month</label> <input type="text" id="endmonth" name="endmonth" class="form-control"/>
			</div>
			<br>
			<div class="form-group">
				<label>end day</label> <input type="text" id="endday" name="endday" class="form-control"/>
			</div>
			<br>
			<div id="warning" style="color:red"></div>
			<input type="submit" value="Analyze Data Set" id="submit" class="btn btn-default"/>
			
		</form>
	</div>
	<script>
	
	$(document).ready(function() {
		if (document.getElementById("startyear").value == "") {
			document.getElementById("startyear").focus();
		}
		var elMsg = document.getElementById('warning');
		
		function loginCheck() {
		
			if (document.getElementById("startyear").value == "") {
				elMsg.textContent = "Please enter start year";
				document.getElementById('startyear').focus();
				return false;
			}
			if (document.getElementById('startmonth').value == "") {
				elMsg.textContent = "Please enter start month";
				document.getElementById('startmonth').focus();
				return false;
			}
			if (document.getElementById('startday').value == "") {
				elMsg.textContent = "Please enter start day";
				document.getElementById('startday').focus();
				return false;
			}
			if (document.getElementById('endyear').value == "") {
				elMsg.textContent = "Please enter end year";
				document.getElementById('endyear').focus();
				return false;
			}
			if (document.getElementById('endmonth').value == "") {
				elMsg.textContent = "Please enter end month";
				document.getElementById('endmonth').focus();
				return false;
			}
			if (document.getElementById('endday').value == "") {
				elMsg.textContent = "Please enter end day";
				document.getElementById('endday').focus();
				return false;
			}
		}
		var elSubmit = document.getElementById('submit');
		elSubmit.onclick = loginCheck;
	});
	
	</script>
</body>
</html>