import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class User extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  

        String n = request.getParameter("uname");  
        String p = request.getParameter("pwd");  

        ServletConfig config = getServletConfig();
        String name = config.getInitParameter("username");          
        String pass = config.getInitParameter("password");  
          
        if(n.equals(name) && p.equals(pass)){
            out.println("Welcome " + n);  
        } else {  
            out.println("Sorry username or password error");  
            RequestDispatcher rd = request.getRequestDispatcher("index.html");  
            rd.include(request, response);  
        }  
        out.close();  
    }
}
