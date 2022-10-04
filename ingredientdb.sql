CREATE DATABASE ingredientdb;
USE ingredientdb;
CREATE TABLE recipes(link VARCHAR(100), time INTEGER, name varchar(30), ingredient1 VARCHAR(20), ingredient2 VARCHAR(20), ingredient3 VARCHAR(20));
insert into recipes(link, time, ingredient1, ingredient2, ingredient3) values ('https://www.deliciousmeetshealthy.com/how-to-make-perfect-hard-boiled-eggs/', 7, 'Hard Boiled Egg', 'egg', null, null),
('https://leitesculinaria.com/37545/recipes-perfect-fried-egg.html', 5, 'Fried Egg', 'egg', null, null),
('https://www.acouplecooks.com/simple-sauteed-broccoli/', 10, 'Sauteed Broccoli','broccoli',null,null);