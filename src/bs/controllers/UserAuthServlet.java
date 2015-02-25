package bs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bs.dataaccess.CustomerDb;
import bs.dataaccess.UserAuthDb;
import bs.models.Customer;
import bs.models.UserAuth;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("insertUser");
		
		String Url = "";

		if (action.equals("usercred")) {
			Url = createUserAccount(request, response);
		}
		response.sendRedirect("AccountManagement.jsp");
		
	}

	private String createUserAccount(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		String passWord = request.getParameter("pass");
		
		UserAuth userToAdd = new UserAuth(userName, passWord);
		
		UserAuthDb.createUserAuth(userToAdd);
		request.getSession().setAttribute("username", userToAdd.getUsername());
		this.getServletConfig().getServletContext().setAttribute("username", userToAdd.getUsername());
		
		return "/customer/AccountManagement.jsp";

	}
	
	

}
