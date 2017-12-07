package filters;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	private String username;
	private String role;
	private boolean manager;
	
	public User() {
		this.manager = false;
	}

	
	public boolean isManager() {
		return manager;
	}
	public void setManager(boolean manager) {
		this.manager = manager;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
