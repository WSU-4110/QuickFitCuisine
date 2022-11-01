<?php
include 'SpecialHealthPage.php';
session_start();
$_SESSION['recipes_arr'];
$_SESSION['recipes'];
$_SESSION['timeSortBool'] = false;
$_SESSION['ingredientsSortBool'] = false;
?>
<!doctype html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Quick Fit Cuisine</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="styles.css" rel="stylesheet" type="text/css" />
	<script src="index.js" type="text/javascript" defer></script>
</head>

<body>
	<main-header></main-header>
	<main>
	<div class="split left">
  	<div class="centered">
		<h1>Recipe Finder</h1>
		<div id="myBtnContainer">
		  <button class="btn active" onclick="filterSelection('all')"> Show all</button>
		  <button class="btn" onclick="filterSelection('vegetarian')"> Vegetarian</button>
		  <button class="btn" onclick="filterSelection('pescatarian')"> Pescatarian</button>
		  <button class="btn" onclick="filterSelection('vegan')"> Vegan</button>
		  <button class="btn" onclick="filterSelection('diabetic')"> Diabetic</button>
		</div>
		<p>We assume you have salt, pepper, water, and oil.</p>
		<form action="" method="post">
			<div class="container">
				<fieldset>
					<legend>Ingredient Selector</legend>
					<!--Ingredient Button Menu, name is array, id is for label, value is string-->
					<table>
						<tr>
							<td>
					<div class="filterDiv vegetarian vegan">
					<label for="broccoli">Broccoli:</label>
					<input type="checkbox" name="selection[]" id="broccoli" value="broccoli"><br>
					</div>
							</td>
							<td>
					<div class="filterDiv vegetarian vegan">
					<label for="onion">Onion:</label>
					<input type="checkbox" name="selection[]" id="onion" value="onion"><br>
					</div>
							</td>
							<td>
					<div class="filterDiv vegetarian vegan">
					<label for="carrot">Carrot:</label>
					<input type="checkbox" name="selection[]" id="carrot" value="carrot"><br>
					</div>
							</td>
							<td>
					<div class="filterDiv vegetarian">
					<label for="egg">Egg:</label>
					<input type="checkbox" name="selection[]" id="egg" value="egg"><br>
					</div>
							</td>
						</tr>
						<tr>
							<td>
					<div class="filterDiv">
					<label for="salmon">Salmon:</label>
					<input type="checkbox" name="selection[]" id="salmon" value="salmon"><br>
					</div>
							</td>
							<td>
					<div class="filterDiv vegetarian vegan">
					<label for="mustard">Mustard:</label>
					<input type="checkbox" name="selection[]" id="mustard" value="mustard"><br>
					</div>
							</td>
							<td>
					<div class="filterDiv vegetarian vegan">
					<label for="maplesyrup">Maple Syrup:</label>
					<input type="checkbox" name="selection[]" id="maplesyrup" value="maplesyrup"><br>
					</div>
							</td>
							<td>
					<div class="filterDiv vegetarian vegan">
					<label for="peas">Peas:</label>
					<input type="checkbox" name="selection[]" id="peas" value="peas"><br>
					</div>
							</td>
						</tr>
						<tr>
							<td>
					<div class="filterDiv vegetarian vegan">
					<label for="garlic">Garlic:</label>
					<input type="checkbox" name="selection[]" id="garlic" value="garlic"><br>
					</div>
							</td>
							<td>
					<div class="filterDiv vegetarian">
					<label for="cheese">Cheese:</label>
					<input type="checkbox" name="selection[]" id="cheese" value="cheese"><br>
					</div>
							</td>
							<td>
					<div class="filterDiv vegetarian vegan">
					<label for="spaghetti">Maple Syrup:</label>
					<input type="checkbox" name="selection[]" id="spaghetti" value="spaghetti"><br>
					</div>
							</td>
							<td>
					<div class="filterDiv vegetarian vegan">
					<label for="spices">Spices:</label>
					<input type="checkbox" name="selection[]" id="spices" value="spices"><br>
					</div>
							</td>
						</tr>
						<tr>
							<td>
					<div class="filterDiv vegetarian">
					<label for="greekyogurt">Greek Yogurt:</label>
					<input type="checkbox" name="selection[]" id="greekyogurt" value="greekyogurt"><br>
					</div>
							</td>
							<td>
					<div class="filterDiv vegetarian vegan">
					<label for="blackbeans">Black Beans:</label>
					<input type="checkbox" name="selection[]" id="blackbeans" value="blackbeans"><br>
					</div>
							</td>	
							<td>
					<div class="filterDiv vegetarian vegan">
					<label for="avocado">Avocado:</label>
					<input type="checkbox" name="selection[]" id="avocado" value="avocado"><br>
					</div>
							</td>
							<td>
					<div class="filterDiv vegetarian vegan">
					<label for="salsa">Salsa:</label>
					<input type="checkbox" name="selection[]" id="salsa" value="salsa"><br>
					</div>
							</td>
						</tr>
						<tr>
							<td>
					<div class="filterDiv">
					<label for="groundmeat">Ground Meat:</label>
					<input type="checkbox" name="selection[]" id="groundmeat" value="groundmeat"><br>
					</div>
							</td>
							<td>
					<div class="filterDiv vegetarian vegan">
					<label for="brusselsprouts">Brussel Sprouts:</label>
					<input type="checkbox" name="selection[]" id="brusselsprouts" value="brusselsprouts"><br>
					</div>
							</td>
							<td>
					<div class="filterDiv vegetarian vegan">
					<label for="potatoe">Potatoe:</label>
					<input type="checkbox" name="selection[]" id="potatoe" value="potatoe"><br>
					</div>
							</td>
							<td>
					<div class="filterDiv vegetarian vegan">
					<label for="lettuce">Lettuce:</label>
					<input type="checkbox" name="selection[]" id="lettuce" value="lettuce"><br>
					</div>
							</td>
						</tr>
						<tr>
							<td>
					<div class="filterDiv vegetarian">
					<label for="milk">Milk:</label>
					<input type="checkbox" name="selection[]" id="milk" value="milk"><br>
					</div>
							</td>
							<td>
					<div class="filterDiv vegetarian">
					<label for="butter">Butter:</label>
					<input type="checkbox" name="selection[]" id="butter" value="butter"><br>
					</div>
							</td>
							<td>
				<label for="rice">Rice:</label>
				<input type="checkbox" name="selection[]" id="rice" value="rice"><br>
							</td>
							<td>
				<label for="lentils">Lentils:</label>
				<input type="checkbox" name="selection[]" id="lentils" value="lentils"><br>
							</td>
						</tr>
						<tr>
							<td>
				<label for="chicken">Chicken:</label>
				<input type="checkbox" name="selection[]" id="chicken" value="chicken"><br>
							</td>
							<td>
				<label for="chickpeas">Chickpeas:</label>
				<input type="checkbox" name="selection[]" id="chickpeas" value="chickpeas"><br>
							</td>
							<td>
				<label for="lemon">Lemon:</label>
				<input type="checkbox" name="selection[]" id="lemon" value="lemon"><br>
							</td>
							<td>
				<label for="bread">Bread:</label>
				<input type="checkbox" name="selection[]" id="bread" value="bread"><br>
							</td>
						</tr>
				<!--Submit button, clicked after user selects all ingredients. Recipes will load after this button is clicked.-->
				<br><input type="submit" name ="recipefinder" value="Find Recipe">
				
				</fieldset>
			</div>
		</form>
		</div>
	</div> 
	
	<div class="split right">
  	<div class="centered">
    	<h2>Your Recipes</h2>
    	<p>Add ingredients to see available recipes.<br><br>
			<?php
				//database connection variables
    			$dbname = 'ingredientdb';
				$dbuser = 'root';
				$dbpass = 'pass1234';
				$dbhost = 'localhost';
				$conn;
				if (strtoupper(substr(php_uname('s'), 0, 1)) === 'D') {
					$conn = new mysqli($dbhost, $dbuser, $dbpass, $dbname, 3306, "/tmp/mysql.sock");
				}
				else {
					$conn = new mysqli($dbhost, $dbuser, $dbpass, $dbname);
				}
				$recipes = 0;
				$recipe_arr = array();
				$recipe_arr_timeSort = array();
				//if find recipe button is clicked
				if (isset($_POST['recipefinder']) && !empty($_POST['recipefinder'])) {
					session_reset();
					$sql = "SELECT * FROM recipes";
					$result = $conn->query($sql);
					$ingredients = $_POST['selection'];
					//if there is atleast 1 recipe
					if ($result->num_rows > 0) {
						// fetch recipes from database
						while($row = $result->fetch_assoc()) {
							$time = $row["time"];
							$name = $row["name"];
							$link = $row["link"];
							$count = 0;
							$matching = 0;
							if($row["ingredient1"] != null) {
								$count++;
							}
							if($row["ingredient2"] != null) {
								$count++;
							}
							if($row["ingredient3"] != null) {
								$count++;
							}
							if($row["ingredient4"] != null) {
								$count++;
							}
							if($row["ingredient5"] != null) {
								$count++;
							}
							if($row["ingredient6"] != null) {
								$count++;
							}
							if($row["ingredient7"] != null) {
								$count++;
							}
							if($row["ingredient8"] != null) {
								$count++;
							}
							if($row["ingredient9"] != null) {
								$count++;
							}
							if($row["ingredient10"] != null) {
								$count++;
							}
							for($i=0; $i < count($ingredients); $i++) {
								if($row["ingredient1"] == $ingredients[$i]) {
									$matching++;
								}
								else if($row["ingredient2"] == $ingredients[$i]) {
									$matching++;
								}
								else if($row["ingredient3"] == $ingredients[$i]) {
									$matching++;
								}
								else if($row["ingredient4"] == $ingredients[$i]) {
									$matching++;
								}
								else if($row["ingredient5"] == $ingredients[$i]) {
									$matching++;
								}
								else if($row["ingredient6"] == $ingredients[$i]) {
									$matching++;
								}
								else if($row["ingredient7"] == $ingredients[$i]) {
									$matching++;
								}
								else if($row["ingredient8"] == $ingredients[$i]) {
									$matching++;
								}
								else if($row["ingredient9"] == $ingredients[$i]) {
									$matching++;
								}
								else if($row["ingredient10"] == $ingredients[$i]) {
									$matching++;
								}
							}
							//determine if the user selected all of the ingredients belonging to a recipe
							if($count == $matching) {
								//insert the new recipe into the array recipe_arr
								//insertRecipe($name, $link, $time, $count);
								$newrecipe = array (
									0 => $name,
									1 => $link,
									2 => $time,
									3 => $count
								);
								array_push($recipe_arr, $newrecipe);
								$recipes++;
							}						
						}
						//check if there is atleast 1 recipe
						if($recipes > 0) {
							//Sort buttons are displayed here
							echo "<form method='post'>
							<input type='submit' name ='timeSortbutton' value='Sort Recipes by Cooking Time (Low-High)'>
							<input type='submit' name ='descendingIngredientsButton' value='Sort Recipes by Amount of Ingredients (High-Low)'>
							</form>";
							//call the function to print recipes and set session variables (this allows the values to be kept between page refreshes in order to further sort)
							$_SESSION['recipes_arr'] = $recipe_arr;
							$_SESSION['recipes'] = $recipes;
							printRecipes($_SESSION['recipes_arr'], $_SESSION['recipes']);
						}
					}
					else {
						echo "0 Recipes stored in database";
					}
					$conn->close();
				}
				if (isset($_POST['timeSortbutton']) && !empty($_POST['timeSortbutton'])) {
					//Sort buttons are displayed here
					echo "<form method='post'>
					<input type='submit' name ='timeSortbutton' value='Sort Recipes by Cooking Time (Low-High)'>
					<input type='submit' name ='descendingIngredientsButton' value='Sort Recipes by Amount of Ingredients (High-Low)'>
					</form>";
					timeSort($_SESSION['recipes_arr'], $_SESSION['recipes']);
				}
				if (isset($_POST['descendingIngredientsButton']) && !empty($_POST['descendingIngredientsButton'])) {
					//Sort buttons are displayed here
					echo "<form method='post'>
					<input type='submit' name ='timeSortbutton' value='Sort Recipes by Cooking Time (Low-High)'>
					<input type='submit' name ='descendingIngredientsButton' value='Sort Recipes by Amount of Ingredients (High-Low)'>
					</form>";
					descendingIngredients($_SESSION['recipes_arr'], $_SESSION['recipes']);
				}
				//sort recipes in ascending order by cooking time
				function timeSort(Array $recipe_arr, $recipes) {
					for($i = 0; $i < $recipes-1; $i++) {		
						for($j = 0; $j < $recipes - $i - 1; $j++) {
							if($recipe_arr[$j][2] > $recipe_arr[$j+1][2]) {
								$tempName = $recipe_arr[$j][0];
								$tempLink = $recipe_arr[$j][1];
								$tempTime = $recipe_arr[$j][2];
								$tempCount = $recipe_arr[$j][3];
								$recipe_arr[$j][0] = $recipe_arr[$j+1][0];
								$recipe_arr[$j][1] = $recipe_arr[$j+1][1];
								$recipe_arr[$j][2] = $recipe_arr[$j+1][2];
								$recipe_arr[$j][3] = $recipe_arr[$j+1][3];
								$recipe_arr[$j+1][0] = $tempName;
								$recipe_arr[$j+1][1] = $tempLink;
								$recipe_arr[$j+1][2] = $tempTime;
								$recipe_arr[$j+1][3] = $tempCount;
							}
						}
					}	
					printRecipes($recipe_arr, $_SESSION['recipes']);
				}
				//sort recipes in descending order by # of ingredients
				function descendingIngredients(Array $recipe_arr, $recipes) {
					for($i = 0; $i < $recipes-1; $i++) {
						for($j = 0; $j < $recipes - $i - 1; $j++) {
							if($recipe_arr[$j][3] < $recipe_arr[$j+1][3]) {
								$tempName = $recipe_arr[$j][0];
								$tempLink = $recipe_arr[$j][1];
								$tempTime = $recipe_arr[$j][2];
								$tempCount = $recipe_arr[$j][3];
								$recipe_arr[$j][0] = $recipe_arr[$j+1][0];
								$recipe_arr[$j][1] = $recipe_arr[$j+1][1];
								$recipe_arr[$j][2] = $recipe_arr[$j+1][2];
								$recipe_arr[$j][3] = $recipe_arr[$j+1][3];
								$recipe_arr[$j+1][0] = $tempName;
								$recipe_arr[$j+1][1] = $tempLink;
								$recipe_arr[$j+1][2] = $tempTime;
								$recipe_arr[$j+1][3] = $tempCount;
							}
						}
					}
					printRecipes($recipe_arr, $_SESSION['recipes']);
				}
				//each recipe is output here
				function printRecipes(Array $recipe_arr, $recipes) {
					$cols = 5;
					$colCount = 0;
						echo "
						<table>
						<tr>";
					for($i = 0; $i < $recipes; $i++) {
						if($colCount == $cols) {
							$colCount = 0;
							echo "</tr><tr>";
						}
						$name = $recipe_arr[$i][0];
						$link = $recipe_arr[$i][1];
						$time = $recipe_arr[$i][2];
						$count = $recipe_arr[$i][3];
						//styling for each recipe is done here
						echo "
						<td class='mycss'>
						<a href=$link target=_blank>{$name}</a>
						<br>Estimated Recipe Time: {$time}
						<br>Ingredients: {$count}
						</td>";
						$colCount++;
					}
					echo "</tr>
					</table>";
				}
			?>
    	</p>
  	</div>
	</div>
	<script src="filterScript.js"></script>
	</main>
</body>

</html>