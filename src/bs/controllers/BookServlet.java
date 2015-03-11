package bs.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bs.dataaccess.BookDb;
import bs.dataaccess.InventoryDb;
import bs.dataaccess.RatingDb;
import bs.models.Book;
import bs.models.Inventory;
import bs.models.Rating;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		String displayUrl = "";


		if (action.equals("getall")) {
			displayUrl = getAll(request, response);

		} else if (action.matches("\\d+")) {
			displayUrl = getBook(request, response);
			request.getSession().setAttribute("ratingList",
					RatingDb.getLast5RatingByBook(Integer.parseInt(action)));
		} else if (action.equals("showAllRatings")) {
			String bookId = request.getParameter("bookId");
			request.getSession().setAttribute("ratingList",
					RatingDb.getAllRatingByBook(Integer.parseInt(bookId)));
			displayUrl = "BookDetails.jsp?id=" + Integer.parseInt(bookId);
		}
		response.sendRedirect(displayUrl);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("insertBook");

		String Url = "";

		if (action.equals("bookmanagement")) {
			Url = bookAccount(request, response);
		}

		response.sendRedirect(Url);
	}

	private String getBook(HttpServletRequest request,
			HttpServletResponse response) {
		Book b = new Book();
		Inventory i = new Inventory();
		Rating r = new Rating();
		b = BookDb.getBook(Integer.parseInt(request.getParameter("action")));
		i = InventoryDb.getInventory(b.getId());
		r = RatingDb.getRating(b.getId());
		request.getSession().setAttribute("Book", b);
		request.getSession().setAttribute("Inventory", i);
		request.getSession().setAttribute("Rating", r);
		return "BookDetails.jsp?id=" + b.getId();
	}

	private String getAll(HttpServletRequest request,
			HttpServletResponse response) {
		List<Book> b = new ArrayList<Book>();

		b = BookDb.getAllBooks();

		request.getSession().setAttribute("List", b);

		return "BookDisplay.jsp";

	}

	private String bookAccount(HttpServletRequest request,
			HttpServletResponse response) {
		String title = request.getParameter("title");
		String isbn = request.getParameter("isbn");
		String summary = request.getParameter("summary");
		String price = request.getParameter("price");

		Book book = new Book(Integer.parseInt(isbn), Double.parseDouble(price),
				summary, title);

		BookDb.createBook(book);
		return "AuthorManagement.jsp";
	}
}
