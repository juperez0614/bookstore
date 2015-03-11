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
		<div class="row">
			<div class="col-md-2">
				<h1>Genre</h1>
				<table class="table">
					<tbody>
						<c:forEach var="item" items="${genretable}">
							<tr>

								<td><a
									href="SearchServlet?action=genre&genreitem=${item.genre}">${item.genre}</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-md-10">
				<h1>Inventory</h1>
				<table class="table">
					<thead>
						<tr>
							<th>Title</th>
							<th>Price</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${genreList}" varStatus="count">
						
							<tr>
								<td><a href="BookServlet?action=${item.id }">${item.title}</a></td>
								<td>${item.priceFormat}   <c:if test="${count.index <= 4 }"><span style="color:red">Top Seller!</span></c:if></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>












	<%-- <table>
		<c:forEach var="item" items="${genreList}">
			<tr>
				<td><a href="BookServlet?action=${item.id }">${item.title}
				</a></td>
				<td>${item.priceFormat}</td>
			</tr>
		</c:forEach>
	</table>
	<aside>
		<table>
			<c:forEach var="item" items="${genretable}">
				<tr>

					<td><a
						href="SearchServlet?action=genre&genreitem=${item.genre}">${item.genre}</a></td>
				</tr>
			</c:forEach>
		</table>
	</aside> --%>
</body>
</html>