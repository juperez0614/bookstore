package bs.models;

import java.io.Serializable;

public class LineItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private Book book;
	private int quantity;
	private Invoice invoice; 
	private int id;
	
	public LineItem(){}
	
	public LineItem(Book book2, int quantity){
		this.book = book2;
		this.quantity = quantity; 
		
	}

	public LineItem(Book book2, int quantity, int id){
		this.book = book2;
		this.quantity = quantity; 
		this.id = id; 
	}
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
