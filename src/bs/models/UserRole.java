package bs.models;

import java.io.Serializable;

public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;
	private UserAuth user;
	private String role;

	public UserRole(){
		
	}
	
	public UserRole(UserAuth user, String role){
		this.user = user;
		this.role = role; 
	}

	public UserAuth getUser() {
		return user;
	}

	public void setUser(UserAuth user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
