package quick;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDAO userDAO = new userDAO();
	private recipesDAO recipesDAO = new recipesDAO();
	private savedRecipesDAO savedRecipesDAO = new savedRecipesDAO();
	private ingredientsDAO ingredientsDAO = new ingredientsDAO();
	private String currentUser;
	private ArrayList<String> selections = new ArrayList<String>();
	private boolean sortByTime = false;
	private boolean sortByIngredients = false;
	private HttpSession session = null;

	public ControlServlet() {

	}

	public void init() {
		userDAO = new userDAO();
		recipesDAO = new recipesDAO();
		savedRecipesDAO = new savedRecipesDAO();
		currentUser = "";
		selections = new ArrayList<String>();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		try {
			switch (action) {
			case "/login":
				login(request, response);
				break;
			case "/register":
				register(request, response);
				break;
			case "/initialize":
				userDAO.init();
				System.out.println("Database successfully initialized!");
				rootPage(request, response, "");
				break;
			case "/root":
				rootPage(request, response, "");
				break;
			case "/logout":
				logout(request, response);
				break;
			case "/find":
				request.setAttribute("currentUser", currentUser);
				findRecipes(request, response);
				break;
			case "/list":
				request.setAttribute("currentUser", currentUser);
				listUser(request, response);
				break;
			case "/reset":
				request.setAttribute("currentUser", currentUser);
				resetIngredients(request, response);
				break;
			case "/all":
				request.setAttribute("currentUser", currentUser);
				listAllRecipes(request, response);
				break;
			case "/sort":
				request.setAttribute("currentUser", currentUser);
				sortRecipes(request, response);
				break;
			case "/recipeActions":
				request.setAttribute("currentUser", currentUser);
				determineRecipeAction(request, response);
				break;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	private void determineRecipeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String action = request.getParameter("recipeActionButton");
		char check = action.charAt(0);
		if (check == 'D') {
			deleteRecipe(request, response, action);
		} else if (check == 'S') {
			saveRecipe(request, response, action);
		} else if (check == 'V') {
			viewIngredients(request, response, action);
		}
	}

	private void viewIngredients(HttpServletRequest request, HttpServletResponse response, String action)
			throws ServletException, IOException, SQLException {
		System.out.println("Viewing ingredients");
		String name = action;
		name = name.substring(20);
		System.out.println(name);
		int id = recipesDAO.sendRecipeID(name);
		request.setAttribute("viewName", "Ingredients in " + name + ": ");
		ingredients ingreds = ingredientsDAO.specificIngredients(id);

		if (ingreds.getIngredient1() != "") {
			request.setAttribute("ingred1", ingreds.getIngredient1());
		}
		if (ingreds.getIngredient2() != "") {
			request.setAttribute("ingred2", ingreds.getIngredient2());
		}
		if (ingreds.getIngredient3() != "") {
			request.setAttribute("ingred3", ingreds.getIngredient3());
		}
		if (ingreds.getIngredient4() != "") {
			request.setAttribute("ingred4", ingreds.getIngredient4());
		}
		if (ingreds.getIngredient5() != "") {
			request.setAttribute("ingred5", ingreds.getIngredient5());
		}
		if (ingreds.getIngredient6() != "") {
			request.setAttribute("ingred6", ingreds.getIngredient6());
		}
		if (ingreds.getIngredient7() != "") {
			request.setAttribute("ingred7", ingreds.getIngredient7());
		}
		if (ingreds.getIngredient8() != "") {
			request.setAttribute("ingred8", ingreds.getIngredient8());
		}
		if (ingreds.getIngredient9() != "") {
			request.setAttribute("ingred9", ingreds.getIngredient9());
		}
		if (ingreds.getIngredient10() != "") {
			request.setAttribute("ingred10", ingreds.getIngredient10());
		}
		request.setAttribute("listRecipes", recipesDAO.refreshRecipes());
		request.getRequestDispatcher("ingredients.jsp").forward(request, response);
	}

	private void deleteRecipe(HttpServletRequest request, HttpServletResponse response, String action)
			throws ServletException, IOException, SQLException {
		System.out.println("Deleting recipe function");
		String name = action;
		name = name.substring(14);
		System.out.println(name);
		int id = recipesDAO.sendRecipeID(name);
		System.out.println(id);
		savedRecipesDAO.delete(currentUser, id);
		request.setAttribute("listSavedRecipes", recipesDAO.listSavedRecipes(currentUser));
		request.getRequestDispatcher("ingredients.jsp").forward(request, response);
	}

	private void saveRecipe(HttpServletRequest request, HttpServletResponse response, String action)
			throws ServletException, IOException, SQLException {
		System.out.println("saving recipe function");
		String name = action;
		name = name.substring(12);
		System.out.println(name);
		int id = recipesDAO.sendRecipeID(name);
		System.out.println(id);
		if (currentUser.equals("")) {
			System.out.println("Must be logged in to save recipes.");
			request.setAttribute("saveRecipesError", "You must be logged in to save recipes.");
			if (selections.isEmpty()) {
				request.setAttribute("listRecipes", recipesDAO.allRecipes());
			} else {
				request.setAttribute("listRecipes", recipesDAO.listValidRecipes(selections));
			}
			request.getRequestDispatcher("ingredients.jsp").forward(request, response);
		} else {
			System.out.println("passed currentUser check");
			if (savedRecipesDAO.checkNumberOfSavedRecipe(currentUser, id) == 10) {
				System.out.println(
						"You have already saved 10 recipes, cannot save anymore. Delete current saved recipes to make room for others.");
				request.setAttribute("saveRecipesError3",
						"You have already saved 10 recipes, cannot save anymore. Delete current saved recipes to make room for others.");
				request.setAttribute("listRecipes", recipesDAO.listSavedRecipes(currentUser));
				request.getRequestDispatcher("ingredients.jsp").forward(request, response);
			} else {
				System.out.println("passed checknumberofsavedrecipe check");
				if (savedRecipesDAO.checkSavedRecipe(currentUser, id)) {
					// valid path, saving recipe
					System.out.println("saving recipe");
					savedRecipesDAO.insertSavedRecipe(currentUser, id);
					request.setAttribute("listSavedRecipes", recipesDAO.listSavedRecipes(currentUser));
					request.getRequestDispatcher("ingredients.jsp").forward(request, response);
				} else {
					System.out.println("Recipe Already Saved");
					request.setAttribute("saveRecipesError2", "You have already saved that recipe.");
					if (selections.isEmpty()) {
						request.setAttribute("listRecipes", recipesDAO.allRecipes());
					} else {
						request.setAttribute("listRecipes", recipesDAO.listValidRecipes(selections));
					}
					request.getRequestDispatcher("ingredients.jsp").forward(request, response);
				}
			}
		}

	}

	private void sortRecipes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println("sorting recipes");
		String filter = request.getParameter("sortButton");
		if (filter.equals("Saved")) {
			request.setAttribute("listSavedRecipes", recipesDAO.listSavedRecipes(currentUser));
		} else if (filter.equals("Time")) {
			request.setAttribute("listRecipes", recipesDAO.timeSort(sortByTime));
			if (sortByTime) {
				sortByTime = false;
			} else {
				sortByTime = true;
			}
		} else if (filter.equals("Ingredients")) {
			request.setAttribute("listRecipes", recipesDAO.ingredientsSort(sortByIngredients));
			if (sortByIngredients) {
				sortByIngredients = false;
			} else {
				sortByIngredients = true;
			}
		}
		request.getRequestDispatcher("ingredients.jsp").forward(request, response);
	}

	private void listAllRecipes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println("displaying all recipes");
		selections = new ArrayList<String>();
		request.setAttribute("listRecipes", recipesDAO.allRecipes());
		request.getRequestDispatcher("ingredients.jsp").forward(request, response);
	}

	private void resetIngredients(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println("reset ingredients");
		selections = new ArrayList<String>();
		request.getRequestDispatcher("ingredients.jsp").forward(request, response);
	}

	private void findRecipes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println("finding recipes");
		String s = request.getParameter("selection");
		boolean added = false;
		for (int i = 0; i < selections.size(); i++) {
			if (s.equals(selections.get(i))) {
				added = true;
			}
		}
		if (added == false) {
			selections.add(s);
		} else {
			System.out.println("Ingredient already added. Cannot add again");
		}
		for (int i = 0; i < selections.size(); i++) {
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

	private void rootPage(HttpServletRequest request, HttpServletResponse response, String view)
			throws ServletException, IOException, SQLException {
		System.out.println("root view");
		request.setAttribute("listUser", userDAO.listAllUsers());
		request.getRequestDispatcher("rootView.jsp").forward(request, response);
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (email.equals("root") && password.equals("pass1234")) {
			System.out.println("Login Successful! Redirecting to root");
			session = request.getSession();
			session.setAttribute("username", email);
			rootPage(request, response, "");
		} else if (userDAO.isValid(email, password)) {
			currentUser = email;
			System.out.println("Login Successful! Redirecting");
			request.setAttribute("currentUser", currentUser);
			request.getRequestDispatcher("ingredients.jsp").forward(request, response);
		} else {
			request.setAttribute("loginStr", "Login Failed: Please check your credentials.");
			request.getRequestDispatcher("ingredients.jsp").forward(request, response);
		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirmation");

		if (password.equals(confirm)) {
			if (!userDAO.checkEmail(email)) {
				System.out.println("Registration Successful! Added to database");
				user users = new user(email, password);
				savedRecipes saved = new savedRecipes(email);
				userDAO.insert(users);
				savedRecipesDAO.insert(saved);
				request.getRequestDispatcher("ingredients.jsp").forward(request, response);
			} else {
				System.out.println("An account is already registered under this email.");
				request.setAttribute("errorOne",
						"Registration failed: An account is already registered under this email.");
				request.getRequestDispatcher("ingredients.jsp").forward(request, response);
			}
		} else {
			System.out.println("Password and Password Confirmation do not match");
			request.setAttribute("errorTwo", "Registration failed: Password and Password Confirmation do not match.");
			request.getRequestDispatcher("ingredients.jsp").forward(request, response);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		currentUser = "";
		response.sendRedirect("ingredients.jsp");
	}
}
