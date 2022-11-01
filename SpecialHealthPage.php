<!DOCTYPE html>
<!--declaration of HTML5-->
<html>

<head>
    <meta charset="utf-8">
    <title>Lifestyle Options</title>
    <script src="index.js" type="text/javascript" defer></script>
    <link href="styles.css" rel="stylesheet" type="text/css" />
        
</head>

<body>

    <main-header></main-header>

    <br>Lifestyle Options
    <!--style sheet--> <br>
	
	<form method = "get" action="ingredients.php">
		<div id="switchContainer">
			<ul>
				<li>Vegan
					<label class="switch">
						<input type="checkbox" id="myCheck" value="filterSelection('vegan')">
						<span class="slider round"></span>
					</label>
				</li>
				<li>Vegetarian
					<label class="switch">
						<input type="checkbox" id="myCheck" value="filterSelection('vegetarian')">
						<span class="slider round"></span>
					</label>
				</li>
				<li>Pescatarian
					<label class="switch">
						<input type="checkbox" id="myCheck" value="filterSelection('pescatarian')">
						<span class="slider round"></span>
					</label>
				</li>
				<li>Diabetic
					<label class="switch">
						<input type="checkbox" id="myCheck" value="filterSelection('diabetic')">
						<span class="slider round"></span>
					</label>
				</li>
				<br><input type="submit" value="Save Prefrences">
				<!--new addition, link for new html document.-->
			</ul>
		</div>
	</form>
        
        <footer>
            <p><small>QuickFitCuisine<b></b></small></p>
        </footer>
    </body>
</html>
