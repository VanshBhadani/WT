<%
    int a=Integer.parseInt(request.getParameter("num1"));
    int b=Integer.parseInt(request.getParameter("num2"));
    String c=request.getParameter("op");
    switch(c){
        case "+":
            out.println("Sum is: " + (a + b));
            break;
        case "-":
            out.println("Difference is: " + (a - b));
            break;
        case "*":
            out.println("Product is: " + (a * b));
            break;
        case "/":
            if (b != 0) {
                out.println("Quotient is: " + (a / b));
            } else {
                out.println("Division by zero is not allowed.");
            }
            break;
        default:
            out.println("Invalid operation selected.");
    }
    
%>