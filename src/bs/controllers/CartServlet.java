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
		System.out.println("action is " + action);
		System.out.println("quantity is " + quantity);
		if (action.equals("addToCart")) {
			addToCart(request, quantity);
		} else if (action.equals("update")) {
			updateQuantity(request, quantity);
		}else if(action.equals("delete")){
			deleteLineItem(request);
		}else if(action.equals("checkout")){
			ProfitDb.processInvoice(Integer.parseInt(invoiceId));
			//response.sendRedirect("index.jsp");
		}

		response.sendRedirect("Cart.jsp");
	}

	private void deleteLineItem(HttpServletRequest request) {
		String lineItemId = request.getParameter("lineId");
		LineItem delete = LineItemDb.getLineItem(Integer
				.parseInt(lineItemId));
		LineItemDb.deleteLineItem(delete);
		populateCart(request);
	}

	private void updateQuantity(HttpServletRequest request, String quantity) {
		String lineItemId = request.getParameter("lineId");
		System.out.println("line item id " + lineItemId);
		LineItem update = LineItemDb.getLineItem(Integer
				.parseInt(lineItemId));
		update.setQuantity(Integer.parseInt(quantity));
		LineItemDb.updateLineItems(update);
		populateCart(request);
	}

	private void addToCart(HttpServletRequest request, String quantity) {

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
		/* request.getSession().setAttribute("lineItem", createdLine); */
		populateCart(request);
	}

	private void populateCart(HttpServletRequest request) {
		Invoice i = (Invoice) request.getSession().getAttribute("Invoice");
		Cart cart = new Cart();
		cart.setLineItems(LineItemDb.selectLineItems(i.getId()));
		request.getSession().setAttribute("cart", cart);
	}

}
