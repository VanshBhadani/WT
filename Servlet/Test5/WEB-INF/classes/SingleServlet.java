
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SingleServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("cookieName");
        String value = req.getParameter("cookieValue");
        if (name != null && value != null ) {
            res.addCookie(new Cookie(name, value));
        }

        out.print("<h2>Stored Cookies:</h2>");
        Cookie[] cks = req.getCookies();
        if (cks != null) {
            for (Cookie ck : cks) {
                out.print("<p>" + ck.getName() + ": " + ck.getValue() + "</p>");
            }
        } else {
            out.print("<p>No cookies found</p>");
        }
        out.close();
    }
}
