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
 * Servlet implementation class RevenueSummaryServlet
 */
//@WebServlet("/RevenueSummaryServlet")
public class RevenueSummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevenueSummaryServlet() {
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
			
			String summaryBy = request.getParameter("searchBy");
			String searchValue = request.getParameter("searchValue");
	       
			String sql = "";
			
			if(summaryBy.equals("flight")){
				sql = "SELECT R.BookingFee "
						+ "FROM Reservation R "
						+ "WHERE R.ResrNo "
						+ "IN (SELECT I.ResrNo "
						+ "FROM Includes I "
						+ "WHERE I.FlightNo = " + searchValue + ");";
			}else if(summaryBy.equals("city")){
				sql = "SELECT R.BookingFee "
						+ "FROM Reservation R "
						+ "WHERE R.ResrNo "
						+ "IN (SELECT I.ResrNo "
						+ "FROM Includes I "
						+ "WHERE I.LegNo "
						+ "IN (SELECT L.LegNo "
						+ "FROM Leg L "
						+ "WHERE L.ArrAirportId "
						+ "IN (SELECT A.Id "
						+ "FROM Airport A "
						+ "WHERE A.City = '" + searchValue +"') ));";
			}else if(summaryBy.equals("customer")){
				sql = "SELECT R.BookingFee FROM Reservation R WHERE R.AccountNo = " + searchValue + ";";
			}
			
			PreparedStatement statement = conn.prepareStatement(sql);
		
	       // Execute SQL statement returns a ResultSet object.
			ResultSet rs = statement.executeQuery(sql);
			List<beans.RevenueSummaryBeans> list = new ArrayList<beans.RevenueSummaryBeans>();
			while (rs.next()) {
				String bookingFee = rs.getString(1);

				
				
	    	   
				beans.RevenueSummaryBeans info = new beans.RevenueSummaryBeans();
				info.setSummaryBy(searchValue);
				info.setBookingFee(bookingFee);
				info.setList();
				
				list.add(info);
	    	   
			}
			List<String> colNames = new ArrayList<String>();
			colNames.add("Summary By");
			colNames.add("Booking Fee");

	       
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
