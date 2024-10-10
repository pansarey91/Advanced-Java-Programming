<%@page language="java" import="java.util.*" %>
<html>
<head>
<title>Ass-6 : Time</title>
</head>
<body>
<H1>

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