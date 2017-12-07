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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import filters.User;

/* For hashing */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
		String plaintextPw = request.getParameter("userpassword");
		
		/* If pw field was left empty */
		if(plaintextPw.equals("")){
			out.print("<p style=\"color:red\">Pw left blank</p>");
			System.out.println("Empty password provided");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		String password = "";

		try {
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-512");
			md.update(username.getBytes("UTF-8"));
			byte[] bytes = md.digest(plaintextPw.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < bytes.length; i++){
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			password = sb.toString();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			System.out.println("No such algorithm.");
			e1.printStackTrace();
		}

		password = password.substring(0, 20);
		System.out.println("The password after hashing and truncating is " + password);


		try {
			Connection conn = MySQLConnUtils.getMySQLConnection();
			System.out.println("Get connection " + conn);
			String sql = "SELECT Username "
					+ "FROM UserAccounts U, Customer C "
					+ "WHERE U.Username='" + username + "' "
					+ "AND U.password='" + password + "' "
					+ "AND C.Id='" + username + "';";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()){
				//Username exists
				System.out.println("Logged in");
				/* For login */
				HttpSession session = request.getSession();
				User user = new User();
				user.setUsername(username);
				user.setRole("Customer");
				session.setAttribute("user", user);
				
				/* For logout expiration */
				// now I use only session timeout for login expiration 
				
				response.sendRedirect("HomePage.jsp");
			}else{
				out.print("<p style=\"color:red\">Invalid Username or Password</p>");
				System.out.println("invalid password");
//				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");  
//				rd.include(request,response);  
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			rs.close();
			statement.close();
			conn.close();

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("user " + username + " pass " + password);	
	}

}
