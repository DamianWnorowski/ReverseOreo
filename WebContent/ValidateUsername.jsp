<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="servlets.MySQLConnUtils"%>

<%
	System.out.println("We in the validate jsp");
	String username = request.getParameter("user");
	Connection conn = MySQLConnUtils.getMySQLConnection();
	System.out.println("Get connection " + conn);
	String sql = "SELECT username FROM UserAccounts WHERE username='" + username +  "';";
	PreparedStatement statement = conn.prepareStatement(sql);
	ResultSet rs = statement.executeQuery(sql);
	if(rs.next()){
		//Username exists
		System.out.println("Username Already Exists!");
		%> 
		invalid
		<%
	}else{
		System.out.println("Username is available");
		%> 
		valid
		<%
	}
	rs.close();
	statement.close();
	conn.close();
%>
