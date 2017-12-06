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
 * Servlet implementation class ListRersrByNameServlet
 */
@WebServlet("/ListResrByName")
public class ListResrByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListResrByNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String firstname = request.getParameter("firstName");

		String lastname = request.getParameter("lastName");
//		String firstname = "Jane";
//		String lastname = "Smith";
		
		
		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			System.out.println("Get connection " + conn);
	       
			String sql = "SELECT R.ResrDate, R.ResrNo, R.BookingFee,  R.TotalFare, "
					+ "C.Id, P.FirstName, P.LastName, C.Email "
					+ "FROM Reservation R, Customer C, Person P "
					+ "WHERE R.AccountNo = C.AccountNo "
					+ "AND C.Id = P.Id "
					+ "AND P.FirstName = '" + firstname + "'"
					+ "AND P.LastName = '" + lastname + "';";
					
			PreparedStatement statement = conn.prepareStatement(sql);
		
	       // Execute SQL statement returns a ResultSet object.
			ResultSet rs = statement.executeQuery(sql);
			List<beans.SalesInfoBeans> list = new ArrayList<beans.SalesInfoBeans>();
			while (rs.next()) {
				String resrDate = rs.getString(1);
				String resrNo = rs.getString(2);
				String bookingFee = rs.getString(3);
				String totalFare = rs.getString(4);
				String id = rs.getString(5);
				String firstName = rs.getString(6);
				String lastName = rs.getString(7);
				String email = rs.getString(8);
				
				
	    	   
				beans.SalesInfoBeans info = new beans.SalesInfoBeans();
				info.setResrDate(resrDate);
				info.setResrNo(resrNo);
				info.setBookingFee(bookingFee);
				info.setTotalFare(totalFare);
				info.setId(id);
				info.setFirstName(firstName);
				info.setLastName(lastName);
				info.setEmail(email);
				info.setList();
				
				list.add(info);
	    	   
			}
			List<String> colNames = new ArrayList<String>();
			colNames.add("Reservation Date");
			colNames.add("Reservation Number");
			colNames.add("Booking Fee");
			colNames.add("Total Fare");
			colNames.add("Customer Id");
			colNames.add("First Name");
			colNames.add("Last Name");
			colNames.add("Email");
			
	       
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
