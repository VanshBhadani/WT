
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Calculator extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int a1 = Integer.parseInt(request.getParameter("n1"));
            int a2 = Integer.parseInt(request.getParameter("n2"));
            String op1 = request.getParameter("op");

            switch (op1) {
                case "+":
                    out.println("<h3>Addition: " + (a1 + a2) + "</h3>");
                    break;
                case "-":
                    out.println("<h3>Subtraction: " + (a1 - a2) + "</h3>");
                    break;
                case "*":
                    out.println("<h3>Multiplication: " + (a1 * a2) + "</h3>");
                    break;
                case "/":
                    if (a2 != 0) {
                        out.println("<h3>Division: " + (a1 / a2) + "</h3>");
                    } else {
                        out.println("<h3>Error: Division by zero is not allowed.</h3>");
                    }
                    break;
                default:
                    out.println("<h3>Error: Please select a valid operator.</h3>");
            }
            out.println("</body></html>");
        } catch (NumberFormatException e) {
            out.println("<h3>Error: Invalid input. Please enter numeric values.</h3>");
        } catch (Exception e) {
            out.println("<h3>Error: An unexpected error occurred.</h3>");
        } finally {
            out.close();
        }
    }
}
