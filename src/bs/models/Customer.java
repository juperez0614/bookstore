package bs.models;

import java.io.Serializable;

public class Customer implements Serializable {
	private static final long serialVersionUID = 2L;
	private int id; 
	private String firstName; 
	private String lastName; 
	private String address;
	private String address2; 
	private String city;
	private String state;
	private int zipcode;
	private String email; 
	private UserAuth userName;
	
	public Customer(){}
	
	public Customer (String firstName, String lastName, String address,
			String address2, String city, String state, int zipcode, String email, UserAuth username){
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.address = address; 
		this.address2 = address2; 
		this.city = city; 
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
		this.userName = username;
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

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserAuth getUserName() {
		return userName;
	}

	public void setUserName(UserAuth userName) {
		this.userName = userName;
	}	

	
}
