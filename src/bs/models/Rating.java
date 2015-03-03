package bs.models;

import java.io.Serializable;

public class Rating implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private int rating;
	private String review;
	

	public Rating(int nRating, String nReview)
	{
		rating = nRating;
		review = nReview;
	}
	
	public Rating(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	

}
