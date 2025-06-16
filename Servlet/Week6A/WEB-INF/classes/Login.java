
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class Login extends GenericServlet {

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String a = req.getParameter("email");
        String b = req.getParameter("pass");

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");

            // Execute SQL query using direct string concatenation
            String sql = "SELECT * FROM user WHERE email = '" + a + "' AND password = '" + b + "'";
            Statement pstmt = con.createStatement();
            ResultSet rs = pstmt.executeQuery(sql);

            // Check if user exists in database
            if (rs.next()) {
                String c = rs.getString("email");
                String d = rs.getString("password");
                if (a.equals(c) && b.equals(d)) {
                    out.println("Welcome ");

                }
            } else {
                out.println("Invalid email or password!");
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        } catch (SQLException e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}
