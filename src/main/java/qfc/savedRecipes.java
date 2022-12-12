package qfc;
public class savedRecipes {
	protected String email;
	protected int recipeid;

	// constructors
	public savedRecipes() {
	}

	public savedRecipes(String email) {
		this.email = email;
	}

	public savedRecipes(String email, int recipeid) {
		this.email = email;
		this.recipeid = recipeid;
	}

	// getter and setter methods
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRecipeid() {
		return recipeid;
	}

	public void setRecipeid(int recipeid) {
		this.recipeid = recipeid;
	}

}