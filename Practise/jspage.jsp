<%
int a=Integer.parseInt(request.getParameter("num1"));
if(a>=18) out.print("You are eligible to vote.");
else out.print("You are not eligible to vote.");
%>