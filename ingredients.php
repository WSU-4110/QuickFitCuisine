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
		<form action="ingredients.php" method="POST">
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
				<br><input type="submit" value="Find Recipe">
				
			</fieldset>
			
		</form>
		
		</div>
	</div> 
	
	<div class="split right">
  	<div class="centered">
    	<h2>Your Recipes</h2>
    	<p>Add ingredients to your pantry to see available recipes.
		<?php 
    				$dbname = 'ingredientdb';
					$dbuser = 'root';
					$dbpass = 'pass1234';
					$dbhost = 'localhost';
					$conn = new mysqli($dbhost, $dbuser, $dbpass, $dbname);
					if (isset($_POST['selection'])) {
						$sql = "SELECT link FROM recipes";
						$result = $conn->query($sql);

						if ($result->num_rows > 0) {
							// output data of each row
							while($row = $result->fetch_assoc()) {
								$link = $row["link"];
							  	echo "<a href=$link target=_blank>recipe</a>";
							}
						  } else {
							echo "0 results";
						  }
						  $conn->close();
						
						//$result = $stmt->result_metadata();
						
					}
				?>
    	</p>
  	</div>
	</div>

	</main>
</body>

</html>