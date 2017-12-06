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
 * Servlet implementation class EmployeeRevenueServlet
 */
//@WebServlet("/EmployeeRevenueServlet")
public class EmployeeRevenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRevenueServlet() {
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
	       
			String sql = "SELECT P.FirstName, P.LastName, P.Id, SUM(R.BookingFee) "
					+ "AS TotalRevenue "
					+ "FROM Person P, Employee E, Reservation R "
					+ "WHERE P.Id = E.Id "
					+ "AND E.SSN = R.RepSSN "
					+ "GROUP BY P.Id "
					+ "ORDER BY TotalRevenue "
					+ "DESC LIMIT 1;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
		
	       // Execute SQL statement returns a ResultSet object.
			ResultSet rs = statement.executeQuery(sql);
			List<beans.CustomerRevenueBeans> list = new ArrayList<beans.CustomerRevenueBeans>();
			while (rs.next()) {
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				String id = rs.getString(3);
				String totalRevenue = rs.getString(4);
				
				
	    	   
				beans.CustomerRevenueBeans info = new beans.CustomerRevenueBeans();
				info.setFirstName(firstName);
				info.setLastName(lastName);
				info.setId(id);
				info.setTotalRevenue(totalRevenue);
				info.setList();
				
				list.add(info);
	    	   
			}
			List<String> colNames = new ArrayList<String>();
			colNames.add("First Name");
			colNames.add("Last Name");
			colNames.add("Id");
			colNames.add("Total Revenue");
	       
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
