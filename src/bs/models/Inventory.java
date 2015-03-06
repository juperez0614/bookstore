package bs.models;

import java.io.Serializable;

public class Inventory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookid;
	private int quantity;
	
	
	public Inventory(){}
	
	public Inventory(int bookid, int quantity){
		this.bookid = bookid;
		this.quantity = quantity;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
