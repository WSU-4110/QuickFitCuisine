import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/userDAO")
public class userDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public userDAO(){}
	
	/** 
	 * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
    	//uses default connection to the database
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/recipedb?allowPublicKeyRetrieval=true&useSSL=false&user=john&password=john1234");
            System.out.println(connect);
        }
    }
    
    protected void connect_func_init() throws SQLException {
    	//uses default connection to the database
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?useSSL=false&user=john&password=john1234");
            System.out.println(connect);
        }
    }
    
    public boolean database_login(String email, String password) throws SQLException{
    	try {
    		connect_func("root","pass1234");
    		String sql = "select * from user where email = ?";
    		preparedStatement = connect.prepareStatement(sql);
    		preparedStatement.setString(1, email);
    		ResultSet rs = preparedStatement.executeQuery();
    		return rs.next();
    	}
    	catch(SQLException e) {
    		System.out.println("failed login");
    		return false;
    	}
    }
	//connect to the database 
    public void connect_func(String username, String password) throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/recipedb?"
  			          + "useSSL=false&user=" + username + "&password=" + password);
            System.out.println(connect);
        }
    }
    
    public List<user> listAllUsers() throws SQLException {
        List<user> listUser = new ArrayList<user>();        
        String sql = "SELECT * FROM User";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            user users = new user(email,password);
            listUser.add(users);
        }        
        resultSet.close();
        disconnect();        
        return listUser;
    }
    
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insert(user users) throws SQLException {
    	connect_func("root","pass1234");         
		String sql = "insert into User(email, password) values (?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, users.getEmail());
			preparedStatement.setString(2, users.getPassword());

		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public boolean delete(String email) throws SQLException {
        String sql = "DELETE FROM User WHERE email = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean update(user users) throws SQLException {
        String sql = "update User set firstName=?, password = ?, where email = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, users.getEmail());
		preparedStatement.setString(2, users.getPassword());
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public user getUser(String email) throws SQLException {
    	user user = null;
        String sql = "SELECT * FROM User WHERE email = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String password = resultSet.getString("password");
            user = new user(email, password);
        }
         
        resultSet.close();
        statement.close();
         
        return user;
    }
    
    public boolean checkEmail(String email) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE email = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
    	return checks;
    }
    
    public boolean checkPassword(String password) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE password = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
       	return checks;
    }
    
    
    
    public boolean isValid(String email, String password) throws SQLException
    {
    	String sql = "SELECT * FROM User";
    	connect_func();
    	statement = (Statement) connect.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	
    	resultSet.last();
    	
    	int setSize = resultSet.getRow();
    	resultSet.beforeFirst();
    	
    	for(int i = 0; i < setSize; i++)
    	{
    		resultSet.next();
    		if(resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password)) {
    			return true;
    		}		
    	}
    	return false;
    }
    
    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func_init();
        statement =  (Statement) connect.createStatement();
        
        String[] INITIAL = {"drop database if exists recipedb; ",
					        "create database recipedb; ",
					        "use recipedb; ",
					        "drop table if exists User; ",
					        "drop table if exists Recipes; ",
					        "drop table if exists Ingredients; ",
					        ("CREATE TABLE if not exists User( " +
					            "email VARCHAR(100) NOT NULL, " + 
					            "password VARCHAR(20) NOT NULL, " +
					            "PRIMARY KEY (email) "+"); "),
					        ("CREATE TABLE if not exists Recipes( " +
						            "recipeid INT NOT NULL AUTO_INCREMENT, " + 
						            "link VARCHAR(200) NOT NULL, " +
						            "name VARCHAR(100) NOT NULL, " +
						            "time INT NOT NULL, " +
						            "ingredient1 VARCHAR(30), " +
						            "ingredient2 VARCHAR(30), " +
						            "ingredient3 VARCHAR(30), " +
						            "ingredient4 VARCHAR(30), " +
						            "ingredient5 VARCHAR(30), " +
						            "ingredient6 VARCHAR(30), " +
						            "ingredient7 VARCHAR(30), " +
						            "ingredient8 VARCHAR(30), " +
						            "ingredient9 VARCHAR(30), " +
						            "ingredient10 VARCHAR(30), " +
						            "PRIMARY KEY(recipeid) "+"); "),
					        ("CREATE TABLE if not exists ingredients( " +
						            "recipeid INT NOT NULL, " + 
						            "ingredient1 VARCHAR(30), " +
						            "ingredient2 VARCHAR(30), " +
						            "ingredient3 VARCHAR(30), " +
						            "ingredient4 VARCHAR(30), " +
						            "ingredient5 VARCHAR(30), " +
						            "ingredient6 VARCHAR(30), " +
						            "ingredient7 VARCHAR(30), " +
						            "ingredient8 VARCHAR(30), " +
						            "ingredient9 VARCHAR(30), " +
						            "ingredient10 VARCHAR(30), " +
						            "FOREIGN KEY(recipeid) REFERENCES Recipes(recipeid)," +
						            "PRIMARY KEY(recipeid) "+"); ")
        					};
        String[] TUPLES = {("insert into User(email, password)"+" values "
        			+ "('root', 'pass1234'),"
        			+ "('d@gmail.com', 'pass');"),
        				("insert into Recipes(link, time, name, ingredient1, ingredient2, ingredient3, ingredient4, ingredient5, ingredient6, ingredient7, ingredient8, ingredient9, ingredient10)"+" values "
        				+ "('https://tasty.co/recipe/weekday-meal-prep-pesto-chicken-veggies', 22, 'Pesto Chicken & Veggies', 'chicken', 'greenbeans', 'tomato', 'pesto', null, null, null, null, null, null),"
						+ "('https://www.gimmesomeoven.com/5-ingredient-pasta-salad/#tasty-recipes-65190', 15, 'Pesto Pasta Salad', 'spaghetti', 'redpepper', 'pesto', 'cheese', null, null, null, null, null, null),"
						+ "('https://www.cookingclassy.com/balsamic-glazed-salmon/#jump-to-recipe', 20, 'Balsamic Glazed Salmon', 'vinegar', 'broth', 'honey', 'mustard', 'garlic', 'salmon', null, null, null, null),"
						+ "('https://damndelicious.net/2014/03/29/spaghetti-carbonara/', 20, 'Spaghetti Carbonara', 'spaghetti', 'egg', 'cheese', 'bacon', 'garlic', null, null, null, null, null),"
						+ "('https://www.deliciousmeetshealthy.com/how-to-make-perfect-hard-boiled-eggs/', 7, 'Hard Boiled Egg', 'egg', null, null, null, null, null, null, null, null, null),"
						+ "('https://leitesculinaria.com/37545/recipes-perfect-fried-egg.html', 5, 'Fried Egg', 'egg', null, null, null, null, null, null, null, null, null),"
						+ "('https://thehealthyepicurean.com/maple-mustard-salmon-roasted-broccoli/', 25, 'Salmon and Broccoli', 'salmon', 'broccoli', 'mustard', 'maplesyrup', null, null, null, null, null, null),"
						+ "('https://thehealthyepicurean.com/simple-spaghetti-with-garlic-peas-parmesan/', 30, 'Spaghetti with Garlic, Peas, Cheese', 'spaghetti', 'peas', 'garlic', 'egg', 'cheese', null, null, null, null, null),"
						+ "('https://thehealthyepicurean.com/taco-lettuce-cups/', 20, 'Taco Lettuce Cups', 'blackbeans', 'groundbeef', 'lettuce', 'spices', 'avocado', 'salsa', 'greekyogurt', null, null, null),"
						+ "('https://thehealthyepicurean.com/rustic-yukon-mashed-potatoes/', 25, 'Mashed Potatoes', 'potato', 'milk', 'butter', null, null, null, null, null, null, null),"
						+ "('https://thehealthyepicurean.com/maple-mustard-brussels-sprouts/', 15, 'Brussel Sprouts', 'maplesyrup', 'mustard', 'brusselsprouts', null, null, null, null, null, null, null),"
						+ "('https://www.acouplecooks.com/simple-sauteed-broccoli/', 10, 'Sauteed Broccoli','broccoli', null, null, null, null, null, null, null, null, null),"
						+ "('https://natashaskitchen.com/grilled-cheese-sandwich/', 30, 'Grilled Cheese', 'bread','butter','cheese',null,null,null,null, null, null, null),"
						+ "('https://cookieandkate.com/crispy-falafel-recipe/', 50, 'Crispy Falafel','chickpeas','onion','spices',null,null,null,null,null,null,null),"
						+ "('https://www.inspiredtaste.net/15938/easy-and-smooth-hummus-recipe/#itr-recipe-15938', 10,'Easy Hummus','chickpeas', 'lemon', 'garlic', null, null, null, null, null, null,null),"
						+ "('https://www.gimmesomeoven.com/baked-chicken-breast/#tasty-recipes-60192', 35, 'Baked Chicken Breasts','chicken', 'spices', null, null, null, null,null,null,null,null),"
						+ "('https://www.gimmesomeoven.com/5-ingredient-black-bean-soup/', 20, 'Black Bean Soup', 'blackbeans', 'salsa', 'spices', 'garlic', null, null, null, null, null, null),"
						+ "('https://www.tasteofhome.com/recipes/tilapia-florentine/', 30, 'Tilapia Florentine', 'spinach', 'tilapia', 'lemon', 'egg', 'cheese', null, null, null, null, null),"
						+ "('https://www.tasteofhome.com/recipes/lime-cilantro-tilapia/', 25, 'Lime-Cilantro Tilapia', 'lime', null, 'spices', 'tilapia', null, null, null, null, null, null),"
						+ "('https://www.tasteofhome.com/recipes/tuna-crescent-ring/', 30, 'Tuna Cresent Ring', 'tuna', 'peas', 'carrot', 'onion', 'mustard', 'mayonnaise', null, null, null, null),"
						+ "('https://www.tasteofhome.com/recipes/cornmeal-crusted-catfish/', 30, 'Cornmeal-Crusted Catfish', 'egg', null, 'spices', 'catfish', null, null, null, null, null, null),"
						+ "('https://www.tasteofhome.com/recipes/citrus-coconut-steamed-cod/', 30, 'Citrus Coconut Steamed Cod', 'orange', 'spices', 'cod', 'almonds', 'onion', null, null, null, null, null),"
						+ "('https://www.almanac.com/recipe/rosemary-chicken-spinach', 30,'Rosemary Chicken', 'chicken','spices','garlic', 'spinach', null, null,null,null,null,null),"
						+ "('https://minimalistbaker.com/chicken-noodle-soup-1-pot/', 35,'Chicken Noodle Soup','chicken','onion','garlic', 'carrot','celery','spices',null,null,null,null),"
						+ "('https://www.cookinglight.com/recipes/one-pot-pasta-spinach-tomatoes', 35,'One Pot Pasta', 'onion','tomato','garlic', 'spaghetti','spices','spinach','cheese',null,null,null),"
						+ "('https://caitsplate.com/honey-mustard-onion-pretzel-encrusted-chicken-tenders/', 25, 'Honey Chicken Tenders','chicken','honey','mustard','onion','egg',null,null,null,null,null),"
						+ "('https://caitsplate.com/easy-turkey-taco-skillet/#tasty-recipes-35532%27,15,%27Turkey', 15, 'Taco Skillet','turkey','blackbeans','corn','cheese',null,null,null,null,null,null),"
            			+ "('https://plantbasedonabudget.com/yellow-dal/', 30, 'Easy Yellow Dal', 'garlic', 'onion', 'rice', 'lentils', null, null, null, null, null,null);"),
        				("insert into Ingredients(recipeid, ingredient1, ingredient2, ingredient3, ingredient4, ingredient5, ingredient6, ingredient7, ingredient8, ingredient9, ingredient10)"+" values "
        				+ "(1, 'chicken', 'greenbeans', 'tomato', 'pesto', null, null, null, null, null, null);"),
			    			};
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < TUPLES.length; i++)	
        	statement.execute(TUPLES[i]);
        disconnect();
    }
    
    
   
    
    
    
    
    
	
	

}
