package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import filters.User;

/**
 * Servlet implementation class CustomerReserveServlet
 */
//@WebServlet("/CustomerReserveServlet")
public class CustomerReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReserveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(false);
		System.out.println("customer reserve servlet");
		
		String flightId = request.getParameter("flightid");
		String flightNumber = request.getParameter("flightnumber");
		String origin = request.getParameter("origin");
		int resrNumber = 0;
		
		String AccNo="";

		filters.User user = new User();
		user = (User)session.getAttribute("user");
		String username = user.getUsername();
		
		long millis=System.currentTimeMillis();  
		Date date=new Date(millis);  
		System.out.println(date);  

		
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			System.out.println("Get connection " + conn);
			
			String sqlUser = "SELECT AccountNo FROM Customer WHERE Id = '" + username + "';";
			PreparedStatement statementUser = conn.prepareStatement(sqlUser);
			ResultSet rsUser = statementUser.executeQuery(sqlUser);
			int accountNo = 0;
			
			if(rsUser.next()) {
				accountNo = rsUser.getInt(1);
			}
			
			String sql = "SELECT MAX(ResrNo) FROM Reservation;";
					
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery(sql);
			
			if(rs.next()){
				resrNumber = rs.getInt(1);
			}
			resrNumber++;
			System.out.println("resrvation number: " + resrNumber);
	       
			String sql2 = "INSERT INTO Reservation(ResrNo, ResrDate, BookingFee, TotalFare, RepId, AccountNo)"
					+ "VALUES(?, ?, ?, ?, ?, ?)";
			
			statement = conn.prepareStatement(sql2);
			statement.setInt(1, resrNumber);
			statement.setDate(2, date);
			statement.setFloat(3, 0);
			statement.setFloat(4, 0);
			statement.setString(5, "");
			statement.setInt(6, accountNo);
			statement.execute();
			
			String sql3 = "SELECT LegNo From Leg "
					+ "WHERE AirlineId = '" + flightId + "' "
					+ "AND FlightNo = '" + flightNumber + "' "
					+ "AND DepAirportID = '" + origin + "' ";
			
			PreparedStatement statement3 = conn.prepareStatement(sql3);
			ResultSet rs3 = statement.executeQuery(sql);
			
			rs3.next();
			
			
			int legNo = rs3.getInt(1);
			
			String sql4 = "INSERT INTO Includes(ResrNo, AirlineID, FlightNo, LegNo, Date) "
					+ "VALUES (?, ?, ?, ?, ?);";
			
			PreparedStatement statement4 = conn.prepareStatement(sql4);
			statement4.setInt(1, resrNumber);
			statement4.setString(2, flightId);
			statement4.setInt(3, Integer.parseInt(flightNumber));
			statement4.setInt(4, legNo);
			statement4.setDate(5, date);
			statement4.execute();
			
			String sql6 = "INSERT INTO ReservationPassenger(ResrNo, Id, AccountNo, SeatNo, Class, Meal) "
					+ "VALUES(?, ?, ?, ?, ?, ?);";
			
			statement = conn.prepareStatement(sql6);
			statement.setInt(1, resrNumber);
			statement.setString(2, username);
			statement.setInt(3, accountNo);
			statement.setString(4, "2");
			statement.setString(5, "regular");
			statement.setString(6, "yummy");
			statement.execute();
			
			
			
			
			
		    
	       
			//IMPORTANT CHANGE FORWARD ADDRESS
			request.getRequestDispatcher("Results.jsp").forward(request, response);

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
