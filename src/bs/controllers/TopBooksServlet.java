package bs.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bs.dataaccess.BookDb;
import bs.dataaccess.GenreDb;
import bs.models.Book;
import bs.models.Genre;

/**
 * Servlet implementation class TopBooksServlet
 */
@WebServlet("/TopBooksServlet")
public class TopBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Book> topTen = BookDb.getTopTenBooks();
		List<Book> trending = BookDb.getTrendingBooks();
		List<Genre> genreTable = GenreDb.getAll();
		
		if(topTen != null ){
			request.getSession().setAttribute("topten", topTen);	
		}
		if(trending != null ){
			request.getSession().setAttribute("trending", trending);
		}
		
		request.getSession().setAttribute("genretable", genreTable);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
	}

}
