<?php
$conn = new mysqli("localhost", "root", "", "phpdb", 3307);

if ($conn->connect_error) die("Connection failed");

if ($_POST) {
   $name = $_POST["name"];
   $pass = $_POST["password"];
   $fullname = $_POST["fullname"] ?? "";
   
   // Check if username exists
   $result = $conn->query("SELECT * FROM newusers WHERE name='$name'");
   
   if ($result->num_rows > 0) {
       $user = $result->fetch_assoc();
       
       // Check password
       if ($user['password'] == $pass) {
           echo "Welcome " . $user['fullname'] . "!";
       } else {
           echo "Password mismatch";
       }
   } else {
       // User not found - store new user
       if ($fullname) {
           $conn->query("INSERT INTO newusers (name, password, fullname) VALUES ('$name', '$pass', '$fullname')");
           echo "New user registered! Welcome " . $fullname . "!";
       } else {
           echo "User not found. Please provide full name.";
       }
   }
}
?>