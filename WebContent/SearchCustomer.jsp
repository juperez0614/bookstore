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
		 <c:choose>
			<c:when test="${custResultList.size() == 0}">
				<h2>
					No information returned, submit a new query <a
						href="CustomerAnalyzer.jsp">Here!</a>
				</h2>
			</c:when>
			<c:otherwise> 
				<div class="row">
					<div class="col-md-12">
						<table class="table">
							<thead>
								<tr>
									<th>Name</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${custResultList}">
									<tr>
										<td><a href="CustomerServlet?action=${item.id }">${item.firstName }
												${item.lastName }</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
		 	</c:otherwise>
		</c:choose>
	</div> 

</body>
</html>