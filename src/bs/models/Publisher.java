package bs.models;

import java.io.Serializable;

public class Publisher implements Serializable {

	private static final long serialVersionUID = 5L;
	private int id; 
	private String companyName; 
	private String address;
	private String address2; 
	private String city; 
	private String state;
	private int zipCode; 
	private String phone; 
	private String pointOfContact;
	private int bookId; 
	
	public Publisher(){}
	
	public Publisher (int id,String companyName, String address, String address2, String city, 
			String state, int zipCode, String phone, String pointOfContact, int bookId){
		this.id = id;
		this.companyName = companyName; 
		this.address = address; 
		this.address2 = address2; 
		this.city = city; 
		this.state = state; 
		this.zipCode = zipCode; 
		this.phone = phone; 
		this.pointOfContact = pointOfContact; 
		this.bookId = bookId; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPointOfContact() {
		return pointOfContact;
	}

	public void setPointOfContact(String pointOfContact) {
		this.pointOfContact = pointOfContact;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
}
