package bs.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bs.dataaccess.InventoryDb;
import bs.dataaccess.InvoiceDb;
import bs.dataaccess.LineItemDb;
import bs.dataaccess.ProfitDb;
import bs.models.Book;
import bs.models.Cart;
import bs.models.Customer;
import bs.models.Inventory;
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
		// TODO: figure out how to display total price
		// TODO: add cookies to keep contents of cart
		// TODO: figure out inventory stuff
		if (action.equals("addToCart")) {
			Url = addToCart(request, response, quantity);
		} else if (action.equals("update")) {
			Url = updateQuantity(request, response, quantity);
		} else if (action.equals("delete")) {
			Url = deleteLineItem(request, response);
		} else if (action.equals("checkout")) {
			ProfitDb.processInvoice(Integer.parseInt(invoiceId));
			Invoice returned = InvoiceDb
					.getInvoice(Integer.parseInt(invoiceId));
			request.getSession().setAttribute("Invoice", returned);
			Url = "PurchaseConfirmation.jsp";
		}

		response.sendRedirect(Url);
	}

	private String deleteLineItem(HttpServletRequest request,
			HttpServletResponse response) {
		String lineItemId = request.getParameter("lineId");
		LineItem delete = LineItemDb.getLineItem(Integer.parseInt(lineItemId));
		LineItemDb.deleteLineItem(delete);
		replenishInventory(delete);
		populateCart(request, response);
		return "Cart.jsp";
	}

	private String updateQuantity(HttpServletRequest request,
			HttpServletResponse response, String quantity) {
		String lineItemId = request.getParameter("lineId");

		LineItem update = LineItemDb.getLineItem(Integer.parseInt(lineItemId));
		update.setQuantity(Integer.parseInt(quantity));
		LineItemDb.updateLineItems(update);
		populateCart(request, response);
		return "Cart.jsp";
	}

	private String addToCart(HttpServletRequest request,
			HttpServletResponse response, String quantity) {
		System.out.println("in add to cart");
		String url = "Cart.jsp";
		if (quantity.equals("") || quantity == null) {
			quantity = "1";
		}

		Invoice toCheck = (Invoice) request.getSession()
				.getAttribute("Invoice");
		Cart toCart = (Cart) request.getSession().getAttribute("cart");

		LineItem newItem = new LineItem((Book) request.getSession()
				.getAttribute("Book"), Integer.parseInt(quantity));

		if (verifyInventory(newItem) != false) {
			System.out.println("made it through verify");
			if (toCheck == null) {
				System.out.println("creating new...");
				Customer c = (Customer) request.getSession().getAttribute(
						"customer");
				Invoice invoice = new Invoice();
				invoice.setCustomer(c);
				Invoice returned = InvoiceDb.createInvoice(invoice);
				request.getSession().setAttribute("Invoice", returned);// add to
																		// session
				// CookieUtil.createCookie(response,
				// Integer.toString(returned.getId()));
				LineItemDb.createLineItem(newItem, (Invoice) request.getSession()
				.getAttribute("Invoice"));

			} else {
				 if (updateDoubleEntry(request, response, toCheck, toCart,
						newItem)){
					 return url;
				 } 
				 else{
					LineItemDb.createLineItem(newItem, (Invoice) request.getSession()
					.getAttribute("Invoice"));
				 }		
			}
			populateCart(request, response);
			return url;
		} else {
			return "QuantityError.jsp";
		}
	}

	private boolean updateDoubleEntry(HttpServletRequest request,
			HttpServletResponse response, Invoice toCheck, Cart toCart,
			LineItem newItem) {
		for (int i = 0; i < toCart.getLineItems().size(); i++) {
			// book exists in cart already
			if (newItem.getBook().getId() == toCart.getLineItems().get(i)
					.getBook().getId()) {
				toCart.getLineItems()
						.get(i)
						.setQuantity(
								toCart.getLineItems().get(i).getQuantity()
										+ newItem.getQuantity());
				toCart.getLineItems().get(i).setInvoice(toCheck);
				LineItemDb.updateLineItems(toCart.getLineItems().get(i));
				populateCart(request, response);
				return true;
			}
		}
		return false;
	}

	private void populateCart(HttpServletRequest request,
			HttpServletResponse response) {

		Invoice i = (Invoice) request.getSession().getAttribute("Invoice");
		Cart cart = new Cart();
		cart.setLineItems(LineItemDb.selectLineItems(i.getId()));
		request.getSession().setAttribute("cart", cart);

	}

	private boolean verifyInventory(LineItem toCheck) {
		Inventory i = InventoryDb.getInventory(toCheck.getBook().getId());
		System.out.println("inventory bookid: " + i.getBookid());
		if (i.getQuantity() >= toCheck.getQuantity()) {
			i.setQuantity(i.getQuantity() - toCheck.getQuantity());
			InventoryDb.updateInventory(i);
			return true;
		}
		return false;
	}

	private void replenishInventory(LineItem toCheck) {
		Inventory i = InventoryDb.getInventory(toCheck.getBook().getId());
		i.setQuantity(i.getQuantity() + toCheck.getQuantity());
		InventoryDb.updateInventory(i);
	}

}