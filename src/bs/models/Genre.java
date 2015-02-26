package bs.models;

import java.io.Serializable;

public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id; 
	private String genre; 
	
	public Genre(){}
	public Genre(String genre, int id){
		this.genre = genre; 
		this.id = id; 
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
}
