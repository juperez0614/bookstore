package bs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bs.dataaccess.AuthorDb;
import bs.dataaccess.CustomerDb;
import bs.models.Author;
import bs.models.Customer;

/**
 * Servlet implementation class AuthorServlet
 */
@WebServlet("/AuthorServlet")
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorServlet() {
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
		String action = request.getParameter("insertAuthor");
		
		String Url = "";

		if (action.equals("authormanagement")) {
			Url = authorAccount(request, response);
		}
	}

	private String authorAccount(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String bio = request.getParameter("biography");

		
		Author authorToAdd = new Author(firstName, lastName, bio);

		AuthorDb.createAuthor(authorToAdd);
		
		
		//session.setAttribute("customer", customerToAdd);
		
		return "AuthorManagement.jsp";
	}
}
