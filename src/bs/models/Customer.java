package bs.models;

import java.io.Serializable;

public class Customer implements Serializable {
	private static final long serialVersionUID = 2L;
	private String firstName; 
	private String lastName; 
	private String address;
	private String address2; 
	private String city;
	private String state; 
	private String email; 
	//private User userId;
	
	public Customer(){}
	
	public Customer (String firstName, String lastName, String address,
			String address2, String city, String state, String email){
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.address = address; 
		this.address2 = address2; 
		this.city = city; 
		this.state = state; 
		this.email = email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
