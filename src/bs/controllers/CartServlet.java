package bs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bs.dataaccess.InvoiceDb;
import bs.dataaccess.LineItemDb;
import bs.dataaccess.ProfitDb;
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
		String action = request.getParameter("manageLineItem");
		String quantity = request.getParameter("quantity");
		String invoiceId = request.getParameter("invoiceId");
		String Url = "";
		//TODO: figure out how to display total price
		//TODO: add cookies to keep contents of cart
		//TODO: figure out inventory stuff
		if (action.equals("addToCart")) {
			Url = addToCart(request, quantity);
		} else if (action.equals("update")) {
			Url = updateQuantity(request, quantity);
		}else if(action.equals("delete")){
			Url  =deleteLineItem(request);
		}else if(action.equals("checkout")){
			ProfitDb.processInvoice(Integer.parseInt(invoiceId));
			Url = "index.jsp"; //change to confirm page
		}

		response.sendRedirect(Url);
	}

	private String deleteLineItem(HttpServletRequest request) {
		String lineItemId = request.getParameter("lineId");
		LineItem delete = LineItemDb.getLineItem(Integer
				.parseInt(lineItemId));
		LineItemDb.deleteLineItem(delete);
		populateCart(request);
		return "Cart.jsp"; //TODO: figure out empty list situation
	}

	private String updateQuantity(HttpServletRequest request, String quantity) {
		String lineItemId = request.getParameter("lineId");
		
		LineItem update = LineItemDb.getLineItem(Integer
				.parseInt(lineItemId));
		update.setQuantity(Integer.parseInt(quantity));
		LineItemDb.updateLineItems(update);
		populateCart(request);
		return "Cart.jsp";
	}

	private String addToCart(HttpServletRequest request, String quantity) {

		if (quantity.equals("") || quantity == null) {
			quantity = "1";
		}

		Invoice toCheck = (Invoice) request.getSession()
				.getAttribute("Invoice");
		if (toCheck == null) {
			Customer c = (Customer) request.getSession().getAttribute(
					"customer");
			Invoice invoice = new Invoice();
			invoice.setCustomer(c);
			Invoice returned = InvoiceDb.createInvoice(invoice);
			request.getSession().setAttribute("Invoice", returned);
		}
		LineItem newItem = new LineItem((Book) request.getSession()
				.getAttribute("Book"), Integer.parseInt(quantity));
		LineItemDb.createLineItem(newItem, (Invoice) request.getSession()
				.getAttribute("Invoice"));
		populateCart(request);
		return "Cart.jsp";
	}

	private void populateCart(HttpServletRequest request) {
		Invoice i = (Invoice) request.getSession().getAttribute("Invoice");
		Cart cart = new Cart();
		cart.setLineItems(LineItemDb.selectLineItems(i.getId()));
		request.getSession().setAttribute("cart", cart);
	}

}
