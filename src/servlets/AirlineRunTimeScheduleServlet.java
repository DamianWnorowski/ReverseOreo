package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AirlineRunTimeScheduleServlet
 */
//@WebServlet("/AirlineRunTimeScheduleServlet")
public class AirlineRunTimeScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AirlineRunTimeScheduleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	       try {
	    	   Connection conn = MySQLConnUtils.getMySQLConnection();
		       System.out.println("Get connection " + conn);
		       String sql = "SELECT L.AirlineID, L.FlightNo FROM Leg L WHERE L.DepTime <= NOW();";
		       String sql2 = "SELECT L.AirlineID, L.FlightNo FROM Leg L WHERE L.DepTime > NOW();";
		       PreparedStatement statement = conn.prepareStatement(sql);
		       PreparedStatement statement2 = conn.prepareStatement(sql2);
			
		       // Execute SQL statement returns a ResultSet object.
		       ResultSet rs = statement.executeQuery(sql);
		       ResultSet rs2 = statement2.executeQuery(sql2);
		       
		       List<beans.AirlineScheduleBeans> list = new ArrayList<beans.AirlineScheduleBeans>();
		       while (rs.next()) {
		    	   String airlineId = rs.getString(1);
		    	   String flightNo = rs.getString(2);
		    	   
		    	   beans.AirlineScheduleBeans info = new beans.AirlineScheduleBeans();
		    	   info.setAirlineId(airlineId);
		    	   info.setFlightNumber(flightNo);
		    	   info.setOnTime("Delayed");
		    	   info.setList();

		    	   list.add(info);
		       }
		       
		       while(rs2.next()){
		    	   String airlineId = rs.getString(1);
		    	   String flightNo = rs.getString(2);
		    	   
		    	   beans.AirlineScheduleBeans info = new beans.AirlineScheduleBeans();
		    	   info.setAirlineId(airlineId);
		    	   info.setFlightNumber(flightNo);
		    	   info.setOnTime("On Time");
		    	   info.setList();

		    	   list.add(info);
		       }
		       List<String> colNames = new ArrayList<String>();
		       colNames.add("Airline Id");
		       colNames.add("Flight Number");
		       colNames.add("Time Schedule");
		       
		       request.setAttribute("colNames", colNames);
		       request.setAttribute("rowVal", list);
		       request.getRequestDispatcher("/Manager/Results.jsp").forward(request, response);
//		       RequestDispatcher dispatcher = request.getServletContext().
//		    		   getRequestDispatcher("/flights.jsp");
//		       dispatcher.forward(request, response);
	       } catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	       }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
