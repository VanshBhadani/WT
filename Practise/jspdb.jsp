<%@page import="java.sql.*"%>
<%
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/DB", "root", "");
        Statement st=con.createStatement();
        String sql="Select * from users where name='"+name+"' and password='"+password+"'";

        ResultSet rs=st.executeQuery(sql);
        if(rs.next()){
            out.print("Login successful");
        }else{
            out.print("Invalid credentials");
        }
    }catch(Exception e){
        e.printStackTrace();
    }
%>