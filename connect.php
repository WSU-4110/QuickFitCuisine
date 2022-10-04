<?php
    $dbname = 'ingredientdb';
    $dbuser = 'root';
    $dbpass = 'pass1234';
    $dbhost = 'localhost';
    $link = mysqli_connect($dbhost, $dbuser, $dbpass) or die("Unable to connect to '$dbhost'");
    mysqli_select_db($link, $dbname) or die("Could not open database '$dbname'");
?>