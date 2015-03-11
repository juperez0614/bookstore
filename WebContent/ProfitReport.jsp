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
		<h3>Time Period 1</h3>
		<h4>Profit for this timeframe our: ${startdate } to ${enddate } is
			${profit }</h4>
		<h4>Sales for this timeframe our: ${startdate } to ${enddate } is
			${sales }</h4>
			<br>
			<h3>Time Period 2</h3>
			<h4>Profit for this timeframe our: ${startdate1 } to ${enddate1 } is
			${profit1 }</h4>
		<h4>Sales for this timeframe our: ${startdate1 } to ${enddate1 } is
			${sales1 }</h4>
			<br>
	</div>
</body>
</html>