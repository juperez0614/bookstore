package bs.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bs.dataaccess.BookAuthorDb;
import bs.dataaccess.BookDb;
import bs.models.Book;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		String displayUrl = "";

		if (action.equals("genre")) {
			displayUrl = getAllBooksForGenre(request, response);
		}

		if (action.equals("search")) {
			String searchtype = request.getParameter("searchtype");
			String searchTerm = request.getParameter("searchbar");
			displayUrl = conductSearch(request, response, searchtype,
					searchTerm);
		}
		response.sendRedirect(displayUrl);
	}

	private String getAllBooksForGenre(HttpServletRequest request,
			HttpServletResponse response) {
		String genre = request.getParameter("genreitem");
		List<Book> b = new ArrayList<Book>();

		b = BookDb.getBookByGenre(genre);

		request.getSession().setAttribute("genreList", b);

		return "GenreBookDisplay.jsp";
	}

	private String conductSearch(HttpServletRequest request,
			HttpServletResponse response, String type, String term) {
		List<Book> b = new ArrayList<Book>();

		if (type.equals("author")) {
			b = BookAuthorDb.getBookByAuthor(term);
		} else if (type.equals("title")) {
			b = BookDb.getBookByTitle(term);
		} else if (type.equals("genre")) {
			b = BookDb.getBookByGenre(term);
		} else if (type.equals("publisher")) {
			b = BookDb.getBookByPub(term);
		} else if (type.equals("isbn")) {
			b = BookDb.getBookByISBN(term);
		} else {
			return "index.jsp"; // should be error page
		}

		request.getSession().setAttribute("genreList", b);
		return "GenreBookDisplay.jsp";
	}
}
