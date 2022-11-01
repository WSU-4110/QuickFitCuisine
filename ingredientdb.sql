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
('https://www.acouplecooks.com/simple-sauteed-broccoli/', 10, 'Sauteed Broccoli','broccoli', null, null, null, null, null, null, null, null, null),
('https://natashaskitchen.com/grilled-cheese-sandwich/', 30, 'Grilled Cheese', 'bread','butter','cheese',null,null,null,null, null, null, null),
('https://cookieandkate.com/crispy-falafel-recipe/', 50, 'Crispy Falafel','chickpeas','onion','spices',null,null,null,null,null,null,null),
('https://www.inspiredtaste.net/15938/easy-and-smooth-hummus-recipe/#itr-recipe-15938', 10,'Easy Hummus','chickpeas', 'lemon', 'garlic', null, null, null, null, null, null,null),
('https://www.gimmesomeoven.com/baked-chicken-breast/#tasty-recipes-60192', 35, 'Baked Chicken Breasts','chicken', 'spices', null, null, null, null,null,null,null,null),
('https://plantbasedonabudget.com/yellow-dal/', 30, 'Easy Yellow Dal', 'garlic', 'onion', 'rice', 'lentils', null, null, null, null, null,null);

