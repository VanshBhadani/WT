<?php
$conn = new mysqli("localhost", "root", "", "phpdb", 3307);

if ($conn->connect_error)
    die("Connection failed");

if ($_POST) {
    $name = $_POST["name"];
    $pass = $_POST["password"];

    $result = $conn->query("SELECT * FROM users WHERE name='$name' AND password='$pass'");

    if ($result->num_rows > 0) {
        echo "Login successful!";
    } else {
        echo "Invalid credentials";
    }
}
?>