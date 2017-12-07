package servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
//@WebServlet(urlPatterns = { "/Manager/AllFlights" })
public class ListAllFlightsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		
	public ListAllFlightsServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
    	   Connection conn = MySQLConnUtils.getMySQLConnection();
	       System.out.println("Get connection " + conn);
	       String sql = "SELECT * FROM Flight;";
	       PreparedStatement statement = conn.prepareStatement(sql);
		
	       // Execute SQL statement returns a ResultSet object.
	       ResultSet rs = statement.executeQuery(sql);
	       List<beans.flight> list = new ArrayList<beans.flight>();
	       while (rs.next()) {
	    	   String airlineId = rs.getString(1);
	    	   String flightNo = rs.getString(2);
	    	   String noOfSeats = rs.getString(3);
	    	   String daysOperating = rs.getString(4);
	    	   String minLengthOfStay = rs.getString(5);
	    	   String maxLengthOfStay = rs.getString(6);
	    	   
	    	   beans.flight info = new beans.flight();
	    	   info.setAirlineId(airlineId);
	    	   info.setFlightNo(flightNo);
	    	   info.setNoOfSeats(noOfSeats);
	    	   info.setDaysOperating(daysOperating);
	    	   info.setMinLengthOfStay(minLengthOfStay);
	    	   info.setMaxLengthOfStay(maxLengthOfStay);
	    	   info.setList();

	    	   list.add(info);
	    	   
	       }
	       List<String> colNames = new ArrayList<String>();
	       colNames.add("Airline Id");
	       colNames.add("Flight Number");
	       colNames.add("Number of Seats");
	       colNames.add("Days Operating");
	       colNames.add("Min Length of Stay");
	       colNames.add("Max Length of Stay");
	       
	       request.setAttribute("colNames", colNames);
	       request.setAttribute("rowVal", list);
	       request.getRequestDispatcher("/Manager/Results.jsp").forward(request, response);
//	       RequestDispatcher dispatcher = request.getServletContext().
//	    		   getRequestDispatcher("/flights.jsp");
//	       dispatcher.forward(request, response);
       } catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
 
   @Override
   protected void doPost(HttpServletRequest request,
           HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request, response);
   }
 
}