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
	String sql = "SELECT * FROM Customer;";
	PreparedStatement statement = conn.prepareStatement(sql);
	ResultSet rs = statement.executeQuery(sql);

	List<beans.CustomerBeans> list = new ArrayList<beans.CustomerBeans>();
	while (rs.next()) {
		String id = rs.getString(1);	
		String accountNumber = rs.getString(2);
		String creditCard = rs.getString(3);
		String email = rs.getString(4);
		String createDate = rs.getString(5);
		String rating = rs.getString(6);
			
		beans.CustomerBeans info = new beans.CustomerBeans();
		info.setId(id);
		info.setAccountNumber(accountNumber);
		info.setCreditCard(creditCard);
		info.setEmail(email);
		info.setDate(createDate);
		info.setRating(rating);
		info.setList();
		
		list.add(info);
	}
	

	
		
	List<String> colNames = new ArrayList<String>();
	colNames.add("Customer Id");
	colNames.add("Account Number");
	colNames.add("Credit Card");
	colNames.add("Email");
	colNames.add("Creation Date");
	colNames.add("Rating");

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
