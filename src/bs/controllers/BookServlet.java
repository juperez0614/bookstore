package bs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bs.dataaccess.AuthorDb;
import bs.dataaccess.BookDb;
import bs.models.Author;
import bs.models.Book;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
		// TODO Auto-generated constructor stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("insertBook");

		String Url = "";

		if (action.equals("bookmanagement")) {
			Url = bookAccount(request, response);
		}
	}

	private String bookAccount(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		String isbn = request.getParameter("isbn");
		String summary = request.getParameter("summary");
		String price = request.getParameter("price");

		Book bookToAdd = new Book(Integer.parseInt(isbn),  Double.parseDouble(price), summary, title);

		BookDb.createBook(bookToAdd);

		// session.setAttribute("customer", customerToAdd);

		return "AuthorManagement.jsp";
	}
}
