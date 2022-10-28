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
		<p>We assume you have salt, pepper, and water.</p>
		<form action="" method="post">
			<fieldset>
				<legend>Ingredient Selector</legend>
				<!--Ingredient Button Menu, name is array, id is for label, value is string-->

				<label for="broccoli">Broccoli:</label>
				<input type="checkbox" name="selection[]" id="broccoli" value="broccoli"><br>

				<label for="onion">Onion:</label>
				<input type="checkbox" name="selection[]" id="onion" value="onion"><br>

				<label for="carrot">Carrot:</label>
				<input type="checkbox" name="selection[]" id="carrot" value="carrot"><br>

				<label for="egg">Egg:</label>
				<input type="checkbox" name="selection[]" id="egg" value="egg"><br>



				<!--Submit button, clicked after user selects all ingredients. Recipes will load after this button is clicked.-->
				<br><input type="submit" name ="submit" value="Find Recipe">
				
			</fieldset>
			
		</form>
		
		</div>
	</div> 
	
	<div class="split right">
  	<div class="centered">
    	<h2>Your Recipes</h2>
    	<p>Add ingredients to your pantry to see available recipes.<br><br>
		<?php 
    				$dbname = 'ingredientdb';
					$dbuser = 'root';
					$dbpass = 'pass1234';
					$dbhost = 'localhost';
					$conn = new mysqli($dbhost, $dbuser, $dbpass, $dbname);
					if (isset($_POST['submit']) && !empty($_POST['submit'])) {
						$recipes = 0;
						$sql = "SELECT * FROM recipes";
						$result = $conn->query($sql);
						$ingredients = $_POST['selection'];
						$recipe_arr = array();
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
								else if($row["ingredient2"] != null) {
									$count++;
								}
								else if($row["ingredient3"] != null) {
									$count++;
								}
								else if($row["ingredient4"] != null) {
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
								}
								//determine if the user selected all of the ingredients belonging to a recipe
								if($count == $matching) {
									//insert the new recipe into the array recipe_arr
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
							//each recipe is output here, the styling for each will be done here [basis for filtering for time, # of ingredients, etc]
							for($i = 0; $i < $recipes; $i++) {
								$name = $recipe_arr[$i][0];
								$link = $recipe_arr[$i][1];
								$time = $recipe_arr[$i][2];
								$count = $recipe_arr[$i][3];
								echo "<p class='mycss'><a href=$link target=_blank>{$name}</a><br>Estimated Recipe Time: {$time}<br></p>";
							}
						  } 
						  else {
							echo "0 results";
						  }
						  $conn->close();
						
						//$result = $stmt->result_metadata();
						
					}
					else {
						//echo 'waiting';
					}
				?>
    	</p>
  	</div>
	</div>

	</main>
</body>

</html>