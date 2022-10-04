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
						$sql = "SELECT * FROM recipes";
						$result = $conn->query($sql);
						$ingredients = $_POST['selection'];
						if ($result->num_rows > 0) {
							// output link
							while($row = $result->fetch_assoc()) {
								$time = $row["time"];
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
								}		
								if($count == $matching) {
									//each recipe is output here, the styling for each will be done here
									echo "<p class='mycss'>Estimated Recipe Time: {$time} <br><a href=$link target=_blank>click here for recipe</a><br></p>";
								}						
							}
						  } else {
							echo "0 results";
						  }
						  $conn->close();
						
						//$result = $stmt->result_metadata();
						
					}
					else {
						echo 'waiting';
					}
				?>
    	</p>
  	</div>
	</div>

	</main>
</body>

</html>