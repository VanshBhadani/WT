<?php
if ($_POST) {
    $name = $_POST["name"];
    $email = $_POST["email"];
    $phone = $_POST["phone"];
    $password = $_POST["password"];

 $errors = [];

// Validate Name: only letters and at least 6 characters
if (!ctype_alpha($name) || strlen($name) < 6) {
    $errors[] = "Name must contain only letters and be at least 6 characters long.";
}

// Validate Password: at least 6 characters
if (strlen($password) < 6) {
    $errors[] = "Password must be at least 6 characters long.";
}

// Validate Email: must contain '@' and '.'
if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    $errors[] = "Please enter a valid email address.";
}

// Validate Phone Number: must be numeric and exactly 10 digits
if (!is_numeric($phone) || strlen($phone) != 10) {
    $errors[] = "Phone number must be exactly 10 digits.";
}

// Output result
if (empty($errors)) {
    echo "Registration Successful!";
} else {
    foreach ($errors as $error) {
        echo $error . "<br>";
    }
}
}
?>