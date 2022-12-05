import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;


public class ControlServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private userDAO userDAO = new userDAO();
	    private recipesDAO recipesDAO = new recipesDAO();
	    private String currentUser;
	    private ArrayList<String> selections = new ArrayList<String>();
	    private boolean sortByTime = false;
	    private boolean sortByIngredients = false;
	    private HttpSession session=null;
	    
	    public ControlServlet()
	    {
	    	
	    }
	    
	    public void init()
	    {
	    	userDAO = new userDAO();
	    	recipesDAO = new recipesDAO();
	    	currentUser= "";
	    	selections = new ArrayList<String>();
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getServletPath();
	        System.out.println(action);
	    
	    try {
        	switch(action) {  
        	case "/login":
        		login(request,response);
        		break;
        	case "/register":
        		register(request, response);
        		break;
        	case "/initialize":
        		userDAO.init();
        		System.out.println("Database successfully initialized!");
        		rootPage(request,response,"");
        		break;
        	case "/root":
        		rootPage(request,response, "");
        		break;
        	case "/logout":
        		logout(request,response);
        		break;
        	 case "/find": 
                 findRecipes(request, response);           	
                 break;
        	 case "/list": 
                 listUser(request, response);           	
                 break;
        	 case "/reset": 
                 resetIngredients(request, response);           	
                 break;
        	 case "/all": 
                 listAllRecipes(request, response);           	
                 break;
        	 case "/sort": 
                 sortRecipes(request, response);           	
                 break;
	    	}
	    }
	    catch(Exception ex) {
        	System.out.println(ex.getMessage());
	    	}
	    }
	    
	    private void sortRecipes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
	    	System.out.println("sorting recipes");
	    	String filter = request.getParameter("sortButton");	
	    	if(selections.isEmpty()) {
	    		System.out.println("Cannot sort recipes when no ingredients have been selected.");
	    	}
	    	else {
	    		if(filter.equals("Time")) {
		    		request.setAttribute("listRecipes", recipesDAO.timeSort(sortByTime));
		    		if(sortByTime) {
		    			sortByTime = false;
		    		}
		    		else {
		    			sortByTime = true;
		    		}
		    	}
		    	else if(filter.equals("Ingredients")) {
		    		request.setAttribute("listRecipes", recipesDAO.ingredientsSort(sortByIngredients));
		    		if(sortByIngredients) {
		    			sortByIngredients = false;
		    		}
		    		else {
		    			sortByIngredients = true;
		    		}
		    	}
	    	}
	    	request.getRequestDispatcher("ingredients.jsp").forward(request, response);
	    }
	    
	    private void listAllRecipes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
	    	System.out.println("displaying all recipes");
	    	selections = new ArrayList<String>();
	    	request.setAttribute("listRecipes", recipesDAO.allRecipes());
	    	request.getRequestDispatcher("ingredients.jsp").forward(request, response);
	    }
	    
	    private void resetIngredients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
	    	System.out.println("reset ingredients");
	    	selections = new ArrayList<String>();
	    	request.getRequestDispatcher("ingredients.jsp").forward(request, response);
	    }
	    
	    private void findRecipes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
	    	System.out.println("finding recipes");
	    	String s = request.getParameter("selection");
	    	boolean added = false;
	    	for(int i  = 0; i < selections.size(); i++) {
				if(s.equals(selections.get(i))) {
					added = true;
				}
			}
	    	if(added == false) {
	    		selections.add(s);
	    	}
	    	else {
	    		System.out.println("Ingredient already added. Cannot add again");
	    	}
	    	for(int i = 0; i < selections.size(); i++) {
	    		System.out.print(selections.get(i) + " ");
	    	}
	    	
	    	List<recipes> recipeList = recipesDAO.listValidRecipes(selections);
	    	request.setAttribute("listRecipes", recipeList);
	    	request.setAttribute("ingredientSelections", selections);
	    	request.getRequestDispatcher("ingredients.jsp").forward(request, response);
	    }
	    
	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        System.out.println("listUser started: 00000000000000000000000000000000000");

	     
	        List<user> listUser = userDAO.listAllUsers();
	        request.setAttribute("listUser", listUser);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("listPeople finished: 111111111111111111111111111111111111");
	    }
	    	        
	    private void rootPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("root view");
			request.setAttribute("listUser", userDAO.listAllUsers());
	    	request.getRequestDispatcher("rootView.jsp").forward(request, response);
	    }
	    
	    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	 String email = request.getParameter("email");
	    	 String password = request.getParameter("password");
	    	 
	    	 if (email.equals("root") && password.equals("pass1234")) {
				 System.out.println("Login Successful! Redirecting to root");
				 session = request.getSession();
				 session.setAttribute("username", email);
				 rootPage(request, response, "");
	    	 }
	    	 else if(userDAO.isValid(email, password)) 
	    	 {
			 	 
			 	currentUser = email;
				System.out.println("Login Successful! Redirecting");
				request.getRequestDispatcher("ingredients.jsp").forward(request, response);
	    	 }
	    	 else {
	    		 request.setAttribute("loginStr","Login Failed: Please check your credentials.");
	    		 request.getRequestDispatcher("login.jsp").forward(request, response);
	    	 }
	    }
	           
	    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	String email = request.getParameter("email");
	   	 	String password = request.getParameter("password");	   	 	
	   	 	String confirm = request.getParameter("confirmation");
	   	 	
	   	 	if (password.equals(confirm)) {
	   	 		if (!userDAO.checkEmail(email)) {
	   	 			System.out.println("Registration Successful! Added to database");
		            user users = new user(email, password);
		   	 		userDAO.insert(users);
		   	 		response.sendRedirect("login.jsp");
	   	 		}
		   	 	else {
		   	 		System.out.println("An account is already registered under this email.");
		    		 request.setAttribute("errorOne","Registration failed: An account is already registered under this email.");
		    		 request.getRequestDispatcher("register.jsp").forward(request, response);
		   	 	}
	   	 	}
	   	 	else {
	   	 		System.out.println("Password and Password Confirmation do not match");
	   	 		request.setAttribute("errorTwo","Registration failed: Password and Password Confirmation do not match.");
	   	 		request.getRequestDispatcher("register.jsp").forward(request, response);
	   	 	}
	    }    
	    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    	currentUser = "";
        		response.sendRedirect("login.jsp");
        	}
}
	        
	        
	    
	        
	        
	        
	    


