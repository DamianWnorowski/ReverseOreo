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
 * Servlet implementation class MostActiveFlightsServlet
 */
//@WebServlet("/MostActiveFlightsServlet")
public class MostActiveFlightsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostActiveFlightsServlet() {
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
	       
			String sql = "SELECT I.AirlineId, I.FlightNo, COUNT(I.ResrNo) "
					+ "AS total_reservations "
					+ "FROM Includes I "
					+ "GROUP BY I.AirlineId "
					+ "ORDER BY total_reservations DESC;";
			PreparedStatement statement = conn.prepareStatement(sql);
		
	       // Execute SQL statement returns a ResultSet object.
			ResultSet rs = statement.executeQuery(sql);
			List<beans.MostActiveFlightsBeans> list = new ArrayList<beans.MostActiveFlightsBeans>();
			while (rs.next()) {
				String airlineId = rs.getString(1);
				String flightNumber = rs.getString(2);
				String totalResr = rs.getString("total_reservations");
				
				
	    	   
				beans.MostActiveFlightsBeans info = new beans.MostActiveFlightsBeans();
				info.setAirlineId(airlineId);
				info.setFlightNumber(flightNumber);
				info.setTotalResr(totalResr);
				info.setList();
				
				list.add(info);
	    	   
			}
			List<String> colNames = new ArrayList<String>();
			colNames.add("Airline Id");
			colNames.add("Flight Number");
			colNames.add("Total Reservations");
	       
			request.setAttribute("colNames", colNames);
			request.setAttribute("rowVal", list);
	       
			//IMPORTANT CHANGE FORWARD ADDRESS
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
