<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container theme-showcase">
		<div class="row">
			<div class="col-md-6">
				<table class="table">
					<thead>
						<tr>
							<th>Rating</th>
							<th>Review</th>
							<th>Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${ratingList}">
							<tr>
								<td>${item.rating}</td>
								<td>${item.review}</td>
								<td>${item.ratingDate }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>