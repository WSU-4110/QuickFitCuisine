<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Quick Fit Cuisine</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="styles.css" rel="stylesheet" type="text/css" />
	<link rel="apple-touch-icon" sizes="180x180" href="images/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="images/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="images/favicon-16x16.png">
	<link rel="manifest" href="images/site.webmanifest">
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

<!--  
<script type="text/javascript">
	function toggleAll(){  
		var checkboxes=document.getElementsByName('selection[]');  
		for(var i=0; i<checkboxes.length; i++){  
           if(checkboxes[i].type=='checkbox')  
            checkboxes[i].checked=true; 
		} 
	}
	function deSelectAll(){  
                var checkboxes=document.getElementsByName('selection[]');  
                for(var i=0; i<checkboxes.length; i++){  
                    if(checkboxes[i].type=='checkbox')  
                        checkboxes[i].checked=false;  
                }  
    }             
</script>
-->
<body>
	<main>
	<h1>Welcome to Quick Fit Cuisine</h1>
	<a href="login.jsp" target="_self">Login</a><br>
	<a href="register.jsp" target="_self">Register</a><br><br>
	
	
	<div class="selection"><br>
		<h2>Recipe Finder</h2>
		<div id="myBtnContainer">
		  <button class="btn active" onclick="filterSelection('all')"> Show all</button>
		  <button class="btn" onclick="filterSelection('vegetarian')"> Vegetarian</button>
		  <button class="btn" onclick="filterSelection('pescatarian')"> Pescatarian</button>
		  <button class="btn" onclick="filterSelection('vegan')"> Vegan</button>
		 <!--  <img src="moon.png" width="20" height ="20"/> -->
		</div>
		<p>We assume you have salt, pepper, water, and oil.</p>
		<form action="find" method="post">
			<div class="container">
				<fieldset>
					<legend>Ingredient Selector</legend>
					<!--Ingredient Button Menu, name is array, id is for label, value is string-->
	
					<fieldset>
					<legend>Dairy</legend>
						<div class="filterDiv vegetarian pescatarian">
	
						<input type="submit" name="selection" id="egg" value="egg">
	
						<input type="submit" name="selection" id="greekyogurt" value="greekyogurt">
		
						<input type="submit" name="selection" id="cheese" value="cheese">
	
						<input type="submit" name="selection" id="milk" value="milk">

						<input type="submit" name="selection" id="butter" value="butter">
					</div>
			
					</fieldset>
	
					<fieldset>
					<legend>Vegetables</legend>

						<div class="filterDiv vegetarian vegan pescatarian">
						<input type="submit" name="selection" id="onion" value="onion">

						<input type="submit" name="selection" id="chickpeas" value="chickpeas">

						<input type="submit" name="selection" id="red onion" value="red onion">

						<input type="submit" name="selection" id="carrot" value="carrot">
	
						<input type="submit" name="selection" id="peas" value="peas">

						<input type="submit" name="selection" id="greenbeans" value="greenbeans">

						<input type="submit" name="selection" id="redpepper" value="redpepper">
					
						<input type="submit" name="selection" id="broccoli" value="broccoli">
	
						<input type="submit" name="selection" id="brusselsprouts" value="brusselsprouts">
	
						<input type="submit" name="selection" id="potato" value="potato">
						
						<input type="submit" name="selection" id="blackbeans" value="blackbeans">
						
						<input type="submit" name="selection" id="lettuce" value="lettuce">

						<input type="submit" name="selection" id="celery" value="celery">

						<input type="submit" name="selection" id="spinach" value="spinach">

						
					</div>
					</fieldset>

					<fieldset>
					<legend>Fruits</legend>
						<div class="filterDiv vegetarian vegan pescatarian">

						<input type="submit" name="selection" id="lemon" value="lemon">

						<input type="submit" name="selection" id="lime" value="lime">

						<input type="submit" name="selection" id="corn" value="corn">

						<input type="submit" name="selection" id="avocado" value="avocado">

						<input type="submit" name="selection" id="tomato" value="tomato">

						<input type="submit" name="selection" id="orange" value="orange">
	
					</div>
					</fieldset>
	
					<fieldset>
					<legend>Meats</legend>
						<div class="filterDiv ">

						<input type="submit" name="selection" id="chicken" value="chicken">
	
						<input type="submit" name="selection" id="groundbeef" value="groundbeef">
	
						<input type="submit" name="selection" id="bacon" value="bacon">

						<input type="submit" name="selection" id="turkey" value="turkey">
					</div>
					</fieldset>
	
					<fieldset>
						<legend>Fish</legend>
							<div class="filterDiv pescatarian">

							<input type="submit" name="selection" id="salmon" value="salmon">
		
							<input type="submit" name="selection" id="branzino" value="branzino">
		
							<input type="submit" name="selection" id="sardines" value="sardines">

							<input type="submit" name="selection" id="catfish" value="catfish">

							<input type="submit" name="selection" id="cod" value="cod">

							<input type="submit" name="selection" id="tilapia" value="tilapia">

							<input type="submit" name="selection" id="tuna" value="tuna">
						</div>
					</fieldset>
					
					<fieldset>
					<legend>Condiments</legend>	
						<div class="filterDiv vegetarian vegan pescatarian">

						<input type="submit" name="selection" id="mustard" value="mustard">
	
						<input type="submit" name="selection" id="ketchup" value="ketchup">
	
						<input type="submit" name="selection" id="maplesyrup" value="maplesyrup">
	
						<input type="submit" name="selection" id="salsa" value="salsa">

						<input type="submit" name="selection" id="pesto" value="pesto">

						<input type="submit" name="selection" id="spices" value="spices">

						<input type="submit" name="selection" id="mayonnaise" value="mayonnaise">
					</div>
	
	
					</fieldset>
					
					<fieldset>
					<legend>Pasta</legend>

						<div class="filterDiv vegetarian vegan pescatarian">

						<input type="submit" name="selection" id="spaghetti" value="spaghetti">
	
						<input type="submit" name="selection" id="penne" value="penne">
	
						<input type="submit" name="selection" id="orzo" value="orzo">
	

						<input type="submit" name="selection" id="lingiune" value="lingiune"><br>
	

						<input type="submit" name="selection" id="fettuccine" value="fettuccine">
						</div>
	
	
					</fieldset>

					<fieldset>
					<legend>Grains</legend>

						<div class="filterDiv vegetarian vegan pescatarian">
	
						<input type="submit" name="selection" id="rice" value="rice">

				
						<input type="submit" name="selection" id="lentils" value="lentils">
	
						</div>
	
	
					</fieldset>
	
					<fieldset>
					<legend>Misc</legend>

						<div class="filterDiv pescatarian vegan vegetarian">

						<input type="submit" name="selection" id="bread" value="bread">

						<input type="submit" name="selection" id="broth" value="broth">

						<input type="submit" name="selection" id="vinegar" value="vinegar">

						<input type="submit" name="selection" id="almonds" value="almonds">

						<input type="submit" name="selection" id="honey" value="honey">

						<input type="submit" name="selection" id="garlic" value="garlic">
						</div>
	
	
					</fieldset>
					<!-- 
					<input type="checkbox" onClick="toggleAll()" /> Toggle All<br/>
					<input type="checkbox" onClick="deSelectAll()" /> Deselect All<br/>
					 -->
					
	
					
					
				</fieldset>
				
			</div>	
			</form>
			<form action="reset" method="post">
					<!--reset button, clears selected ingredients-->
					<br><input type="submit" value="Clear Ingredients">	
			</form>	
			<form action="all" method="post">
					<!--displays all recipes in db-->
					<br><input type="submit" value="Show All Recipes">	
			</form>	
	</div> 
	<div class="result">
		<h1>QuickFitCuisine</h1>
    	<h2>Your Recipes</h2>
    	<p>Add ingredients to see available recipes.<br><br></p>
    	<fieldset>
    	<legend>Filters</legend>
    	<form action="sort" method="post">
					<!--sorts recipes by time-->
					<br><input type="submit" name="sortButton" value="Time">	
					<!--sorts recipes by # of ingredients-->
					<input type="submit" name="sortButton" value="Ingredients">
		</form>
    	</fieldset>
    	<table style="width:100%">
            <%
            int cols = 5;
            int colCount = 0;
            %>
            <tr>
            <c:forEach var="recipes" items="${listRecipes}">
            	<%
            	if(colCount == cols) {
            		colCount = 0;
            		out.println("</tr><tr>");
            	}
            	%>
                	<td class='mycss'>
                	<a href="${recipes.link}" target="_blank">"${recipes.name}"</a>
                    <br>Estimated Recipe Time: <c:out value="${recipes.time}" />
					<br>Ingredients: <c:out value="${recipes.count}" />
                    </td>
            	<%colCount++;%>
			</c:forEach>
			</tr>
	 	</table>
    	
  	</div>
	<script src="filterScript.js"></script>
<script>
	var icon = document.getElementById("myBtnContainer");

	icon.onclick = function(){
		document.body.classList.toggle("dark-theme");
	}
</script>

	</main>
</body>

</html>