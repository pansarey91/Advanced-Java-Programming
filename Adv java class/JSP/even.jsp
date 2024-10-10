<%@ page language="java"%>
<html>
<head>
<title>Even number program in JSP</title>
</head>
<body>
<H1> List of Even Numbers = <BR>
<%
 for(int i=2;i<=10;i++) 
 {
  if((i%2)==0)
  {
   out.print(Integer.toString(i)); 
   out.print("<br>");
  }
 }
%>
</body>
</html>