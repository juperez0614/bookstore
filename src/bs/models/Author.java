package bs.models;

import java.io.Serializable;

public class Author implements Serializable {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName; 
	private String biography; 
	
	public Author(){}

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
