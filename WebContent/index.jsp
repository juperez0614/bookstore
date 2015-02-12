<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="data.dbConnect.DBConnectionPool" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String driver = "org.gjt.mm.mysql.Driver";
String url = "jdbc:mysql://localhost:3306/bookStore";
String username = "newuser";
String passwd = "01234";

DBConnectionPool connPool = new DBConnectionPool(url, username, passwd);
Connection conn = connPool.getConnection();
if(conn != null){
	 out.println("Success");
	 /*
	String title = request.getParameter("Title");
	String strQuery = "insert into Books(Title) values ('" + title + "');";
	Statement stmt = conn.createStatement();
	stmt.executeUpdate(strQuery); */
}else {
	out.println("Failed");
}
%>
</body>
</html>