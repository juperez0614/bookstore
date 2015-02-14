package bs.models;

import java.io.Serializable;

public class Author implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id; 
	private String firstName;
	private String lastName; 
	private String biography; 
	
	public Author(){}
	
	public Author(String firstName, String lastName, String biography){
		this.firstName = firstName;
		this.lastName = lastName; 
		this.biography = biography; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	
}
