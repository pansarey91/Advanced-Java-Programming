<%@page language="java" import="java.util.*" %>
<html>
<head>
<title>Ass4SetB1</title>
</head>
<body>
<H1>
<form action = "" method="get">
Enter Your Name <input type ="text" name = "t1"><BR>
<input type="submit" value="Click Me"/>
</form>
<%
 String name = request.getParameter("t1");
 out.println("Welcome "+name);

 Calendar cal = Calendar.getInstance();
 int h = cal.get(Calendar.HOUR_OF_DAY);

  if(h>=1 && h<=11)
     out.println("<BR> Good Morning ...");
  else if(h>=12 && h<=16)
     out.println("<BR> Good Afternoon ...");	 
  else if(h>=17 && h<=19)
     out.println("<BR> Good Evening ...");	 
  else 
     out.println("<BR> Good Neight ...");	 
%>

</body>
</html>