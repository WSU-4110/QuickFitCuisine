package quick;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/ingredientsDAO")
public class ingredientsDAO {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;

	public ingredientsDAO() {
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
			connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/recipedb?"
					+ "useSSL=false&user=" + username + "&password=" + password);
			System.out.println(connect);
		}
	}

	protected void disconnect() throws SQLException {
		//disconnect from the database
		if (connect != null && !connect.isClosed()) {
			connect.close();
		}
	}

	public ingredients specificIngredients(int recipeid) throws SQLException {
		/*takes a recipeid as the parameter and searches the recipes table in the database recipedb for that recipeid. 
		Adds all non-null ingredients in that recipe to an ingredients object and returns the object*/
		ingredients ing = new ingredients();
		String sql = "SELECT ingredient1, ingredient2, ingredient3, ingredient4, ingredient5, ingredient6, ingredient7, ingredient8, ingredient9, ingredient10 FROM Recipes WHERE recipeid="
				+ recipeid + "";
		connect_func();
		statement = (Statement) connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		resultSet.next();
		String ing1 = resultSet.getString("ingredient1");
		String ing2 = resultSet.getString("ingredient2");
		String ing3 = resultSet.getString("ingredient3");
		String ing4 = resultSet.getString("ingredient4");
		String ing5 = resultSet.getString("ingredient5");
		String ing6 = resultSet.getString("ingredient6");
		String ing7 = resultSet.getString("ingredient7");
		String ing8 = resultSet.getString("ingredient8");
		String ing9 = resultSet.getString("ingredient9");
		String ing10 = resultSet.getString("ingredient10");
		if (ing1 != null) {
			ing.setIngredient1(ing1);
		} else {
			ing.setIngredient1("");
		}

		if (ing2 != null) {
			ing.setIngredient2(ing2);
		} else {
			ing.setIngredient2("");
		}

		if (ing3 != null) {
			ing.setIngredient3(ing3);
		} else {
			ing.setIngredient3("");
		}

		if (ing4 != null) {
			ing.setIngredient4(ing4);
		} else {
			ing.setIngredient4("");
		}

		if (ing5 != null) {
			ing.setIngredient5(ing5);
		} else {
			ing.setIngredient5("");
		}

		if (ing6 != null) {
			ing.setIngredient6(ing6);
		} else {
			ing.setIngredient6("");
		}

		if (ing7 != null) {
			ing.setIngredient7(ing7);
		} else {
			ing.setIngredient7("");
		}

		if (ing8 != null) {
			ing.setIngredient8(ing8);
		} else {
			ing.setIngredient8("");
		}

		if (ing9 != null) {
			ing.setIngredient9(ing9);
		} else {
			ing.setIngredient9("");
		}

		if (ing10 != null) {
			ing.setIngredient10(ing10);
		} else {
			ing.setIngredient10("");
		}

		return ing;
	}

}
