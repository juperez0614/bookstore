package bs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bs.dataaccess.InvoiceDb;
import bs.dataaccess.LineItemDb;
import bs.models.Book;
import bs.models.Cart;
import bs.models.Customer;
import bs.models.Invoice;
import bs.models.LineItem;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
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
		// TODO Auto-generated method stub
		//System.out.println("made it into cart servlet");
		Invoice toCheck = (Invoice)request.getSession().getAttribute("Invoice");
		if (toCheck == null) {
			Customer c = (Customer) request.getSession().getAttribute(
					"customer");
			System.out.println("Created customer id: " + c.getId());
			Invoice invoice = new Invoice();
			invoice.setCustomer(c);
			Invoice returned = InvoiceDb.createInvoice(invoice);
			System.out.println("Created invoice id: " + returned.getId());
			request.getSession().setAttribute("Invoice", returned);
		}
		LineItem newItem = new LineItem((Book)request.getSession().getAttribute("Book"), 1); //1 = quantity change later
		LineItemDb.createLineItem(newItem, (Invoice)request.getSession().getAttribute("Invoice"));
		
		Invoice i =  (Invoice)request.getSession().getAttribute("Invoice");
		System.out.println("invoice id = " +i.getLineItems());
		Cart cart = new Cart();
		cart.setLineItems(LineItemDb.selectLineItems(i.getId()));
		System.out.println(cart.getLineItems());
		request.getSession().setAttribute("cart", cart);
		
		
		response.sendRedirect("Cart.jsp");
	}

}
