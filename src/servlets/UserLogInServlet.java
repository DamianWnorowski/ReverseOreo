package servlets;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

public class UserLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public UserLogInServlet(){
		super();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request,
           HttpServletResponse response) throws ServletException, IOException {
	   response.setContentType("text/html");
	   PrintWriter out = response.getWriter();
	
	   String username = request.getParameter("username");
	   String password = request.getParameter("userpassword");
			
	   try {
		   Connection conn = MySQLConnUtils.getMySQLConnection();
		   System.out.println("Get connection " + conn);
		   String sql = "SELECT Username FROM UserAccounts WHERE Username='" + username + "' AND Password='"+ password + "';";
		   PreparedStatement statement = conn.prepareStatement(sql);
		
		   
		   ResultSet rs = statement.executeQuery(sql);
		   if(rs.next()){
			   //Username exists
			   System.out.println("Username Logged in");
		   }else{
			   out.print("<p style=\"color:red\">Invalid Username or Password</p>");
			   System.out.println("invalid password");
			   RequestDispatcher rd =request.getRequestDispatcher("login.jsp");  
	            rd.include(request,response);  
		   }	   
		      
	   } catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
	   }
	
	   System.out.println("user " + username + " pass " + password);	
	}
 
}
