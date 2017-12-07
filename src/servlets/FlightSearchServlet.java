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
 * Servlet implementation class FlightSearchServlet
 */
//@WebServlet("/FlightSearchServlet")
public class FlightSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String origin = request.getParameter("origin");
		String dest = request.getParameter("destination");
		
		String trip = request.getParameter("trip");
		System.out.println("origin: " + origin + " dest: " + dest + " trip " + trip);
		
		try {
			if(trip.equals("oneway")) {
				Connection conn = MySQLConnUtils.getMySQLConnection();
				System.out.println("Get connection " + conn);
				String sql = "SELECT DISTINCT L2.AirlineID, L2.FlightNo "
						+ "FROM Leg L1, Leg L2 "
						+ "WHERE L1.DepAirportID = '" + origin + "' "
						+ "AND L2.ArrAirportID = '" + dest + "' "
						+ "AND L1.AirlineID = L2.AirlineID "
						+ "AND L1.FlightNo = L2.FlightNo;";
				PreparedStatement statement = conn.prepareStatement(sql);
	
				// Execute SQL statement returns a ResultSet object.
				ResultSet rs = statement.executeQuery(sql);
				List<beans.FlightLegBeans> list = new ArrayList<beans.FlightLegBeans>();
				while (rs.next()) {
					String airlineId = rs.getString(1);
					String flightNumber = rs.getString(2);
					String dept = origin;
					String arr = dest;
//					String fare = "1000";
	
					
					String sql2 = "Select Fare From Fare WHERE AirlineId = '" + airlineId +"' "
							+ "AND FlightNo = " + flightNumber + ";";
					PreparedStatement statement2 = conn.prepareStatement(sql2);
					ResultSet rs2 = statement2.executeQuery(sql2);
					String fare = "";
					if(rs2.next()) {
						fare = rs2.getString(1);
					}
	
					beans.FlightLegBeans info = new beans.FlightLegBeans();
					info.setAirlineId(airlineId);
					info.setFlightNumber(flightNumber);
					info.setDept(dept);
					info.setArr(arr);
					info.setPrice(fare);
					info.setList();
	
					list.add(info);
	
				}
				List<String> colNames = new ArrayList<String>();
				colNames.add("Airline Id");
				colNames.add("Flight Number");
				colNames.add("Origin");
				colNames.add("Destination");
				colNames.add("Price");
				
				request.setAttribute("colNames", colNames);
				request.setAttribute("rowVal", list);
				request.getRequestDispatcher("Results.jsp").forward(request, response);
				
				rs.close();
				statement.close();
				conn.close();
				
			}else {
				System.out.println("ROUND TRIP");
				Connection conn = MySQLConnUtils.getMySQLConnection();
				System.out.println("Get connection " + conn);
				String sql = "SELECT DISTINCT L1.AirlineID, L1.FlightNo, L3.AirlineID, L3.FlightNo "
						+ "FROM Leg L1, Leg L2, Leg L3, Leg L4 "
						+ "WHERE L1.DepAirportID = '" + origin + "' "
						+ "AND L2.ArrAirportID = '" + dest + "' "
						+ "AND L3.DepAirportID = '" + dest + "' "
						+ "AND L4.ArrAirportID = '" + origin + "' "
						+ "AND L1.AirlineID = L2.AirlineID "
						+ "AND L1.FlightNo = L2.FlightNo "
						+ "AND L3.AirlineID = L4.AirlineID "
						+ "AND L3.FlightNo = L4.FlightNo;";
				System.out.println("after statement");
				PreparedStatement statement = conn.prepareStatement(sql);
	
				// Execute SQL statement returns a ResultSet object.

				ResultSet rs = statement.executeQuery(sql);
				List<beans.FlightLegRoundBeans> list = new ArrayList<beans.FlightLegRoundBeans>();
				while (rs.next()) {
					String airlineIdDest = rs.getString(1);
					String flightNumberDest = rs.getString(2);
					String airlineIdBack = rs.getString(3);
					String flightNumberBack =  rs.getString(4);
					String fare = "1000";
	
					
//					String sql2 = "Select Fare From Fare WHERE AirlineId = '" + origin +"' "
//							+ "AND FlightNo = " + dest + ";";
//					PreparedStatement statement2 = conn.prepareStatement(sql2);
//					ResultSet rs2 = statement2.executeQuery(sql2);
//					String fare = "";
//					if(rs2.next()) {
//						fare = rs2.getString(1);
//					}
	
					beans.FlightLegRoundBeans info = new beans.FlightLegRoundBeans();
					info.setAirlineIdDest(airlineIdDest);
					info.setFlightNumberDest(flightNumberDest);
					info.setAirlineIdBack(airlineIdBack);
					info.setFlightNumberBack(flightNumberBack);
					info.setPrice(fare);
					info.setList();
	
					list.add(info);
	
				}
				List<String> colNames = new ArrayList<String>();
				colNames.add("Airline Id to Dest");
				colNames.add("Flight Number to Dest");
				colNames.add("Airline Id Back");
				colNames.add("Flight Number Back");
				colNames.add("Price");
				
				request.setAttribute("colNames", colNames);
				request.setAttribute("rowVal", list);
				request.getRequestDispatcher("Results.jsp").forward(request, response);
				
				rs.close();
				statement.close();
				conn.close();
			}

			

			

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
