package quick;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

@WebServlet("/recipesDAO")
public class recipesDAO {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private List<recipes> savedRecipes = new ArrayList<recipes>();

	public recipesDAO() {
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

	public int sendRecipeID(String name) throws SQLException {
		String sql = "SELECT recipeid from Recipes where name='" + name + "'";
		connect_func();
		statement = (Statement) connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		resultSet.next();
		int id = resultSet.getInt("recipeid");
		resultSet.close();
		statement.close();
		disconnect();
		return id;
	}

	public List<recipes> listValidRecipes(ArrayList<String> selections) throws SQLException {
		List<recipes> recipeList = new ArrayList<recipes>();
		String sql = "SELECT * FROM Recipes";
		connect_func();
		statement = (Statement) connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			String name = resultSet.getString("name");
			String link = resultSet.getString("link");
			int time = resultSet.getInt("time");
			int id = resultSet.getInt("recipeid");
			int count = 0;
			int matching = 0;
			boolean i1 = false, i2 = false, i3 = false, i4 = false, i5 = false, i6 = false, i7 = false, i8 = false,
					i9 = false, i10 = false;
			if (resultSet.getString("ingredient1") != null) {
				i1 = true;
				count++;
			}
			if (resultSet.getString("ingredient2") != null) {
				i2 = true;
				count++;
			}
			if (resultSet.getString("ingredient3") != null) {
				i3 = true;
				count++;
			}
			if (resultSet.getString("ingredient4") != null) {
				i4 = true;
				count++;
			}
			if (resultSet.getString("ingredient5") != null) {
				i5 = true;
				count++;
			}
			if (resultSet.getString("ingredient6") != null) {
				i6 = true;
				count++;
			}
			if (resultSet.getString("ingredient7") != null) {
				i7 = true;
				count++;
			}
			if (resultSet.getString("ingredient8") != null) {
				i8 = true;
				count++;
			}
			if (resultSet.getString("ingredient9") != null) {
				i9 = true;
				count++;
			}
			if (resultSet.getString("ingredient10") != null) {
				i10 = true;
				count++;
			}
			for (int i = 0; i < selections.size(); i++) {
				if (i1) {
					if (resultSet.getString("ingredient1").equals(selections.get(i))) {
						matching++;
					}
				}
				if (i2) {
					if (resultSet.getString("ingredient2").equals(selections.get(i))) {
						matching++;
					}
				}
				if (i3) {
					if (resultSet.getString("ingredient3").equals(selections.get(i))) {
						matching++;
					}
				}
				if (i4) {
					if (resultSet.getString("ingredient4").equals(selections.get(i))) {
						matching++;
					}
				}
				if (i5) {
					if (resultSet.getString("ingredient5").equals(selections.get(i))) {
						matching++;
					}
				}
				if (i6) {
					if (resultSet.getString("ingredient6").equals(selections.get(i))) {
						matching++;
					}
				}
				if (i7) {
					if (resultSet.getString("ingredient7").equals(selections.get(i))) {
						matching++;
					}
				}
				if (i8) {
					if (resultSet.getString("ingredient8").equals(selections.get(i))) {
						matching++;
					}
				}
				if (i9) {
					if (resultSet.getString("ingredient9").equals(selections.get(i))) {
						matching++;
					}
				}
				if (i10) {
					if (resultSet.getString("ingredient10").equals(selections.get(i))) {
						matching++;
					}
				}
			}
			// determine if the user selected all of the ingredients belonging to a recipe
			if (count == matching) {
				// create a new recipe object for the recipe and add the recipe object to the
				// recipe_arr array
				recipes rec = new recipes(id, link, name, time, count);
				recipeList.add(rec);
			}
		}
		resultSet.close();
		statement.close();
		disconnect();
		savedRecipes = recipeList;
		return recipeList;
	}

	public List<recipes> listSavedRecipes(String currentUser) throws SQLException {
		List<recipes> recipeList = new ArrayList<recipes>();
		String[] sql = {
				"SELECT * FROM Recipes WHERE recipeid in (select recipeid1 from SavedRecipes where email='"
						+ currentUser + "');",
				"SELECT * FROM Recipes WHERE recipeid in (select recipeid2 from SavedRecipes where email='"
						+ currentUser + "');",
				"SELECT * FROM Recipes WHERE recipeid in (select recipeid3 from SavedRecipes where email='"
						+ currentUser + "');",
				"SELECT * FROM Recipes WHERE recipeid in (select recipeid4 from SavedRecipes where email='"
						+ currentUser + "');",
				"SELECT * FROM Recipes WHERE recipeid in (select recipeid5 from SavedRecipes where email='"
						+ currentUser + "');",
				"SELECT * FROM Recipes WHERE recipeid in (select recipeid6 from SavedRecipes where email='"
						+ currentUser + "');",
				"SELECT * FROM Recipes WHERE recipeid in (select recipeid7 from SavedRecipes where email='"
						+ currentUser + "');",
				"SELECT * FROM Recipes WHERE recipeid in (select recipeid8 from SavedRecipes where email='"
						+ currentUser + "');",
				"SELECT * FROM Recipes WHERE recipeid in (select recipeid9 from SavedRecipes where email='"
						+ currentUser + "');",
				"SELECT * FROM Recipes WHERE recipeid in (select recipeid10 from SavedRecipes where email='"
						+ currentUser + "');" };
		connect_func();
		statement = (Statement) connect.createStatement();
		for (int i = 0; i < 10; i++) {
			ResultSet resultSet = statement.executeQuery(sql[i]);
			if (resultSet.next() == false) {
				continue;
			}
			String name = resultSet.getString("name");
			String link = resultSet.getString("link");
			int time = resultSet.getInt("time");
			int id = resultSet.getInt("recipeid");
			int count = 0;
			if (resultSet.getString("ingredient1") != null) {
				count++;
			}
			if (resultSet.getString("ingredient2") != null) {
				count++;
			}
			if (resultSet.getString("ingredient3") != null) {
				count++;
			}
			if (resultSet.getString("ingredient4") != null) {
				count++;
			}
			if (resultSet.getString("ingredient5") != null) {
				count++;
			}
			if (resultSet.getString("ingredient6") != null) {
				count++;
			}
			if (resultSet.getString("ingredient7") != null) {
				count++;
			}
			if (resultSet.getString("ingredient8") != null) {
				count++;
			}
			if (resultSet.getString("ingredient9") != null) {
				count++;
			}
			if (resultSet.getString("ingredient10") != null) {
				count++;
			}
			// create a new recipe object for the recipe and add the recipe object to the
			// recipe_arr array
			recipes rec = new recipes(id, link, name, time, count);
			recipeList.add(rec);
		}
		statement.close();
		disconnect();
		savedRecipes = recipeList;
		return recipeList;
	}

	public List<recipes> allRecipes() throws SQLException {
		List<recipes> recipeList = new ArrayList<recipes>();
		String sql = "SELECT * FROM Recipes";
		connect_func();
		statement = (Statement) connect.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			String name = resultSet.getString("name");
			String link = resultSet.getString("link");
			int time = resultSet.getInt("time");
			int id = resultSet.getInt("recipeid");
			int count = 0;
			if (resultSet.getString("ingredient1") != null) {
				count++;
			}
			if (resultSet.getString("ingredient2") != null) {
				count++;
			}
			if (resultSet.getString("ingredient3") != null) {
				count++;
			}
			if (resultSet.getString("ingredient4") != null) {
				count++;
			}
			if (resultSet.getString("ingredient5") != null) {
				count++;
			}
			if (resultSet.getString("ingredient6") != null) {
				count++;
			}
			if (resultSet.getString("ingredient7") != null) {
				count++;
			}
			if (resultSet.getString("ingredient8") != null) {
				count++;
			}
			if (resultSet.getString("ingredient9") != null) {
				count++;
			}
			if (resultSet.getString("ingredient10") != null) {
				count++;
			}
			// create a new recipe object for the recipe and add the recipe object to the
			// recipe_arr array
			recipes rec = new recipes(id, link, name, time, count);
			recipeList.add(rec);
		}
		resultSet.close();
		statement.close();
		disconnect();
		savedRecipes = recipeList;
		return recipeList;
	}
	
	public List<recipes> refreshRecipes() throws NullPointerException {
		return savedRecipes;
	}

	public List<recipes> timeSort(boolean check) throws NullPointerException {
		List<recipes> recipeList = new ArrayList<recipes>();
		recipeList = savedRecipes;
		if (check) {
			// sort in descending order
			for (int i = 0; i < recipeList.size() - 1; i++) {
				for (int j = 0; j < recipeList.size() - i - 1; j++) {
					if (recipeList.get(j).getTime() < recipeList.get(j + 1).getTime()) {
						Collections.swap(recipeList, j, j + 1);
					}
				}
			}
		} else {
			// sort in ascending order
			for (int i = 0; i < recipeList.size() - 1; i++) {
				for (int j = 0; j < recipeList.size() - i - 1; j++) {
					if (recipeList.get(j).getTime() > recipeList.get(j + 1).getTime()) {
						Collections.swap(recipeList, j, j + 1);
					}
				}
			}
		}
		return recipeList;
	}

	public List<recipes> ingredientsSort(boolean check) throws NullPointerException {
		List<recipes> recipeList = new ArrayList<recipes>();
		recipeList = savedRecipes;
		if (check) {
			// sort in ascending order
			for (int i = 0; i < recipeList.size() - 1; i++) {
				for (int j = 0; j < recipeList.size() - i - 1; j++) {
					if (recipeList.get(j).getCount() > recipeList.get(j + 1).getCount()) {
						Collections.swap(recipeList, j, j + 1);
					}
				}
			}
		} else {
			// sort in descending order
			for (int i = 0; i < recipeList.size() - 1; i++) {
				for (int j = 0; j < recipeList.size() - i - 1; j++) {
					if (recipeList.get(j).getCount() < recipeList.get(j + 1).getCount()) {
						Collections.swap(recipeList, j, j + 1);
					}
				}
			}
		}
		return recipeList;
	}

	protected void disconnect() throws SQLException {
		if (connect != null && !connect.isClosed()) {
			connect.close();
		}
	}

}
