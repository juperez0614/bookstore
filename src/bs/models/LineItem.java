package bs.models;

public class LineItem {
	private int id;
	private int invoiceId;
	private int bookId;
	private int quantity;
	
	public LineItem(){}
	
	public LineItem(int nId, int nInvoiceId, int nBookId, int nQuantity){
		id = nId;
		invoiceId = nInvoiceId;
		bookId = nBookId;
		quantity = nQuantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
