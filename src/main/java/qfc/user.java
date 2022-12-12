package qfc;
public class user {
	protected String password;
	protected String email;

	// constructors
	public user() {
	}

	public user(String email) {
		this.email = email;
	}

	public user(String email, String password) {
		this.email = email;
		this.password = password;
	}

	// getter and setter methods
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}