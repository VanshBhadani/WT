
<?php
$conn = new mysqli("localhost", "root", "", "phpdb", 3307);

if ($_POST) {
    $name = $_POST["name"];
    $pass = $_POST["password"];
    $full = $_POST["fullname"] ?? "";
    
    $result = $conn->query("SELECT * FROM newusers WHERE name='$name'");
    
    if ($result->num_rows > 0) {
        $user = $result->fetch_assoc();
        echo ($user['password'] == $pass) ? "Welcome " . $user['fullname'] : "Password mismatch";
    } else {
        if ($full) {
            $conn->query("INSERT INTO newusers VALUES ('$name', '$pass', '$full')");
            echo "Welcome " . $full;
        } else {
            echo "User not found";
        }
    }
}