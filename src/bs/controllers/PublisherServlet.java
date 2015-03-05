package bs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bs.dataaccess.PublisherDb;
import bs.models.Publisher;

/**
 * Servlet implementation class PublisherServlet
 */
@WebServlet("/PublisherServlet")
public class PublisherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublisherServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("insertPub");

		String Url = "";

		if (action.equals("publishermanagement")) {
			Url = pubAccount(request, response);
		}
	}

	private String pubAccount(HttpServletRequest request,
			HttpServletResponse response) {
		
		String companyName = request.getParameter("companyname");
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String phone = request.getParameter("phone");
		String poc = request.getParameter("poc");
		
		Publisher pubToAdd = new Publisher(companyName, address, address2, city, state, Integer.parseInt(zipcode), phone, poc);

		PublisherDb.createPublisher(pubToAdd);

		// session.setAttribute("customer", customerToAdd);

		return "AuthorManagement.jsp";
	}
}
