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
		<form action="SearchServlet" method="get" class="form-inline">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search"
					name="searchbar"> <input type="hidden" name="action"
					value="search" /> <select name="searchtype" class="form-control">
					<option value="author">Author</option>
					<option value="title">Title</option>
					<option value="isbn">ISBN</option>
					<option value="publisher">Publisher</option>
					<option value="genre">Genre</option>
				</select>
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</form>





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
						<c:forEach var="item" items="${List}">
							<tr>
								<td><a href="BookServlet?action=${item.id }">${item.title}
								</a></td>
								<td>${item.priceFormat}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('.selectpicker').selectpicker();
		});
	</script>
</body>
</html>