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
				<input type="checkbox" name="selection[]" id="broccoli" value="broccoli">

				<label for="onion">Onion:</label>
				<input type="checkbox" name="selection[]" id="onion" value="onion">

				<label for="carrot">Carrot:</label>
				<input type="checkbox" name="selection[]" id="carrot" value="carrot">

				<label for="egg">Egg:</label>
				<input type="checkbox" name="selection[]" id="egg" value="egg">



				<!--Submit button, clicked after user selects all ingredients. Recipes will load after this button is clicked.-->
				<br><input type="submit" value="Find Recipe">
				<?php 
					if (isset($_POST['selection'])) 
					{
    					$dbname = 'ingredientdb';
						$dbuser = 'root';
						$dbpass = 'pass1234';
						$dbhost = 'localhost';
						$mysqli = new mysqli($dbhost, $dbuser, $dbpass, $dbname);
						if (isset($_POST['selection'])) {
							$stmt = $myslqi->prepare("SELECT * from recipes");
							$stmt->execute();
							$result = $stmt->result_metadata();
						}
					}
				?>
			</fieldset>
			
		</form>
		</div>
	</div> 

	<div class="split right">
  	<div class="centered">
    	<h2>Your Recipies</h2>
    	<p>Add ingredients to your pantry to see available recipies.
    	</p>
  	</div>
	</div>

	</main>
</body>

</html>