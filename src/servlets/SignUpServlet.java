package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String email = request.getParameter("email");
		String phonenum = request.getParameter("phonenum");
		String address1 = request.getParameter("address1");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		int accountnumber = 0;
		
		long millis=System.currentTimeMillis();  
        Date date=new Date(millis);  
        System.out.println(date);  
		
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
		       String sql = "SELECT Id FROM Person WHERE Id='" + username + "';";
		       PreparedStatement statement = conn.prepareStatement(sql);
			
		       // Execute SQL statement returns a ResultSet object.
		       ResultSet rs = statement.executeQuery(sql);
		       if(rs.next()){
		    	   //Username exists
		    	   System.out.println("Username Taken");
		       }else{
		    	   sql = "SELECT COUNT(*) AS total FROM Customer";
		    	   statement = conn.prepareStatement(sql);
		    	   rs = statement.executeQuery(sql);
		    	   
		    	   rs.next();
		    	   accountnumber = rs.getInt("total");
		    	   System.out.println("Accounts: " + accountnumber);
		    	   accountnumber++;
		    	   System.out.println("Accounts: " + accountnumber);
		    	   
		    	   
		    	   sql = "INSERT INTO Customer (Id, AccountNo, CreditCardNo, Email, CreationDate, Rating, Password) VALUES (?, ?, ?, ?, ?, ?, ?)";
		    	   statement = conn.prepareStatement(sql);
		    	   statement.setString(1, username);
		    	   statement.setInt(2, accountnumber);
		    	   statement.setString(3, "");
		    	   statement.setString(4, email);
		    	   statement.setDate(5, date);
		    	   statement.setInt(6, 0);
		    	   statement.setString(7, password);
		    	   statement.execute();
		    	   
		    	   sql = "INSERT INTO Person (Id, FirstName, LastName, Address, City, State, ZipCode) VALUES (?, ?, ?, ? ,? ,?,?)";
		    	   statement = conn.prepareStatement(sql);
		    	   statement.setString(1, username);
		    	   statement.setString(2, firstname);
		    	   statement.setString(3, lastname);
		    	   statement.setString(4, address1);
		    	   statement.setString(5, city);
		    	   statement.setString(6, state);
		    	   statement.setInt(7, Integer.parseInt(zipcode));  	   
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
