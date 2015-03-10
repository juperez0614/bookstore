package bs.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bs.dataaccess.CustomerDb;
import bs.dataaccess.UserAuthDb;
import bs.dataaccess.UserRoleDb;
import bs.models.Customer;
import bs.models.UserAuth;
import bs.models.UserRole;
import bs.util.CookieUtil;

/**
 * Servlet implementation class UserAuthServlet
 */
@WebServlet("/UserAuthServlet")
public class UserAuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAuthServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		System.out.println("actino is: " + action);
		String url = "index.jsp";
		if (action.equals("checkUser")) {
			url = checkUser(request, response);
		}

		response.sendRedirect(url);
	}

	private String checkUser(HttpServletRequest request,
			HttpServletResponse response) {
		//String test = (String) request.getSession().getAttribute("uname");
		UserAuth user = (UserAuth) request.getSession()
				.getAttribute("uname");

		String url = "";
		if (user == null) {
			Cookie[] cookies = request.getCookies();
			String username = CookieUtil.getCookieValue(cookies,
					"usernameCookie");

			System.out.println("username cookie is the following value: "
					+ username);
			// cookie doesn't exist, go to login
			if (username == null || username.equals("")) {
				url = "Login.jsp";
			}
			// if exist get user and go to home page
			else {
				user = UserAuthDb.getUserAuth(username);
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("customer",
						CustomerDb.getCustomerByUsername(user.getUsername()));
				url = "index.jsp";

			}
		} else {
			// if user exists go to home page TODO: consider where to route to
			url = "index.jsp";
		}

		return url;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String Url = "";
		String action = request.getParameter("insertUser");
		
System.out.println(action);
		if (action.equals("usercred")) {
			Url = createUserAccount(request, response);
			response.sendRedirect(Url);
		} else if (action.equals("login")) {
			Url = loginUserAccount(request, response);
			response.sendRedirect(Url);
		} else if (action.equals("usernameCheck")) {
			usernameCheck(request, response);
		}

	}

	private void usernameCheck(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("username");
		System.out.println("name is " + name);
		UserAuth returned = UserAuthDb.getUserAuth((String) request
				.getParameter("username"));

		if (returned == null) {
			out.println("<p style='color:green'> " + name + " is avaliable</p>");

		} else {
			out.println("<p style='color:red'> " + name
					+ " is  not avaliable</p>");
		}
	}

	private String loginUserAccount(HttpServletRequest request,
			HttpServletResponse response) {

		UserAuth returned = UserAuthDb.getUserAuth((String) request
				.getParameter("uname"));
		
		
		String password = request.getParameter("password");
		System.out.println("passworkd " + password);

		if (returned != null && returned.getPassword().equals(password)) {
			request.getSession().setAttribute("userauth", returned);
			UserRole userType = UserRoleDb.getUserRole(returned.getUsername());
			request.getSession().setAttribute("userrole", userType);
			Customer cReturned = CustomerDb.getCustomerByUsername(returned
					.getUsername());
			request.getSession().setAttribute("customer", cReturned);
			Cookie c = new Cookie("usernameCookie", returned.getUsername());
			c.setMaxAge(60 * 60 * 24 * 365 * 2);
			c.setPath("/");

			response.addCookie(c);
			return "index.jsp";
		} else {
			return "Login.jsp"; // TODO: redirect to error page ask to fix
		}

	}

	private String createUserAccount(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		System.out.println(passWord + " is the password");

		UserAuth userToAdd = new UserAuth(userName, passWord);

		UserAuth returnedUser = UserAuthDb.createUserAuth(userToAdd);
		request.getSession().setAttribute("uname",
				returnedUser);

		Cookie c = new Cookie("usernameCookie", userToAdd.getUsername());
		c.setMaxAge(60 * 60 * 24 * 365 * 2);
		c.setPath("/");
		response.addCookie(c);

		return "AccountManagement.jsp";
	}

}
