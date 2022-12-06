<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!-- normalize -->
    <link rel="stylesheet" href="normalize.css" />
    <!-- font-awesome -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"
    />
	
<meta charset="UTF-8">
<title>Quick Fit Cuisine</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="styles.css" rel="stylesheet" type="text/css" />
<script src="index.js" type="text/javascript" defer></script>
</head>

<% 
  request.getSession().setAttribute("user", request.getParameter("currentUser"));
%>

<script>
	var coll = document.getElementsByClassName("collapsible");
	var i;

	for (i = 0; i < coll.length; i++) {
		coll[i].addEventListener("click", function() {
			this.classList.toggle("active");
			var content = this.nextElementSibling;
			if (content.style.maxHeight) {
				content.style.maxHeight = null;
			} else {
				content.style.maxHeight = content.scrollHeight + "px";
			}
		});
	}
</script>
<script>
function openLogin() {
  document.getElementById("login").style.display = "block";
	}
function closeLogin() {
  document.getElementById("login").style.display = "none";
	}
function openRegister() {
	  document.getElementById("register").style.display = "block";
	}
function closeRegister() {
	  document.getElementById("register").style.display = "none";
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
<!--  -->
<!--  nav -->
<!--  <nav class="navbar"> -->
<!--  <div class="nav-center"> -->
	<!-- header -->
<!--  <div class="nav-header">   -->
<!-- <a href= "ingredients.jsp" class="nav-logo">  -->
<!-- <img src="${pageContext.request.contextPath}/images/apple-touch-icon.png" alt="QuickFitCuisine" />  -->

 <!-- </a>  -->
<!-- <button type="button" class="btn nav-btn">  -->
 <!-- <i class="fas fa-align-justify"></i> 
</button>
</div>   -->
<!-- links -->
<!-- <div class="nav-links">
 <a href="login.jsp" class="nav-links" target="_self">Login</a>
	<a href="register.jsp" class="nav-links" target="_self">Register</a> -->
	<!-- <img src="${pageContext.request.contextPath}/images/moon.png" width="100" height ="100"/> -->
<!--   </div>
</div>
</nav> -->

	<main>
	<h1>Welcome to Quick Fit Cuisine</h1>
	<button class="open-button" onclick="openLogin()">Login</button>
	<div class = "login"><h2>Logged in as user: <user><c:out value = "${currentUser}"/></user></h2></div>
	<div class = "userform-popup" align="center" id="login">
 		<h1> Login </h1>
	
		<p> ${loginFailedStr} </p>
		<form action="login" method="get">
			<table border="1" cellpadding="5">
				<tr>
					<th>Email: </th>
					<td>
						<input type="text" name="email" size="45" autofocus>
					</td>
				</tr>
				<tr>
					<th>Password: </th>
					<td> 
						<input type="password" name="password" size="45">
					</td>
				</tr>
					<td colspan="2" align="center">
						<input type="submit" value="Login"/>
					</td>
				
			</table>
			<button type="button" class="close-button" onclick="closeLogin()">Close</button>
			<button type="button" class="close-button" onclick="openRegister();closeLogin()">Register</button>
		</form>
	</div>
	<div class = "userform-popup" align="center" id="register">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		<form action="register">
		<h1> Register </h1>
			<table border="1" cellpadding="5">
				<tr>
					<th>Email: </th>
					<td align="center" colspan="3">
						<input type="text" name="email" size="45"  value="example@gmail.com" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Password: </th>
					<td align="center" colspan="3"> 
						<input type="password" name="password" size="45" value="password" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Password Confirmation: </th>
					<td align="center" colspan="3">
						<input type="password" name="confirmation" size="45" value="password" onfocus="this.value=''">
					</td>
				
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Register"/>
					</td>
				</tr>
			</table>
			<button type="button" class="btn cancel" onclick="closeRegister()">Close</button>
		</form>
	</div>
	<div class="selection">
		
		<div id="myBtnContainer">	
		<br>
		<br>
		<h1>QuickFitCuisine</h1>
		
		<div class="nav-links">
 	<a href="login.jsp" class="nav-links" target="_self">Login</a>
	<a href="register.jsp" class="nav-links" target="_self">Register</a>
	<form action="logout" method="post">
		<input type="submit" name="logout" value="Logout">
		</form>
	</div>
	
		<h3>Recipe Finder</h3>                  
		<p>We assume you have salt, pepper, water, and oil.</p>
		  <button class="btn active" onclick="filterSelection('all')"> Show all</button>
		  <button class="btn" onclick="filterSelection('vegetarian')"> Vegetarian</button>
		  <button class="btn" onclick="filterSelection('pescatarian')"> Pescatarian</button>
		  <button class="btn" onclick="filterSelection('vegan')"> Vegan</button>
		</div>
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
						<legend>Ingredient Selector</legend>
						<!--Ingredient Button Menu, name is array, id is for label, value is string-->

						<fieldset>
							<legend>Dairy</legend>
							<div class="filterDiv vegetarian pescatarian">

								<input type="submit" name="selection" id="egg" value="egg">

								<input type="submit" name="selection" id="greekyogurt"
									value="greekyogurt"> <input type="submit"
									name="selection" id="cheese" value="cheese"> <input
									type="submit" name="selection" id="milk" value="milk">

								<input type="submit" name="selection" id="butter" value="butter">
							</div>

						</fieldset>

						<fieldset>
							<legend>Vegetables</legend>

							<div class="filterDiv vegetarian vegan pescatarian">
								<input type="submit" name="selection" id="onion" value="onion">

								<input type="submit" name="selection" id="chickpeas"
									value="chickpeas"> <input type="submit"
									name="selection" id="red onion" value="red onion"> <input
									type="submit" name="selection" id="carrot" value="carrot">

								<input type="submit" name="selection" id="peas" value="peas">

								<input type="submit" name="selection" id="greenbeans"
									value="greenbeans"> <input type="submit"
									name="selection" id="redpepper" value="redpepper"> <input
									type="submit" name="selection" id="broccoli" value="broccoli">

								<input type="submit" name="selection" id="brusselsprouts"
									value="brusselsprouts"> <input type="submit"
									name="selection" id="potato" value="potato"> <input
									type="submit" name="selection" id="blackbeans"
									value="blackbeans"> <input type="submit"
									name="selection" id="lettuce" value="lettuce"> <input
									type="submit" name="selection" id="celery" value="celery">

								<input type="submit" name="selection" id="spinach"
									value="spinach">


							</div>
						</fieldset>

						<fieldset>
							<legend>Fruits</legend>
							<div class="filterDiv vegetarian vegan pescatarian">

								<input type="submit" name="selection" id="lemon" value="lemon">

								<input type="submit" name="selection" id="lime" value="lime">

								<input type="submit" name="selection" id="corn" value="corn">

								<input type="submit" name="selection" id="avocado"
									value="avocado"> <input type="submit" name="selection"
									id="tomato" value="tomato"> <input type="submit"
									name="selection" id="orange" value="orange">

							</div>
						</fieldset>

						<fieldset>
							<legend>Meats</legend>
							<div class="filterDiv ">

								<input type="submit" name="selection" id="chicken"
									value="chicken"> <input type="submit" name="selection"
									id="groundbeef" value="groundbeef"> <input
									type="submit" name="selection" id="bacon" value="bacon">

								<input type="submit" name="selection" id="turkey" value="turkey">
							</div>
						</fieldset>

						<fieldset>
							<legend>Fish</legend>
							<div class="filterDiv pescatarian">

								<input type="submit" name="selection" id="salmon" value="salmon">

								<input type="submit" name="selection" id="branzino"
									value="branzino"> <input type="submit" name="selection"
									id="sardines" value="sardines"> <input type="submit"
									name="selection" id="catfish" value="catfish"> <input
									type="submit" name="selection" id="cod" value="cod"> <input
									type="submit" name="selection" id="tilapia" value="tilapia">

								<input type="submit" name="selection" id="tuna" value="tuna">
							</div>
						</fieldset>

						<fieldset>
							<legend>Condiments</legend>
							<div class="filterDiv vegetarian vegan pescatarian">

								<input type="submit" name="selection" id="mustard"
									value="mustard"> <input type="submit" name="selection"
									id="ketchup" value="ketchup"> <input type="submit"
									name="selection" id="maplesyrup" value="maplesyrup"> <input
									type="submit" name="selection" id="salsa" value="salsa">

								<input type="submit" name="selection" id="pesto" value="pesto">

								<input type="submit" name="selection" id="spices" value="spices">

								<input type="submit" name="selection" id="mayonnaise"
									value="mayonnaise">
							</div>


						</fieldset>

						<fieldset>
							<legend>Pasta</legend>

							<div class="filterDiv vegetarian vegan pescatarian">

								<input type="submit" name="selection" id="spaghetti"
									value="spaghetti"> <input type="submit"
									name="selection" id="penne" value="penne"> <input
									type="submit" name="selection" id="orzo" value="orzo">


								<input type="submit" name="selection" id="lingiune"
									value="lingiune"><br> <input type="submit"
									name="selection" id="fettuccine" value="fettuccine">
							</div>


						</fieldset>

						<fieldset>
							<legend>Grains</legend>

							<div class="filterDiv vegetarian vegan pescatarian">

								<input type="submit" name="selection" id="rice" value="rice">


								<input type="submit" name="selection" id="lentils"
									value="lentils">

							</div>


						</fieldset>

						<fieldset>
							<legend>Misc</legend>

							<div class="filterDiv pescatarian vegan vegetarian">

								<input type="submit" name="selection" id="bread" value="bread">

								<input type="submit" name="selection" id="broth" value="broth">

								<input type="submit" name="selection" id="vinegar"
									value="vinegar"> <input type="submit" name="selection"
									id="almonds" value="almonds"> <input type="submit"
									name="selection" id="honey" value="honey"> <input
									type="submit" name="selection" id="garlic" value="garlic">
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
				<br>
				<input type="submit" value="Clear Ingredients">
			</form>
			<form action="all" method="post">
				<!--displays all recipes in db-->
				<br>
				<input type="submit" value="Show All Recipes">
			</form>
		</div>
		<div class="result">
			<h1>QuickFitCuisine</h1>
			<h2>Your Recipes</h2>
			<p>
				Add ingredients to see available recipes.<br>
				<br> ${saveRecipesError} ${saveRecipesError2}
				${saveRecipesError3}
			</p>

			<c:forEach var="ingredient" items="${ingredientSelections}"
				varStatus="i">
    		${ingredient}
    		${not i.last ? ", " : ""}
    		<c:if test="${(i.count % 5) == 0}">
					<br>
				</c:if>
			</c:forEach>

			<br>${ingred1} ${ingred2} ${ingred3} ${ingred4} ${ingred5}
			${ingred6} ${ingred7} ${ingred8} ${ingred9} ${ingred10}

			<fieldset>
				<legend>Filters</legend>
				<form action="sort" method="post">
					<!--sorts recipes by time-->
					<br>
					<input type="submit" name="sortButton" value="Time">
					<!--sorts recipes by # of ingredients-->
					<input type="submit" name="sortButton" value="Ingredients">
					<!--sorts recipes by saved-->
					<input type="submit" name="sortButton" value="Saved">
				</form>
			</fieldset>
			<form action="recipeActions" method="post">
				<!-- this table displays specific recipes from selected ingredients or displays all recipes -->
				<table style="width: 100%">
					<%
					int cols = 5;
					int colCount = 0;
					%>
					<tr>
						<c:forEach var="recipes" items="${listRecipes}">
							<%
							if (colCount == cols) {
								colCount = 0;
								out.println("</tr><tr>");
							}
							%>
							<td class='mycss'><a href="${recipes.link}" target="_blank">"${recipes.name}"</a>
								<br>Estimated Recipe Time: <c:out value="${recipes.time}" />
								<br>Ingredients: <c:out value="${recipes.count}" /> <br>
							<input type="submit" name="recipeActionButton"
								value="Save Recipe ${recipes.name}"> <br>
							<input type="submit" name="recipeActionButton"
								value="View Ingredients in ${recipes.name}"> <!-- display ingredients here -->
							</td>
							<%colCount++;%>
						</c:forEach>
					</tr>
				</table>
				<!-- this table displays recipes that the user has saved -->
				<table style="width: 100%">
					<%
					int cols2 = 5;
					int colCount2 = 0;
					%>
					<tr>
						<c:forEach var="recipes" items="${listSavedRecipes}">
							<%
							if (colCount2 == cols2) {
								colCount2 = 0;
								out.println("</tr><tr>");
							}
							%>
							<td class='mycss'><a href="${recipes.link}" target="_blank">"${recipes.name}"</a>
								<br>Estimated Recipe Time: <c:out value="${recipes.time}" />
								<br>Ingredients: <c:out value="${recipes.count}" /> <br>
							<input type="submit" name="recipeActionButton"
								value="Delete Recipe ${recipes.name}"> <br>
							<input type="submit" name="recipeActionButton"
								value="View Ingredients in ${recipes.name}"> <!-- display ingredients here (just copy paste the code you made for the other table to here) -->
							</td>
							<%colCount2++;%>
						</c:forEach>
					</tr>
				</table>
			</form>
		</div>
    <script>
  	window.onscroll = function() {scrollFunction()};

  	function scrollFunction() {
  	  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
  	    document.getElementById("myBtnContainer").style.top = "0";
  	  } else {
  	    document.getElementById("myBtnContainer").style.top = "-50px";
  	  }
  	}
  	</script>
  	<script>
  	window.onscroll = function() {scrollFunction()};

  	function scrollFunction() {
  	  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
  	    document.getElementById("yourrecipe").style.top = "0";
  	  } else {
  	    document.getElementById("yourrecipe").style.top = "-50px";
  	  }
  	}
  	</script>
		<script src="filterScript.js"></script>
	</main>
</body>

</html>