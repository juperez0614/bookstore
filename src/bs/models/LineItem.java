package bs.models;

public class LineItem {
	private Book book;
	private int quantity;
	
	public LineItem(){}
	
	public LineItem(Book nBookId, int nQuantity){
		book = nBookId;
		quantity = nQuantity;
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
	

}
