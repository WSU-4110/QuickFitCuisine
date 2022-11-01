DROP DATABASE IF EXISTS ingredientdb;
CREATE DATABASE ingredientdb;
USE ingredientdb;
CREATE TABLE recipes(link VARCHAR(100), time INTEGER, name varchar(40), ingredient1 VARCHAR(20), ingredient2 VARCHAR(20), ingredient3 VARCHAR(20), ingredient4 VARCHAR(20), ingredient5 VARCHAR(20), ingredient6 VARCHAR(20), ingredient7 VARCHAR(20), ingredient8 VARCHAR(20), ingredient9 VARCHAR(20), ingredient10 VARCHAR(20));
insert into recipes(link, time, name, ingredient1, ingredient2, ingredient3, ingredient4, ingredient5, ingredient6, ingredient7, ingredient8, ingredient9, ingredient10) values 
('https://www.deliciousmeetshealthy.com/how-to-make-perfect-hard-boiled-eggs/', 7, 'Hard Boiled Egg', 'egg', null, null, null, null, null, null, null, null, null),
('https://leitesculinaria.com/37545/recipes-perfect-fried-egg.html', 5, 'Fried Egg', 'egg', null, null, null, null, null, null, null, null, null),
('https://thehealthyepicurean.com/maple-mustard-salmon-roasted-broccoli/', 25, 'Salmon and Broccoli', 'salmon', 'broccoli', 'mustard', 'maplesyrup', null, null, null, null, null, null),
('https://thehealthyepicurean.com/simple-spaghetti-with-garlic-peas-parmesan/', 30, 'Spaghetti with Garlic, Peas, Cheese', 'spaghetti', 'peas', 'garlic', 'egg', 'cheese', null, null, null, null, null),
('https://thehealthyepicurean.com/taco-lettuce-cups/', 20, 'Taco Lettuce Cups', 'blackbeans', 'groundmeat', 'lettuce', 'spices', 'avocado', 'salsa', 'greekyogurt', null, null, null),
('https://thehealthyepicurean.com/rustic-yukon-mashed-potatoes/', 25, 'Mashed Potatoes', 'potatoe', 'milk', 'butter', null, null, null, null, null, null, null),
('https://thehealthyepicurean.com/maple-mustard-brussels-sprouts/', 15, 'Brussel Sprouts', 'maplesyrup', 'mustard', 'brusselsprouts', null, null, null, null, null, null, null),
('https://www.acouplecooks.com/simple-sauteed-broccoli/', 10, 'Sauteed Broccoli','broccoli', null, null, null, null, null, null, null, null, null)
('https://natashaskitchen.com/grilled-cheese-sandwich/',30,'Bread','Butter','Cheese',null,null,null,null, null, null, null)
('https://cookieandkate.com/crispy-falafel-recipe/',50,'Oil','Chickpeas','Onion','Parsley','Cilantro','Garlic','Salt','BlackPepper','Ground Cumin','Ground Cinnamon')
('https://www.inspiredtaste.net/15938/easy-and-smooth-hummus-recipe/#itr-recipe-15938',10,'Chickpeas','Lemon Juice','Tahini','Garlic Clove','Oil','Ground Cumin','Salt','Water','Paprika',null)
('https://www.gimmesomeoven.com/baked-chicken-breast/#tasty-recipes-60192',35,'Boneless Skinless Chicken Breast','Oil','Salt','Black Pepper','Garlic Powder','Paprika',null,null,null,null)
('https://plantbasedonabudget.com/yellow-dal/',30,'Oil','Onion','Garlic','Ginger','Coriander','Cumin','Turmeric','Lentils','Water',null);
('https://caitsplate.com/easy-turkey-taco-skillet/#tasty-recipes-35532-jump-target',15,'Turkey Taco Skillet','Oil','Ground Turkey','Black Beans','Corn','Cheese',null,null.null,null,null)
('https://www.almanac.com/recipe/rosemary-chicken-spinach', 30,'Rosemary Chicken', 'Chicken Breast','Rosemary','Garlic', 'Oil','Vinegar','Sugar','Spinach',null.null,null)
('https://minimalistbaker.com/chicken-noodle-soup-1-pot/', 35,'Chicken Noodle Soup','Chicken Thighs','Onion','Garlic', 'Oil','Carrot','Celery','Tumeric','Ginger'.'Thyme',null)
('https://www.cookinglight.com/recipes/one-pot-pasta-spinach-tomatoes', 35,'One Pot Pasta', 'Onion','Tomato','Garlic', 'Oil','Oregano','Chicken Stock','Linguine','Spinach'.'Parmesan',null)
('https://caitsplate.com/honey-mustard-onion-pretzel-encrusted-chicken-tenders/', 25, 'Honey Chicken Tenders','Chicken Breast','Honey','Mustard','Onion','Egg','Flour',null,null,null,null)
('https://www.acouplecooks.com/simple-sauteed-broccoli/', 10, 'Sauteed Broccoli','broccoli', null, null, null, null, null, null, null, null, null),
('https://natashaskitchen.com/grilled-cheese-sandwich/', 30, 'Grilled Cheese', 'bread','butter','cheese',null,null,null,null, null, null, null),
('https://cookieandkate.com/crispy-falafel-recipe/', 50, 'Crispy Falafel','chickpeas','onion','spices',null,null,null,null,null,null,null),
('https://www.inspiredtaste.net/15938/easy-and-smooth-hummus-recipe/#itr-recipe-15938', 10,'Easy Hummus','chickpeas', 'lemon', 'garlic', null, null, null, null, null, null,null),
('https://www.gimmesomeoven.com/baked-chicken-breast/#tasty-recipes-60192', 35, 'Baked Chicken Breasts','chicken', 'spices', null, null, null, null,null,null,null,null),
('https://plantbasedonabudget.com/yellow-dal/', 30, 'Easy Yellow Dal', 'garlic', 'onion', 'rice', 'lentils', null, null, null, null, null,null),
('https://tasty.co/recipe/weekday-meal-prep-pesto-chicken-veggies', 22, 'Pesto Chicken & Veggies', 'chicken', 'greenbeans', 'cherrytomato', 'pesto', null, null, null, null, null, null),
('https://www.gimmesomeoven.com/5-ingredient-black-bean-soup/', 20, 'Black Bean Soup', 'blackbeans', 'salsa', 'spices', 'garlic', null, null, null, null, null, null),
('https://damndelicious.net/2014/03/29/spaghetti-carbonara/', 20, 'Spaghetti Carbonara', 'spaghetti', 'eggs', 'parmesan', 'bacon', 'garlic', null, null, null, null, null),
('https://www.gimmesomeoven.com/5-ingredient-pasta-salad/#tasty-recipes-65190', 15, 'Pesto Pasta Salad', 'pasta', 'redpeppers', 'pesto', 'mozzarella', null, null, null, null, null, null),
('https://www.cookingclassy.com/balsamic-glazed-salmon/#jump-to-recipe', 20, 'Balsamic Glazed Salmon', 'vinegar', 'broth', 'honey', 'mustard', 'garlic', 'salmon', null, null, null, null),
('https://www.tasteofhome.com/recipes/tilapia-florentine/', 30, 'Tilapia Florentine', 'spinach', 'tilapia', 'lemon', 'egg', 'parmesan', 'ricotta', null, null, null, null),
('https://www.tasteofhome.com/recipes/lime-cilantro-tilapia/', 25, 'Lime-Cilantro Tilapia', 'lime', 'cilantro', 'spices', 'tilapia', null, null, null, null, null, null),
('https://www.tasteofhome.com/recipes/tuna-crescent-ring/', 30, 'Tuna Cresent Ring', 'tuna', 'peas', 'carrot', 'onion', 'mustard', 'mayonnaise', null, null, null, null),
('https://www.tasteofhome.com/recipes/cornmeal-crusted-catfish/', 30, 'Cornmeal-Crusted Catfish', 'egg', 'cornmeal', 'spices', 'catfish', null, null, null, null, null, null),
('https://www.tasteofhome.com/recipes/citrus-coconut-steamed-cod/', 30, 'Citrus Coconut Steamed Cod', 'orange', 'spices', 'cod', 'almonds', 'onion', 'cilantro', null, null, null, null);
