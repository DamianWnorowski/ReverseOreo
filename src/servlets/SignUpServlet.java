package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("userpassword");
		
		try {
	    	   Connection conn = MySQLConnUtils.getMySQLConnection();
		       System.out.println("Get connection " + conn);
		       String sql = "SELECT Username FROM UserAccounts WHERE Username='" + username + "';";
		       PreparedStatement statement = conn.prepareStatement(sql);
			
		       // Execute SQL statement returns a ResultSet object.
		       ResultSet rs = statement.executeQuery(sql);
		       if(rs.next()){
		    	   //Username exists
		    	   System.out.println("Username Taken");
		       }else{
		    	   sql = "INSERT INTO UserAccounts (Username, Password) VALUES (?, ?)";
		    	   statement = conn.prepareStatement(sql);
		    	   statement.setString(1, username);
		    	   statement.setString(2, password);
		    	   statement.execute();
		    	   
		    	   request.getRequestDispatcher("/usercreated.jsp").forward(request, response);
		       }
		    	   
		      
	       } catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println("user " + username + " pass " + password);
		
		

		
	}

}
