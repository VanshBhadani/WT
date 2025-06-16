
<%
    String name = request.getParameter("cookieName");
    String value = request.getParameter("cookieValue");
    
    if (name != null && value != null) {
        response.addCookie(new Cookie(name, value));
    }

    out.print("<html><body>");
    out.print("<h2>Stored Cookies:</h2>");
    
    Cookie[] cks = request.getCookies();
    if (cks != null) {
        for (Cookie ck : cks) {
            out.print("<p>" + ck.getName() + ": " + ck.getValue() + "</p>");
        }
    } else {
        out.print("<p>No cookies found</p>");
    }
    
    out.print("</body></html>");
%>