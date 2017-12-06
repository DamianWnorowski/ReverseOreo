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
 * Servlet implementation class EmployeeListServlet
 */
@WebServlet("/EmployeeListServlet")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
	    	   Connection conn = MySQLConnUtils.getMySQLConnection();
		       System.out.println("Get connection " + conn);
		       
		       String sql = "SELECT P.FirstName, P.LastName, P.Address, P.City, P.State, P.ZipCode, P.Id, "
		       		+ "E.SSN, E.HourlyRate,  E.IsManager, E.StartDate "
		       		+ "FROM Person P, Employee E WHERE P.Id = E.Id;";
		       PreparedStatement statement = conn.prepareStatement(sql);
			
		       // Execute SQL statement returns a ResultSet object.
		       ResultSet rs = statement.executeQuery(sql);
		       List<beans.EmployeeInfo> list = new ArrayList<beans.EmployeeInfo>();
		       while (rs.next()) {
		    	   String firstName = rs.getString(1);
		    	   String lastName = rs.getString(2);
		    	   String address = rs.getString(3);
		    	   String city = rs.getString(4);
		    	   String state = rs.getString(5);
		    	   String zipcode = rs.getString(6);
		    	   String id = rs.getString(7);
		    	   String ssn = rs.getString(8);
		    	   String rate = rs.getString(9);
		    	   String isManager = rs.getString(10);
		    	   String startDate = rs.getString(11);
		    	   
		    	   beans.EmployeeInfo info = new beans.EmployeeInfo();
		    	   info.setFirstName(firstName);
		    	   info.setLastName(lastName);
		    	   info.setAddress(address);
		    	   info.setCity(city);
		    	   info.setState(state);
		    	   info.setZipcode(zipcode);
		    	   info.setId(id);
		    	   info.setSsn(ssn);
		    	   info.setRate(rate);
		    	   info.setIsManager(isManager);
		    	   info.setStartDate(startDate);
		    	   info.setList();
		    	   list.add(info);
		    	   
		       }
		       List<String> colNames = new ArrayList<String>();
		       colNames.add("First Name");
		       colNames.add("Last Name");
		       colNames.add("Address");
		       colNames.add("City");
		       colNames.add("State");
		       colNames.add("Zipcode");
		       colNames.add("Id");
		       colNames.add("SSN");
		       colNames.add("Hourly Rate");
		       colNames.add("Is Manager");
		       colNames.add("Start Date");
		       
		       
		       
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
