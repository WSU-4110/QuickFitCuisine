package quick;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/savedRecipesDAO")
public class savedRecipesDAO {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;

	public savedRecipesDAO() {
	}

	protected void connect_func() throws SQLException {
		// uses default connection to the database
		if (connect == null || connect.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			connect = (Connection) DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/recipedb?allowPublicKeyRetrieval=true&useSSL=false&user=john&password=john1234");
			System.out.println(connect);
		}
	}

	public boolean database_login(String email, String password) throws SQLException {
		try {
			connect_func("root", "pass1234");
			String sql = "select * from user where email = ?";
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			System.out.println("failed login");
			return false;
		}
	}

	// connect to the database
	public void connect_func(String username, String password) throws SQLException {
		if (connect == null || connect.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			connect = (Connection) DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/recipedb?allowPublicKeyRetrieval=true&"
							+ "useSSL=false&user=" + username + "&password=" + password);
			System.out.println(connect);
		}
	}

	protected void disconnect() throws SQLException {
		//disconnect from database
		if (connect != null && !connect.isClosed()) {
			connect.close();
		}
	}

	public void insert(savedRecipes saved) throws SQLException {
		//inserts the user's email into the SavedRecipes database. This function is only used when a new user registers.
		connect_func("root", "pass1234");
		String sql = "insert into SavedRecipes(email) values (?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, saved.getEmail());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		disconnect();
	}

	public void update(String col, String user, int id) throws SQLException {
		/*updates a user's saved recipes. 
		Used in the insertSavedRecipe() function below in order to update a null recipeid column to a non-null recipeid*/
		connect_func("root", "pass1234");
		String sql = "update SavedRecipes set " + col + "='" + id + "' where email ='" + user + "'";
		statement = (Statement) connect.createStatement();
		statement.executeUpdate(sql);
		statement.close();
		disconnect();
	}

	public void delete(String user, int id) throws SQLException {
		//deletes a recipe from a user's saved recipes
		connect_func("root", "pass1234");
		String sql = "select * from SavedRecipes where email='" + user + "'";
		String sql2;
		statement = (Statement) connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		resultSet.next();
		if (resultSet.getString("recipeid1") != null && resultSet.getInt("recipeid1") == id) {
			sql2 = "update SavedRecipes set recipeid1=null where email ='" + user + "'";
			statement.executeUpdate(sql2);
		} else if (resultSet.getString("recipeid2") != null && resultSet.getInt("recipeid2") == id) {
			sql2 = "update SavedRecipes set recipeid2=null where email ='" + user + "'";
			statement.executeUpdate(sql2);
		} else if (resultSet.getString("recipeid3") != null && resultSet.getInt("recipeid3") == id) {
			sql2 = "update SavedRecipes set recipeid3=null where email ='" + user + "'";
			statement.executeUpdate(sql2);
		} else if (resultSet.getString("recipeid4") != null && resultSet.getInt("recipeid4") == id) {
			sql2 = "update SavedRecipes set recipeid4=null where email ='" + user + "'";
			statement.executeUpdate(sql2);
		} else if (resultSet.getString("recipeid5") != null && resultSet.getInt("recipeid5") == id) {
			sql2 = "update SavedRecipes set recipeid5=null where email ='" + user + "'";
			statement.executeUpdate(sql2);
		} else if (resultSet.getString("recipeid6") != null && resultSet.getInt("recipeid6") == id) {
			sql2 = "update SavedRecipes set recipeid6=null where email ='" + user + "'";
			statement.executeUpdate(sql2);
		} else if (resultSet.getString("recipeid7") != null && resultSet.getInt("recipeid7") == id) {
			sql2 = "update SavedRecipes set recipeid7=null where email ='" + user + "'";
			statement.executeUpdate(sql2);
		} else if (resultSet.getString("recipeid8") != null && resultSet.getInt("recipeid8") == id) {
			sql2 = "update SavedRecipes set recipeid8=null where email ='" + user + "'";
			statement.executeUpdate(sql2);
		} else if (resultSet.getString("recipeid9") != null && resultSet.getInt("recipeid9") == id) {
			sql2 = "update SavedRecipes set recipeid9=null where email ='" + user + "'";
			statement.executeUpdate(sql2);
		} else if (resultSet.getString("recipeid10") != null && resultSet.getInt("recipeid10") == id) {
			sql2 = "update SavedRecipes set recipeid10=null where email ='" + user + "'";
			statement.executeUpdate(sql2);
		}
		resultSet.close();
		statement.close();
		disconnect();
	}

	public boolean checkSavedRecipe(String currentUser, int id) throws SQLException {
		//checks a user's saved recipes to see if they have already saved the recipe that they are trying to save
		boolean check = true;
		connect_func();
		String sql = "select * from SavedRecipes where email='" + currentUser + "'";
		statement = (Statement) connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		resultSet.next();
		if (resultSet.getString("recipeid1") != null && resultSet.getInt("recipeid1") == id) {
			return false;
		} else if (resultSet.getString("recipeid2") != null && resultSet.getInt("recipeid2") == id) {
			return false;
		} else if (resultSet.getString("recipeid3") != null && resultSet.getInt("recipeid3") == id) {
			return false;
		} else if (resultSet.getString("recipeid4") != null && resultSet.getInt("recipeid4") == id) {
			return false;
		} else if (resultSet.getString("recipeid5") != null && resultSet.getInt("recipeid5") == id) {
			return false;
		} else if (resultSet.getString("recipeid6") != null && resultSet.getInt("recipeid6") == id) {
			return false;
		} else if (resultSet.getString("recipeid7") != null && resultSet.getInt("recipeid7") == id) {
			return false;
		} else if (resultSet.getString("recipeid8") != null && resultSet.getInt("recipeid8") == id) {
			return false;
		} else if (resultSet.getString("recipeid9") != null && resultSet.getInt("recipeid9") == id) {
			return false;
		} else if (resultSet.getString("recipeid10") != null && resultSet.getInt("recipeid10") == id) {
			return false;
		}
		resultSet.close();
		statement.close();
		disconnect();
		return check;
	}

	public int checkNumberOfSavedRecipe(String currentUser, int id) throws SQLException {
		/*gets the number of recipes that a user has saved. 
		 * Used to determine if the user has reached the maximum amount of saved recipes allowed, which is 10.*/
		int count = 0;
		System.out.println("hello");
		connect_func();
		String sql = "select * from SavedRecipes where email='" + currentUser + "'";
		statement = (Statement) connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		resultSet.next();
		if (resultSet.getString("recipeid1") != null) {
			count++;
		}
		if (resultSet.getString("recipeid2") != null) {
			count++;
		}
		if (resultSet.getString("recipeid3") != null) {
			count++;
		}
		if (resultSet.getString("recipeid4") != null) {
			count++;
		}
		if (resultSet.getString("recipeid5") != null) {
			count++;
		}
		if (resultSet.getString("recipeid6") != null) {
			count++;
		}
		if (resultSet.getString("recipeid7") != null) {
			count++;
		}
		if (resultSet.getString("recipeid8") != null) {
			count++;
		}
		if (resultSet.getString("recipeid9") != null) {
			count++;
		}
		if (resultSet.getString("recipeid10") != null) {
			count++;
		}
		resultSet.close();
		statement.close();
		disconnect();
		System.out.println(count);
		return count;
	}

	public void insertSavedRecipe(String currentUser, int id) throws SQLException {
		//inserts a recipe into a user's Saved Recipes at the first recipeid column that has a null value
		connect_func();
		String sql = "select * from SavedRecipes where email='" + currentUser + "'";
		statement = (Statement) connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		resultSet.next();
		if (resultSet.getString("recipeid1") == null) {
			update("recipeid1", currentUser, id);
		} else if (resultSet.getString("recipeid2") == null) {
			update("recipeid2", currentUser, id);
		} else if (resultSet.getString("recipeid3") == null) {
			update("recipeid3", currentUser, id);
		} else if (resultSet.getString("recipeid4") == null) {
			update("recipeid4", currentUser, id);
		} else if (resultSet.getString("recipeid5") == null) {
			update("recipeid5", currentUser, id);
		} else if (resultSet.getString("recipeid6") == null) {
			update("recipeid6", currentUser, id);
		} else if (resultSet.getString("recipeid7") == null) {
			update("recipeid7", currentUser, id);
		} else if (resultSet.getString("recipeid8") == null) {
			update("recipeid8", currentUser, id);
		} else if (resultSet.getString("recipeid9") == null) {
			update("recipeid9", currentUser, id);
		} else if (resultSet.getString("recipeid10") == null) {
			update("recipeid10", currentUser, id);
		}
		resultSet.close();
		statement.close();
		disconnect();
	}
}
