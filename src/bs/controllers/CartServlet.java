package bs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
import bs.util.CookieUtil;

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
			Url = addToCart(request, response, quantity);
		} else if (action.equals("update")) {
			Url = updateQuantity(request, response, quantity);
		}else if(action.equals("delete")){
			Url  =deleteLineItem(request, response);
		}else if(action.equals("checkout")){
			ProfitDb.processInvoice(Integer.parseInt(invoiceId));
			Invoice returned = InvoiceDb.getInvoice(Integer.parseInt(invoiceId));
			request.getSession().setAttribute("Invoice", returned);
			Url = "PurchaseConfirmation.jsp";
		}

		response.sendRedirect(Url);
	}

	private String deleteLineItem(HttpServletRequest request, HttpServletResponse response) {
		String lineItemId = request.getParameter("lineId");
		LineItem delete = LineItemDb.getLineItem(Integer
				.parseInt(lineItemId));
		LineItemDb.deleteLineItem(delete);
		populateCart(request, response);
		return "Cart.jsp"; 
	}

	private String updateQuantity(HttpServletRequest request, HttpServletResponse response, String quantity) {
		String lineItemId = request.getParameter("lineId");
		
		LineItem update = LineItemDb.getLineItem(Integer
				.parseInt(lineItemId));
		update.setQuantity(Integer.parseInt(quantity));
		LineItemDb.updateLineItems(update);
		populateCart(request, response);
		return "Cart.jsp";
	}

	private String addToCart(HttpServletRequest request, HttpServletResponse response, String quantity) {

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
			request.getSession().setAttribute("Invoice", returned);// add to session
			//CookieUtil.createCookie(response, Integer.toString(returned.getId()));

		}
		LineItem newItem = new LineItem((Book) request.getSession()
				.getAttribute("Book"), Integer.parseInt(quantity));
		LineItemDb.createLineItem(newItem, (Invoice) request.getSession()
				.getAttribute("Invoice"));
		
		populateCart(request, response);
		return "Cart.jsp";
	}

	private void populateCart(HttpServletRequest request, HttpServletResponse response) {
		
		Invoice i = (Invoice) request.getSession().getAttribute("Invoice");
		Cart cart = new Cart();
		cart.setLineItems(LineItemDb.selectLineItems(i.getId()));
		request.getSession().setAttribute("cart", cart);
		
	}

}
