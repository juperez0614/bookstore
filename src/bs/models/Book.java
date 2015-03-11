package bs.models;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;

public class Book implements Serializable {
	private static final long serialVersionUID = 3L;
	private int id;
	private int ISBN; 
	private double price; 
	private double cost; 
	private String summary; 
	private String title;
	private Genre genre;
	private Publisher publisher; 
	private List<Author> authorList; //in case of multiple authors
	private List<Rating> ratingList;
	private double averageRating;
	
	public Book(){}
	
	public Book( int ISBN, double price, String summary, String title){
		this.ISBN = ISBN;
		this.price = price; 
		this.summary = summary; 
		this.title = title;
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}

	public List<Rating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}
	
	public String getPriceFormat(){
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(price);
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}
}
