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

/* For hashing */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


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
		String plaintextPw = request.getParameter("userpassword");

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
