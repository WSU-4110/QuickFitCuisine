<!DOCTYPE html>
<!--declaration of HTML5-->
<html>

<head>
    <meta charset="utf-8">
    <title>Lifestyle Options</title>
    
    <link href="styles.css" rel="stylesheet" type="text/css" />
        
</head>

<body>

    <main-header></main-header>
    <nav>
                <ul>
                    <li><a href="ingredients.php">Recipe Finder</a></li>
                    <li><a href="SpecialHealthPage.php">Health Issues/Dietary Preferences</a></li>
                </ul>
    </nav>

    <br>Lifestyle Options
    <!--style sheet--> <br>
    <ul>
        <li>Diabetic
            <!-- Rounded switch -->
            <label class="switch">
                <input type="checkbox">
                <span class="slider round"></span>
              </label></li>
            <li>Vegan
                <label class="switch">
                    <input type="checkbox">
                    <span class="slider round"></span>
                  </label>
            </li>
            <li>Pescatarian
                <label class="switch">
                    <input type="checkbox">
                    <span class="slider round"></span>
                  </label>
            </li> 
            <li>Vegetarian
                <label class="switch">
                    <input type="checkbox">
                    <span class="slider round"></span>
                  </label>
            </li>
           <!--new addition, link for new html document.-->
        </ul>
        <br>
        <footer>
            <p>Dark Mode/LightMode 
            <img src="moon.png" id="icon" style="width:2em; height:2em;"> <br>
              <br> 
        </footer>

        <script>
            var icon = document.getElementById("icon");

            if(localStorage.getItem("theme") == null){
                localStorage.setItem("theme","light");
            }


            let localData = localStorage.getItem("theme");

            if(localData == "light"){
                icon.src = "moon.png";
                document.body.classList.remove("dark-theme");
            }
            else if(localData == "dark"){
                icon.src = "sun.png";
                document.body.classList.add("dark-theme");
            }

            icon.onclick = function(){
                document.body.classList.toggle("dark-theme");
                if(document.body.classList.contain("dark-theme")){
                    icon.src = "sun.png";
                    localStorage.setItem("theme","dark");
                }else{
                    icon.src = "moon.png"
                    localStorage.setItem("theme","light");
                }
            }
        </script>

    </body>
</html>
