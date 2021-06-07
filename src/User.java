import java.util.UUID;

import src.IDandPasswords;

public class User {

	private String username;
	private String password;
	private UUID userID;
	private boolean isAdmin;
	private String name;
	private String surname;
	private int age;
	private String email;
	

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.userID = UUID.randomUUID();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UUID getUserID() {
		return userID;
	}

	public void setAdmin(boolean admin) {
		isAdmin = admin;
	}

	
}
	
