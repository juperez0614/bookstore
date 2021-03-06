package bs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bs.dataaccess.AuthorDb;
import bs.models.Author;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("insertAuthor");

		if (action.equals("authormanagement")) {
			authorAccount(request, response);
		}
	}

	private String authorAccount(HttpServletRequest request,
			HttpServletResponse response) {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String bio = request.getParameter("biography");

		Author authorToAdd = new Author(firstName, lastName, bio);

		AuthorDb.createAuthor(authorToAdd);

		return "AuthorManagement.jsp";
	}
}
