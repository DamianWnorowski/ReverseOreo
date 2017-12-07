<%@page import="filters.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="servlets.MySQLConnUtils"%>
<%@ page import="java.util.ArrayList, java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%
try{
	System.out.println("Building table list");
	Connection conn = MySQLConnUtils.getMySQLConnection();
	System.out.println("Get connection " + conn);
	
	String AccNo="";
	filters.User user = new User();
	user = (User)session.getAttribute("user");
	String username = user.getUsername();
	String sql = "SELECT*FROM Customer C WHERE C.Id = '" + username + "';";
	System.out.println(sql);
	PreparedStatement statement = conn.prepareStatement(sql);
	ResultSet rs = statement.executeQuery(sql);


	List<beans.CustomerBeans> list = new ArrayList<beans.CustomerBeans>();
	while (rs.next()) {
		String accountNumber = rs.getString(2);	//Starting from second bc we do not want id
		String CreditCard = rs.getString(3);
		String email = rs.getString(3);
		String date = rs.getString(3);
		String rating = rs.getString(3);

		beans.CustomerBeans cb = new beans.CustomerBeans();
		cb.setAccountNumber(accountNumber);
		cb.setCreditCard(CreditCard);
		cb.setEmail(email);
		cb.setDate(date);
		cb.setRating(rating);
		cb.setList();
		list.add(cb);

	}
	List<String> colNames = new ArrayList<String>();
	colNames.add("Airline Name");
	colNames.add("Flight Number");

	request.setAttribute("colNames", list);
	request.setAttribute("rowVal", colNames);
%>

	<table class="table table-striped">
	<thead>
		<tr>
			<c:forEach items="${colNames}" var="val">
				<tr>
				<c:forEach items="${val.list}" var="attr">
					<td>${attr}</td>
				</c:forEach>
				</tr>
			</c:forEach>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${rowVal}" var="col">
			<tr>
				<th>${col}</th>
			</tr>
		</c:forEach>
	</tbody>
</table>
	
	
<%
	rs.close();
	statement.close();
	conn.close();
} catch (SQLException | ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>
