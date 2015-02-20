package bs.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bs.dataaccess.CustomerDb;
import bs.models.Customer;

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
		// TODO Auto-generated constructor stub
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
		String action = request.getParameter("insertCust");
		
		String Url = "";

		if (action.equals("addCustomer")) {
			Url = createCustomerAccount(request, response);
		}
	}
	
	private String createCustomerAccount(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String email = request.getParameter("email");
		
		Customer customerToAdd = new Customer(firstName, lastName, address, address2, city, state, Integer.parseInt(zipcode), email, 1);
		int idCheck = CustomerDb.emailExists(email);
		System.out.println(idCheck);
		if (idCheck != 0){ // move to update
			customerToAdd.setId(idCheck);
			CustomerDb.updateCustomer(customerToAdd);
		}
		else { // move to create new user
			CustomerDb.createCustomer(customerToAdd);
		}
		
		
		session.setAttribute("customer", customerToAdd);
		
		return "addAccount.jsp";
	}
}
