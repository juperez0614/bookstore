<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/Top/top.jsp"></jsp:include>
	<jsp:include page="/Partial/Header.jsp"></jsp:include>
	<div class="container theme-showcase">
		<div class="row">
			<div class="col-md-6">
				<c:if test="${topten.size() > 0 }">
					<h1>Top Ten</h1>
				</c:if>
				<table class="table">
					<thead>
						<tr>
							<th>Title</th>
							<th>Price</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${topten}">
							<tr>
								<td>${item.title }</td>
								<td>${item.price }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-md-6">
				<c:if test="${trending.size() > 0 }">
					<h1>Trending</h1>
				</c:if>
				<table class="table">
					<thead>
						<tr>
							<th>Title</th>
							<th>Price</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${trending}">
							<tr>
								<td>${item.title }</td>
								<td>${item.price }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>