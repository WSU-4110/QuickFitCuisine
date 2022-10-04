<!doctype html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Quick Fit Cuisine</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="style.css" rel="stylesheet" type="text/css" />
	<script src="index.js" type="text/javascript" defer></script>
</head>

<body>
	<main-header></main-header>
	<main>

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
    					
					}
				?>
			</fieldset>
			
		</form>



	</main>
</body>

</html>