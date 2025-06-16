<?php
if ($_POST) {
    $a = $_POST["number"];
    $b = $_POST["number2"];
    $c = $_POST["op"];
    switch ($c) {
        case "+":
            $result = $a + $b;
            break;
        case "-":
            $result = $a - $b;
            break;
        case "*":
            $result = $a * $b;
            break;
        case "/":
            if ($b != 0) {
                $result = $a / $b;
            } else {
                $result = "Error: Division by zero";
            }
            break;
        default:
            $result = "Invalid operation";
    }
    echo "Result: $result";
}
?>