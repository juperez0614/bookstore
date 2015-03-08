<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/Partial/Header.jsp"></jsp:include>
	<div class="container theme-showcase">
		<h1>Java Error</h1>
		<p>Sorry, Java has thrown an exception</p>
		<p>To continue, click the back button</p>

		<h2>Details</h2>
		<p>Type: ${pageContext.exception["class"]}</p>
		<p>Message: ${pageContext.exception.message}</p>
	</div>
</body>
</html>