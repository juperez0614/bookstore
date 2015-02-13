package bs.models;

import java.io.Serializable;

public class Book implements Serializable {
	private static final long serialVersionUID = 3L;
	private int id;
	private int ISBN; 
	private double price; 
	private String summary; 
	
	public Book(){}
	
	public Book(int id, int ISBN, double price, String summary){
		this.id = id; 
		this.ISBN = ISBN;
		this.price = price; 
		this.summary = summary; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}
