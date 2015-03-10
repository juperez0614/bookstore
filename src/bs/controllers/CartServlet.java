package bs.controllers;

import java.io.IOException;
import java.io.PrintWriter;

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

//TODO: figure out completeing purchase
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("manageLineItem");
		String quantity = request.getParameter("quantity");
		String invoiceId = request.getParameter("invoiceId");
		String Url = "";

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

		} else if (action.equals("confirmCheckout")) {
			/*
			 * Cart c = (Cart) request.getSession().getAttribute("cart");
			 * Invoice i = (Invoice)
			 * request.getSession().getAttribute("Invoice");
			 */
			request.getSession().removeAttribute("Invoice");
			request.getSession().removeAttribute("cart");
			Url = "index.jsp";
		} else if (action.equals("updateQuantityVerify")) {
			Url = inventoryCheck(request, response);
			return;
		} else if (action.equals("quantityCheck")) {
			String bookId = request.getParameter("bookid");
			quantityCheck(response, quantity, bookId);
			return;
		}

		response.sendRedirect(Url);
	}

	private void quantityCheck(HttpServletResponse response, String quantity,
			String bookId) throws IOException {
		Inventory inventory = InventoryDb
				.getInventory(Integer.parseInt(bookId));
		if (inventory.getQuantity() <= 0
				|| (inventory.getQuantity() - Integer.parseInt(quantity)) < 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<p style='color:red'>We only have "
					+ inventory.getQuantity() + " left in stock</p>");
		}
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
		if (verifyInventory(update) == true) {
			LineItemDb.updateLineItems(update);
		} else {
			request.getSession().setAttribute("quantityupdateerror",
					"Not Enough Stock");
		}

		populateCart(request, response);
		return "Cart.jsp";
	}

	private String addToCart(HttpServletRequest request,
			HttpServletResponse response, String quantity) {
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
			if (toCheck == null) {
				Customer c = (Customer) request.getSession().getAttribute(
						"customer");
				if (c == null) {

					return "Login.jsp";
				}
				Invoice invoice = new Invoice();
				invoice.setCustomer(c);
				Invoice returned = InvoiceDb.createInvoice(invoice);
				request.getSession().setAttribute("Invoice", returned);// add to
																		// session
				LineItemDb.createLineItem(newItem, (Invoice) request
						.getSession().getAttribute("Invoice"));

			} else {
				if (updateDoubleEntry(request, response, toCheck, toCart,
						newItem)) {
					return url;
				} else {
					LineItemDb.createLineItem(newItem, (Invoice) request
							.getSession().getAttribute("Invoice"));
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
		if (toCart != null) { // this doesn't work
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

	private String inventoryCheck(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String lineItemId = request.getParameter("lineId");
		LineItem update = LineItemDb.getLineItem(Integer.parseInt(lineItemId));

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("quantity");

		Inventory returned = InventoryDb.getInventory(update.getBook().getId());
		if (returned.getQuantity() <= 0
				|| (returned.getQuantity() - Integer.parseInt(name)) < 0) {
			out.print("<p style='color:red'>We only have "
					+ returned.getQuantity() + " left in stock</p>");

		}

		out.close();
		return "Cart.jsp";
	}

}
