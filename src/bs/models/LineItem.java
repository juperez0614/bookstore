package bs.models;

public class LineItem {
	private Book book;
	private int quantity;
	private Invoice invoice; 
	
	public LineItem(){}
	
	public LineItem(Book book, int quantity/*Invoice invoice*/){
		this.book = book;
		this.quantity = quantity;
		//this.invoice = invoice;
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
	

}
