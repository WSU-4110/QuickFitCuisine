package recipes;
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
@WebServlet("/recipesDAO")
public class recipesDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public recipesDAO(){}
	
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
            int count = 0;
			int matching = 0;
			boolean i1 = false, i2 = false, i3 = false, i4 = false, i5 = false, i6 = false, i7 = false, i8 = false, i9 = false, i10 = false;
			if(resultSet.getString("ingredient1") != null) {
				i1 = true;
				count++;
			}
			if(resultSet.getString("ingredient2") != null) {
				i2 = true;
				count++;
			}
			if(resultSet.getString("ingredient3") != null) {
				i3 = true;
				count++;
			}
			if(resultSet.getString("ingredient4") != null) {
				i4 = true;
				count++;
			}
			if(resultSet.getString("ingredient5") != null) {
				i5 = true;
				count++;
			}
			if(resultSet.getString("ingredient6") != null) {
				i6 = true;
				count++;
			}
			if(resultSet.getString("ingredient7") != null) {
				i7 = true;
				count++;
			}
			if(resultSet.getString("ingredient8") != null) {
				i8 = true;
				count++;
			}
			if(resultSet.getString("ingredient9") != null) {
				i9 = true;
				count++;
			}
			if(resultSet.getString("ingredient10") != null) {
				i10 = true;
				count++;
			}
			for(int i = 0; i < selections.size(); i++) {
				if(i1) {
					if(resultSet.getString("ingredient1").equals(selections.get(i))) {
						matching++;
					}
				}
				else if(i2) {
					if(resultSet.getString("ingredient2").equals(selections.get(i))) {
						matching++;
					}
				}
				else if(i3) {
					if(resultSet.getString("ingredient3").equals(selections.get(i))) {
						matching++;
					}
				}
				else if(i4) {
					if(resultSet.getString("ingredient4").equals(selections.get(i))) {
						matching++;
					}
				}
				else if(i5) {
					if(resultSet.getString("ingredient5").equals(selections.get(i))) {
						matching++;
					}
				}
				else if(i6) {
					if(resultSet.getString("ingredient6").equals(selections.get(i))) {
						matching++;
					}
				}
				else if(i7) {
					if(resultSet.getString("ingredient7").equals(selections.get(i))) {
						matching++;
					}
				}
				else if(i8) {
					if(resultSet.getString("ingredient8").equals(selections.get(i))) {
						matching++;
					}
				}
				else if(i9) {
					if(resultSet.getString("ingredient9").equals(selections.get(i))) {
						matching++;
					}
				}
				else if(i10) {
					if(resultSet.getString("ingredient10").equals(selections.get(i))) {
						matching++;
					}
				}
			}
			//determine if the user selected all of the ingredients belonging to a recipe
			if(count == matching) {
				//create a new recipe object for the recipe and add the recipe object to the recipe_arr array
				recipes rec = new recipes(link, name, time, count);
	            recipeList.add(rec);
			}	
        }        
        resultSet.close();
        statement.close();
        disconnect();        
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
            int count = 0;
			if(resultSet.getString("ingredient1") != null) {
				count++;
			}
			if(resultSet.getString("ingredient2") != null) {
				count++;
			}
			if(resultSet.getString("ingredient3") != null) {
				count++;
			}
			if(resultSet.getString("ingredient4") != null) {
				count++;
			}
			if(resultSet.getString("ingredient5") != null) {
				count++;
			}
			if(resultSet.getString("ingredient6") != null) {
				count++;
			}
			if(resultSet.getString("ingredient7") != null) {
				count++;
			}
			if(resultSet.getString("ingredient8") != null) {
				count++;
			}
			if(resultSet.getString("ingredient9") != null) {
				count++;
			}
			if(resultSet.getString("ingredient10") != null) {
				count++;
			}
			//create a new recipe object for the recipe and add the recipe object to the recipe_arr array
			recipes rec = new recipes(link, name, time, count);
	        recipeList.add(rec);	
        }        
        resultSet.close();
        statement.close();
        disconnect();        
        return recipeList;
    }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    
}
