package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewEmployeeServlet
 */
@WebServlet("/AddNewEmployeeServlet")
public class AddNewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewEmployeeServlet() {
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
		String ssn = request.getParameter("SSN");
		String phonenum = request.getParameter("phonenum");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String id = request.getParameter("id");
		String plaintextPw = request.getParameter("userpassword");
		String password = "";
		float rate = 15;

		long millis=System.currentTimeMillis();  
		Date date=new Date(millis);  
		System.out.println(date);  

		int isManager = 0;
		if(request.getParameter("position").equals("manager")){
			isManager = 1;
			rate = 20;
			System.out.println("employee is a manager");
		}

		try {
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-512");
			md.update(id.getBytes("UTF-8"));
			byte[] bytes = md.digest(plaintextPw.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++){
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
			String sql = "SELECT Id FROM Employee WHERE Id='" + id + "';";
			PreparedStatement statement = conn.prepareStatement(sql);

			// Execute SQL statement returns a ResultSet object.
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()){
				//Username exists
				System.out.println("Username Taken");
			}else{
				sql = "INSERT INTO Employee (Id, SSN, IsManager, StartDate, HourlyRate, Password) VALUES (?, ?, ?, ? ,? ,?)";
				statement = conn.prepareStatement(sql);
				statement.setString(1, id);
				statement.setInt(2, Integer.parseInt(ssn));
				statement.setInt(3, isManager);
				statement.setDate(4, date);
				statement.setFloat(5, rate);  	   
				statement.setString(6, password);
				statement.execute();

				sql = "INSERT INTO Person (Id, FirstName, LastName, Address, City, State, ZipCode) VALUES (?, ?, ?, ? ,? ,?,?)";
				statement = conn.prepareStatement(sql);
				statement.setString(1, id);
				statement.setString(2, firstname);
				statement.setString(3, lastname);
				statement.setString(4, address1 +" "+ address2);
				statement.setString(5, city);
				statement.setString(6, state);
				statement.setInt(7, Integer.parseInt(zipcode));  	   
				statement.execute();



				request.getRequestDispatcher("/usercreated.jsp").forward(request, response);
			}
			rs.close();
			statement.close();
			conn.close();


		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("user " + id + " pass " + password);
	}

}
