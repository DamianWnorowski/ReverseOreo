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
	String allResr = request.getParameter("all");
	

	String AccNo = "";
	PreparedStatement statement;
	ResultSet rsAccNo;
	ResultSet rs;
	filters.User user = new User();
	user = (User)session.getAttribute("user");
	String username = user.getUsername();
	
	//Checking whether or not to get active resr or all resr
	if(allResr == "yes"){											//ALL
		//Getting the Account number correspoding to the username which is saved in the session
		String sqlGetAccNo = "SELECT AccountNo FROM Customer C WHERE C.Id = '" + username + "';";
		statement= conn.prepareStatement(sqlGetAccNo);
		rsAccNo = statement.executeQuery(sqlGetAccNo);
		while(rsAccNo.next()){
			AccNo = rsAccNo.getString(1);
		}
		
		//Starting the SQL Statement for getting the reservations
		String sql = "SELECT * FROM ReservationPassenger R WHERE R.AccountNo = " + AccNo + ";";
		statement = conn.prepareStatement(sql);
		rs = statement.executeQuery(sql);
	}
	else{											//CURRENT
		//Getting the Account number correspoding to the username which is saved in the session
		String sqlGetAccNo = "SELECT AccountNo FROM Customer C WHERE C.Id = '" + username + "';";
		statement= conn.prepareStatement(sqlGetAccNo);
		rsAccNo = statement.executeQuery(sqlGetAccNo);
		while(rsAccNo.next()){
			AccNo = rsAccNo.getString(1);
		}
		
		//Starting the SQL Statement for getting the reservations
		String sql = "SELECT * FROM ReservationPassenger R WHERE R.AccountNo = " + AccNo + ";";
		statement = conn.prepareStatement(sql);
		rs = statement.executeQuery(sql);
	}


	List<beans.ReservationPassengerListBeans> list = new ArrayList<beans.ReservationPassengerListBeans>();
	while (rs.next()) {
		String ResrNo = rs.getString(1);
		String Id = rs.getString(2);
		String AccountNo = rs.getString(3);
		String SeatNo = rs.getString(4);
		String Class = rs.getString(5);
		String Meal = rs.getString(6);
		beans.ReservationPassengerListBeans rl = new beans.ReservationPassengerListBeans();
		rl.setResrNo(ResrNo);
		rl.setId(Id);
		rl.setAccountNo(AccountNo);
		rl.setSeatNo(SeatNo);
		rl.setTheClass(Class);
		rl.setMeal(Meal);
		rl.setList();
		list.add(rl);

	}
	
	List<String> colNames = new ArrayList<String>();
	colNames.add("Reservation No.");
	colNames.add("Id");
	colNames.add("Account No.");
	colNames.add("Seat No.");
	colNames.add("Class");
	colNames.add("Meal");

	request.setAttribute("colNames", colNames);
	request.setAttribute("rowVal", list);
	System.out.println("END");
	
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
	rsAccNo.close();
	statement.close();
	conn.close();
} catch (SQLException | ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>
