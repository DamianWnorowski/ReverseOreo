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
		       String sql = "SELECT * FROM Flight;";
		       PreparedStatement statement = conn.prepareStatement(sql);
			
		       // Execute SQL statement returns a ResultSet object.
		       ResultSet rs = statement.executeQuery(sql);
		       List<beans.flight> list = new ArrayList<beans.flight>();
		       while (rs.next()) {
		    	   String airplaneId = rs.getString(1);
		    	   String airplaneName = rs.getString(2);
		    	   beans.flight f = new beans.flight();
		    	   f.setAirplaneId(airplaneId);
		    	   f.setAirplaneName(airplaneName);
		    	   f.setList();
		    	   list.add(f);
		    	   
		       }
		       List<String> colNames = new ArrayList<String>();
		       colNames.add("Airplane Name");
		       colNames.add("Airplane ID");
		       
		       request.setAttribute("colNames", colNames);
		       request.setAttribute("rowVal", list);
		       request.getRequestDispatcher("/flightlist.jsp").forward(request, response);
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
