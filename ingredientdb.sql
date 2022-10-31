DROP DATABASE IF EXISTS ingredientdb;
CREATE DATABASE ingredientdb;
USE ingredientdb;
CREATE TABLE recipes(link VARCHAR(100), time INTEGER, name varchar(30), ingredient1 VARCHAR(20), ingredient2 VARCHAR(20), ingredient3 VARCHAR(20), ingredient4 VARCHAR(20), ingredient5 VARCHAR(20), ingredient6 VARCHAR(20), ingredient7 VARCHAR(20), ingredient8 VARCHAR(20), ingredient9 VARCHAR(20), ingredient10 VARCHAR(20));
insert into recipes(link, time, name, ingredient1, ingredient2, ingredient3, ingredient4, ingredient5, ingredient6, ingredient7, ingredient8, ingredient9, ingredient10) values 
('https://www.deliciousmeetshealthy.com/how-to-make-perfect-hard-boiled-eggs/', 7, 'Hard Boiled Egg', 'egg', null, null, null, null, null, null, null, null, null),
('https://leitesculinaria.com/37545/recipes-perfect-fried-egg.html', 5, 'Fried Egg', 'egg', null, null, null, null, null, null, null, null, null),
('https://www.acouplecooks.com/simple-sauteed-broccoli/', 10, 'Sauteed Broccoli','broccoli', null, null, null, null, null, null, null, null, null);