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
		System.out.println("origin: " + origin + " dest: " + dest);
		
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			System.out.println("Get connection " + conn);
			String sql = "SELECT * FROM Leg "
					+ "WHERE DepAirportID = '" + origin + "' "
							+ "AND ArrAirportID = '" + dest + "';";
			PreparedStatement statement = conn.prepareStatement(sql);

			// Execute SQL statement returns a ResultSet object.
			ResultSet rs = statement.executeQuery(sql);
			List<beans.FlightLegBeans> list = new ArrayList<beans.FlightLegBeans>();
			while (rs.next()) {
				String airlineId = rs.getString(1);
				String flightNumber = rs.getString(2);
				String legNumber = rs.getString(3);
				String dept = rs.getString(4);
				String arr = rs.getString(5);
				String arrTime = rs.getString(6);
				String deptTime = rs.getString(7);

				beans.FlightLegBeans info = new beans.FlightLegBeans();
				info.setAirlineId(airlineId);
				info.setFlightNumber(flightNumber);
				info.setLegNumber(legNumber);
				info.setDept(dept);
				info.setArr(arr);
				info.setArrTime(arrTime);
				info.setDeptTime(deptTime);
				info.setList();

				list.add(info);

			}
			List<String> colNames = new ArrayList<String>();
			colNames.add("Airline Id");
			colNames.add("Flight Number");
			colNames.add("Leg Number");
			colNames.add("Origin");
			colNames.add("Destination");
			colNames.add("Arrival Time");
			colNames.add("Departing Time");
			

			request.setAttribute("colNames", colNames);
			request.setAttribute("rowVal", list);
			request.getRequestDispatcher("Results.jsp").forward(request, response);
			rs.close();
			statement.close();
			conn.close();

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
