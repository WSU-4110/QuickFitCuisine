<?php
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

<script>
	var coll = document.getElementsByClassName("collapsible");
	var i;
	
	for (i = 0; i < coll.length; i++) {
	  coll[i].addEventListener("click", function() {
		this.classList.toggle("active");
		var content = this.nextElementSibling;
		if (content.style.maxHeight){
		  content.style.maxHeight = null;
		} else {
		  content.style.maxHeight = content.scrollHeight + "px";
		} 
	  });
	}
	</script>

<body>
	<main>
	<h1>Welcome to Quickfit Cuisine</h1>
	<div class="selection">
		<h2>Recipe Finder</h2>
		<div id="myBtnContainer">
		  <button class="btn active" onclick="filterSelection('all')"> Show all</button>
		  <button class="btn" onclick="filterSelection('vegetarian')"> Vegetarian</button>
		  <button class="btn" onclick="filterSelection('pescatarian')"> Pescatarian</button>
		  <button class="btn" onclick="filterSelection('vegan')"> Vegan</button>
		</div>
		<p>We assume you have salt, pepper, water, and oil.</p>
		<form action="" method="post">
			<div class="container">
				<fieldset>
					<legend>Ingredient Selector</legend>
					<!--Ingredient Button Menu, name is array, id is for label, value is string-->
	
					<fieldset>
					<legend>Dairy</legend>
						<div class="filterDiv vegetarian pescatarian">
	
						<label for="egg">Egg:</label>
						<input type="checkbox" name="selection[]" id="egg" value="egg">
	
						<label for="greekyogurt">Greek Yogurt:</label>
						<input type="checkbox" name="selection[]" id="greekyogurt" value="greekyogurt">
		
						<label for="cheese">Cheese:</label>
						<input type="checkbox" name="selection[]" id="cheese" value="cheese">
	
						<label for="milk">Milk:</label>
						<input type="checkbox" name="selection[]" id="milk" value="milk">
	
						<label for="butter">Butter:</label>
						<input type="checkbox" name="selection[]" id="butter" value="butter">
					</div>
			
					</fieldset>
	
					<fieldset>
					<legend>Vegetables</legend>

						<div class="filterDiv vegetarian vegan pescatarian">
						<label for="onion">Onion:</label>
						<input type="checkbox" name="selection[]" id="onion" value="onion">

						<label for="chickpeas">Chickpeas:</label>
						<input type="checkbox" name="selection[]" id="chickpeas" value="chickpeas">
	
						<label for="red onion">Red Onion:</label>
						<input type="checkbox" name="selection[]" id="red onion" value="red onion">
	
						<label for="carrot">Carrot:</label>
						<input type="checkbox" name="selection[]" id="carrot" value="carrot">
	
						<label for="peas">Peas:</label>
						<input type="checkbox" name="selection[]" id="peas" value="peas"><br>
	
						<label for="avocado">Avocado:</label>
						<input type="checkbox" name="selection[]" id="avocado" value="avocado">

						<label for="greenbeans">Green Beans:</label>
						<input type="checkbox" name="selection[]" id="greenbeans" value="greenbeans">

						<label for="redpepper">Red Pepper:</label>
						<input type="checkbox" name="selection[]" id="redpepper" value="redpepper">
					
						<label for="broccoli">Broccoli:</label>
						<input type="checkbox" name="selection[]" id="broccoli" value="broccoli">
	
						<label for="garlic">Garlic:</label>
						<input type="checkbox" name="selection[]" id="garlic" value="garlic">
	
						<label for="brusselsprouts">Brussel Sprouts:</label>
						<input type="checkbox" name="selection[]" id="brusselsprouts" value="brusselsprouts"><br>
	
						<label for="potato">Potato:</label>
						<input type="checkbox" name="selection[]" id="potato" value="potato">
						
						<label for="blackbeans">Black Beans:</label>
						<input type="checkbox" name="selection[]" id="blackbeans" value="blackbeans">
						
						<label for="lettuce">Lettuce:</label>
						<input type="checkbox" name="selection[]" id="lettuce" value="lettuce">

						<label for="celery">Celery:</label>
						<input type="checkbox" name="selection[]" id="celery" value="celery">

						<label for="spinach">Spinach:</label>
						<input type="checkbox" name="selection[]" id="spinach" value="spinach">

						
					</div>
					</fieldset>

					<fieldset>
					<legend>Fruits</legend>
						<div class="filterDiv vegetarian vegan pescatarian">
						<label for="lemon">Lemon:</label>
						<input type="checkbox" name="selection[]" id="lemon" value="lemons">

						<label for="lime">Lime:</label>
						<input type="checkbox" name="selection[]" id="lime" value="lime">

						<label for="corn">Corn:</label>
						<input type="checkbox" name="selection[]" id="corn" value="corn">
	
					</div>
					</fieldset>
	
					<fieldset>
					<legend>Meats</legend>
						<div class="filterDiv ">
						<label for="chicken">Chicken:</label>
						<input type="checkbox" name="selection[]" id="chicken" value="chicken">
	
						<label for="groundmeat">Ground Beef:</label>
						<input type="checkbox" name="selection[]" id="groundmeat" value="groundmeat">
	
						<label for="bacon">Bacon:</label>
						<input type="checkbox" name="selection[]" id="bacon" value="bacon">

						<label for="turkey">Turkey:</label>
						<input type="checkbox" name="selection[]" id="turkey" value="turkey">
					</div>
					</fieldset>
	
					<fieldset>
						<legend>Fish</legend>
							<div class="filterDiv pescatarian">
							<label for="salmon">Salmon:</label>
							<input type="checkbox" name="selection[]" id="salmon" value="salmon">
		
							<label for="branzino">Branzino:</label>
							<input type="checkbox" name="selection[]" id="branzino" value="branzino">
		
							<label for="sardines">Sardines:</label>
							<input type="checkbox" name="selection[]" id="sardines" value="sardines">

							<label for="catfish">Catfish:</label>
							<input type="checkbox" name="selection[]" id="catfish" value="catfish">

							<label for="cod">Cod:</label>
							<input type="checkbox" name="selection[]" id="cod" value="cod">

							<label for="tilapia">Tilapia:</label>
							<input type="checkbox" name="selection[]" id="tilapia" value="tilapia">
						</div>
					</fieldset>
					
					<fieldset>
					<legend>Condiments</legend>	
						<div class="filterDiv vegetarian vegan pescatarian">
	
						<label for="mustard">Mustard:</label>
						<input type="checkbox" name="selection[]" id="mustard" value="mustard">
	
						<label for="ketchup">Ketchup:</label>
						<input type="checkbox" name="selection[]" id="ketchup" value="ketchup">
	
						<label for="maplesyrup">Maple Syrup:</label>
						<input type="checkbox" name="selection[]" id="maplesyrup" value="maplesyrup">
	
						<label for="salsa">Salsa:</label>
						<input type="checkbox" name="selection[]" id="salsa" value="salsa">

						<label for="pesto">Pesto:</label>
						<input type="checkbox" name="selection[]" id="pesto" value="pesto"><br>

						<label for="spices">Spices:</label>
						<input type="checkbox" name="selection[]" id="spices" value="spices"><br>

						<label for="mayonnaise">Mayonnaise:</label>
						<input type="checkbox" name="selection[]" id="mayonnaise" value="mayonnaise"><br>
					</div>
	
	
					</fieldset>
					
					<fieldset>
					<legend>Pasta</legend>

						<div class="filterDiv vegetarian vegan pescatarian">
						<label for="spaghetti">Spaghetti:</label>
						<input type="checkbox" name="selection[]" id="spaghetti" value="spaghetti">
	
						<label for="penne">Penne:</label>
						<input type="checkbox" name="selection[]" id="penne" value="penne">
	
						<label for="orzo">orzo:</label>
						<input type="checkbox" name="selection[]" id="orzo" value="orzo">
	
						<label for="lingiune">lingiune:</label>
						<input type="checkbox" name="selection[]" id="lingiune" value="lingiune"><br>
	
						<label for="fettuccine">fettuccine:</label>
						<input type="checkbox" name="selection[]" id="fettuccine" value="fettuccine">
						</div>
	
	
					</fieldset>
	
					<fieldset>
					<legend>Misc</legend>

						<div class="filterDiv pescatarian vegan vegetarian">
						<label for="bread">Bread:</label>
						<input type="checkbox" name="selection[]" id="bread" value="bread">

						<label for="broth">Broth:</label>
						<input type="checkbox" name="selection[]" id="broth" value="broth">

						<label for="vinegar">Vinegar:</label>
						<input type="checkbox" name="selection[]" id="vinegar" value="vinegar">

						<label for="almonds">Almonds:</label>
						<input type="checkbox" name="selection[]" id="almonds" value="almonds">

						<label for="honey">Honey:</label>
						<input type="checkbox" name="selection[]" id="honey" value="honey">
						</div>
	
	
					</fieldset>
	
	
					<!--Submit button, clicked after user selects all ingredients. Recipes will load after this button is clicked.-->
					<br><input type="submit" name ="recipefinder" value="Find Recipe">
					
				</fieldset>
				
			</form>
			
			</div>
		</div> 
	
	<div class="result">
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