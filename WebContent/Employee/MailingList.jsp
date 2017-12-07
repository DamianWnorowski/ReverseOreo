<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="servlets.MySQLConnUtils"%>
<%@ page import="java.util.ArrayList, java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%

	System.out.println("Building table list");
	Connection conn = MySQLConnUtils.getMySQLConnection();
	System.out.println("Get connection " + conn);
	String sql = "SELECT C.Email FROM Customer C WHERE C.Id NOT IN (SELECT E.Id FROM Employee E);";
	PreparedStatement statement = conn.prepareStatement(sql);
	ResultSet rs = statement.executeQuery(sql);

	List<String> list = new ArrayList<String>();
	while (rs.next()) {
		String email = rs.getString(1);	
		list.add(email);
	}

	request.setAttribute("rowVal", list);
%>

	<table class="table table-striped">
	<thead>
		<tr>
			<th>Customer Emails</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${rowVal}" var="val">
			<tr>
				<td>${val}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
	
	
<%
	rs.close();
	statement.close();
	conn.close();
%>
