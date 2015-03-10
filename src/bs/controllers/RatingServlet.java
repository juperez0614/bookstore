package bs.controllers;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bs.dataaccess.RatingDb;
import bs.models.Customer;
import bs.models.Rating;

/**
 * Servlet implementation class RatingServlet
 */
@WebServlet("/RatingServlet")
public class RatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RatingServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		
		
		Customer c = (Customer) request.getSession().getAttribute("customer");
		String ratingReview = request.getParameter("ratingReview");
		String bookid = request.getParameter("bookid");
		String ratingRank = request.getParameter("ratingNumber");
		
		Rating nRating = new Rating(Integer.parseInt(ratingRank), ratingReview);
		nRating.setRatingDate(new java.sql.Date(currentDate.getTime()));
		
		nRating.setBookid(Integer.parseInt(bookid));
		nRating.setCustomerid(c.getId());
		
		RatingDb.createRating(nRating);
		
		response.sendRedirect("BookServlet?action=" + nRating.getBookid());

	}

}
