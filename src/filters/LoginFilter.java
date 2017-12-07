package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/LoginFilter")
public class LoginFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		System.out.println("Requested Resource::"+uri);


		HttpSession session = req.getSession(false);
		
		/* if first access or timeout */
		if(session == null) {
			System.out.println("Unauthorized access request");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.include(req, res);
			return;
		} else if(uri.endsWith("UserLogInServlet") || uri.endsWith("SignUpServlet") || uri.endsWith("signup.jsp")) {
			System.out.println("No Access permissions required");
			chain.doFilter(request, response);
			return;
		}
		

		if(session != null) {
			String user = (String) session.getAttribute("user");
			if(user != null) {
				System.out.println("Stored user in session is: " + user);						
				System.out.println("Access granted");
				chain.doFilter(request, response);
				return;
			} else {
				System.out.println("Unauthorized access request");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.include(req, res);
				return;
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
