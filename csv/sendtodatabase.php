<?php
//this file is used for sending data to database and creating tables 
require "connection.php";
$user_id = $_POST["id"];
$user_name= $_POST["name"];
$user_college=$_POST["college"];
$user_contact=$_POST["contact"];
$user_address=$_POST["address"];
$user_selected = $_POST["selected"];
$mysql_query = "insert into cointheta values ('$user_id','$user_name','$user_college','$user_contact','$user_address','$user_selected')";
$result = mysqli_query($connection ,$mysql_query);
	echo "data is successfully entered into database";
?>
