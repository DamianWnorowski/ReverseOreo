package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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
 * Servlet implementation class RecordReservationServlet
 */
//@WebServlet("/RecordReservationServlet")
public class RecordReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());	
		
		String accountNumber = request.getParameter("accountNumber");
		String bookingFee = request.getParameter("bookingFee");
		String totalFare = request.getParameter("totalFare");
		String repId = request.getParameter("repId");
		int resrNumber = 0;
		
		long millis=System.currentTimeMillis();  
		Date date=new Date(millis);  
		System.out.println(date);  

		
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			System.out.println("Get connection " + conn);
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
			statement.setFloat(3, Float.parseFloat(bookingFee));
			statement.setFloat(4, Float.parseFloat(totalFare));
			statement.setString(5, repId);
			statement.setString(6, accountNumber);
			statement.execute();
		    
	       
			//IMPORTANT CHANGE FORWARD ADDRESS
			request.getRequestDispatcher("/Employee/Home.jsp").forward(request, response);

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
