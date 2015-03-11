package bs.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bs.dataaccess.CustomerDb;
import bs.dataaccess.InvoiceDb;
import bs.dataaccess.RatingDb;
import bs.dataaccess.UserAuthDb;
import bs.models.Customer;
import bs.models.Invoice;
import bs.models.Rating;
import bs.models.UserAuth;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String url = "";
		
		if (action.matches("\\d+")){
			url = getCustomer(request, response);
		}
		
		response.sendRedirect(url);

	}
	
	private String getCustomer(HttpServletRequest request,
			HttpServletResponse response) {
		Customer c = new Customer();
		List<Rating> rList = new ArrayList<Rating>();
		List<Invoice> iList = new ArrayList<Invoice>();
		c = CustomerDb.getCustomer(Integer.parseInt(request.getParameter("action")));
		iList = InvoiceDb.getInvoiceListForCustomer(c.getId());
		rList = RatingDb.getRatingByCustomer(c.getId());
		System.out.println("customer id" + c.getId());
		System.out.println("rlist" + rList.size());
		request.getSession().setAttribute("customer", c);
		request.getSession().setAttribute("invoiceList", iList);
		request.getSession().setAttribute("customerRatings", rList);
		return "CustomerDetails.jsp?id=" + c.getId();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("insertCust");
		UserAuth username = (UserAuth) request.getSession()
				.getAttribute("uname");

		String Url = "";

		if (action.equals("addCustomer")) {
			Url = createCustomerAccount(request, response, username.getUsername());
		}

		response.sendRedirect(Url);

	}

	private String createCustomerAccount(HttpServletRequest request,
			HttpServletResponse response, String username) {
		HttpSession session = request.getSession();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String email = request.getParameter("email");

		Customer customerToAdd = new Customer(firstName, lastName, address,
				address2, city, state, Integer.parseInt(zipcode), email,
				UserAuthDb.getUserAuth(username));
		int idCheck = CustomerDb.emailExists(email);
		Customer returned = new Customer();
		if (idCheck != 0) { // move to update
			customerToAdd.setId(idCheck);
			returned = CustomerDb.updateCustomer(customerToAdd);
		} else { // move to create new user
			returned = CustomerDb.createCustomer(customerToAdd);
		}

		session.setAttribute("customer", returned);

		return "index.jsp";
	}
}
