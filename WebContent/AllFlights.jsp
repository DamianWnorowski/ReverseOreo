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
	String sql = "SELECT * FROM Flight;";
	PreparedStatement statement = conn.prepareStatement(sql);
	ResultSet rs = statement.executeQuery(sql);


	List<beans.flight> list = new ArrayList<beans.flight>();
	while (rs.next()) {
		String airlineId = rs.getString(1);
		String flightNo = rs.getString(2);
		beans.flight f = new beans.flight();
		f.setAirlineId(airlineId);
		f.setFlightNo(flightNo);
		f.setList();
		list.add(f);

	}
	List<String> colNames = new ArrayList<String>();
	colNames.add("Airline Name");
	colNames.add("Flight Number");

	request.setAttribute("colNames", colNames);
	request.setAttribute("rowVal", list);
%>

	<table class="table table-striped">
	<thead>
		<tr>
			<c:forEach items="${colNames}" var="col">
				<th>${col}</th>
			</c:forEach>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${rowVal}" var="val">
			<tr>
				<c:forEach items="${val.list}" var="attr">
					<td>${attr}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</tbody>
</table>
	
	
<%
	rs.close();
	statement.close();
	conn.close();
%>
